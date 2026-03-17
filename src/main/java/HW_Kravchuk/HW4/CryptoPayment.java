package HW_Kravchuk.HW4;

public class CryptoPayment implements PaymentMethod{
    @Override
    public String name() {
        return "crypto payment";
    }

    @Override
    public boolean pay(int amount) {
        if (amount < 0 || (amount%5!=0))
            return false;
        else
            return true;
    }
}
