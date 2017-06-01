package codingpractice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Wartree on 5/26/17.
 *
 */
public class AppleOrange {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppleOrange.class);

    public void getFruits(int rangeA, int rangeB, int apple, int orange, int[] apples, int[] oranges) {
        int appleCount = 0;
        int orangeCount = 0;
        int appleLocale;
        int orangeLocale;

        for (int i = 0; i < apples.length; i++) {
            appleLocale = apples[i] + apple;
            if (appleLocale >= rangeA && appleLocale <= rangeB ) {
                appleCount++;
            }
        }

        for (int i = 0; i < oranges.length; i++ ) {
            orangeLocale = oranges[i] + orange;
            if (orangeLocale >= rangeA && orangeLocale <= rangeB) {
                orangeCount++;
            }
        }

        LOGGER.info("Apples:  {};  Oranges:  {}", appleCount, orangeCount);
    }
}
