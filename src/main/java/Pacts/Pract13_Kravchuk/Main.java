package Pacts.Pract13_Kravchuk;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    //4 завдання
    public static final SupportTicket POISON_PILL = new SupportTicket(-1, "END", "END");

    static void main(String[] args) throws InterruptedException {
        //початок 1 завдання
    List<Order> orders = List.of(
            new Order(1, 1500),
            new Order(2, 4500),
            new Order(3, 2000)
    );

    AtomicInteger totalSum = new AtomicInteger(0);
    AtomicInteger maxSum = new AtomicInteger(0);

    Runnable sumTask = () -> {
        int sum = orders.stream().mapToInt(Order::totalCents).sum();
        totalSum.set(sum);
        System.out.println("Сума обчислена: " + sum);
    };

    Runnable maxTask = () -> {
        int max = orders.stream().mapToInt(Order::totalCents).max().orElse(0);
        maxSum.set(max);
        System.out.println("Максимум обчислений: " + max);
    };

        TaskRunner.runAndWait(List.of(sumTask, maxTask));

        System.out.println("Всі обчислення завершено. Результати: Сума = " + totalSum.get() + ", Макс = " + maxSum.get());

        int violations = 0;
        int runs = 500;

        for (int i = 0; i < runs; i++) {
            Inventory unsafe = new UnsafeInventory(100);

            Thread t1 = new Thread(() -> unsafe.reserve(60));
            Thread t2 = new Thread(() -> unsafe.reserve(60));

            t1.start();
            t2.start();
            t1.join();
            t2.join();

            if (unsafe.available() < 0) {
                violations++;
            }
        }

        System.out.println("Кількість порушень інваріанту (available < 0) з " + runs + " спроб: " + violations);

        Inventory safe = new SynchronizedInventory(100);
        Thread t3 = new Thread(() -> safe.reserve(60));
        Thread t4 = new Thread(() -> safe.reserve(60));
        t3.start();
        t4.start();
        t3.join();
        t4.join();

        System.out.println("Безпечна версія: " + safe.available());

    Account acc1 = new Account(1, 1000);
    Account acc2 = new Account(2, 1000);
    TransferService service = new TransferService();

    // Зустрічні перекази
    Thread t1 = new Thread(() -> service.transfer(acc1, acc2, 300));
    Thread t2 = new Thread(() -> service.transfer(acc2, acc1, 500));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Баланс acc1: " + acc1.balance + " (очікується 1200)");
        System.out.println("Баланс acc2: " + acc2.balance + " (очікується 800)");


            BlockingQueue<SupportTicket> queue = new LinkedBlockingQueue<>(10);
            ConcurrentHashMap<String, Integer> topicStats = new ConcurrentHashMap<>();

            Runnable producer = () -> {
                try {
                    queue.put(new SupportTicket(1, "Alice", "A"));
                    queue.put(new SupportTicket(2, "Bob", "B"));
                    queue.put(new SupportTicket(3, "Charlie", "C"));
                    queue.put(new SupportTicket(4, "Dave", "D"));

                    queue.put(POISON_PILL);

                    System.out.println("Producer завершив роботу.");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            };

            Runnable consumer = () -> {
                try {
                    while (true) {
                        SupportTicket ticket = queue.take();
                        if (ticket == POISON_PILL)
                            break;

                        topicStats.merge(ticket.topic(), 1, Integer::sum);
                        System.out.println(Thread.currentThread().getName() + " обробив заявку: " + ticket.id());
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            };

            Thread prodThread = new Thread(producer, "Producer-Thread");
            Thread cons1 = new Thread(consumer, "Consumer-1");
            Thread cons2 = new Thread(consumer, "Consumer-2");

            prodThread.start();
            cons1.start();
            cons2.start();

            prodThread.join();
            cons1.join();
            cons2.join();

            System.out.println("\nПідсумкова статистика за темами:");
            topicStats.forEach((topic, count) -> System.out.println(topic + ": " + count));
}
    }


