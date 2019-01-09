import org.junit.Assert;
import org.junit.Test;

public class InventoryTests {
    @Test
    public void addApples() {
        Inventory inventory = new Inventory();
        inventory.addProduct(new Product("apple", .6, 2));

        Assert.assertEquals(2, inventory.getProduct("apple").getQuantity());
    }

    @Test
    public void addMoreApples() {
        Inventory inventory = new Inventory();
        inventory.addProduct(new Product("apple", .6, 1));
        inventory.addProduct(new Product("apple", .6, 2));

        Assert.assertEquals(3, inventory.getProduct("apple").getQuantity());
    }

    @Test(expected = InsufficientInventory.class)
    public void removeApples() throws InsufficientInventory {
        Inventory inventory = new Inventory();
        inventory.addProduct(new Product("apple", .6, 10));
        inventory.removeProduct(new Product("apple", .6, 12));
    }
}
