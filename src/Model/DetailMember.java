package Model;

import java.util.ArrayList;

/*@author Rizki Ramadandi*/
public class DetailMember {
    private Member member;
    private ArrayList<Borrowing> borrowingList;
    private int totalBook;

    public DetailMember(Member member, ArrayList<Borrowing> borrowingList, int totalBook) {
        this.member = member;
        this.borrowingList = borrowingList;
        this.totalBook = totalBook;
    }

    public DetailMember() {
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public ArrayList<Borrowing> getBorrowingList() {
        return borrowingList;
    }

    public void setBorrowingList(ArrayList<Borrowing> borrowingList) {
        this.borrowingList = borrowingList;
    }

    public int getTotalBook() {
        return totalBook;
    }

    public void setTotalBook(int totalBook) {
        this.totalBook = totalBook;
    }

}
