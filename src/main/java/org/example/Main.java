package org.example;

import java.util.List;
import com.google.common.collect.Lists;

public class Main {
    public static void main(String[] args) {
        List<Integer> l1 = List.of(1, 2);
        List<Integer> l2 = List.of(3,4);

        Lists.cartesianProduct(l1, l2).stream().forEach( l -> System.out.println("List: " + l));

        System.out.println("Hello world!");
    }
}