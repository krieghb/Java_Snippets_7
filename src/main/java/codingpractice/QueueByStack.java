package codingpractice;

import org.omg.PortableInterceptor.INACTIVE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by Wartree on 5/23/17.
 *
 *
 */
public class QueueByStack {
    private static Logger LOGGER = LoggerFactory.getLogger(QueueByStack.class);


    private Stack<Integer> st1 = new Stack<>();
    private Stack<Integer> st2 = new Stack<>();
    private Queue<Integer> qu = new LinkedList<>();


    public List<Integer> MakeList() {

        List<Integer> allNums = new ArrayList<>();
        allNums.add(1);
        allNums.add(10);
        allNums.add(33);
        allNums.add(39);
        allNums.add(5);

        return allNums;
    }

    public void MakeQueues() {
        for (Integer i : MakeList()) {
            push(i);
            qu.add(i);
        }
    }


    public void PrintQueues() {
        LOGGER.info("Stack:  {}", toString());
        LOGGER.info("Queue:  {}", qu.toString());


        while (!isEmpty()) {
            LOGGER.info("Stack: {}", pop());
        }
        while (!qu.isEmpty()) {
            LOGGER.info("Queue: {}", qu.remove());
        }
    }

    public Integer push(Integer integer) {
        st1.push(integer);

        return integer;
    }
    public boolean isEmpty() {
        return st1.isEmpty() && st2.isEmpty();
    }

    private Integer peekOrPop(boolean peek) {
        Integer peekaboo;
        if (st2.isEmpty()) {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }
        if (peek) {
            peekaboo = st2.peek();
        }
        else {
            peekaboo = st2.pop();
        }
        return peekaboo;

    }
    public Integer peek() {
        return peekOrPop(true);
    }

    public Integer pop() {
        return peekOrPop(false);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator i;
        i = st1.isEmpty() ? st2.iterator() : st1.iterator();

        while (i.hasNext()) {
            sb.append(i.next());
            if (i.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }


}
