package Pacts.Pract9_Kravchuk;

public class Library {
    private String name;


    public Library(String name) {
        this.name = name;
    }


    public static class Book {
        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        void bookLabel() {

        }
    }

}
