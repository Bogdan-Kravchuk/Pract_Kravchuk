package Pacts.Pract8_Kravchuk;

import java.util.ArrayList;
import java.util.List;

public class task2 {
    private static List<Integer> list = new ArrayList<>();

    static void main(String[] args) {
        System.out.println(firstOrNull(list));
        addDefaultIds(list);
        System.out.println(sum(list));
        System.out.println(firstOrNull(list));


    }

    public static <T> T firstOrNull(List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static double sum(List<? extends Number> numbers) {
        double result = 0.0;
        for (Number n : numbers) {
            result += n.doubleValue();
        }
        return result;
    }

    public static void addDefaultIds(List<? super Integer> ids) {
        ids.add(1);
        ids.add(2);
        ids.add(3);

        for (Object i: ids)
            System.out.println(i);
    }
}
