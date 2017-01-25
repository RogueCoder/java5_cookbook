package org.rogue.coder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nathan on 1/20/2017.
 */
public class RCForEach {

    public static void main(String[] args) {

        //List of String values
        List<String> stringList = Arrays.asList(
                new String[]{"Rogue", "Coder", "Was", "Here"}
        );

        //if just doing forEach, we don't need a stream()
        stringList.forEach(string ->
                //print it!
                System.out.println(string)
        );//look Ma, no curly brackets!

        //List of our test POJO's
        List<RCPojo> pojoList = Arrays.asList(
                new RCPojo[]{
                        new RCPojo("one", "two", 2),
                        new RCPojo("three", "four", 4),
                        new RCPojo("five", "six", 6)
                }
        );

        //just a boolean property, nothing to see here
        boolean myBoolean = false;

        //More than one operation, so let's add some curly brackets
        pojoList.forEach(pojo->{
            //print our pojo out to system
            System.out.println(pojo.toString());

            //modify the bar property
            pojo.setBar(pojo.getBar().concat("!"));

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

    }

}
