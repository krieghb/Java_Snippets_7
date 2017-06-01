package codingpractice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by Wartree on 5/25/17.
 */
public class BirthdayCandles {

    SortedMap<String, Integer> hmm = new TreeMap<>();


    private static final Logger LOGGER = LoggerFactory.getLogger(BirthdayCandles.class);

    public void getCandles(int[] arr) {
        Arrays.sort(arr);

        int top = arr[arr.length - 1];
        int count = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] < top) {
                break;
            }
            count++;
        }


        LOGGER.info("Count: {}", count);


        int foo = 4;
        foo = -(foo + 1);

        foo = -(foo);
        LOGGER.info("FOO: {}", foo);



    }
}
