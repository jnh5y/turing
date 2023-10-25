package org.example;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.*;
import java.util.stream.Collectors;

import static org.example.Cards.*;

public class Main {
    public static void main(String[] args) {
//        List<Condition> card4 = List.of(Conditions.card4_cond2); //List.of(Conditions.card4_cond1, Conditions.card4_cond2, Conditions.card4_cond3);
//        List<Condition> card9 = List.of(Conditions.card9_cond1); //, Conditions.card9_cond2, Conditions.card9_cond3);
//        List<Condition> card11 = List.of(Conditions.card11_cond1, /*Conditions.card11_cond2,*/ Conditions.card11_cond3);
//        List<Condition> card14 = List.of(Conditions.card14_cond1, Conditions.card14_cond2, Conditions.card14_cond3);

        // Example of applying a card ahead of time.
//        Condition.allCombinations = Condition.allCombinations.stream()
//                .filter(comb -> Conditions.card14_cond3.func.apply(comb)).collect(Collectors.toList());

        // Game 1
        // List<Condition>[] cards = new List[] {CARD_4, CARD_9, CARD_11, CARD_14};

        // Game 2
//        List<Condition>[] cards = new List[] {CARD_3, CARD_7, CARD_10, CARD_14};
        Condition.allCombinations = Condition.allCombinations.stream()
                .filter(comb -> !Conditions.card9_cond4.func.apply(comb))
                .filter((comb -> Conditions.card4_cond1.func.apply(comb)))
                .filter((comb -> Conditions.card9_cond1.func.apply(comb)))
                .filter((comb -> Conditions.card18_cond2.func.apply(comb)))
                .collect(Collectors.toList());

        System.out.println("Number of combinations considered: " + Condition.allCombinations.size());
        System.out.println("Combinations: " + Condition.allCombinations);

        // Game 12
        List<Condition>[] cards = new List[] {CARD_4, CARD_9, CARD_18, CARD_20};


        List<List<Condition>> conds = Lists.cartesianProduct(cards).stream().filter(l -> {
            Optional<Set<Condition.Combination>> combinations =
                    l.stream()
                            .map(Condition::getMatches)
                            .reduce(Sets::intersection);

            combinations.stream().filter(combs -> combs.size() == 1).forEach(combs -> {
                System.out.println(l + " matches " + combs.stream().toList().get(0));

                /* Attempt to implement non-superfluous condition.
                // I'm not sure about it quite yet. */
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
            });

            /* Debugging
            System.out.println("List of conditions: " + l);
            if (combinations.isEmpty()) {
                System.out.println("There are no matches for " + l);
            }
            */

            return combinations.filter(combinationSet -> combinationSet.size() == 1).isPresent();
        }).toList();

        /* conds.forEach(c -> {
            System.out.println("Conditions with 1 solution: " + c);
        }); */
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
}