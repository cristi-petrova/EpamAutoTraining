package javaClasses;

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

    public String toString() {
        return _author + " " + _title + " " + _yearEdition + " " + _edition;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        if (id > 0) {
            _id = id;
        } else {
            System.out.println("Id должно быть положительным числом");
        }
    }

    public String getAuthor() {
        return _author;
    }

    public void setAuthor(String author) {
        _author = author;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getEdition() {
        return _edition;
    }

    public void setEdition(String edition) {
        _edition = edition;
    }

    public int getYearEdition() {
        return _yearEdition;
    }

    public void setYearEdition(int yearEdition) {
        if (yearEdition >= 0) {
            _yearEdition = yearEdition;
        } else {
            System.out.println("Год должен быть положительным числом");
        }
    }

    public int getNumberPages() {
        return _numberPages;
    }

    public void setNumberPages(int numberPages) {
        if (numberPages >= 0) {
            _numberPages = numberPages;
        } else {
            System.out.println("Число страниц должно быть положительным числом");
        }
    }

    public int getPrice() {
        return _price;
    }

    public void setPrice(int price) {
        if (price >= 0) {
            _price = price;
        } else {
            System.out.println("Цена должна быть положительным числом");
        }
    }

    public int getType() {
        return _type;
    }

    public void setType(int type) {
        if (type >= 0 && type < 6) {
            _type = type;
        } else {
            System.out.println("Тип должен быть в диапазоне от 0 до 5");
        }
    }
}
