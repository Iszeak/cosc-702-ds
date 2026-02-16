package org.babcocku.set.hashset;

public class Main {

    public static void main(String[] args) {

        String[] fruits = {"Zebra", "Apple", "Mango", "Banana"};

        System.out.println("--- HashSet Test ---");

        CustomHashSet<String> hSet = new CustomHashSet<>();

        for (String f : fruits) {
            hSet.add(f);
        }

        System.out.print("Elements: ");
        printSet(hSet);

        System.out.println("Contains 'Mango'? " + hSet.contains("Mango"));
        System.out.println("Size: " + hSet.size());

        // Integer Sets
        CustomHashSet<Integer> setA = new CustomHashSet<>();
        CustomHashSet<Integer> setB = new CustomHashSet<>();

        // Set A
        setA.add(1);
        setA.add(6);
        setA.add(3);

        // Set B
        setB.add(3);
        setB.add(4);
        setB.add(5);

        System.out.print("\nSet A: ");
        printSet(setA);

        System.out.print("Set B: ");
        printSet(setB);

        // UNION
        CustomHashSet<Integer> unionResult = setA.union(setB);
        System.out.print("Union (A + B): ");
        printSet(unionResult);

        // INTERSECTION
        CustomHashSet<Integer> intersectResult = setA.intersection(setB);
        System.out.print("Intersection (Common): ");
        printSet(intersectResult);

        // REMOVE DEMO
        hSet.remove("Apple");
        System.out.print("\nAfter removing Apple: ");
        printSet(hSet);
    }

    // Manual printer (no Java utils)
    private static <T> void printSet(CustomHashSet<T> set) {

        System.out.print("[ ");

        set.forEach(value -> System.out.print(value + " "));

        System.out.println("]");
    }
}