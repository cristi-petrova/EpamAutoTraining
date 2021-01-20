package javaClasses;

import java.util.ArrayList;

public class Book {

    private int _id;
    private String _author;
    private String _title;
    private String _edition;
    private int _yearEdition;
    private int _numberPages;
    private int _price;
    private int _type;

    public Book(int id, String author, String title, String edition, int yearEdition, int numberPages, int price, int type) {

        _id = id;
        _author = author;
        _title = title;
        _edition = edition;
        _yearEdition = yearEdition;
        _numberPages = numberPages;
        _price = price;
        _type = type;

    }

    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book(1, "Vasil Bykau", "Abelisk", "AST", 1989, 320, 22, 3));
        books.add(new Book(2, "Vasil Bykau", "Adna noch","Bombora", 2001, 124, 14, 4));
        books.add(new Book(3, "Pyatrus Brouka", "Polonyanka","AST", 2015, 104, 15, 1));
        books.add(new Book(4, "Pyatrus Brouka", "Kastus Kalinouski","EKSMO", 2006, 264, 20, 3));
        books.add(new Book(5, "Rygor Baradulin", "Krasavik","AST", 1999, 254, 23, 3));

        ArrayList<Book> booksByAuthor = Book.searchByAuthor(books, "Vasil Bykau");

        System.out.println("Список книг, автор Vasil Bykau:");

        output(booksByAuthor);

        ArrayList<Book> booksByEdition = Book.searchByEdition(books, "AST");

        System.out.println("Список книг, автор издательство AST:");

        output(booksByEdition);

        ArrayList<Book> booksByYear = Book.searchByYear(books, 2000);

        System.out.println("Список книг, год издательства после 2000");

        output(booksByYear);

    }

    private static void output(ArrayList<Book> booksByItem) {
        for (Book book : booksByItem) {
            System.out.println(book);
        }
        System.out.println();
    }

    public String toString(){

        return _author + " " + _title +" " + _yearEdition +" " + _edition;

    }

    public static ArrayList<Book> searchByAuthor (ArrayList<Book> books, String author){

        ArrayList<Book> booksByAuthor = new ArrayList<>();

        for (Book book : books) {

            if (author.equals(book.getAuthor())) {
                booksByAuthor.add(book);
            }

        }

        return booksByAuthor;
    }

    public static ArrayList<Book> searchByEdition (ArrayList<Book> books, String edition){

        ArrayList<Book> booksByEdition = new ArrayList<>();

        for (Book book : books) {

            if (edition.equals(book.getEdition())) {
                booksByEdition.add(book);
            }

        }

        return booksByEdition;
    }


    public static ArrayList<Book> searchByYear (ArrayList<Book> books, int yearEdition){

        ArrayList<Book> searchByYear = new ArrayList<>();

        for (Book book : books) {

            if (yearEdition < book.getYearEdition()) {
                searchByYear.add(book);
            }

        }

        return searchByYear;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        if (id > 0){
            _id = id;
        } else {
            System.out.println("Id должно быть положительным числом");
        }

    }

    public String getAuthor(){
        return _author;
    }

    public void setAuthor(String author){
        _author = author;
    }

    public String getTitle(){
        return _title;
    }

    public void setTitle(String title){
        _title = title;
    }

    public String getEdition(){
        return _edition;
    }

    public void setEdition(String edition){
        _edition = edition;
    }

    public int getYearEdition (){
        return _yearEdition;
    }

    public void setYearEdition(int yearEdition){
        if (yearEdition >= 0){
            _yearEdition = yearEdition;
        } else {
            System.out.println("Год должен быть положительным числом");
        }
    }

    public int getNumberPages(){
        return _numberPages;
    }

    public void setNumberPages(int numberPages){
        if (numberPages >= 0){
            _numberPages = numberPages;
        } else {
            System.out.println("Число страниц должно быть положительным числом");
        }
    }

    public int getPrice(){
        return _price;
    }

    public void setPrice(int price){

        if (price >= 0){
            _price = price;
        } else {
            System.out.println("Цена должна быть положительным числом");
        }
    }

    public int getType(){
        return _type;
    }

    public void setType(int type){

        if (type >= 0 && type <6){
            _type = type;
        } else {
            System.out.println("Тип должен быть в диапазоне от 0 до 5");
        }
    }

}
