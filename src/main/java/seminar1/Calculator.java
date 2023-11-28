package seminar1;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divider cannot be zero");
        }
        return (double) a / b;
    }

    public static double calculatingDiscount(double purchaseAmount, int discountAmount) {
        // purchaseAmount - сумма покупки
        // discountAmount - размер скидки
        if (purchaseAmount < 0){
            throw new ArithmeticException("Error: Negative purchase amount");
        }

        if (discountAmount < 0){
            throw new ArithmeticException("Error: Negative discount");
        }

        if (discountAmount > 100){
            throw new ArithmeticException("Error: The discount should not be more than 100% ");
        }

        double discount = 1 - (double) discountAmount/100;

        return discount ==0 ? purchaseAmount : purchaseAmount * discount; // Метод должен возвращать сумму покупки со скидкой
    }
}