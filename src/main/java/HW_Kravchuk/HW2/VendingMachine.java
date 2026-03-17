package HW_Kravchuk.HW2;

public class VendingMachine {
    private Product[] products;
    private double balance;

    VendingMachine(Product[] products) {
        this.products = products.clone();
    }

    public String[] getProductNames() {
        String[] names = new String[products.length];
        for (int i = 0; i < products.length; i++)
            names[i] = products[i].getName();
        return names;
    }

    public void insertMoney(double amount) {
        if (0 > amount)
            throw new IllegalArgumentException("Amount must be greater than zero");

        balance = 0;
        balance = balance + amount;
    }

    public Product selectProduct(int id) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getId() == id) {
                if (products[i].getPrice() <= balance){
                    getChange(products[i].getPrice());
                    System.out.println("Товар успішно куплений!");
                    System.out.println(products[i].getName()+ "  "+ products[i].getPrice());
                    return products[i];}
                else
                    System.out.println("Not enough money");
            }
        }
        return null;
    }

    public double getChange(double productPrice) {
        balance =  balance - productPrice;
        System.out.println("Баланс після зняття: " + balance);
        return balance;
    }
}
