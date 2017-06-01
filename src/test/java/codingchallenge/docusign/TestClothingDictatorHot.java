package codingchallenge.docusign;

import org.junit.Before;

import static org.junit.Assert.assertEquals;

/**
 *  @author Krieghbaum
 *
 */
public class TestClothingDictatorHot extends ClothingDictatorHot {

    private static ClothingDictatorHot cdh;

    @Before
    public void TestSetup() {
        cdh = new ClothingDictatorHot();
    }


    @org.junit.Test
    public void TestValidHotRemovePJs() {
        int removePJS = 8;
        String expectedResponse = "Removing PJs";
        String removeResponse = cdh.getResponse(removePJS);

        assertEquals(expectedResponse, removeResponse);
    }

    @org.junit.Test
    public void TestValidHotAddPants() {
        int addPants = 6;
        String expectedResponse = "shorts";
        cdh.removePJs();
        String actualResponse = cdh.getResponse(addPants);
        assertEquals(expectedResponse, actualResponse);
    }

    @org.junit.Test
    public void TestValidHotAddHat() {
        int addHat = 2;
        String expectedResponse = "sun visor";
        cdh.removePJs();
        cdh.wearShirt();
        String actualResponse = cdh.getResponse(addHat);
        assertEquals(expectedResponse, actualResponse);
    }

    @org.junit.Test
    public void TestFailHotAddHat() {
        int addHat = 2;
        String expectedResponse = "fail";
        cdh.removePJs();
        String actualResponse = cdh.getResponse(addHat);
        assertEquals(expectedResponse, actualResponse);
    }

}
