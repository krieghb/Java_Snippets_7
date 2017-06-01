package codingpractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Wartree on 5/28/17.
 *
 */
public class Between2Sets {

    public void getTotalX(int[] a, int[] b) {
        int maxSize = a.length > b.length ? a.length : b.length;
        List<Integer> xArr = new ArrayList<>();
        int maxNum = 100;
        boolean isX;
        boolean isY;
        int count = 0;
        for (int i = 2; i < maxNum; i++) {
            isX = true;
            for (int j = 0; j < a.length; j++) {
                if (i % a[j] != 0) {
                    isX = false;
                    break;
                }
            }
            isY = true;
            if (isX) {
                for (int j = 2; j < b.length; j++) {
                    if (b[j] % i != 0) {
                        isY = false;
                        break;
                    }
                }
            }
            if (isX && isY) {
                count++;
            }

        }
        System.out.println("Count:  " + count);
    }

    public int getLCD(int[] arr) {
        int lcd = 0;

        Arrays.sort(arr);
        int current = arr[0];
        while(lcd == 0) {
            for (int i = 0; i < arr.length; i++) {
                if (i % current != 0) {
                    break;
                }
                lcd = i;
            }
            if (lcd != 0) {
                current += arr[0];
            }
        }

        return lcd;
    }
}
