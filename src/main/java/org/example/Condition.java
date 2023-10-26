package org.example;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Condition {
    public static List<Integer> ONE_TO_FIVE = List.of(1, 2, 3, 4, 5);

    public static List<Combination> allCombinations = Lists.cartesianProduct(ONE_TO_FIVE, ONE_TO_FIVE, ONE_TO_FIVE)
            .stream()
            .map(l -> new Combination(l.get(0), l.get(1), l.get(2))).sorted().collect(Collectors.toList());

    public static List<Combination> combinationsToAnalyze = Lists.cartesianProduct(ONE_TO_FIVE, ONE_TO_FIVE, ONE_TO_FIVE)
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
        return combinationsToAnalyze.stream().filter(comb -> func.apply(comb)).collect(Collectors.toSet());
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
            return Stream.of(blue, yellow, purple).filter(i -> i.equals(numberToFind)).count();
        }

        public Integer sum() {
            return blue + yellow + purple;
        }

        public long evenCount() {
            return Stream.of(blue, yellow, purple).filter(i -> i % 2 == 0).count();
        }

        public boolean hasPair() {
            return (blue == yellow && yellow != purple) ||
                    (blue == purple && yellow != purple) ||
                    (yellow == purple && blue != yellow);
        }

        public int largestSequence() {
            if (blue + 1 == yellow) {
                if (yellow + 1 == purple) {
                    return 3;
                }
                return 2;
            } else if (yellow + 1 == purple) {
                return 2;
            }
            if (blue - 1 == yellow) {
                if (yellow - 1 == purple) {
                    return 3;
                }
                return 2;
            } else if (yellow - 1 == purple) {
                return 2;
            }
            return 1;
        }
        public boolean ascendingOrder() {
            return blue < yellow && yellow < purple;
        }
        public boolean descendingOrder() {
            return blue > yellow && yellow > purple;
        }
    }
}
