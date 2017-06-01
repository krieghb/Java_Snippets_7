package codingpractice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by Wartree on 5/25/17.
 *
 */
public class EveryOther {

    private static final Logger LOGGER = LoggerFactory.getLogger(EveryOther.class);

//    private char[] myString;
//    private char[] str1;
//    private char[] str2;

    private StringBuilder sb1 = new StringBuilder();
    private StringBuilder sb2 = new StringBuilder();




    public EveryOther(String str) {
//        myString = str.toCharArray();
//        str1 = new char[str.length()];
//        str2 = new char[str.length()];
    }




    public void getEveryOther(String str) {
//        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) {
//                str1[count] = str.charAt(i);
                sb1.append(str.charAt(i));
            }
            else {
//                str2[count++] = str.charAt(i);
                sb2.append(str.charAt(i));
            }
        }

//        LOGGER.info("Str1:  {};  Str2:  {}", Arrays.toString(str1), Arrays.toString(str2));
        LOGGER.info("Str1:  {};  Str2:  {}", sb1.toString(), sb2.toString());



    }



}
