import codingchallenge.docusign.ClothingDictatorExe;
import codingpractice.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * @author Krieghbaum
 *
 */
public class SnippetsMain {

    private static Logger LOGGER = LoggerFactory.getLogger(SnippetsMain.class);



    public static void main (String args[]) {



        TestDomestic();

    }

    public static void TestDomestic() {
        ClothingDictatorExe de = new ClothingDictatorExe();

        String in = "HOT 8, 6, 4, 2, 1, 7";
        de.executeCommand(in);
    }

    public static void TestDecToBinar() {
        int deci = 15;
        DecToBinary dtb = new DecToBinary();
        dtb.getBinary(deci);
    }

    public static void TestBetween2Sets() {

        int[] a = {2, 4};
        int[] b = {16, 32, 96};

    /*
    2 4
16 32 96
     */
        Between2Sets b2s = new Between2Sets();
        b2s.getTotalX(a, b);

    }

    public static void TestQuartiles() {
    /*
    3 7 8 5 12 14 21 13 18
     */
        int[] quartileList = {3, 7, 8, 5, 12, 14, 21, 13, 18};
        Quartiles q = new Quartiles();
        q.getQuartiles(quartileList, quartileList.length);
    }

    public static void TestMeanMedianMode() {
    /*
    10
64630 11735 14216 99233 14470 4978 73429 38120 51135 67060
     */

        int[] arr = {64630, 11735, 14216, 99233, 14470, 4978, 73429, 38120, 51135, 67060};
        MeanMedianMode mmm = new MeanMedianMode();
        mmm.getMMM(arr, arr.length);
    }

    public static void TestAppleOrange() {
    /*
    7 11
5 15
3 2
-2 2 1
5 -6
     */

        int rA = 7;
        int rB = 11;
        int apple = 5;
        int orange = 15;
        int[] apples = {-2, 2, 1};
        int[] oranges = {5, -6};
        AppleOrange ao = new AppleOrange();
        ao.getFruits(rA, rB, apple, orange, apples, oranges);
    }

    public static void TestGradeRoundUp() {
        int[] grades = {22, 55, 93, 98, 78, 66, 83};

        LOGGER.info("Grades before:  {}", grades);

        GradeRoundUp gru = new GradeRoundUp();
        gru.getGrades(grades);

    }

    public static void TestTimeConversion() {
        TimeConversion tc = new TimeConversion();

        String oldTime = "11:01:01AM";
        tc.convertTime2(oldTime);
    }

    public static void TestBirthday() {
        int[] arr = {3,1,2,3};

        BirthdayCandles bc = new BirthdayCandles();
        bc.getCandles(arr);
    }

    public static void TestMinMaxSum() {
        int[] arr = {1,2,1000000000,1000000000,1000000000};

        MinMaxSum mms = new MinMaxSum();
        mms.getSum(arr);

        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        long lMax = Long.MAX_VALUE;
        long lMin = Long.MIN_VALUE;

        LOGGER.info("Int Max:  {};  Int Min:  {}", max, min);
        LOGGER.info("Long Max:  {};  Long Min:  {}", lMax, lMin);
    }

    public static void TestEveryOther() {
        String myStr = "This is A Test";

        EveryOther eo = new EveryOther(myStr);
        eo.getEveryOther(myStr);
    }


    public static void TestContacts() {
        Contacts contacts = new Contacts();
//        contacts.printContacts();
//        contacts.addAll();
//        contacts.printContacts();

//        contacts.testC();
//        contacts.testBinary();
        contacts.testAll();
    }


    public static void TestMedian() {
        RunningMedian rm = new RunningMedian();
        int[] arr = new int[6];
        arr[0] = 12;
        arr[1] = 4;
        arr[2] = 5;
        arr[3] = 3;
        arr[4] = 8;
        arr[5] = 7;/*12
4
5
3
8
7*/

//        rm.createMedian(arr, arr.length);
//        rm.getMedian();

        for (int i = 0; i < arr.length; i++) {
            LOGGER.info("Adding {}", arr[i]);
            rm.addValue(arr[i]);
            LOGGER.info("Median:  {}", rm.getMedian());
        }

    }


    public static void TestQueueByStack() {
        QueueByStack qbs = new QueueByStack();
        qbs.MakeQueues();
        qbs.PrintQueues();
    }



    //  To test Balanced Bracket problem.
    public static void TestBalancedBracket(String[] args) {
        BalancedBrackets bb = new BalancedBrackets();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (bb.isBalanced(expression)) ? "YES" : "NO" );
        }
    }


}

