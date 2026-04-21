package Pacts.Pract15_Kravchuk;

public class PracticeMain {

    public static void main(String[] args) throws ClassNotFoundException {

        ClassInfoPrinter.print(Book.class);


        System.out.println("------------------------------------------");

        ServiceFactory.create(CashPaymentService.class.getName());

        ServiceFactory.create(CardPaymentService.class.getName());

        System.out.println("-------------------------------------------");

        SetupFlow flow = new SetupFlow();
        StepRunner.run(flow);
    }
}
