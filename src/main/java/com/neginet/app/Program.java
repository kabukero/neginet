package com.neginet.app;

import java.util.HashMap;
import java.util.Map;

public class Program {

    // Set the path of the text file that contains all the data
    public static final String PATH_TEXT_FILE = "D:\\dev\\java2\\app\\src\\main\\resources\\coding-test-data.txt";

    // Set the size of the most common first names or last names
    public static final int MOST_COMMON_ELEMENTS_SIZE = 10;

    // Set the size of the list of modified names
    public static final int LIST_MODIFIED_NAMES_SIZE = 25;

    public static void main(String[] args) {
        Map<String, Integer> fullNames =  new HashMap<>();
        Map<String, Integer> lastNames = new HashMap<>();
        Map<String, Integer> firstNames = new HashMap<>();

        PeopleNameUtil.getNames(PATH_TEXT_FILE, fullNames, lastNames, firstNames);

        Map<String, Integer> mostCommonLastNames = PeopleNameUtil.getMostCommonElements(lastNames, MOST_COMMON_ELEMENTS_SIZE);
        Map<String, Integer> mostCommonFirstNames = PeopleNameUtil.getMostCommonElements(firstNames, MOST_COMMON_ELEMENTS_SIZE);

        showCardinality(fullNames, lastNames, firstNames);
        showMostCommonElements(mostCommonLastNames, "\n2. The most common last names are:");
        showMostCommonElements(mostCommonFirstNames, "\n3. The most common first names are:");
        showListOfModifiedNames(fullNames, LIST_MODIFIED_NAMES_SIZE);
    }

    static void showCardinality(final Map<String, Integer> fullNames, final Map<String, Integer> lastNames, final Map<String, Integer> firstNames) {
        System.out.println("\n1. The names cardinality for full, last, and first names:");
        System.out.println("Full names: " + fullNames.size());
        System.out.println("Last names: " + lastNames.size());
        System.out.println("First names: " + firstNames.size());
    }

    static void showMostCommonElements(final Map<String, Integer> lastNames, final String header) {
        System.out.println(header);
        for (Map.Entry<String, Integer> entry : lastNames.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    static void showListOfModifiedNames(final Map<String, Integer> fullNames, final long listSize) {
        System.out.println("\n4. List of Modified Names");
        Map<String, Integer> fullNamesModified = PeopleNameUtil.getListOfModifiedNames(fullNames, listSize);
        fullNamesModified.keySet().forEach(System.out::println);
    }
}
