package codingpractice;

import org.omg.PortableInterceptor.INACTIVE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wartree on 5/26/17.
 *
 */
public class MeanMedianMode {
    private static final Logger LOGGER = LoggerFactory.getLogger(MeanMedianMode.class);

    public void getMMM(int[] arr, int size) {
        Arrays.sort(arr);

        double mean = getMean(arr, size);
        double median = getMedian(arr, size);
        int mode = getMode(arr, size);

        LOGGER.info("Mean:  {};  Median:  {};  Mode:  {}", mean, median, mode);
        System.out.printf("%.1f\n%.1f\n%d", mean, median, mode);

    }

    public double getMean(int[] arr, int size) {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum+= arr[i];
        }
        return sum / size;
    }

    public double getMedian(int[] arr, int size) {
        double median;
        if (size % 2 == 0) {
            median = (arr[size / 2] + arr[(size / 2) - 1]) / 2.0;
        }
        else {
            median = arr[size / 2] / 1.0;
        }
        return median;
    }

    public int getMode(int[] arr, int size) {
        Map<Integer, Integer> modeMap = new HashMap<>();
        int currentInt;
        int maxOccurances = Integer.MIN_VALUE;
        int highInt = Integer.MAX_VALUE;
        int occurances;
        for (int i = 0; i < size; i++) {
            currentInt = arr[i];
            if (modeMap.containsKey(currentInt)) {
                occurances = modeMap.get(currentInt) + 1;
                modeMap.put(currentInt, occurances);
            }
            else {
                occurances = 1;
                modeMap.put(currentInt, 1);
            }
            if (occurances > maxOccurances || (occurances == maxOccurances && currentInt < highInt)) {
                maxOccurances = occurances;
                highInt = currentInt;
            }
        }

//        int highValue = Integer.MIN_VALUE;
//        int currentNum = Integer.MIN_VALUE;
//        int currentVal;
//
//        for (Integer myInt : modeMap.keySet()) {
//            currentVal = modeMap.get(myInt);
//            if (currentVal > highValue) {
//                highValue = currentVal;
//                currentNum = myInt;
//            }
//            else if (currentVal == highValue && myInt < currentNum) {
//                currentNum = myInt;
//            }
//        }

        return highInt;
    }
}
