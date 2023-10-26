package org.example;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.collect.Sets.cartesianProduct;
import static org.example.Cards.*;

public class Main {
    public static Map<Condition.Combination, Integer> solnCounts = new HashMap<>();
    public static void main(String[] args) {
        // Game 1
        // List<Condition>[] cards = new List[] {CARD_4, CARD_9, CARD_11, CARD_14};
        // Game 2
        // List<Condition>[] cards = new List[] {CARD_3, CARD_7, CARD_10, CARD_14};
        // Game 12
        // List<Condition>[] cards = new List[] {CARD_4, CARD_9, CARD_18, CARD_20};



        boolean printContainment = false;
        Condition.combinationsToAnalyze = Condition.allCombinations.stream()
////                .filter(comb -> !Conditions.card9_cond4.func.apply(comb))
//                .filter((comb -> Conditions.card1_cond2.func.apply(comb)))
//                .filter((comb -> Conditions.card7_cond1.func.apply(comb)))
//                .filter((comb -> Conditions.card27_cond3.func.apply(comb)))
                .collect(Collectors.toList());

        System.out.println("Number of combinations considered: " + Condition.allCombinations.size());
        System.out.println("Combinations: " + Condition.allCombinations);

        //List<Condition> CARD_48 = List.of(Conditions.card48_cond4, Conditions.card48_cond8);

        List<Condition>[] cards = new List[] {CARD_1, CARD_7, CARD_27, CARD_35, CARD_48};

        List<List<Condition>> conds = getUniqueSolutions(cards, printContainment);

        List<Map<Condition, Integer>> listCounts = printCountsOfConditionsInSolutions(conds);

        // Sorting Counts and messing around.
        List<Map<Condition, Integer>> sortedListCounts = listCounts.stream().sorted((o1, o2) -> {
            if (o1.size() != o2.size()) {
                return o2.size() - o1.size();
            } else {
                return o2.values().stream().max(Integer::compareTo).get()
                        .compareTo(o1.values().stream().max(Integer::compareTo).get());
            }
        }).toList();
        System.out.println("\n List of conditions sorted: ");
        sortedListCounts.forEach(s -> {
            List<Map.Entry<Condition, Integer>> stream = sortMap(s);
            System.out.println(stream);
        });

        List<Condition> listOfConditions = sortedListCounts.stream().limit(3)
                .map(s -> s.entrySet().stream()
                        .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                        .map(e -> e.getKey()).limit(1).toList().get(0)
                ).toList();
        getCombinations(listOfConditions).stream().forEach(combinations -> {
            System.out.println("\n Conditions " + listOfConditions + " led to combinations " + combinations);
        });

        System.out.println("\nSolution counts: ");
        solnCounts.forEach((s,i) -> System.out.println(s + ":" + i));

        // Finding discriminating Conditions.
        System.out.println("\nDoing something with discrimination for 1 condition: ");
        List<List<Condition>> listConditions =
                Arrays.stream(cards).toList().stream().flatMap(Collection::stream).map(List::of).toList();
        List<Map.Entry<List<Condition>, Map<BitSet, Integer>>> list = buildSortedDiscriminatingList(listConditions);
        list.forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

        // Finding discriminating Conditions.
        System.out.println("\nDoing something with discrimination for 2 conditions: ");
        // This is all the Sets of Pairs (Sets) of Cards (List<Conditions>)
        Set<Set<List<Condition>>> combinationsOfCards = Sets.combinations(Set.of(cards), 2);
        List<List<Condition>> conditionPairs = combinationsOfCards.stream().flatMap( set -> {
            return Lists.cartesianProduct(set.stream().toList()).stream();
        }).toList();
        List<Map.Entry<List<Condition>, Map<BitSet, Integer>>> list2 = buildSortedDiscriminatingList(conditionPairs);
        list2.forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

    }

