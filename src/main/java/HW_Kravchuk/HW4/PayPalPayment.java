package HW_Kravchuk.HW4;

public class PayPalPayment implements PaymentMethod{


    @Override
    public String name() {
        return "PayPal payment";
    }

    @Override
    public boolean pay(int amount) {
        if (amount < 0 || amount < 10)
        return false;
        else
        return true;
    }
}
