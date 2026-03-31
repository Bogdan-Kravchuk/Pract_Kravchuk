package Pacts.Pract11_Kravchuk;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    static void main(String[] args) {
        List<Book> books = List.of(
                new Book("Clean Code", "Robert Martin", 2008, List.of("clean", "practice", "java")),
                new Book("Effective Java", "Joshua Bloch", 2018, List.of("java", "best", "api")),
                new Book("Modern Java", "Nicolai Parlog", 2020, List.of("java", "streams", "records")),
                new Book("Java Concurrency", "Brian Goetz", 2006, List.of("concurrency", "java"))
        );

        List<Sale> sales = List.of(
                new Sale("a@ex.com", "Tea", 120),
                new Sale("b@ex.com", "Cake", 200),
                new Sale("a@ex.com", "Tea", 120),
                new Sale("c@ex.com", "Coffee", 150),
                new Sale("b@ex.com", "Cake", 200)
        );
//сортування більше 2015 року
        List<Book> filter = books.stream().filter(book -> book.year()>2015).toList();
        System.out.println(filter);
        System.out.println("-------------------------------------------------------------");
        //сортування за алфавітом
        List<String> sorted = books.stream()
                .map(book -> book.title().toUpperCase())
                .sorted()
                .limit(3)
                .toList();
        System.out.println(sorted);


        System.out.println("----------------------------- task 2");
        List<String> allTegs = books.stream().flatMap(book -> book.tags().stream()).toList();
        System.out.println(allTegs);
        System.out.println("-----------------------------");
        List<String> allTegs2 = books.stream().flatMap(book -> book.tags().stream())
                .distinct()
                .toList();
        System.out.println(allTegs2);
        System.out.println("-----------------------------");
        List<String> allTegs3 = books.stream().flatMap(book -> book.tags().stream())
                .distinct()
                .sorted()
                .toList();
        System.out.println(allTegs3);
        System.out.println("-----------------------------");
        Map<String, Long> tagFrequency = books.stream().flatMap(book -> book.tags().stream())
                .collect(Collectors.groupingBy(s ->s, Collectors.counting()));
        System.out.println(tagFrequency);
        System.out.println("-----------------------------");

        int N = 3;
        List<String> topTags = tagFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(N)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println("Топ " + N + " теги: " + topTags);

        System.out.println("\n--- Завдання 3 ---");

        // Виручка за продуктами
        Map<String, Integer> revenueByProduct = sales.stream()
                .collect(Collectors.toMap(
                        Sale::product,
                        Sale::cents,
                        Integer::sum
                ));
        System.out.println("Виручка за продуктами: " + revenueByProduct);

        // Кількість транзакцій за клієнтом
        Map<String, Long> transactionsByCustomer = sales.stream()
                .collect(Collectors.groupingBy(
                        Sale::customerEmail,
                        Collectors.counting()
                ));
        System.out.println("Кількість транзакцій за клієнтами: " + transactionsByCustomer);
    }
}
