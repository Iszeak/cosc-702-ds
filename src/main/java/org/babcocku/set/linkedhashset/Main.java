package org.babcocku.set.linkedhashset;

public class Main {
    public static void main(String[] args) {

        CustomLinkedHashSet<String> set = new CustomLinkedHashSet<>();

        set.add("Isaac");
        set.add("Adegunle");
        set.add("Java");
        set.add("Isaac"); // duplicate

        set.printInOrder();
        // Isaac -> Adegunle -> Java -> null

        System.out.println(set.contains("Java")); // true

        set.remove("Adegunle");
        set.printInOrder();
        // Isaac -> Java -> null
    }
}
