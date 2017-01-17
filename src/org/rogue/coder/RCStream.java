package org.rogue.coder;

import java.util.*;

/**
 * Created by RogueCoder on 1/12/2017.
 */
public class RCStream {

    public static void main(String[] args) {

        //List of String values
        List<String> stringList = Arrays.asList(
                new String[]{"Rogue", "Coder", "Was", "Here"}
        );

        //List of our test POJO's
        List<RCPojo> pojoList = Arrays.asList(
                new RCPojo[]{
                        new RCPojo("one","two", 2),
                        new RCPojo("three", "four", 4)
                }
        );

        //if just doing forEach, we don't need a stream()
        stringList.forEach(string->
            //print it!
            System.out.println(string)
        );//look Ma, no curly brackets!

        //use a pipeline to filter out null values
        stringList.stream()
                .filter(string -> null != string)
                .forEach(string -> System.out.println(string));

        //just a boolean property, nothing to see here
        boolean myBoolean = false;

        //More than one operation, so let's add some curly brackets
        pojoList.forEach(pojo->{
            //print our pojo out to system
            System.out.println(pojo.toString());

            //modify the bar property
            setBarValue(pojo);

            /*
            //OOPS! can't set myBoolean in the stream!
            if(null != pojo.getBar())
                myBoolean = true;
            */
        });

        //Initialize a new HashMap
        Map<String, Integer> map = new HashMap<>(2);
        map.put("foo",1);
        map.put("bar",2);

        //print out our map keys and values
        map.forEach((k,v)->
            System.out.println("The value of: " + k + " is: " + v)
        );

        //let's stream our map values then sum our values!
        int total = map
                .values()
                .stream()
                .mapToInt(i->i)
                .sum();
        System.out.println("Total: " + total);

        //find the average of our val property in the RCPojo List
        double avg = pojoList
                .stream()
                .mapToInt(RCPojo::getVal)
                .average()
                .getAsDouble();
        System.out.println("Average: " + avg);

        //old way :(
        int oldWayTotal = 0;
        for(int v: map.values())
            oldWayTotal += v;
        System.out.println("Old Way Total: " + total);
    }

    public static void setBarValue(RCPojo pojo){
        pojo.setBar(pojo.getBar().concat("!"));
    }
}
