package codingpractice;

import java.util.Stack;

/**
 * Created by Wartree on 5/23/17.
 *
 */
public class BalancedBrackets {

    public boolean isBalanced(String expression) {
        boolean isBal = true;
        Stack<String> brackStack = new Stack<String>();

        for (String str : expression.split("")) {
            if (switchIt(str)) {
                brackStack.push(str);
            }
            else {
                if (brackStack.isEmpty() || (!getOpen(str).equals(brackStack.pop()))) {
                    isBal = false;
                    break;
                }
            }
        }
        if (!brackStack.isEmpty()) {
            isBal = false;
        }

        return isBal;
    }

    private String getOpen(String brack) {
        String str = "";
        if (brack.equals("}")) {
            str = "{";
        }
        else if (brack.equals(")")) {
            str = "(";
        }
        else if (brack.equals("]")) {
            str = "[";
        }

        return str;
    }


    private boolean switchIt(String brack) {
        return (brack.equals("{") || brack.equals("(") || brack.equals("["));
    }


}
