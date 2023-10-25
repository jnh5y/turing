package org.example;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Condition> conditionList1 = List.of(Conditions.cond, Conditions.cond4);
        List<Condition> conditionList2 = List.of(Conditions.cond2, Conditions.cond3);

        List<List<Condition>> conds = Lists.cartesianProduct(conditionList1, conditionList2).stream().filter(l -> {
            Optional<Set<Condition.Combination>> combinations =
                    l.stream()
                            .map(Condition::getMatches)
                            .reduce(Sets::intersection);

            combinations.stream().filter(combs -> combs.size() == 1).forEach(combs -> {
                System.out.println("There are matches for " + l + " Size: " + combs.size() + " Combs: " + combs);
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
  }
}