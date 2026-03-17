package HW_Kravchuk.HW2;

public class Main {

    static void main(String[] args) {
        Product product1 = new Product(1, "Смартфон", 500.0);
        Product product2 = new Product(2, "Планшет", 1000.0);
        Product product3 = new Product(3, "Смарт-годинник", 100.00);
        Product[] products = {product1, product2, product3};
        VendingMachine machine = new VendingMachine(products);

        machine.insertMoney(10);
        machine.selectProduct(3);

    }

}
