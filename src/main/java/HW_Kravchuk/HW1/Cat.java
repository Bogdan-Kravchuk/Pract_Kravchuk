package HW_Kravchuk.HW1;

import java.util.Objects;

public class Cat extends Mammal {
    private String color;
    private String name;
    private int age;

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return super.toString()+ "Cat{" +
                "color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age && Objects.equals(color, cat.color) && Objects.equals(name, cat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(color);
    }
}