    private static List<Map.Entry<List<Condition>, Map<BitSet, Integer>>> buildSortedDiscriminatingList(List<List<Condition>> listConditions) {
        Map<List<Condition>, Map<BitSet, Integer>> conditionCountMap = new HashMap<>();
        listConditions.forEach(conditionsToCheck -> {
            Map<BitSet, Integer> counts = new HashMap<>();
            solnCounts.keySet().forEach( soln -> {
                for (int i = 0; i < conditionsToCheck.size(); i++) {
                    Boolean result = conditionsToCheck.get(i).func.apply(soln);
                    BitSet bitset = new BitSet(1);
                    bitset.set(i, result);
                    updateCountingMap(counts, bitset);
                }
            });
            //System.out.println(condition + " : " + counts);
            conditionCountMap.put(conditionsToCheck, counts);
        });

        List<Map.Entry<List<Condition>, Map<BitSet, Integer>>> list =
                conditionCountMap.entrySet().stream().collect(Collectors.toList());

        list.sort((o1, o2) -> {
            if (o2.getValue().keySet().size() == o1.getValue().keySet().size()) {
                return o1.getValue().values().stream().max(Integer::compareTo).get()
                        .compareTo(o2.getValue().values().stream().max(Integer::compareTo).get());
            } else {
                return o2.getValue().keySet().size() - o1.getValue().keySet().size();
            }
        });
        return list;
    }

    private static List<Map.Entry<Condition, Integer>> sortMap(Map<Condition, Integer> s) {
        List<Map.Entry<Condition, Integer>> stream = s.entrySet().stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue())).toList();
        return stream;
    }

    private static List<Map<Condition, Integer>> printCountsOfConditionsInSolutions(List<List<Condition>> conds) {
        System.out.println("\nThere are " + conds.size() + " possible condition combinations which lead to a unique solution.\n");
        int numCards = conds.get(0).size();
        List<Map<Condition, Integer>> listCounts = new ArrayList<>(5);

        for (int i = 0; i < numCards; i++) {
            Map<Condition, Integer> counts = getCountingMap(conds, i);
            System.out.println("For card " + i + ": " + counts);
            listCounts.add(counts);
        }
        return listCounts;
    }

    private static <T> Map<T, Integer> getCountingMap(List<List<T>> conds, int i) {
        Map<T, Integer> counts = new HashMap<>();
        conds.stream().forEach(ls -> {
            T cond = ls.get(i);
            updateCountingMap(counts, cond);
        });
        return counts;
    }

    private static <T> void updateCountingMap(Map<T, Integer> counts, T key) {
        if (counts.containsKey(key)) {
            counts.put(key, counts.get(key) + 1);
        } else {
            counts.put(key, 1);
        }
    }

    private static List<List<Condition>> getUniqueSolutions(List<Condition>[] cards, boolean printContainment) {
        return Lists.cartesianProduct(cards).stream().filter(l -> {
            Optional<Set<Condition.Combination>> combinations =
                    getCombinations(l);

            combinations.stream().filter(combs -> combs.size() == 1).forEach(combs -> {
                System.out.println(l + " matches " + combs.stream().toList().get(0));
                updateCountingMap(solnCounts, combs.stream().toList().get(0));

                /* Attempt to implement non-superfluous condition.
                // I'm not sure about it quite yet. */
                if (printContainment) {
                    Lists.cartesianProduct(l, l).stream()
                            .filter(ls -> ls.get(0) != ls.get(1))
                            .forEach(ls -> {
                                Condition first = ls.get(0);
                                Condition second = ls.get(1);
                                //System.out.println("Analyzing " + first + " : " + second);
                                if (first.getMatches().containsAll(second.getMatches())) {
                                    System.out.println("Condition " + first + " contains " + second);
                                }
                            });
                }
            });

            return combinations.filter(combinationSet -> combinationSet.size() == 1).isPresent();
        }).toList();
    }

    private static Optional<Set<Condition.Combination>> getCombinations(List<Condition> l) {
        return l.stream()
                .map(Condition::getMatches)
                .reduce(Sets::intersection);
    }
}