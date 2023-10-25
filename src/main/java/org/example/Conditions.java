package org.example;

import com.google.common.collect.Sets;

import java.util.Set;

public class Conditions {
    public static Condition cond = new Condition(combination -> combination.purple() > 3);

    public static Condition cond2 = new Condition(combination -> combination.blue() == 1 &&
            combination.yellow() == 4);
    public static Condition cond3 = new Condition(c -> true);

    public static Condition cond4 = new Condition(combination -> combination.blue() == 1 &&
            combination.yellow() == 4 && combination.purple() == 3);

    public static Set<Condition.Combination> intersection(Condition cond1, Condition cond2) {
        return Sets.intersection(cond1.getMatches(), cond2.getMatches());

    }
}

