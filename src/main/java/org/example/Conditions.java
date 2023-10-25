package org.example;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Conditions {
    public Condition cond = new Condition(combination -> combination.purple > 3);

    public class Condition {
        public static List<Integer> ONE_TO_FIVE = List.of(1, 2, 3, 4, 5);

        public static List<Combination> allCombinations = Lists.cartesianProduct(ONE_TO_FIVE, ONE_TO_FIVE, ONE_TO_FIVE)
                .stream()
                .map( l -> new Combination(l.get(0), l.get(1), l.get(2))).sorted().collect(Collectors.toList());

        Function<Combination, Boolean> func;

        public Condition(Function<Combination, Boolean> func) {
            this.func = func;
        }

        public List<Combination> getMatches() {
            return allCombinations.stream().filter(comb -> func.apply(comb)).toList();
        }
    }

    public record Combination(Integer blue, Integer yellow, Integer purple) implements Comparable<Combination> {
        @Override
        public int compareTo(Combination o) {
            if (this.blue.compareTo(o.blue) != 0) {
                return this.blue.compareTo(o.blue);
            }
            if (this.yellow.compareTo(o.yellow) != 0) {
                return this.yellow.compareTo(o.yellow);
            }
            if (this.purple.compareTo(o.purple) != 0) {
                return this.purple.compareTo(o.purple);
            }
            return 0;
        }
    }
}
