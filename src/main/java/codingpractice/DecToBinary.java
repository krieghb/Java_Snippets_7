package codingpractice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by Wartree on 5/29/17.
 *
 */
public class DecToBinary {
    private static final Logger LOGGER = LoggerFactory.getLogger(DecToBinary.class);

    private Queue<Integer> binar = new LinkedList<>();
    private Stack<Integer> stack2 = new Stack<>();


    public void getBinary(int deci) {
        int n = deci;
        int remainder;
        while (n > 0) {
            remainder = n % 2;
            n = n / 2;
            binar.add(remainder);
//            binar.offer(remainder);
            stack2.push(remainder);
        }

        LOGGER.info("Queue:  {}", binar);
        LOGGER.info("Stack:  {}", stack2);
        getOnes(deci);


    }

    public void getOnes(int deci) {
        int max = 0;
        int current = 0;
        int top;
        boolean isZero;

//        String bin = Integer.toBinaryString(deci);
//
//        for (char one : bin.toCharArray()) {
//            isZero = one == '0';
//            if (isZero) {
//                if (current > max) {
//                    max = current;
//                }
//                current = 0;
//            }
//            else {
//                current++;
//            }
//        }

        while (!binar.isEmpty()) {
            top = binar.poll();
            isZero = top == 0;

            if (isZero ) {
                if (current > max) {
                    max = current;
                }
                current = 0;
            }
            else {
                    current++;
                }
            }

        if (current > max) {
            max = current;
        }
        LOGGER.info("Ones:  {}", max);
    }
}
