package Pacts.Pract9_Kravchuk;

public class Car {
    private String model;
    public Car(String model) {
        this.model = model;
    }



    public static class Engine{
        private int horsepower;

        public Engine(int horsepower) {
            this.horsepower = horsepower;
        }

        void spec() {
            Engine engine = new Engine(horsepower);
        }

        @Override
        public String toString() {
            return "Engine{" +
                    "horsepower=" + horsepower +
                    '}';
        }
    }

    static void main(String[] args) {
        Car car = new Car("Audi");

        Car.Engine engine = new Car.Engine(5);
        System.out.println(car);
        System.out.println(engine);
        Library library = new Library("Name");
        Library.Book book = new Library.Book("A", "B");
        book.bookLabel();

        Ticket ticket = new Ticket("A", 1);
ticket.runOnce();




    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                '}';
    }
}
