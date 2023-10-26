package org.example;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.*;
import java.util.stream.Collectors;

import static org.example.Cards.*;

public class Main {
    public static void main(String[] args) {
        // Game 1
        // List<Condition>[] cards = new List[] {CARD_4, CARD_9, CARD_11, CARD_14};
        // Game 2
        // List<Condition>[] cards = new List[] {CARD_3, CARD_7, CARD_10, CARD_14};
        // Game 12
        // List<Condition>[] cards = new List[] {CARD_4, CARD_9, CARD_18, CARD_20};

        boolean printContainment = false;
        Condition.allCombinations = Condition.allCombinations.stream()
//                .filter(comb -> !Conditions.card9_cond4.func.apply(comb))
                .filter((comb -> Conditions.card1_cond2.func.apply(comb)))
                .filter((comb -> Conditions.card7_cond1.func.apply(comb)))
                .filter((comb -> Conditions.card27_cond3.func.apply(comb)))
                .collect(Collectors.toList());

        System.out.println("Number of combinations considered: " + Condition.allCombinations.size());
        System.out.println("Combinations: " + Condition.allCombinations);

        List<Condition> CARD_48 = List.of(Conditions.card48_cond4, Conditions.card48_cond8);

        List<Condition>[] cards = new List[] {CARD_1, CARD_7, CARD_27, CARD_35, CARD_48};

        List<List<Condition>> conds = getUniqueSolutions(cards, printContainment);
        printCountsOfConditionsInSolutions(conds);
    }

    private static void printCountsOfConditionsInSolutions(List<List<Condition>> conds) {
        System.out.println("\nThere are " + conds.size() + " possible conditions which lead to unique solutions.\n");

        int numCards = conds.get(0).size();
        for (int i = 0; i < numCards; i++) {
            int finalI = i;
            Map<Condition, Integer> counts = new HashMap<>();
            conds.stream().forEach(ls -> {
                Condition cond = ls.get(finalI);
                if (counts.containsKey(cond)) {
                    counts.put(cond, counts.get(cond) + 1);
                } else {
                    counts.put(cond, 1);
                }
            });
            System.out.println("For card " + i + ": " + counts);
        }
    }

    private static List<List<Condition>> getUniqueSolutions(List<Condition>[] cards, boolean printContainment) {
        return Lists.cartesianProduct(cards).stream().filter(l -> {
            Optional<Set<Condition.Combination>> combinations =
                    l.stream()
                            .map(Condition::getMatches)
                            .reduce(Sets::intersection);

            combinations.stream().filter(combs -> combs.size() == 1).forEach(combs -> {
                System.out.println(l + " matches " + combs.stream().toList().get(0));

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
}