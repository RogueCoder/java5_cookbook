package org.rogue.coder;

import java.util.*;
import java.util.function.IntBinaryOperator;

/**
 * Created by RogueCoder on 1/12/2017.
 */
public class RCStream {

    public static void main(String[] args) {

        //List of String values
        List<String> stringList = Arrays.asList(
                new String[]{"Rogue", "Coder", "Was", "Here"}
        );

        //use a pipeline to filter out null values
        stringList.stream()
                .filter(string -> null != string)
                .forEach(string -> System.out.println(string));

        //List of RCPojo's
        List<RCPojo> pojoList = Arrays.asList(
                new RCPojo[]{
                        new RCPojo("one","two", 2),
                        new RCPojo("three", "four", 4),
                        new RCPojo("five", "six", 6)
                }
        );

        //find the average of our val property in the RCPojo List
        double avg = pojoList
                .stream()
                .mapToInt(RCPojo::getVal)
                .average()
                .getAsDouble();
        System.out.println("Average: " + avg);

        //Initialize a new HashMap
        Map<String, Integer> map = new HashMap<>(2);
        map.put("foo",1);
        map.put("bar",2);

        //let's stream our map values then sum our values!
        int total = map
                .values()
                .stream()
                .mapToInt(i->i)
                .sum();
        System.out.println("Total: " + total);

        //old way :(
        int oldWayTotal = 0;
        for(int v: map.values()) {
            oldWayTotal += v;
        }
        System.out.println("Old Way Total: " + total);

        //use stream to find distinct values
        pojoList
                .stream()
                .mapToInt(RCPojo::getVal)
                .distinct()
                .forEach(i->
                    System.out.println("Distinct i: " + i)
                );

        int reduced = pojoList
                .stream()
                .mapToInt(RCPojo::getVal)
                .reduce((i, j) -> i+j)
                .getAsInt();

        System.out.println("Reduce: " + reduced);

        //here we are checking to see if any of the values are less than 6
        boolean anyLessThan6 = pojoList
                .stream()
                .mapToInt(RCPojo::getVal)
                .anyMatch(i -> i < 6);
        //you can also do allMatch(...)

        assert(anyLessThan6 == true);

    }

}
