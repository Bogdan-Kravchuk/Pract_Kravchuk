package HW_Kravchuk.HW4;

public class EmailNotifier extends BaseNotifier {

    @Override
    public void notifyUser(String msg){
        System.out.println("Оповіщення поштою: "+ msg);
    }
}
