package HW_Kravchuk.HW3;


public class BaseInit {
    private static String staticVarBASE= "статична змінна Base";
    private String notStaticVarBASE = "не статична змінна BAse";


   static  {
        System.out.println("is a static method BASE");
    }
    {
        System.out.println("is a instance method BASE");
    }
    BaseInit(){
        System.out.println("is a constructor method BASE");
    }
}
