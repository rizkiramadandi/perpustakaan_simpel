package Model;

import java.util.ArrayList;

/*@author Rizki Ramadandi*/
public class DetailPublisher {
    private Publisher publisher;
    private ArrayList<Book> bookList;

    public DetailPublisher(Publisher publisher, ArrayList<Book> bookList, int totalBook) {
        this.publisher = publisher;
        this.bookList = bookList;
        this.totalBook = totalBook;
    }

    public DetailPublisher() {
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
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
    int totalBook;
}
