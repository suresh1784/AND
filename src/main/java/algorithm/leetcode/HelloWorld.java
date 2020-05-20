package algorithm.leetcode;

import java.util.*;

public class HelloWorld{
    public static void main(String[] argv)
            throws Exception
    {

        try {

            // creating object of Hashtable<String, String>
            HashMap<String, String>
                    table = new HashMap<String, String>();

            // populate the table
            table.put(null, "1");
            table.put("key1", "1");
            table.put("key2", "2");
            table.put("key3", "3");

            // getting unmodifiable map
            // using unmodifiableMap() method
            Map<String, String> m = Collections
                    .unmodifiableMap(table);

            // printing the unmodifiableMap
            System.out.println("Initial collection: "
                    + table);

            // Adding element to new Collection
            System.out.println("\nTrying to modify"
                    + " the unmodifiablemap");
            m.put(null, "5");
        }

        catch (UnsupportedOperationException e) {
            System.out.println("Exception thrown : " + e);
        }
    }
}