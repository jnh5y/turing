package org.example;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        List<Condition> card4 = List.of(Conditions.card4_cond2); //List.of(Conditions.card4_cond1, Conditions.card4_cond2, Conditions.card4_cond3);
//        List<Condition> card9 = List.of(Conditions.card9_cond1); //, Conditions.card9_cond2, Conditions.card9_cond3);
//        List<Condition> card11 = List.of(Conditions.card11_cond1, /*Conditions.card11_cond2,*/ Conditions.card11_cond3);
//        List<Condition> card14 = List.of(Conditions.card14_cond1, Conditions.card14_cond2, Conditions.card14_cond3);

        // Example of applying a card ahead of time.
//        Condition.allCombinations = Condition.allCombinations.stream()
//                .filter(comb -> Conditions.card14_cond3.func.apply(comb)).collect(Collectors.toList());

        List<Condition> card4 = List.of(Conditions.card4_cond1, Conditions.card4_cond2, Conditions.card4_cond3);
        List<Condition> card9 = List.of(Conditions.card9_cond1, Conditions.card9_cond2, Conditions.card9_cond3);
        List<Condition> card11 = List.of(Conditions.card11_cond1, Conditions.card11_cond2, Conditions.card11_cond3);
        List<Condition> card14 = List.of(Conditions.card14_cond1, Conditions.card14_cond2, Conditions.card14_cond3);

        List<List<Condition>> conds = Lists.cartesianProduct(card4, card9, card11, card14).stream().filter(l -> {
            Optional<Set<Condition.Combination>> combinations =
                    l.stream()
                            .map(Condition::getMatches)
                            .reduce(Sets::intersection);

            combinations.stream().filter(combs -> combs.size() == 1).forEach(combs -> {
                System.out.println("There are matches for " + l + " Size: " + combs.size() + " Combs: " + combs);

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



                System.out.println();
            });

            /* Debugging
            System.out.println("List of conditions: " + l);
            if (combinations.isEmpty()) {
                System.out.println("There are no matches for " + l);
            }
            */

            return combinations.filter(combinationSet -> combinationSet.size() == 1).isPresent();
        }).toList();

        conds.stream().forEach(c -> {
            System.out.println("Conditions with 1 solution: " + c);
        });
        System.out.println("There are " + conds.size() + " possible conditions which lead to unique solutions.");
  }
}