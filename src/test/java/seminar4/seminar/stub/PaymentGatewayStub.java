package seminar4.seminar.stub;

import seminar4.seminar.sub.PaymentGateway;

public class PaymentGatewayStub implements PaymentGateway {
    @Override
    public boolean charge(double amount) {
        // Здесь мы предоставляем фиксированный результат для тестирования
        return amount >= 0; // Возвращаем true, если сумма положительная
    }
}