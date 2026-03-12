package Pacts.Pract8_Kravchuk;

import java.util.ArrayList;
import java.util.List;

public class task1 {
    private static List type = new ArrayList<task1>();
    private static List<String> stringType = new ArrayList<String>();

    static void main() {
        String nameProduct = "Audi";
        int priceProduct = 1000;
        type.add(nameProduct);
        type.add(priceProduct);
        //
       for (Object o: type ) {
           if (o instanceof String)
               System.out.println(o);
       }
       //
            stringType.add(nameProduct);
           // stringType.add(priceProduct);

for (String s: stringType )
    System.out.println(s);


        System.out.println("//Дженеріки допомагають визначити тип обєкта, який можна додати в колекцію. Без перевірки instanceof  ");

    }
}
