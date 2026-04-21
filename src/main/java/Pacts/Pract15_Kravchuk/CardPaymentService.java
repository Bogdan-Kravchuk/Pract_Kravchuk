package Pacts.Pract15_Kravchuk;

public class CardPaymentService implements PaymentService {
    @Override
    public void pay() {
        System.out.println("Pay card");
    }
}
