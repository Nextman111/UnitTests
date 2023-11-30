package seminar3;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> inventory;

    public Store() {
        inventory = new ArrayList<>();
    }

    public void addProductToInventory(Product product) {
        inventory.add(product);
    }

    public void removeProductFromInventory(Product product) {
        inventory.remove(product);
    }

    public Product findProductByName(String name) {
        for (Product product : inventory) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getInventory() {
        return inventory;
    }

    public Cart createCart() {
        return new Cart();
    }
}
