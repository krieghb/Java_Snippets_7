package codingpractice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by Wartree on 5/24/17.
 *
 */
public class Contacts {
    private static Logger LOGGER = LoggerFactory.getLogger(Contacts.class);
    private static Set<String> allContacts = new TreeSet<>();
    private static String[] arr = new String[1];
    private static List<String> arrList = new ArrayList<>();

    private static String[] toTestArr = new String[14];

    public void addAll(){
        allContacts.add("hi");
        allContacts.add("there");
        allContacts.add("awesome");
        allContacts.add("bodacious");
        allContacts.add("hI");
        allContacts.add("zebra");
        allContacts.add("a");
        allContacts.add("thadius");
        allContacts.add("thuper");
        allContacts.add("duper");
        allContacts.add("pooper");
        allContacts.add("flooper");
        allContacts.add("grooper");
        allContacts.add("thing");


    }

    public void testArr() {
//        toTestArr[0] = "hack";
//        toTestArr[1] = "hackerrank";

        toTestArr[0] = "hi";
        toTestArr[1] = "there";
        toTestArr[2] = "awesome";
        toTestArr[3] = "bodacious";
        toTestArr[4] = "hI";
        toTestArr[5] = "zebra";
        toTestArr[6] = "a";
        toTestArr[7] = "thadius";
        toTestArr[8] = "thuper";
        toTestArr[9] = "duper";
        toTestArr[10] = "pooper";
        toTestArr[11] = "flooper";
        toTestArr[12] = "grooper";
        toTestArr[13] = "thing";
    }
    public void testAll() {
        testArr();
        allContacts.clear();

        for (String str : toTestArr) {
            LOGGER.info("Adding:  {} to {}", str, allContacts);
            allContacts.add(str);
            LOGGER.info("New:  {}", allContacts);
            testBinary();

        }
    }


    public void printContacts() {
        LOGGER.info("allContacts:  {}", allContacts);
    }

    public void testC() {
        Iterator i = allContacts.iterator();
        boolean allGood = true;
        String findIt = "th";
        int counter = 0;


        while (i.hasNext() && allGood) {
            String current = i.next().toString();
            if (findIt.length() > current.length()) {
                continue;
            }
            short compareTo = (short) findIt.compareTo(current.toLowerCase().substring(0, findIt.length()));
            LOGGER.info("Searching for th:  {} / {}", findIt, current);

            if (compareTo < 0) {
//                LOGGER.info("Current string is too high");
                allGood = false;
            } else if (compareTo == 0) {
//                LOGGER.info("Current string is equal");
                counter++;
            } else {
//                LOGGER.info("Current string is too small.");
            }

        }

        LOGGER.info("Count Total:  {}", counter);
    }


    public void testBinary() {
        String findIt = "th";
        testBinary(findIt);

    }
    public void testBinary(String findIt) {
        int counter = 0;
        int aIndex;
        int maxI = 0;
        int minI = 0;

        arr = new String[allContacts.size()];
        allContacts.toArray(arr);
        aIndex = getIndex(arr, findIt, 0, arr.length - 1);
        if (aIndex >= 0) {
//            if (aIndex == 0) {
//                counter = 1;
//                maxI = 0;
//                minI = 1;
//            }
//            else if (aIndex == arr.length - 1) {
//                counter = 1;
//                maxI = 1;
//                minI = 0;
//            }
//            else {

            if (aIndex > arr.length - 1) {
                maxI = 1;
            }
            else {
                maxI = getHighCount(aIndex + 1, findIt);
            }
                minI = getLowCount(aIndex, findIt);
                counter = maxI + minI;
//            }
//            LOGGER.info("LowCount:  {};  HighCount:  {}", minI, maxI);
        }
        LOGGER.info("Total?  {}", counter);
//        System.out.println(counter);

    }
    public int getIndex(String[] arr, String toSearch, int min, int max) {
        int index = -1;

        int low = 0;
        int mid;
        int high = arr.length - 1;
        String current;
        boolean found = false;

        while (low <= high) {
            mid = (low + high) / 2;
            current = arr[mid].length() >= toSearch.length() ? arr[mid].substring(0, toSearch.length()) : arr[mid];
            if (current.compareTo(toSearch) > 0) {
//                LOGGER.info("{} is greater than {}", arr[mid], toSearch);
                high = mid - 1;
            }
            else if (current.compareTo(toSearch) < 0) {
//                LOGGER.info("{} is less than {}", arr[mid], toSearch);
                low = mid + 1;
            }
            else {
//                LOGGER.info("Index set:  {}", mid);
                index = mid;
                found = true;
                break;
            }
        }

        if (!found) {
            index = -1;
        }
        return index;
    }

    public int getHighCount(int min, String toSearch) {
        LOGGER.info("MAX's min: {}", min);
        int index = min;
        int count = 0;
        while (index < arr.length) {
//            LOGGER.info("MAX index:  {}", index);
            if (arr[index].length() < toSearch.length()) {
                index++;
                continue;
            }
            if (toSearch.compareTo(arr[index].substring(0, toSearch.length())) < 0) {
                break;
            }
            if (toSearch.compareTo(arr[index].substring(0, toSearch.length())) == 0) {
                count++;
            }
            index++;
        }
        return count;
    }

    public int getLowCount(int max, String toSearch) {
        LOGGER.info("MIN's max: {}", max);
        int index = max;
        int count = 0;
        while (index >= 0) {
            if (arr[index].length() < toSearch.length()) {
                index--;
                continue;
            }
            if (toSearch.compareTo(arr[index].substring(0, toSearch.length())) > 0) {
                break;
            }
            if (toSearch.compareTo(arr[index].substring(0, toSearch.length())) == 0) {
                count++;
            }
            index--;
        }
        return count;
    }


}
