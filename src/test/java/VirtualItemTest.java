import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import shop.VirtualItem;

import static org.testng.Assert.assertEquals;

@Test(groups = "business")
class VirtualItemTest {
    private VirtualItem disk;
    private static final String DISK_NAME = "Windows";
    private static final int PRICE = 11;
    private final static int SIZE_ON_DISK = 20000;

    @BeforeMethod
    void beforeMethod() {
        disk = getVirtualItemWithValues(new VirtualItem(), DISK_NAME, PRICE, SIZE_ON_DISK);
    }

    @Test
    void toStringMethodOutputInfoTest() {
        assertEquals(disk.toString(), "Class: " + disk.getClass() + "; Name: " + DISK_NAME + "; Price: " +
                Double.toString(PRICE) + "; Size on disk: " + Double.toString(SIZE_ON_DISK), "'toString' method of " +
                String.format("%s class contains incorrect info.", disk.getClass()));
    }

    static VirtualItem getVirtualItemWithValues(VirtualItem item, String diskName, int price, int sizeOnDisk) {
        item.setName(diskName);
        item.setPrice(price);
        item.setSizeOnDisk(sizeOnDisk);
        return item;
    }
}