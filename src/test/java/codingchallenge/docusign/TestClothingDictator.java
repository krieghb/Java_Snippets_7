package codingchallenge.docusign;

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

/**
 * @author Krieghbaum
 *
 *  JUnit Test of the Clothing Dictator.
 *
 */
public class TestClothingDictator {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestClothingDictator.class);

    ClothingDictator clothingDictator;
    String in;
    String actual;
    String expected;

    @BeforeClass
    public static void classSetup() {
        LOGGER.info("Class Setup.");
    }

    @Before
    public void testSetup() {
        LOGGER.info("Test Setup.");

    }

    @AfterClass
    public static void classTearDown() {
        LOGGER.info("Class Tear Down.");
    }
    @After
    public void testTearDown() {
        LOGGER.info("Test Tear Down.");
    }

    @Test
    public void testDomesticHotSuccess1() {

        in = "HOT 8, 6, 4, 2, 1, 7";
        expected = "Removing PJs, shorts, t-shirt, sun visor, sandals, leaving house";
        clothingDictator = new ClothingDictatorHot(in);
        actual = clothingDictator.decideWeather();
        assertEquals(expected, actual);
    }

    @Test
    public void testDomesticColdSuccess1() {

        in = "COLD 8, 6, 3, 4, 2, 5, 1, 7";
        expected = "Removing PJs, pants, socks, shirt, hat, jacket, boots, leaving house";
        clothingDictator = new ClothingDictatorCold(in);
        actual = clothingDictator.decideWeather();
        assertEquals(expected, actual);

    }

    @Test
    public void testDomesticColdFail1() {

        in = "COLD 8, 6, 3, 4, 2, 5, 7";
        expected = "Removing PJs, pants, socks, shirt, hat, jacket, fail";
        clothingDictator = new ClothingDictatorCold(in);
        actual = clothingDictator.decideWeather();
        assertEquals(expected, actual);

    }

    @Test
    public void testDomesticColdFail2() {

        in = "COLD 6";
        expected = "fail";
        clothingDictator = new ClothingDictatorCold(in);
        actual = clothingDictator.decideWeather();
        assertEquals(expected, actual);

    }

    @Test
    public void testDomesticHotFail1() {

        in = "HOT 8, 6, 6";
        expected = "Removing PJs, shorts, fail";
        clothingDictator = new ClothingDictatorHot(in);
        actual = clothingDictator.decideWeather();
        assertEquals(expected, actual);

    }

    @Test
    public void testDomesticHotFail2() {

        in = "HOT 8, 6, 3";
        expected = "Removing PJs, shorts, fail";
        clothingDictator = new ClothingDictatorHot(in);
        actual = clothingDictator.decideWeather();
        assertEquals(expected, actual);

    }
}
