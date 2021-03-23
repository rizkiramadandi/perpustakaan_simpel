package Model;

import java.util.ArrayList;

/*@author Rizki Ramadandi*/
public class DetailCategory {
    private Category category;
    private ArrayList<Book> bookList;
    private int totalBook;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public DetailCategory() {
    }

    public DetailCategory(Category category, ArrayList<Book> bookList, int totalBook) {
        this.category = category;
        this.bookList = bookList;
        this.totalBook = totalBook;
    }

    
}
