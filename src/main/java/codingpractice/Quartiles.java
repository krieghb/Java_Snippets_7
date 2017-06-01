package codingpractice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by Wartree on 5/27/17.
 *
 */
public class Quartiles {

    private static final Logger LOGGER = LoggerFactory.getLogger(Quartiles.class);

    public void getQuartiles(int[] arr, int size) {
        Arrays.sort(arr);
        int splitSize = size / 2;
        int[] lArr = new int[splitSize];
        int[] hArr = new int[splitSize];
        int q1;
        int q2;
        int q3;
        System.arraycopy(arr, 0, lArr, 0, splitSize);
        splitSize = (size % 2 == 0) ? splitSize : splitSize + 1;
        System.arraycopy(arr, splitSize, hArr, 0, size / 2);

        if (size % 2 == 0) {
            q2 = (arr[size / 2 - 1] + arr[size / 2]) / 2;
        }
        else {
            q2 = arr[size / 2];
        }
        if (lArr.length % 2 == 0) {
            q1 = (lArr[lArr.length / 2 - 1] + lArr[lArr.length / 2]) / 2;
            q3 = (hArr[hArr.length / 2 - 1] + hArr[hArr.length / 2]) / 2;
        }
        else {
            q1 = lArr[lArr.length / 2];
            q3 = hArr[hArr.length / 2];
        }


        LOGGER.info("Q1:  {};  Q2:  {};  Q3:  {}", q1, q2, q3);

    }
}
