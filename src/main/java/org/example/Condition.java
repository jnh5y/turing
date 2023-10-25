package org.example;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Condition {
    public static List<Integer> ONE_TO_FIVE = List.of(1, 2, 3, 4, 5);

    public static List<Combination> allCombinations = Lists.cartesianProduct(ONE_TO_FIVE, ONE_TO_FIVE, ONE_TO_FIVE)
            .stream()
            .map(l -> new Combination(l.get(0), l.get(1), l.get(2))).sorted().collect(Collectors.toList());

    Function<Combination, Boolean> func;

    String description;

    @Override
    public String toString() {
        return "'" + description + '\'';
    }

    public Condition(String description, Function<Combination, Boolean> func) {
        this.description = description;
        this.func = func;
    }

    public Set<Combination> getMatches() {
        return allCombinations.stream().filter(comb -> func.apply(comb)).collect(Collectors.toSet());
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

        public long countNumber(Integer numberToFind) {
            return List.of(blue, yellow, purple).stream().filter(i -> i.equals(numberToFind)).count();
        }
    }

}
