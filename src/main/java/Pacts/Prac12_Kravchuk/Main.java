package Pacts.Prac12_Kravchuk;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
   public static void main(String[] args) throws IOException {
       Path cvs = Path.of("file.csv");
       Files.writeString(cvs, "id, email, Status, amountCents \n" +
               "1001, john.doe@example.com, PAID, 1500.00\n" +
               "1002, alice.smith@test.ua, NEW, 99.50\n" +
               "uuid-3a4b, bob.jones@mail.com, FAILED, 5000.0\n" +
               "user-88, mary.jane@company.net, PAID, 1250.75\n" +
               "999, test.user@domain.com, NEW, 0.0");

      PaymentLoader.load(cvs);


        List<Payment> payments = new ArrayList<>();
        Payment payment1 = new Payment("123", "@user", PaymentStatus.NEW, 10.0);
        payments.add(payment1);
        Payment payment2 = new Payment("456", "@user1", PaymentStatus.PAID, 50.0);
        payments.add(payment2);
        Payment payment3 = new Payment("789", "@user2", PaymentStatus.FAILED, 70.0);
        payments.add(payment3);


PaymentReportWriter.writeReport(Path.of("outFile.txt"),  payments);


    }

}
