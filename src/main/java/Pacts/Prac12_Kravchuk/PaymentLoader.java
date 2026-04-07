package Pacts.Prac12_Kravchuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PaymentLoader {


  public   static void main(String[] args) {
        load(Path.of("file.csv"));
    }

    public static void load(Path csv) {
            List<Payment> payments = new ArrayList<>();
            int invalidLines = 0;

            try (BufferedReader br = Files.newBufferedReader(csv)) {
                String line = br.readLine();

                while ((line = br.readLine()) != null) {
                    if (line.isBlank()) continue;

                    try {
                        String[] parts = line.split(",");
                       // if (parts.length != 4) throw new IllegalArgumentException("Invalid columns count");

                        String id = parts[0].trim();
                        String email = parts[1].trim();
                        PaymentStatus status = PaymentStatus.valueOf(parts[2].trim().toUpperCase());
                        double amountCents = Double.parseDouble(parts[3].trim());

                        payments.add(new Payment(id, email, status, amountCents));
                    } catch (Exception e) {
                        invalidLines++;
                    }
                }
            } catch (IOException e) {
                System.err.println("Помилка читання файлу: " + e.getMessage());
            }

            System.out.println("Валідних платежів: " + payments.size());
            System.out.println("Відхилених рядків (invalidLines): " + invalidLines);
            ;
    }
    }

