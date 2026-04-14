package Pacts.Pract13_Kravchuk;

import java.util.List;

public class TaskRunner {
    public static void runAndWait(List<Runnable> tasks) {
        List<Thread> threads = tasks.stream()
                .map(Thread::new)
                .toList();

        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Потік було перервано!");
            }
        }
    }
}
