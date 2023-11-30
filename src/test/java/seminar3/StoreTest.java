package seminar3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StoreTest {
    private Store store;
    private List<Product> products;

    @BeforeEach
    void setUp() {
        // Инициализируем вспомогательные данные
        store = new Store();

        products = new ArrayList<>();
        products.add(new Product("ABC", 500, 5));
        products.add(new Product("Вася", 400, 1));

    }

    @Test()
    @DisplayName("Store: Добавление продукта")
    void addProductToInventory() {
        // Запоминаем сколько лежит продуктов в инвентаре
        int countBefore = store.getInventory().size();
        // Исполняем метод в цикле добавляем данные и запоминаем количество итераций
        int iter = addProductsToStore(products);
        // Запоминаем сколько лежит после запуска
        int countAfter = store.getInventory().size();
        // Сравниваем, должен добавиться iter объектов
        assertEquals(countBefore + iter, countAfter);
    }

    private int addProductsToStore(List<Product> products){
        int iter = 0;
        for (Product product: products) {
            store.addProductToInventory(product);
            iter++;
        }
        return iter;
    }


    @Test
    @DisplayName("Store: Удаление продукта")
    void removeProductFromInventory() {
        // Исполняем метод в цикле добавляем данные и запоминаем количество итераций
        int iter = addProductsToStore(products);
        // Запоминаем сколько лежит продуктов в инвентаре
        int countBefore = store.getInventory().size();
        // Исполняем метод удаляем объект
        store.removeProductFromInventory(products.get(0));
        // Запоминаем сколько лежит после запуска
        int countAfter = store.getInventory().size();
        // Сравниваем, должен удалиться один объект
        assertEquals(countBefore - 1, countAfter);
    }


    @Test
    @DisplayName("Store: поиск продукта")
    void findProductByName() {
        // добавляем продукты
        addProductsToStore(products);
        // добавляем продукт для поиска
        Product productFind = new Product("Петр", 400, 1);
        store.addProductToInventory(productFind);
        // исполняем метод поиска, сохраняем возврат
        var findeProduct = store.findProductByName(productFind.getName());
        // проверяем результат на совпадение с искомым экземпляром
        assertEquals(productFind, findeProduct);
    }

    @Test
    @DisplayName("Store: Создание корзины")
    void createCart() {
        // исполняем метод, запоминаем возврат
        var cart = store.createCart();
        // Проверяем полученый объект на соответствие с классом Cart
        assertTrue(cart instanceof Cart);
    }
}