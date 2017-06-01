package codingpractice;

import javafx.collections.transformation.SortedList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by Wartree on 5/23/17.
 */
public class RunningMedian {

    private static Logger LOGGER = LoggerFactory.getLogger(RunningMedian.class);
    private Queue<Integer> higher = new PriorityQueue<>();
    private Queue<Integer> lower = new PriorityQueue<Integer>(10000, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });

    private int higherSize = 0;
    private int lowerSize = 0;
    private int totalSize = 0;


    public Integer addValue(Integer val) {
        if (lower.isEmpty()) {
            lower.add(val);
            lowerSize++;
        }
        else {
            if (lower.size() > higher.size()) {
                if (lower.peek() > val) {
                    higher.add(lower.poll());
                    lower.add(val);
                    higherSize++;
                }
                else {
                    higher.add(val);
                    higherSize++;
                }
            }
            else {
                Integer temp = higher.peek();
                if (temp != null && temp >= val) {
                    lower.add(val);
                    lowerSize++;
                }
                else {
                    lower.add(higher.poll());
                    higher.add(val);
                    lowerSize++;
                }
            }
        }
        totalSize++;
        if (totalSize != (higherSize + lowerSize)) {
            LOGGER.info("Sizes aren't matching.  t: {};  h: {};  l: {}", totalSize, higherSize, lowerSize);
        }
         return val;
    }

    public double getMedian() {
        double median;

        if (totalSize % 2 == 0) {
            double a = higher.peek();
            double b = lower.peek();
            median = (a + b) / 2;
        } else {
            median = lower.peek();
        }
        return median;
    }

    public void printQueues() {
        LOGGER.info("Queue:  {} {}", lower, higher);
    }

}
