package Activities;

import java.util.HashMap;

public class Activity11 {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        hashMap.put(1, "Blue");
        hashMap.put(2, "White");
        hashMap.put(3, "Black");
        hashMap.put(4, "Green");
        hashMap.put(5, "Pink");

        // Print the Map
        System.out.println("Original map: " + hashMap);

        // Remove one colour
        hashMap.remove(3);
        // Map after removing a colour
        System.out.println("Map after removing Black: " + hashMap);

        // Check if green exists
        if(hashMap.containsValue("Green")) {
            System.out.println("Green exists in the Map");
        } else {
            System.out.println("Green does not exist in the Map");
        }

        // Print the size of the Map
        System.out.println("Number of colors in the Map is: " + hashMap.size());
    }
}
