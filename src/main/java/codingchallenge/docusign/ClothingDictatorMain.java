package codingchallenge.docusign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Wartree on 5/30/17.
 */
public class ClothingDictatorMain {

    private static Logger LOGGER = LoggerFactory.getLogger(ClothingDictatorMain.class);

    public static void main (String args[]) {



        TestDomestic();

    }
    public static void TestDomestic() {
        ClothingDictatorExe cde = new ClothingDictatorExe();

        String in = "HOT 8, 6, 4, 2, 1, 7";
        cde.executeCommand(in);
    }
}
