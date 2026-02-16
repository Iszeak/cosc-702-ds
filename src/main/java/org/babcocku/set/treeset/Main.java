package org.babcocku.set.treeset;

public class Main {
    public static void main(String[] args) {
        CustomTreeSet<Integer> studentIds = new CustomTreeSet<>();

        // Adding IDs in random order
        studentIds.add(505);
        studentIds.add(101);
        studentIds.add(999);
        studentIds.add(202);
        studentIds.add(101); // Attempting to add a duplicate

        System.out.print("Sorted Student IDs: ");
        studentIds.displaySorted();
        // Output: 101 202 505 999
    }
}
