package Model;

import java.util.ArrayList;

/*@author Rizki Ramadandi*/
public class DetailBook {
    private Book book;
    private ArrayList<Borrowing> borrowingList;
    private int totalBorrowing;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public ArrayList<Borrowing> getBorrowingList() {
        return borrowingList;
    }

    public void setBorrowingList(ArrayList<Borrowing> borrowingList) {
        this.borrowingList = borrowingList;
    }

    public int getTotalBorrowing() {
        return totalBorrowing;
    }

    public void setTotalBorrowing(int totalBorrowing) {
        this.totalBorrowing = totalBorrowing;
    }

    public DetailBook() {
    }

    public DetailBook(Book book, ArrayList<Borrowing> borrowingList, int totalBorrowing) {
        this.book = book;
        this.borrowingList = borrowingList;
        this.totalBorrowing = totalBorrowing;
    }

    
}
