package Pacts.Pract15_Kravchuk;

public class StepExecutionException extends RuntimeException {

        public StepExecutionException(String message) {
            super(message);
        }
        public StepExecutionException(String message, Throwable cause) {
            super(message, cause); // Зберігаємо оригінальний стек помилки
        }
    }

