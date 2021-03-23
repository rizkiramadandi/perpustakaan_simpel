package Model;

import java.util.ArrayList;

/*@author Rizki Ramadandi*/
public class DetailAuthor {
    private Author author;
    private ArrayList<Book> bookList;
    private int totalBook;

    public DetailAuthor(Author author, ArrayList<Book> bookList, int totalBook) {
        this.author = author;
        this.bookList = bookList;
        this.totalBook = totalBook;
    }

    public DetailAuthor() {
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public int getTotalBook() {
        return totalBook;
    }

    public void setTotalBook(int totalBook) {
        this.totalBook = totalBook;
    }

}
