package Pacts.Pract15_Kravchuk;

public class CashPaymentService implements PaymentService {
    @Override
    public void pay() {
        System.out.println("Pay cash");
    }
}
