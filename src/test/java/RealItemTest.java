import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import shop.RealItem;

import static org.testng.Assert.assertEquals;

@Test(groups = "business")
class RealItemTest {
    private RealItem car;
    private double weight = 1560;
    private static final String CAR_NAME = "Audi";
    private static final double PRICE = 32026.9;

    @BeforeMethod
    void beforeMethod() {
        car = getRealItemWithValues(new RealItem(), weight, CAR_NAME, PRICE);
    }

    @Test
    void toStringMethodOutputInfoTest() {
        assertEquals(car.toString(), "Class: " + car.getClass() + "; Name: " + CAR_NAME + "; Price: " +
                Double.toString(PRICE) + "; Weight: " + Double.toString(weight));
    }

    static RealItem getRealItemWithValues(RealItem item, double weight, String carName, double price) {
        item.setName(carName);
        item.setPrice(price);
        item.setWeight(weight);
        return item;
    }
}