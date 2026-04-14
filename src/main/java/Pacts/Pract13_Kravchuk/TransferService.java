package Pacts.Pract13_Kravchuk;

public class TransferService {
    public void transfer(Account from, Account to, int amount) {
        Account firstLock = from.id < to.id ? from : to;
        Account secondLock = from.id < to.id ? to : from;

        synchronized (firstLock) {
            try { Thread.sleep(10); } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            synchronized (secondLock) {
                if (from.balance >= amount) {
                    from.balance -= amount;
                    to.balance += amount;
                    System.out.println("Переказ " + amount + " з ID:" + from.id + " на ID:" + to.id + " успішний.");
                } else {
                    System.out.println("Недостатньо коштів на ID:" + from.id);
                }
            }
        }
    }
}
