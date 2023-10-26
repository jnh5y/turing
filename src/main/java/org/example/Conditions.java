package org.example;

public class Conditions {
    public static Condition card1_cond1 = new Condition("Blue = 1", c -> c.blue() == 1);
    public static Condition card1_cond2 = new Condition("Blue > 1", c -> c.blue() > 1);
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
    public static Condition card15_cond1 = new Condition("Blue > Yellow & Purple", c -> c.blue() > c.yellow() && c.blue() > c.purple());
    public static Condition card15_cond2 = new Condition("Yellow > Blue & Purple", c ->  c.yellow() > c.blue() && c.yellow() > c.purple());
    public static Condition card15_cond3 = new Condition("Purple > Yellow & Blue", c -> c.purple() > c.yellow() && c.purple() > c.blue());
    public static Condition card16_cond1 = new Condition("Even > Odd", c -> c.evenCount() >= 2);
    public static Condition card16_cond2 = new Condition("Even < Odd", c -> c.evenCount() <= 1);

    public static Condition card17_cond1 = new Condition("Zero evens", c -> c.evenCount() == 0);
    public static Condition card17_cond2 = new Condition("One even", c -> c.evenCount() == 1);
    public static Condition card17_cond3 = new Condition("Two evens", c -> c.evenCount() == 2);
    public static Condition card17_cond4 = new Condition("Three evens", c -> c.evenCount() == 3);

    public static Condition card18_cond1 = new Condition("Sum is Even", c -> c.sum() % 2 == 0);
    public static Condition card18_cond2 = new Condition("Sum is Odd", c -> c.sum() % 2 == 1);
    public static Condition card20_cond1 = new Condition("Triple number", c -> c.blue() == c.yellow() && c.yellow() == c.purple());
    public static Condition card20_cond2 = new Condition("Double Number", c ->  (c.blue() == c.yellow() && c.yellow() != c.purple()) || (c.yellow() == c.purple() && c.blue() != c.yellow()));
    public static Condition card20_cond3 = new Condition("No repetition", c ->  c.blue() != c.yellow() && c.yellow() != c.purple());
    public static Condition card21_cond1 = new Condition("No pairs", c -> !c.hasPair());
    public static Condition card21_cond2 = new Condition("A pair", c -> c.hasPair());
    public static Condition card22_cond1 = new Condition("Ascending order", c -> c.ascendingOrder());
    public static Condition card22_cond2 = new Condition("Descending order", c ->  c.descendingOrder());
    public static Condition card22_cond3 = new Condition("No order", c ->  !c.ascendingOrder() && !c.descendingOrder());

    public static Condition card26_cond1 = new Condition("Blue < 3", c -> c.blue() < 3);
    public static Condition card26_cond2 = new Condition("Yellow < 3", c -> c.yellow() < 3);
    public static Condition card26_cond3 = new Condition("Purple < 3", c -> c.purple() < 3);
    public static Condition card27_cond1 = new Condition("Blue < 4", c -> c.blue() < 4);
    public static Condition card27_cond2 = new Condition("Yellow < 4", c -> c.yellow() < 4);
    public static Condition card27_cond3 = new Condition("Purple < 4", c -> c.purple() < 4);

    public static Condition card29_cond1 = new Condition("Blue = 3", c -> c.blue() == 3);
    public static Condition card29_cond2 = new Condition("Yellow = 3", c -> c.yellow() == 3);
    public static Condition card29_cond3 = new Condition("Purple = 3", c -> c.purple() == 3);
    public static Condition card33_cond1 = new Condition("Blue is even", c -> c.blue() % 2 == 0);
    public static Condition card33_cond2 = new Condition("Blue is odd", c -> c.blue() % 2 == 1);
    public static Condition card33_cond3 = new Condition("Yellow is even", c -> c.yellow() % 2 == 0);
    public static Condition card33_cond4 = new Condition("Yellow is odd", c -> c.yellow() % 2 == 1);
    public static Condition card33_cond5 = new Condition("Purple is even", c -> c.purple() % 2 == 0);
    public static Condition card33_cond6 = new Condition("Purple is odd", c -> c.purple() % 2 == 1);
    public static Condition card35_cond1 = new Condition("Blue >= Purple and Yellow", c -> c.blue() >= c.purple() && c.blue() >= c.yellow());
    public static Condition card35_cond2 = new Condition("Yellow >= Blue and Purple", c -> c.yellow() >= c.blue() && c.yellow() >= c.purple());
    public static Condition card35_cond3 = new Condition("Purple >= Yellow and Blue", c -> c.purple() >= c.yellow() && c.purple() >= c.blue());

    public static Condition card36_cond1 = new Condition("Sum = 3x", c -> c.sum() % 3 == 0);
    public static Condition card36_cond2 = new Condition("Sum = 4x", c -> c.sum() % 4 == 0);
    public static Condition card36_cond3 = new Condition("Sum = 5x", c -> c.sum() % 5 == 0);

    public static Condition card46_cond1 = new Condition("Zero 3s", c -> c.countNumber(3) == 0);
    public static Condition card46_cond2 = new Condition("Zero 4s", c -> c.countNumber(4) == 0);
    public static Condition card46_cond3 = new Condition("One 3", c -> c.countNumber(3) == 1);
    public static Condition card46_cond4 = new Condition("One 4", c -> c.countNumber(4) == 1);
    public static Condition card46_cond5 = new Condition("Two 3s", c -> c.countNumber(3) == 2);
    public static Condition card46_cond6 = new Condition("Two 4s", c -> c.countNumber(4) == 2);

    public static Condition card48_cond1 = new Condition("Blue < Yellow", c -> c.blue() < c.yellow());
    public static Condition card48_cond2 = new Condition("Blue = Yellow", c -> c.blue() == c.yellow());
    public static Condition card48_cond3 = new Condition("Blue > Yellow", c -> c.blue() > c.yellow());
    public static Condition card48_cond4 = new Condition("Blue < Purple", c -> c.blue() < c.purple());
    public static Condition card48_cond5 = new Condition("Blue = Purple", c -> c.blue() == c.purple());
    public static Condition card48_cond6 = new Condition("Blue > Purple", c -> c.blue() > c.purple());
    public static Condition card48_cond7 = new Condition("Yellow < Purple", c -> c.yellow() < c.purple());
    public static Condition card48_cond8 = new Condition("Yellow = Purple", c -> c.yellow() == c.purple());
    public static Condition card48_cond9 = new Condition("Yellow > Purple", c -> c.yellow() > c.purple());

}