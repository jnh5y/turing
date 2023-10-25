package org.example;

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
    public static Condition card13_cond1 = new Condition("Yellow < Purple", c -> c.yellow() < c.purple());
    public static Condition card13_cond2 = new Condition("Yellow = Purple", c -> c.yellow() == c.purple());
    public static Condition card13_cond3 = new Condition("Yellow > Purple", c -> c.yellow() > c.purple());
    public static Condition card14_cond1 = new Condition("Blue < Yellow & Purple", c -> c.blue() < c.yellow() && c.blue() < c.purple());
    public static Condition card14_cond2 = new Condition("Yellow < Blue & Purple", c ->  c.yellow() < c.blue() && c.yellow() < c.purple());
    public static Condition card14_cond3 = new Condition("Purple < Yellow & Blue", c -> c.purple() < c.yellow() && c.purple() < c.blue());
    public static Condition card18_cond1 = new Condition("Sum is Even", c -> c.sum() % 2 == 0);
    public static Condition card18_cond2 = new Condition("Sum is Odd", c -> c.sum() % 2 == 1);
    public static Condition card16_cond1 = new Condition("Even > Odd", c -> c.evenCount() >= 2);
    public static Condition card16_cond2 = new Condition("Even < Odd", c -> c.evenCount() <= 1);
    public static Condition card20_cond1 = new Condition("Triple number", c -> c.blue() == c.yellow() && c.yellow() == c.purple());
    public static Condition card20_cond2 = new Condition("Double Number", c ->  (c.blue() == c.yellow() && c.yellow() != c.purple()) || (c.yellow() == c.purple() && c.blue() != c.yellow()));
    public static Condition card20_cond3 = new Condition("No repetition", c ->  c.blue() != c.yellow() && c.yellow() != c.purple());
    public static Condition card21_cond1 = new Condition("No pairs", c -> !c.hasPair());
    public static Condition card21_cond2 = new Condition("A pair", c -> c.hasPair());
    public static Condition card22_cond1 = new Condition("Ascending order", c -> c.ascendingOrder());
    public static Condition card22_cond2 = new Condition("Descending order", c ->  c.descendingOrder());
    public static Condition card22_cond3 = new Condition("No order", c ->  !c.ascendingOrder() && !c.descendingOrder());
}

