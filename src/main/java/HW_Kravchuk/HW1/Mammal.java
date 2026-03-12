package HW_Kravchuk.HW1;

public class Mammal extends Animal{
    private boolean hasFur;
    Mammal(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return super.toString()+
         "Mammal{" +
                "hasFur=" + hasFur +
                '}';
    }
}
