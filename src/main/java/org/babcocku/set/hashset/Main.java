package org.babcocku.set.hashset;

public class Main {
    public static void main(String[] args) {
        String[] fruits = {"Zebra", "Apple", "Mango", "Banana"};

        // Test HashSet
        System.out.println("--- HashSet Test ---");
        CustomHashSet<String> hSet = new CustomHashSet<>();
        for(String f : fruits) {
            hSet.add(f);
        }
        System.out.println("Contains 'Mango'? " + hSet.contains("Mango"));


        CustomHashSet<Integer> setA = new CustomHashSet<>();
        CustomHashSet<Integer> setB = new CustomHashSet<>();

        // Set A: {1, 2, 3}
        setA.add(1); setA.add(2); setA.add(3);

        // Set B: {3, 4, 5}
        setB.add(3); setB.add(4); setB.add(5);

        // Perform Union
        CustomHashSet<Integer> unionResult = setA.union(setB);
        System.out.println("Union (A + B): " + unionResult.getAllElements());
        // Expected: [1, 2, 3, 4, 5]

        // Perform Intersection
        CustomHashSet<Integer> intersectResult = setA.intersection(setB);
        System.out.println("Intersection (Common): " + intersectResult.getAllElements());
        // Expected: [3]
    }
}
