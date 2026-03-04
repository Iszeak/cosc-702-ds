package org.babcocku.set.treeset;

public class Main {
    public static void main(String[] args) {
        CustomTreeSet<Integer> studentIds = new CustomTreeSet<>();

    
        studentIds.add(505);
        studentIds.add(101);
        studentIds.add(999);
        studentIds.add(202);
        studentIds.add(101); 

        studentIds.displaySorted();

        System.out.println(studentIds.contains(3));
        System.out.println(studentIds.size());
    }
}
