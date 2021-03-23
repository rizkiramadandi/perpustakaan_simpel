package Model;

/*@author Rizki Ramadandi*/
public class Borrowing {

    private String id, idMember, member, idBook, book, borrowingDate, returningDate;
    private int borrowingDuration;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Borrowing(String id, String idMember, String member, String idBook, String book, String borrowingDate, String returningDate, int borrowingDuration) {
        this.id = id;
        this.idMember = idMember;
        this.member = member;
        this.idBook = idBook;
        this.book = book;
        this.borrowingDate = borrowingDate;
        this.returningDate = returningDate;
        this.borrowingDuration = borrowingDuration;
    }

    public Borrowing() {
    }

    public String getIdMember() {
        return idMember;
    }

    public void setIdMember(String idMember) {
        this.idMember = idMember;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(String borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public String getReturningDate() {
        return returningDate;
    }

    public void setReturningDate(String returningDate) {
        this.returningDate = returningDate;
    }

    public int getBorrowingDuration() {
        return borrowingDuration;
    }

    public void setBorrowingDuration(int borrowingDuration) {
        this.borrowingDuration = borrowingDuration;
    }

    
}
