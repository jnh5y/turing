package org.example;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class Main {
    public static void main(String[] args) {
        List<Set<Integer>> l1 = List.of(Set.of(1,2,3), Set.of(4,5));
        List<Set<Integer>> l2 = List.of(Set.of(1,2), Set.of(3,4,5));
        List<Set<Integer>> l3 = List.of(Set.of(1,2), Set.of(3), Set.of(4,5));

        List<List<Set<Integer>>> ls = Lists.cartesianProduct(l1, l2, l3).stream().filter(l -> {
            Set<Integer> s = l.stream().reduce(Sets::intersection).get();

            System.out.println("List: " + l + " has intersection of size " + s.size());
            return s.size() == 1;
        }).toList();

        System.out.println("LS " + ls);

        System.out.println("Hello world!");

        System.out.println("Ints: ");
        Conditions.Condition.allCombinations.stream().forEach(comb -> System.out.println("Combination: " + comb));

    }
}