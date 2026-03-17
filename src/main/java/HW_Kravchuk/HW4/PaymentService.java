package HW_Kravchuk.HW4;

public class PaymentService {

    boolean process(PaymentMethod method, int amount) {
        System.out.println("Логування - " + method.name() + "сума: " + amount);
        return method.pay(amount);
    }

    boolean process(PaymentMethod[] method, int amount) {
        boolean result = false;
        for (PaymentMethod method1 : method) {
            if (method1.pay(amount)) {
                System.out.println("Логування - " + method1.name() + "сума: " + amount);
                return result = true;
            }
            System.out.println("Помилка оплати способом: ");
            return result = false;
        }
        return result;
    }
}
