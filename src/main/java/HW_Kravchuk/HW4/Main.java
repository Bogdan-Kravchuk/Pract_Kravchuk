package HW_Kravchuk.HW4;

public class Main {


    static void main() {
        PaymentService paymentService = new PaymentService();

        PaymentMethod cardPayment = new CardPayment();
        PaymentMethod payPalPayment = new PayPalPayment();
        PaymentMethod cryptoPayment = new CryptoPayment();

        PaymentMethod[] methods = {cardPayment, payPalPayment, cryptoPayment};

        paymentService.process(methods, -1);

        BaseNotifier n = new EmailNotifier();
        n.notifyUser("Hello");


    }


}
