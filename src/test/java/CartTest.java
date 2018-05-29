import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import static org.testng.Assert.assertEquals;

@Test(groups = "business")
class CartTest {
    private VirtualItem disk = VirtualItemTest.getVirtualItemWithValues(new VirtualItem(), "Name", 25, 10000);
    private RealItem car = RealItemTest.getRealItemWithValues(new RealItem(), 2000, "auto", 2344);
    private Cart andrewCart = new Cart("andrew-cart");

    @BeforeMethod
    void beforeMethod() {
        andrewCart.addRealItem(car);
        andrewCart.addVirtualItem(disk);
    }

    @Test()
    void totalCartPriceTest() {
        double totalPrice = car.getPrice() + car.getPrice() * 0.2 + disk.getPrice() + disk.getPrice() * 0.2;
        assertEquals(totalPrice, andrewCart.getTotalPrice());
    }
}