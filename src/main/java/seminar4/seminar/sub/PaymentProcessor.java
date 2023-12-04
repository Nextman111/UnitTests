package seminar4.seminar.sub;

public class  PaymentProcessor {
    private PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean processPayment(double amount) {
// Логика обработки платежа с использованием платежной системы
        return paymentGateway.charge(amount);
    }
}
