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

    public void addProduct(String productId, double price, int quantity) {
        int index = getProductIndex(productId);
        if (index >= 0) {
            products.get(index).addStock(quantity);
        } else {
            products.add(new Product(productId, price, quantity));
        }
    }

    public void removeProduct(String productId, int quantity) throws InsufficientInventory {
        // you write this class
    }

    public Product getProduct(String productId) {
        int index = getProductIndex(productId);
        if (index >= 0) {
            return products.get(index);
        } else {
            return null;
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
        inventory.addProduct("milk", 3.5, 1);
        inventory.addProduct("banana", .6, 1);

        System.out.println(inventory.getAllProductNames());
    }
}
