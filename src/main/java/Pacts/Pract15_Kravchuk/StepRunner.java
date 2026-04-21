package Pacts.Pract15_Kravchuk;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StepRunner {

    public static void run(Object target){
        Class<?> clazz = target.getClass();
        List<Method> stepMethods = new ArrayList<>();

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Step.class)) {

                if (method.getReturnType() != void.class || method.getParameterCount() > 0) {
                    throw new StepExecutionException("Невірна сигнатура методу " + method.getName() + ". Очікується void та 0 аргументів.");
                }
                stepMethods.add(method);
            }
        }

        stepMethods.sort(Comparator.comparingInt(m -> m.getAnnotation(Step.class).order()));

        for (Method method : stepMethods) {
            try {
                method.setAccessible(true); // Дозвіл на виклик приватних методів
                method.invoke(target);
            } catch (IllegalAccessException e) {
                throw new StepExecutionException("Немає доступу до методу " + method.getName(), e);
            } catch (InvocationTargetException e) {
                // Загортаємо виняток, який кинув сам метод (getCause)
                throw new StepExecutionException("Метод " + method.getName() + " викинув виняток", e.getCause());
            }
        }
    }

    }


