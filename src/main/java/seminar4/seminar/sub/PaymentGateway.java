package seminar4.seminar.sub;


public interface PaymentGateway {
    boolean charge(double amount);
}