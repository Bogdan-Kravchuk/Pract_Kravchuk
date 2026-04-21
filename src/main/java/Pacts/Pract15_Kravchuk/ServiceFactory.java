package Pacts.Pract15_Kravchuk;

public class ServiceFactory {
    public static void  create(String className) throws ClassNotFoundException {

        try {
            Class<?> clazz = Class.forName(className);
            Object instance = clazz.getDeclaredConstructor().newInstance();
            System.out.println(instance);
        } catch (Exception e) {
            throw new RuntimeException("Помилка при створенні сервісу: " + className, e);
        }
    }
    }

