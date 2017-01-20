package org.rogue.coder;

import com.sun.org.apache.xerces.internal.xs.StringList;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Nathan on 1/17/2017.
 */
public class RCOptional {

    public static void main(String[] args) {

        List<Optional<String>> stringList = new ArrayList<>(2);
        stringList.add(Optional.of("foo"));
        stringList.add(Optional.empty());
        stringList.add(Optional.ofNullable("bar"));
        //stringList.add(Optional.of(null)); throws NullPointerException
        stringList.add(Optional.ofNullable(null));//allows nulls

        //orElse let's you give a default value if optional is null or empty
        stringList.forEach(optional->

            //if value is empty / null then return N/A
            System.out.println(optional + " orElse Value: " + optional.orElse("N/A"))

        );

        System.out.println("");

        RCPojo rcPojo = new RCPojo("foo", "bar", 1);

        //orElse let's you give a default value if optional is null or empty
        stringList.forEach(optional->

                //if value is empty / null then return the getBar value of rcPojo instance
                System.out.println(optional + " orElseGet Value: " + optional.orElseGet(rcPojo::getBar))
                //If rcPojo.getBar() return null and optional.get() is null,
                //then an NullPointerException is thrown
                //Just want a String? Use optional.orElseGet(()->"Default")

        );

        System.out.println("");

        //check if a value is not null or empty
        stringList.forEach(optional->

                System.out.println("Is Present: " + optional.isPresent())

        );

    }

}
