package Pacts.Prac12_Kravchuk;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PaymentReportWriter {
   public static void writeReport(Path out, List<Payment> payments){
            try (BufferedWriter writer = Files.newBufferedWriter(out)) {
                for (Payment p : payments) {
                    writer.write(p.toString());
                    writer.newLine(); // перехід на новий рядок
                }
            } catch (IOException e) {
                System.err.println("Помилка запису: " + e.getMessage());
            }


   }



}
