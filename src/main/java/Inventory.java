import java.util.ArrayList;
import java.util.List;

class InsufficientInventory extends Exception {
    public InsufficientInventory(int currentInventory, int requestedInventory) {
        super("There is not enough inventory for this product. " +
                "Current Inventory: " + currentInventory + " Needed: " + requestedInventory);
    }
}

public class Inventory {
    private List<Product> products = new ArrayList<>();

    private int getProductIndex(String productId) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId().equals(productId)) {
                return i;
            }
        }

        return -1;
    }

    public void addProduct(Product product) {
        int index = getProductIndex(product.getProductId());
        if (index >= 0) {
            products.get(index).addStock(product.getQuantity());
        } else {
            products.add(product);
        }
    }

    public String getAllProductNames() {
        List<String> productIds = new ArrayList<>();
        for (Product product : products) {
            productIds.add(product.getProductId());
        }

        return String.join(", ", productIds);
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addProduct(new Product("milk", 3.5, 1));
        inventory.addProduct(new Product("banana", .6));

        System.out.println(inventory.getAllProductNames());
    }
}
