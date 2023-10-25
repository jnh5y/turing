package org.example;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        List<Set<Integer>> l1 = List.of(Set.of(1,2,3), Set.of(4,5));
//        List<Set<Integer>> l2 = List.of(Set.of(1,2), Set.of(3,4,5));
//        List<Set<Integer>> l3 = List.of(Set.of(1,2), Set.of(3), Set.of(4,5));
//
//        List<List<Set<Integer>>> ls = Lists.cartesianProduct(l1, l2, l3).stream().filter(l -> {
//            Set<Integer> s = l.stream().reduce(Sets::intersection).get();
//
//            System.out.println("List: " + l + " has intersection of size " + s.size());
//            return s.size() == 1;
//        }).toList();
//
//        System.out.println("LS " + ls);
//
//        System.out.println("Hello world!");
//
//        System.out.println("Ints: ");
//        Conditions.Condition.allCombinations.stream().forEach(comb -> System.out.println("Combination: " + comb));

        List<Condition> conditionList1 = List.of(Conditions.cond, Conditions.cond4);
        List<Condition> conditionList2 = List.of(Conditions.cond2, Conditions.cond3);
        List<List<Condition>> conds = Lists.cartesianProduct(conditionList1, conditionList2).stream().filter(l -> {
            System.out.println("List of conditions: " + l);

            Optional<Set<Condition.Combination>> combinations =
                    l.stream()
                            .map(Condition::getMatches)
                            .reduce(Sets::intersection);

            combinations.stream().forEach(combs -> {
                System.out.println("There are matches for " + l);
                System.out.println("Size: " + combs.size() + " Combs: " + combs);
            });

            if (combinations.isEmpty()) {
                System.out.println("There are no matches for " + l);
            }
            return combinations.filter(combinationSet -> combinationSet.size() == 1).isPresent();
        }).toList();

        conds.stream().forEach(c -> {
            System.out.println("Conditions with 1 solution: " + c);
        });

//        Conditions.cond.getMatches()
//                .forEach(combination ->
//                        System.out.println("Combination matching purple > 3: " + combination));
    }
}