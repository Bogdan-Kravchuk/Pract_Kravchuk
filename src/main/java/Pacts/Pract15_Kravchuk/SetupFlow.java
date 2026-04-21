package Pacts.Pract15_Kravchuk;

public class SetupFlow {
    @Step(order = 2)
    private void loadConfig() {
        System.out.println("Крок 2: Конфігурація завантажена (приватний метод).");
    }

    @Step(order = 1)
    public void init() {
        System.out.println("Крок 1: Ініціалізація системи.");
    }

    @Step(order = 3)
    void start() {
        System.out.println("Крок 3: Система запущена.");
    }
}
