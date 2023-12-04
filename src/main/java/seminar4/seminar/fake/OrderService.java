package seminar4.seminar.fake;

public class OrderService {
    private PaymentGateway paymentGateway;

    public OrderService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean placeOrder(double totalAmount) {
        try {
// Обрабатываем платеж через PaymentGateway
            paymentGateway.processPayment(totalAmount);
// Возвращаем true, если платеж успешно обработан
            return true;
        } catch (Exception e) {
// Возвращаем false, если платеж не удался
            return false;
        }
    }
}