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

        studentIds.displaySorted(); // 101 202 505 999

        System.out.println(studentIds.contains(3)); // false
        System.out.println(studentIds.size());      // 4
    }
}
