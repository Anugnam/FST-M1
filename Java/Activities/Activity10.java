package Activities;

import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<String>();
        // Adding element to HashSet
        hashSet.add("A");
        hashSet.add("N");
        hashSet.add("U");
        hashSet.add("S");
        hashSet.add("H");
        hashSet.add("A");

        //Print HashSet
        System.out.println("Original HashSet: " + hashSet);
        //Print size of HashSet
        System.out.println("Size of HashSet: " + hashSet.size());

        //Remove element
        System.out.println("Removing H from HashSet: " + hashSet.remove("H"));
        //Remove element that is not present
        if(hashSet.remove("X")) {
            System.out.println("X removed from the Set");
        } else {
            System.out.println("X is not present in the Set");
        }
        //Search for element
        System.out.println("Checking if S is present: " + hashSet.contains("S"));
        //Print updated HashSet
        System.out.println("Updated HashSet: " + hashSet);
    }
}
