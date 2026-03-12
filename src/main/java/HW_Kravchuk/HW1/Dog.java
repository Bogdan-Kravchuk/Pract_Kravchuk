package HW_Kravchuk.HW1;

import java.util.Objects;

public class Dog extends Mammal {
    private String breed;
    private String name;
    private int age;
    Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return super.toString()+ "Dog{" +
                "breed='" + breed + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return age == dog.age && Objects.equals(breed, dog.breed) && Objects.equals(name, dog.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(breed);
    }
}
