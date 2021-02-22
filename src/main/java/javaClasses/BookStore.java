package javaClasses;

import java.util.ArrayList;

public class BookStore {

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1, "Vasil Bykau", "Abelisk", "AST", 1989, 320, 22, 3));
        books.add(new Book(2, "Vasil Bykau", "Adna noch", "Bombora", 2001, 124, 14, 4));
        books.add(new Book(3, "Pyatrus Brouka", "Polonyanka", "AST", 2015, 104, 15, 1));
        books.add(new Book(4, "Pyatrus Brouka", "Kastus Kalinouski", "EKSMO", 2006, 264, 20, 3));
        books.add(new Book(5, "Rygor Baradulin", "Krasavik", "AST", 1999, 254, 23, 3));

        ArrayList<Book> booksByAuthor = searchByAuthor(books, "Vasil Bykau");
        System.out.println("Список книг, автор Vasil Bykau:");
        output(booksByAuthor);

        ArrayList<Book> booksByEdition = searchByEdition(books, "AST");
        System.out.println("Список книг, издательство AST:");
        output(booksByEdition);

        ArrayList<Book> booksByYear = searchByYear(books, 2000);
        System.out.println("Список книг, год издательства после 2000");
        output(booksByYear);
    }

    private static void output(ArrayList<Book> booksByItem) {
        for (Book book : booksByItem) {
            System.out.println(book);
        }
        System.out.println();
    }

    public static ArrayList<Book> searchByAuthor(ArrayList<Book> books, String author) {
        ArrayList<Book> booksByAuthor = new ArrayList<>();
        for (Book book : books) {
            if (author.equals(book.getAuthor())) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }

    public static ArrayList<Book> searchByEdition(ArrayList<Book> books, String edition) {
        ArrayList<Book> booksByEdition = new ArrayList<>();
        for (Book book : books) {
            if (edition.equals(book.getEdition())) {
                booksByEdition.add(book);
            }
        }
        return booksByEdition;
    }

    public static ArrayList<Book> searchByYear(ArrayList<Book> books, int yearEdition) {
        ArrayList<Book> searchByYear = new ArrayList<>();
        for (Book book : books) {
            if (yearEdition < book.getYearEdition()) {
                searchByYear.add(book);
            }
        }
        return searchByYear;
    }
}
