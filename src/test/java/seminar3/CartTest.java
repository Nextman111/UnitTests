package seminar3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    private ArrayList<Product> products;
    private Cart cart;

    @BeforeEach
    void setUp() {
        // Инициализируем вспомогательные данные
        cart = new Cart();

        products = new ArrayList<>();
        products.add(new Product("ABC", 500, 5));
        products.add(new Product("Вася", 400, 1));

    }

    @Test
    @DisplayName("Store: Добавление продукта")
    void addProduct() {
        // Запоминаем сколько лежит продуктов в инвентаре
        int countBefore = cart.getProducts().size();
        // Исполняем метод в цикле добавляем данные и запоминаем количество итераций
        int iter = addProductsToCart(products);
        // Запоминаем сколько лежит после запуска
        int countAfter = cart.getProducts().size();
        // Сравниваем, должен добавиться iter объектов
        assertEquals(countBefore + iter, countAfter);
    }
    private int addProductsToCart(List<Product> products){
        int iter = 0;
        for (Product product: products) {
            cart.addProduct(product);
            iter++;
        }
        return iter;
    }

    @Test
    void removeProduct() {
        // Исполняем метод в цикле добавляем данные и запоминаем количество итераций
        int iter = addProductsToCart(products);
        // Запоминаем сколько лежит продуктов в инвентаре
        int countBefore = cart.getProducts().size();
        // Исполняем метод удаляем объект
        cart.removeProduct(cart.getProducts().get(0));
        // Запоминаем сколько лежит после запуска
        int countAfter = cart.getProducts().size();
        // Сравниваем, должен удалиться один объект
        assertEquals(countBefore - 1, countAfter);
    }

    @Test
    void calculateTotalPrice() {
        // Исполняем метод в цикле добавляем данные в корзину
        addProductsToCart(products);
        // Считаем суммму того что положили в корзину
        Double expectedSummary = cart.getProducts().stream().mapToDouble((x)-> x.getPrice() * x.getQuantity()).sum();
        // Сравниваем результаты
        assertEquals(expectedSummary, cart.calculateTotalPrice());
    }
}