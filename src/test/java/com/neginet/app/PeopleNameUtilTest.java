package com.neginet.app;

//import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.neginet.app.PeopleNameUtil;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class PeopleNameUtilTest {

    private Map<String, Integer> fullNamesTest;

    @BeforeEach
    void setUp() throws Exception {
        fullNamesTest = new HashMap<>();
        fullNamesTest.put("McDermott, Dewitt", 0);
        fullNamesTest.put("Bernhard, Alejandrin", 0);
        fullNamesTest.put("Bartoletti, Sammie", 0);
        fullNamesTest.put("Zieme, Mattie", 0);
        fullNamesTest.put("Murazik, Kailee", 0);
        fullNamesTest.put("Greenfelder, Genoveva", 0);
        fullNamesTest.put("Effertz, Ulises", 0);
        fullNamesTest.put("Orn, Astrid", 0);
        fullNamesTest.put("Luettgen, Angelina", 0);
        fullNamesTest.put("Jerde, Dax", 0);
        fullNamesTest.put("Shields, Kailee", 0);
        fullNamesTest.put("Schimmel, Lisandro", 0);
        fullNamesTest.put("Swift, Breanne", 0);
        fullNamesTest.put("Friesen, Jackson", 0);
        fullNamesTest.put("Rippin, George", 0);
        fullNamesTest.put("Pfeffer, Elvie", 0);
        fullNamesTest.put("Von, Timmothy", 0);
        fullNamesTest.put("Thompson, Ciara", 0);
        fullNamesTest.put("Deckow, Halle", 0);
        fullNamesTest.put("Upton, Jayson", 0);
        fullNamesTest.put("Hamill, Reyna", 0);
        fullNamesTest.put("Greenfelder, Jacinto", 0);
        fullNamesTest.put("Altenwerth, Timothy", 0);
        fullNamesTest.put("Wolff, Greyson", 0);
        fullNamesTest.put("Little, Brayan", 0);
        fullNamesTest.put("Jacobson, Cale", 0);
        fullNamesTest.put("Raynor, Era", 0);
        fullNamesTest.put("Legros, Ramona", 0);
        fullNamesTest.put("Herman, Glen", 0);
        fullNamesTest.put("Reinger, Golda", 0);
        fullNamesTest.put("Adams, Tyrel", 0);
        fullNamesTest.put("Lynch, Jeremy", 0);
        fullNamesTest.put("Schmeler, Samantha", 0);
        fullNamesTest.put("Schaden, Aliyah", 0);
        fullNamesTest.put("Klocko, Suzanne", 0);
        fullNamesTest.put("Bergnaum, Oliver", 0);
        fullNamesTest.put("Pacocha, Mercedes", 0);
        fullNamesTest.put("Wehner, Duane", 0);
        fullNamesTest.put("Feest, Brandi", 0);
        fullNamesTest.put("Kirlin, Ari", 0);
        fullNamesTest.put("Moen, Donato", 0);
        fullNamesTest.put("Feeney, Ruthe", 0);
        fullNamesTest.put("Medhurst, Horacio", 0);
        fullNamesTest.put("Harris, Oswaldo", 0);
        fullNamesTest.put("Koelpin, Rosendo", 0);
        fullNamesTest.put("Heidenreich, Alexie", 0);
        fullNamesTest.put("Denesik, Shany", 0);
        fullNamesTest.put("Parker, Sabrina", 0);
        fullNamesTest.put("Rosenbaum, Cathrine", 0);
        fullNamesTest.put("Goyette, Greyson", 0);
        fullNamesTest.put("Schinner, Uriah", 0);
        fullNamesTest.put("Dietrich, Bradford", 0);
        fullNamesTest.put("Kuhic, Anne", 0);
        fullNamesTest.put("Ratke, Genesis", 0);
        fullNamesTest.put("Schamberger, Kameron", 0);
        fullNamesTest.put("Anderson, Maybelle", 0);
        fullNamesTest.put("Runte, Thad", 0);
        fullNamesTest.put("Bernhard, Jacynthe", 0);
        fullNamesTest.put("Gislason, Omari", 0);
        fullNamesTest.put("Amore, Elisha", 0);
        fullNamesTest.put("Weber, Cyrus", 0);
        fullNamesTest.put("Reichert, Oma", 0);
        fullNamesTest.put("Reilly, Liliane", 0);
        fullNamesTest.put("Hyatt, Delmer", 0);
        fullNamesTest.put("Breitenberg, Tobin", 0);
        fullNamesTest.put("Dare, Colton", 0);
        fullNamesTest.put("Ward, Loyal", 0);
        fullNamesTest.put("DuBuque, Anahi", 0);
        fullNamesTest.put("Satterfield, Lydia", 0);
        fullNamesTest.put("Kulas, Richard", 0);
        fullNamesTest.put("Breitenberg, Bell", 0);
        fullNamesTest.put("Wolf, Eugene", 0);
        fullNamesTest.put("Feeney, Kenna", 0);
        fullNamesTest.put("Beatty, Lacy", 0);
        fullNamesTest.put("Reilly, Ceasar", 0);
        fullNamesTest.put("Ullrich, Karson", 0);
        fullNamesTest.put("Schinner, Markus", 0);
        fullNamesTest.put("Jerde, Devyn", 0);
        fullNamesTest.put("Smitham, Delores", 0);
        fullNamesTest.put("Borer, Sigrid", 0);
        fullNamesTest.put("McGlynn, Rosina", 0);
        fullNamesTest.put("Frami, Abagail", 0);
        fullNamesTest.put("Wunsch, Austyn", 0);
        fullNamesTest.put("Stiedemann, Dallas", 0);
        fullNamesTest.put("Berge, Zoila", 0);
        fullNamesTest.put("Bradtke, Nicklaus", 0);
        fullNamesTest.put("Will, Antonette", 0);
        fullNamesTest.put("Zulauf, Justen", 0);
        fullNamesTest.put("Rice, Cynthia", 0);
        fullNamesTest.put("Simonis, Joseph", 0);
        fullNamesTest.put("Stiedemann, Jalen", 0);
        fullNamesTest.put("Kertzmann, Victor", 0);
        fullNamesTest.put("Hermann, Brianne", 0);
        fullNamesTest.put("Kunde, Wilford", 0);
        fullNamesTest.put("Wolf, Josianne", 0);
        fullNamesTest.put("Bernhard, Lamont", 0);
        fullNamesTest.put("Rau, Darrin", 0);
        fullNamesTest.put("Satterfield, Ole", 0);
        fullNamesTest.put("Bayer, Concepcion", 0);
        fullNamesTest.put("Bailey, Zella", 0);

    }

    @Test
    @DisplayName("TestGetMostCommonElements")
    void TestGetMostCommonElements() throws Exception {
        int mapSizeExpected = 5;
        Map<String, Integer> testNames = new HashMap<>();
        testNames.put("Lang", 136);
        testNames.put("Barton", 143);
        testNames.put("Hills", 130);
        testNames.put("Terry", 129);
        testNames.put("Reilly", 185);
        testNames.put("Johns", 128);
        testNames.put("Ortiz", 135);
        testNames.put("Becker", 128);
        testNames.put("Hilll", 134);
        testNames.put("Peter", 252);
        testNames.put("Romaguera", 128);
        testNames.put("Ben", 300);
        testNames.put("Susan", 115);
        testNames.put("Robert", 45);

        Map<String, Integer> expectedNames = new LinkedHashMap<>();
        expectedNames.put("Ben", 300);
        expectedNames.put("Peter", 252);
        expectedNames.put("Reilly", 185);
        expectedNames.put("Barton", 143);
        expectedNames.put("Lang", 136);

        Map<String, Integer> orderedNames = PeopleNameUtil.getMostCommonElements(testNames, mapSizeExpected);
        assertEquals(mapSizeExpected, orderedNames.size());

        List<String> expectedNamesTest = new ArrayList<String>(expectedNames.keySet());
        List<String> orderedNamesTest = new ArrayList<String>(orderedNames.keySet());

        assertTrue(orderedNamesTest.containsAll(expectedNamesTest));

        for (int i = 0; i < expectedNamesTest.size(); i++) {
            assertEquals(expectedNamesTest.get(i), orderedNamesTest.get(i));
        }

        List<Integer> expectedFrequencyTest = new ArrayList<Integer>(expectedNames.values());
        List<Integer> orderedFrequencyTest = new ArrayList<Integer>(orderedNames.values());

        assertTrue(orderedFrequencyTest.containsAll(expectedFrequencyTest));

        for (int i = 0; i < expectedFrequencyTest.size(); i++) {
            assertEquals(expectedFrequencyTest.get(i), orderedFrequencyTest.get(i));
        }
    }

    @Test
    @DisplayName("TestGetFirstListOfModifiedNames")
    void TestGetFirstListOfModifiedNames() throws Exception {
        int mapSizeExpected = 10;
        Map<String, Integer> actualFullNames = PeopleNameUtil.getFirstListOfModifiedNames(fullNamesTest, 10);

        assertEquals(mapSizeExpected, actualFullNames.size());

        Pattern patternFullName = Pattern.compile("([A-Za-z]+),\\s([A-Za-z]+)");
        Matcher matcher = null;

        List<String> lastNamesTemp = new ArrayList<>();
        List<String> firstNamesTemp = new ArrayList<>();

        for(String fn : actualFullNames.keySet()) {
            matcher = patternFullName.matcher(fn);

            if (matcher.find()) {
                String lastName = matcher.group(PeopleNameUtil.LAST_NAME_INDEX);
                String firstName = matcher.group(PeopleNameUtil.FIRST_NAME_INDEX);

                assertFalse(lastNamesTemp.contains(lastName));
                lastNamesTemp.add(lastName);

                assertFalse(firstNamesTemp.contains(firstName));
                firstNamesTemp.add(firstName);

            }
        }
    }

    @Test
    @DisplayName("TestGetListOfModifiedNames")
    void TestGetListOfModifiedNames() throws Exception {
        int mapSizeExpected = 10;
        Map<String, Integer> firstListOfModifiedNames = PeopleNameUtil.getFirstListOfModifiedNames(fullNamesTest, 10);
        Map<String, Integer> secondListOfModifiedNames = PeopleNameUtil.getSecondListOfModifiedNames(firstListOfModifiedNames, 10);

        assertEquals(mapSizeExpected, secondListOfModifiedNames.size());

        for(String fn : firstListOfModifiedNames.keySet()) {
            assertTrue(!secondListOfModifiedNames.containsKey(fn));
        }
    }
}
