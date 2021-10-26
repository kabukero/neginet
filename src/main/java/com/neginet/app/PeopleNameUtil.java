package com.neginet.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PeopleNameUtil {
    public static final Pattern patternLine = Pattern.compile("([A-Za-z]+),\\s([A-Za-z]+)\\s--\\s([A-Za-z]+)");
    public static final Pattern patternFullName = Pattern.compile("([A-Za-z]+),\\s([A-Za-z]+)");
    public static final int FULL_NAME_INDEX = 0, LAST_NAME_INDEX = 1, FIRST_NAME_INDEX = 2;

    public static void getNames(String pathTextFile, Map<String, Integer> fullNames, Map<String, Integer> lastNames, Map<String, Integer> firstNames) {
        Matcher matcher = null;
        BufferedReader buffer = null;
        String line;

        try {
            buffer = new BufferedReader(new FileReader(pathTextFile));

            // read the text file line by line
            while ((line = buffer.readLine()) != null) {
                matcher = patternLine.matcher(line);

                if (matcher.find()) {

                    // extract data
                    String lastName = matcher.group(LAST_NAME_INDEX);
                    String firstName = matcher.group(FIRST_NAME_INDEX);
                    String fullName = lastName + ", " + firstName;

                    // save data into hashmaps
                    fullNames.merge(fullName, 1, Integer::sum);
                    lastNames.merge(lastName, 1, Integer::sum);
                    firstNames.merge(firstName, 1, Integer::sum);

                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static Map<String, Integer> getMostCommonElements(final Map<String, Integer> stringElements, final long listSize) {
        long n = 0;

        Map<String, Integer> mapOutput = new LinkedHashMap<String, Integer>();
        Map<String, Integer> mapSorted = sortMapDescendingByValue(stringElements);

        for (Map.Entry<String, Integer> entry : mapSorted.entrySet()) {
            mapOutput.put(entry.getKey(), entry.getValue());
            n++;
            if (n == listSize) {
                break;
            }
        }

        return mapOutput;
    }

    public static Map<String, Integer> getFirstListOfModifiedNames(final Map<String, Integer> fullNames, final long listSize) {

        Map<String, Integer> modifiedFullNames = new HashMap<>();
        Map<String, Integer> lastNamesTemp = new HashMap<>();
        Map<String, Integer> firstNamesTemp = new HashMap<>();
        Matcher matcher = null;
        long n = 0;

        for(String fn : fullNames.keySet()) {
            matcher = patternFullName.matcher(fn);

            if (matcher.find()) {
                String fullName = matcher.group(FULL_NAME_INDEX);
                String lastName = matcher.group(LAST_NAME_INDEX);
                String firstName = matcher.group(FIRST_NAME_INDEX);

                if(!modifiedFullNames.containsKey(fullName) && !lastNamesTemp.containsKey(lastName) && !firstNamesTemp.containsKey(firstName)) {
                    modifiedFullNames.put(fullName, 1);
                    lastNamesTemp.put(lastName, 1);
                    firstNamesTemp.put(firstName, 1);
                    n++;
                    if(n == listSize) {
                        break;
                    }
                }
            }
        }

        return modifiedFullNames;
    }

    public static Map<String, Integer> getSecondListOfModifiedNames(final Map<String, Integer> fullNames, final long listSize) {
        Map<String, Integer> modifiedFullNames = new HashMap<>();
        Map<String, Integer> lastNamesTemp1 = new HashMap<>();
        Map<String, Integer> firstNamesTemp1 = new HashMap<>();
        Map<String, Integer> lastNamesTemp2 = new HashMap<>();
        Map<String, Integer> firstNamesTemp2 = new HashMap<>();
        Matcher matcher = null;
        long n = 0;

        // get lastName and firstName from the original list
        for(String fn : fullNames.keySet()) {
            matcher = patternFullName.matcher(fn);

            if (matcher.find()) {
                String lastName = matcher.group(LAST_NAME_INDEX);
                String firstName = matcher.group(FIRST_NAME_INDEX);

                if(!lastNamesTemp1.containsKey(lastName) && !firstNamesTemp1.containsKey(firstName)) {
                    lastNamesTemp1.put(lastName, 1);
                    firstNamesTemp1.put(firstName, 1);
                }
            }
        }

        // combine lastName with firstName
        for(String lastName : lastNamesTemp1.keySet()) {
            for(String firstName : firstNamesTemp1.keySet()) {

                String fullName = lastName + ", " +  firstName;

                if(!fullNames.containsKey(fullName) && !modifiedFullNames.containsKey(fullName) && !lastNamesTemp2.containsKey(lastName) && !firstNamesTemp2.containsKey(firstName)) {
                    modifiedFullNames.put(fullName, 1);
                    lastNamesTemp2.put(lastName, 1);
                    firstNamesTemp2.put(firstName, 1);
                    n++;
                    if(n == listSize) {
                        return modifiedFullNames;
                    }
                }
            }
        }
        return modifiedFullNames;
    }

    public static Map<String, Integer> getListOfModifiedNames(final Map<String, Integer> fullNames, final long listSize) {
        Map<String, Integer> firstListOfModifiedNames = PeopleNameUtil.getFirstListOfModifiedNames(fullNames, listSize);
        Map<String, Integer> secondListOfModifiedNames = PeopleNameUtil.getSecondListOfModifiedNames(firstListOfModifiedNames, listSize);
        return secondListOfModifiedNames;
    }

    public static Map<String, Integer> sortMapDescendingByValue(final Map<String, Integer> hashMapInput) {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(hashMapInput.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        Map<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
