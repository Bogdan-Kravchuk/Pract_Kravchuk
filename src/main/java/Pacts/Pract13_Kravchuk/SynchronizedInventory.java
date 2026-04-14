package Pacts.Pract13_Kravchuk;

public class SynchronizedInventory implements Inventory {

    private int balance;

    public SynchronizedInventory(int balance) { this.balance = balance; }

    @Override
    public synchronized void reserve(int amount) {
        if (balance >= amount)
            balance -= amount;

    }

    @Override
    public synchronized int available() { return balance; }
}
