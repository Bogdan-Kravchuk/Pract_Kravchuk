package HW_Kravchuk.HW4;

public class CardPayment implements PaymentMethod {
    private String name;


    @Override
    public String name() {
        return "Card Payment";
    }

    @Override
    public boolean pay(int amount) {
        if (amount > 0 || amount < 50_000)
            return false;
        else
            return true;
    }

    public void refund(){
        System.out.println("Refunding....");
    }
}
