package seminar4.seminar.fake;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {

    @Test
    void testPlaceOrderWithFakePaymentGateway() {
// Создаем подделку FakePaymentGateway
        PaymentGateway fakePaymentGateway = new FakePaymentGateway();

// Создаем экземпляр OrderService с подделкой
        OrderService orderService = new OrderService(fakePaymentGateway);

// Вызываем метод placeOrder и ожидаем успешного платежа
        boolean result = orderService.placeOrder(100.0);

// Проверяем, что платеж был успешным
        assertTrue(result);
    }
}