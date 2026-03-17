package HW_Kravchuk.HW3;

public class ChaildInit extends BaseInit{
    private static String staticVarCD= "статична змінна Chaild";
    private String notStaticVarCD = "не статична змінна Chaild";


    static  {
        System.out.println("is a static method Chaild");
    }

    {
        System.out.println("is a instance method Chaild");
    }
    ChaildInit(){
        System.out.println("is a constructor method Chaild");
    }
}
