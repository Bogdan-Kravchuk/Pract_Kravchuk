package HW_Kravchuk.HW4;

public interface PaymentMethod {
    String name();
    boolean pay(int amount);
}
