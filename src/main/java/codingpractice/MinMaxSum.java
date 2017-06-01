package codingpractice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by Wartree on 5/25/17.
 */
public class MinMaxSum {
    private static final Logger LOGGER = LoggerFactory.getLogger(MinMaxSum.class);

    public void getSum(int[] arr) {

        Arrays.sort(arr);

        long maxSum = 0;
        long minSum = 0;
        minSum += arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            minSum += arr[i];
            maxSum += arr[i];
        }
        maxSum += arr[arr.length - 1];

        LOGGER.info("MAX:  {};  MIN:  {}", maxSum, minSum);
    }

}
