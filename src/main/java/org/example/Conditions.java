package org.example;

import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;

public class Conditions {

    public static Condition card3_cond1 = new Condition("Yellow < 3", c -> c.yellow() < 3);
    public static Condition card3_cond2 = new Condition("Yellow = 3", c -> c.yellow() == 3);
    public static Condition card3_cond3 = new Condition("Yellow > 3", c -> c.yellow() > 3);
    public static Condition card4_cond1 = new Condition("Yellow < 4", c -> c.yellow() < 4);
    public static Condition card4_cond2 = new Condition("Yellow = 4", c -> c.yellow() == 4);
    public static Condition card4_cond3 = new Condition("Yellow > 4", c -> c.yellow() > 4);
    public static Condition card7_cond1 = new Condition("Purple is even", c -> c.purple() % 2 == 0);
    public static Condition card7_cond2 = new Condition("Purple is odd", c -> c.purple() % 2 == 1);
    public static Condition card9_cond1 = new Condition("Zero 3s", c -> c.countNumber(3) == 0L);
    public static Condition card9_cond2 = new Condition("One 3", c -> c.countNumber(3) == 1L);
    public static Condition card9_cond3 = new Condition("Two 3s", c -> c.countNumber(3) == 2L);
    public static Condition card9_cond4 = new Condition("Three 3s", c -> c.countNumber(3) == 3L);
    public static Condition card10_cond1 = new Condition("Zero 4s", c -> c.countNumber(4) == 0L);
    public static Condition card10_cond2 = new Condition("One 4", c -> c.countNumber(4) == 1L);
    public static Condition card10_cond3 = new Condition("Two 4s", c -> c.countNumber(4) == 2L);
    public static Condition card10_cond4 = new Condition("Three 4s", c -> c.countNumber(4) == 3L);
    public static Condition card11_cond1 = new Condition("Blue < Yellow", c -> c.blue() < c.yellow());
    public static Condition card11_cond2 = new Condition("Blue = Yellow", c -> c.blue() == c.yellow());
    public static Condition card11_cond3 = new Condition("Blue > Yellow", c -> c.blue() > c.yellow());

    public static Condition card14_cond1 = new Condition("Blue < Yellow & Purple", c -> c.blue() < c.yellow() && c.blue() < c.purple());
    public static Condition card14_cond2 = new Condition("Yellow < Blue & Purple", c ->  c.yellow() < c.blue() && c.yellow() < c.purple());
    public static Condition card14_cond3 = new Condition("Purple < Yellow & Blue", c -> c.purple() < c.yellow() && c.purple() < c.blue());

    public static Condition cond = new Condition("Purple > 3", combination -> combination.purple() > 3);

    public static Condition cond2 = new Condition("Blue = 1 and Yellow =4", combination -> combination.blue() == 1 &&
            combination.yellow() == 4);
    public static Condition cond3 = new Condition("All cards", c -> true);

    public static Condition cond4 = new Condition("143", combination -> combination.blue() == 1 &&
            combination.yellow() == 4 && combination.purple() == 3);

    public static Set<Condition.Combination> intersection(Condition cond1, Condition cond2) {
        return Sets.intersection(cond1.getMatches(), cond2.getMatches());

    }
}

