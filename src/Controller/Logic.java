package Controller;

import Model.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/*@author Rizki Ramadandi*/
public class Logic {

    private SQL sql;

    public Logic() {
        sql = new SQL();
    }

    public DefaultTableModel setTableModelBook(ArrayList<Book> list) {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //Only the third column
                return !(column == 0 || column == 3 || column == 4 || column == 5 || column == 6 || column == 7 || column == 8);
            }
        };
        model.setColumnIdentifiers(new Object[]{"Book ID*", "Title", "Published Year", "ID Category*", "Category*", "ID Author*", "Author*", "ID Publisher*", "Publisher*", "Total Page"});

        for (Book book : list) {
            model.addRow(new Object[]{book.getId(), book.getTitle(), book.getPublishedYear(), book.getIdCategory(), book.getCategory(), book.getIdAuthor(), book.getAuthor(), book.getIdPublisher(), book.getPublisher(), book.getTotalPage()});
        }

        return model;
    }

    public DefaultTableModel setTableModelCategory(ArrayList<Category> list) {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //Only the third column
                return !(column == 0);
            }
        };
        model.setColumnIdentifiers(new Object[]{"Category ID*", "Name", "Label"});

        for (Category category : list) {
            model.addRow(new Object[]{category.getId(), category.getName(), category.getLabel()});
        }

        return model;
    }

    public DefaultTableModel setTableModelAuthor(ArrayList<Author> list) {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //Only the third column
                return !(column == 0);
            }
        };
        model.setColumnIdentifiers(new Object[]{"Author ID*", "Name", "Gender", "Country"});

        for (Author author : list) {
            model.addRow(new Object[]{author.getId(), author.getName(), author.getGender(), author.getCountry()});
        }

        return model;
    }

    public DefaultTableModel setTableModelMember(ArrayList<Member> list) {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //Only the third column
                return !(column == 0);
            }
        };

        model.setColumnIdentifiers(new Object[]{"Member ID*", "Name", "Address", "Phone Number", "Gender"});

        for (Member member : list) {
            model.addRow(new Object[]{member.getId(), member.getName(), member.getAddress(), member.getPhoneNumber(), member.getGender()});
        }

        return model;
    }

    public DefaultTableModel setTableModelPublisher(ArrayList<Publisher> list) {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //Only the third column
                return !(column == 0);
            }
        };
        model.setColumnIdentifiers(new Object[]{"Publisher ID*", "Name", "Address", "Phone Number", "Country"});

        for (Publisher publisher : list) {
            model.addRow(new Object[]{publisher.getId(), publisher.getName(), publisher.getAddress(), publisher.getPhoneNumber(), publisher.getCountry()});
        }

        return model;
    }
    
    public DefaultTableModel setTableModelBorrowing(ArrayList<Borrowing> list) {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //Only the third column
                return !(column == 0 || column == 1 || column == 2 || column == 3 || column == 4);
            }
        };
        model.setColumnIdentifiers(new Object[]{"Borrowing ID*", "Member ID*", "Member Name*", "Book ID*", "Book Title*", "Borrowing Date", "Returning Date", "Borrowing Duration [Day(s)]"});

        for (Borrowing borrowing : list) {
            model.addRow(new Object[]{borrowing.getId(), borrowing.getIdMember(), borrowing.getMember(), borrowing.getIdBook(), borrowing.getBook(), borrowing.getBorrowingDate(), borrowing.getReturningDate(), borrowing.getBorrowingDuration()});
        }

        return model;
    }

    public DefaultTableModel setTableBook() {
        ArrayList<Book> list = sql.selectAllBook();
        return setTableModelBook(list);
    }

    public DefaultTableModel setTableCategory() {
        ArrayList<Category> list = sql.selectAllCategory();
        return setTableModelCategory(list);
    }

    public DefaultTableModel setTableAuthor() {
        ArrayList<Author> list = sql.selectAllAuthor();
        return setTableModelAuthor(list);
    }

    public DefaultTableModel setTableMember() {
        ArrayList<Member> list = sql.selectAllMember();
        return setTableModelMember(list);
    }

    public DefaultTableModel setTablePublisher() {
        ArrayList<Publisher> list = sql.selectAllPublisher();
        return setTableModelPublisher(list);
    }
    
    public DefaultTableModel setTableBorrowing() {
        ArrayList<Borrowing> list = sql.selectAllBorrowing();
        return setTableModelBorrowing(list);
    }
    
    public DefaultTableModel setTableBook(ArrayList<Book> bookList) {
        ArrayList<Book> list = bookList;
        return setTableModelBook(list);
    }
    
    public DefaultTableModel setTableBorrowing(ArrayList<Borrowing> borrowingList) {
        ArrayList<Borrowing> list = borrowingList;
        return setTableModelBorrowing(list);
    }
    
    public ArrayList<Book> selectAllBook() {
        ArrayList<Book> list = sql.selectAllBook();
        return (list);
    }

    public ArrayList<Category> selectAllCategory() {
        ArrayList<Category> list = sql.selectAllCategory();
        return (list);
    }

    public ArrayList<Author> selectAllAuthor() {
        ArrayList<Author> list = sql.selectAllAuthor();
        return (list);
    }

    public ArrayList<Member> selectAllMember() {
        ArrayList<Member> list = sql.selectAllMember();
        return (list);
    }

    public ArrayList<Publisher> selectAllPublisher() {
        ArrayList<Publisher> list = sql.selectAllPublisher();
        return (list);
    }
    
    public ArrayList<Borrowing> selectAllBorrowing() {
        ArrayList<Borrowing> list = sql.selectAllBorrowing();
        return (list);
    }
    
    public DetailBook selectDetailBook(String id) {
        DetailBook detailBook = sql.selectDetailBook(id);
        return detailBook;
    }
    
    public DetailCategory selectDetailCategory(String id) {
        DetailCategory detailCategory = sql.selectDetailCategory(id);
        return detailCategory;
    }
    
    public DetailAuthor selectDetailAuthor(String id) {
        DetailAuthor detailAuthor = sql.selectDetailAuthor(id);
        return detailAuthor;
    }
    
    public DetailPublisher selectDetailPublisher(String id) {
        DetailPublisher detailPublisher = sql.selectDetailPublisher(id);
        return detailPublisher;
    }
    
    public DetailMember selectDetailMember(String id) {
        DetailMember detailMember = sql.selectDetailMember(id);
        return detailMember;
    }

    public DefaultTableModel setTableBook(String query) {
        ArrayList<Book> list = sql.selectBook(query);
        return setTableModelBook(list);
    }

    public DefaultTableModel setTableCategory(String query) {
        ArrayList<Category> list = sql.selectCategory(query);
        return setTableModelCategory(list);
    }

    public DefaultTableModel setTableAuthor(String query) {
        ArrayList<Author> list = sql.selectAuthor(query);
        return setTableModelAuthor(list);
    }

    public DefaultTableModel setTableMember(String query) {
        ArrayList<Member> list = sql.selectMember(query);
        return setTableModelMember(list);
    }

    public DefaultTableModel setTablePublisher(String query) {
        ArrayList<Publisher> list = sql.selectPublisher(query);
        return setTableModelPublisher(list);
    }
    
    public DefaultTableModel setTableBorrowing(String query) {
        ArrayList<Borrowing> list = sql.selectBorrowing(query);
        return setTableModelBorrowing(list);
    }

    public void remove(String id, String table) {
        sql.remove(id, table);
    }
    
    public void updateBook(Book book) {
        sql.updateBook(book);
    }
    
    public void updateAuthor(Author author) {
        sql.updateAuthor(author);
    }
    
    public void updateMember(Member member) {
        sql.updateMember(member);
    }
    
    public void updatePublisher(Publisher publisher) {
        sql.updatePublisher(publisher);
    }
    
    public void updateBorrowing(Borrowing borrowing) {
        sql.updateBorrowing(borrowing);
    }
    
    public void updateCategory(Category category) {
        sql.updateCategory(category);
    }

    public void insertBook(String id, String title, String publishedYear, String idCategory, String category, String idAuthor, String author, String idPublisher, String publisher, int totalPage) {
        Book book = new Book(id, title, idAuthor, author, idPublisher, publisher, idCategory, category, publishedYear, totalPage);
        sql.insertBook(book);
    }

    public void insertMember(String id, String name, String address, String phoneNumber, String gender) {
        Member member = new Member(id, name, address, phoneNumber, gender);
        sql.insertMember(member);
    }

    public void insertPublisher(String id, String name, String address, String phoneNumber, String country) {
        Publisher publisher = new Publisher(id, name, address, phoneNumber, country);
        sql.insertPublisher(publisher);
    }

    public void insertAuthor(String id, String name, String gender, String country) {
        Author author = new Author(id, name, gender, country);
        sql.insertAuthor(author);
    }

    public void insertCategory(String id, String name, String label) {
        Category category = new Category(id, name, label);
        sql.insertCategory(category);
    }
    
    public void insertBorrowing(String id, String idMember, String member, String idBook, String book, String borrowingDate, String returningDate, int borrowingDuration) {
        Borrowing borrowing = new Borrowing(id, idMember, member, idBook, book, borrowingDate, returningDate, borrowingDuration);
        sql.insertBorrowing(borrowing);
    }
}
