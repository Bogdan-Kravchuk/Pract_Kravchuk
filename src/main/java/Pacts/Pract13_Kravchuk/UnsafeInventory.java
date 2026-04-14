package Pacts.Pract13_Kravchuk;

public class UnsafeInventory implements Inventory {
    private int balance;

    public UnsafeInventory(int balance) { this.balance = balance; }

    @Override
    public void reserve(int amount) {
        if (balance >= amount) {
            try { Thread.sleep(1); } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            balance -= amount;
        }
    }

    @Override
    public int available() { return balance; }
}

