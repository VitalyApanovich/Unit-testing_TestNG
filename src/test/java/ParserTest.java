import org.testng.annotations.*;
import parser.JsonParser;
import shop.Cart;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

@Test(groups = "unit")
class ParserTest {
    private static final String CART_NAME = "test";
    private JsonParser jpClass;
    private File file;

    @DataProvider(name = "Input Params")
    public Object[][] inputParams() {
        return new Object[][]{{":"}, {"<"}, {">"}, {"?"}, {"*"}};
    }

    @BeforeMethod
    void beforeMethod() {
        jpClass = new JsonParser();
        String pathName = "src/main/resources/" + CART_NAME + ".json";
        file = new File(pathName);
    }

    @AfterMethod
    void afterMethod() {
        try {
            java.nio.file.Files.deleteIfExists(Paths.get(file.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(enabled = false)
    void readFromFileReturnsCartClassTest() {
        jpClass.writeToFile(new Cart(CART_NAME));
        assertEquals(Cart.class, jpClass.readFromFile(file).getClass());
    }

    @Parameters({"Path"})
    @Test()
    void readFromFileExpectsFileClassTest(String path) {
        assertThrows(parser.NoSuchFileException.class, () -> jpClass.readFromFile(new File(path)));
    }

    @Test
    void writeToFileReturnsExpectedCartNameTest() {
        jpClass.writeToFile(new Cart(CART_NAME));
        assertEquals(CART_NAME, jpClass.readFromFile(file).getCartName());
    }

    @Test(dataProvider = "Input Params")
    void writeToFileHandlesReservedCharactersGracefullyTest(String inputParam) {
        jpClass.writeToFile(new Cart(inputParam));
        assertThrows(parser.NoSuchFileException.class, () -> jpClass.readFromFile(new File("src/main/resources/" + inputParam + ".json")));
    }
}