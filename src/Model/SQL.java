package Model;

import java.util.ArrayList;
import java.sql.*;
import javax.swing.JOptionPane;

/*@author Rizki Ramadandi*/
public class SQL {

    private Connection conn;
    private PreparedStatement prepStmt;

    public SQL() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/perpustakaan_pemvis", "root", "");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Book> selectBook(String query) {
        ArrayList<Book> list = new ArrayList();
        String sqlSelect = "SELECT * FROM buku_simple WHERE judul LIKE ? OR tahun_terbit LIKE ? OR nama_penulis LIKE ? OR nama_penerbit LIKE ? OR nama_kategori LIKE ? ORDER BY id ASC";
        try {
            prepStmt = conn.prepareStatement(sqlSelect);
            prepStmt.setString(1, "%" + query + "%");
            prepStmt.setString(2, "%" + query + "%");
            prepStmt.setString(3, "%" + query + "%");
            prepStmt.setString(4, "%" + query + "%");
            prepStmt.setString(5, "%" + query + "%");
            ResultSet res = prepStmt.executeQuery();
            while (res.next()) {
                list.add(new Book(res.getString("id"), res.getString("judul"), res.getString("penulis"), res.getString("nama_penulis"), res.getString("penerbit"), res.getString("nama_penerbit"), res.getString("kategori"), res.getString("nama_kategori"), res.getString("tahun_terbit"), res.getInt("total_halaman")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Category> selectCategory(String query) {
        ArrayList<Category> list = new ArrayList();
        String sqlSelect = "SELECT * FROM kategori WHERE nama LIKE ? OR label LIKE ? ORDER BY id ASC";
        try {
            prepStmt = conn.prepareStatement(sqlSelect);
            prepStmt.setString(1, "%" + query + "%");
            prepStmt.setString(2, "%" + query + "%");
            ResultSet res = prepStmt.executeQuery();
            while (res.next()) {
                list.add(new Category(res.getString("id"), res.getString("nama"), res.getString("label")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Author> selectAuthor(String query) {
        ArrayList<Author> list = new ArrayList();
        String sqlSelect = "SELECT * FROM penulis WHERE nama LIKE ? OR jenis_kelamin LIKE ? OR negara LIKE ? ORDER BY id ASC";
        try {
            prepStmt = conn.prepareStatement(sqlSelect);
            prepStmt.setString(1, "%" + query + "%");
            prepStmt.setString(2, "%" + query + "%");
            prepStmt.setString(3, "%" + query + "%");
            ResultSet res = prepStmt.executeQuery();
            while (res.next()) {
                list.add(new Author(res.getString("id"), res.getString("nama"), res.getString("jenis_kelamin"), res.getString("negara")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Member> selectMember(String query) {
        ArrayList<Member> list = new ArrayList();
        String sqlSelect = "SELECT * FROM member WHERE nama LIKE ? OR alamat LIKE ? OR no_telpon LIKE ? OR jenis_kelamin LIKE ? ORDER BY id ASC";
        try {
            prepStmt = conn.prepareStatement(sqlSelect);
            prepStmt.setString(1, "%" + query + "%");
            prepStmt.setString(2, "%" + query + "%");
            prepStmt.setString(3, "%" + query + "%");
            prepStmt.setString(4, "%" + query + "%");
            ResultSet res = prepStmt.executeQuery();
            while (res.next()) {
                list.add(new Member(res.getString("id"), res.getString("nama"), res.getString("alamat"), res.getString("no_telpon"), res.getString("jenis_kelamin")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Publisher> selectPublisher(String query) {
        ArrayList<Publisher> list = new ArrayList();
        String sqlSelect = "SELECT * FROM penerbit WHERE nama LIKE ? OR alamat LIKE ? OR no_telpon LIKE ? OR negara LIKE ? ORDER BY id ASC";
        try {
            prepStmt = conn.prepareStatement(sqlSelect);
            prepStmt.setString(1, "%" + query + "%");
            prepStmt.setString(2, "%" + query + "%");
            prepStmt.setString(3, "%" + query + "%");
            prepStmt.setString(4, "%" + query + "%");
            ResultSet res = prepStmt.executeQuery();
            while (res.next()) {
                list.add(new Publisher(res.getString("id"), res.getString("nama"), res.getString("alamat"), res.getString("no_telpon"), res.getString("negara")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Borrowing> selectBorrowing(String query) {
        ArrayList<Borrowing> list = new ArrayList();
        String sqlSelect = "SELECT * FROM peminjaman_simple WHERE nama_member LIKE ? OR judul_buku LIKE ? ORDER BY id ASC";
        try {
            prepStmt = conn.prepareStatement(sqlSelect);
            prepStmt.setString(1, "%" + query + "%");
            prepStmt.setString(2, "%" + query + "%");
            ResultSet res = prepStmt.executeQuery();
            while (res.next()) {
                list.add(new Borrowing(res.getString("id"), res.getString("member"), res.getString("nama_member"), res.getString("buku"), res.getString("judul_buku"), res.getString("tanggal_pinjam"), res.getString("tanggal_kembali"), res.getInt("deadline")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public DetailBook selectDetailBook(String id) {
        DetailBook detailBook = new DetailBook();
        ArrayList<Borrowing> borrowingList = new ArrayList();
        String sqlSelectBook = "SELECT * FROM buku_simple WHERE id = ?";
        String sqlSelectTotalBorrowing = "SELECT * FROM total_buku_peminjaman WHERE id = ?";
        String sqlSelectBorrowing = "SELECT * FROM peminjaman_simple WHERE buku = ? ORDER BY id ASC";
        int totalBorrowing = 0;
        try {
            prepStmt = conn.prepareStatement(sqlSelectBorrowing);
            prepStmt.setString(1, id);
            ResultSet res = prepStmt.executeQuery();
            while (res.next()) {
                borrowingList.add(new Borrowing(res.getString("id"), res.getString("member"), res.getString("nama_member"), res.getString("buku"), res.getString("judul_buku"), res.getString("tanggal_pinjam"), res.getString("tanggal_kembali"), res.getInt("deadline")));
            }
            
            detailBook.setBorrowingList(borrowingList);
            
            prepStmt = conn.prepareStatement(sqlSelectTotalBorrowing);
            prepStmt.setString(1, id);
            res = prepStmt.executeQuery();
            while (res.next()) {
                totalBorrowing = res.getInt("total_peminjaman");
            }
            
            detailBook.setTotalBorrowing(totalBorrowing);
            
            prepStmt = conn.prepareStatement(sqlSelectBook);
            prepStmt.setString(1, id);
            res = prepStmt.executeQuery();
            while (res.next()) {
                detailBook.setBook(new Book(res.getString("id"), res.getString("judul"), res.getString("penulis"), res.getString("nama_penulis"), res.getString("penerbit"), res.getString("nama_penerbit"), res.getString("kategori"), res.getString("nama_kategori"), res.getString("tahun_terbit"), res.getInt("total_halaman")));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detailBook;
    }
    
    public DetailCategory selectDetailCategory(String id) {
        DetailCategory detailCategory = new DetailCategory();
        ArrayList<Book> bookList = new ArrayList();
        String sqlSelectCategory = "SELECT * FROM kategori WHERE id = ?";
        String sqlSelectTotalBook = "SELECT * FROM total_buku_kategori WHERE id = ?";
        String sqlSelectBook = "SELECT * FROM buku_simple WHERE kategori = ? ORDER BY id ASC";
        int totalBook = 0;
        try {
            prepStmt = conn.prepareStatement(sqlSelectBook);
            prepStmt.setString(1, id);
            ResultSet res = prepStmt.executeQuery();
            while (res.next()) {
                bookList.add(new Book(res.getString("id"), res.getString("judul"), res.getString("penulis"), res.getString("nama_penulis"), res.getString("penerbit"), res.getString("nama_penerbit"), res.getString("kategori"), res.getString("nama_kategori"), res.getString("tahun_terbit"), res.getInt("total_halaman")));
            }
            
            detailCategory.setBookList(bookList);
            
            prepStmt = conn.prepareStatement(sqlSelectTotalBook);
            prepStmt.setString(1, id);
            res = prepStmt.executeQuery();
            while (res.next()) {
                totalBook = res.getInt("total_buku");
            }
            
            detailCategory.setTotalBook(totalBook);
            
            prepStmt = conn.prepareStatement(sqlSelectCategory);
            prepStmt.setString(1, id);
            res = prepStmt.executeQuery();
            while (res.next()) {
                detailCategory.setCategory(new Category(res.getString("id"), res.getString("nama"), res.getString("label")));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detailCategory;
    }
    
    public DetailAuthor selectDetailAuthor(String id) {
        DetailAuthor detailAuthor = new DetailAuthor();
        ArrayList<Book> bookList = new ArrayList();
        String sqlSelectAuthor = "SELECT * FROM penulis WHERE id = ?";
        String sqlSelectTotalBook = "SELECT * FROM total_buku_penulis WHERE id = ?";
        String sqlSelectBook = "SELECT * FROM buku_simple WHERE penulis = ? ORDER BY id ASC";
        int totalBook = 0;
        try {
            prepStmt = conn.prepareStatement(sqlSelectBook);
            prepStmt.setString(1, id);
            ResultSet res = prepStmt.executeQuery();
            while (res.next()) {
                bookList.add(new Book(res.getString("id"), res.getString("judul"), res.getString("penulis"), res.getString("nama_penulis"), res.getString("penerbit"), res.getString("nama_penerbit"), res.getString("kategori"), res.getString("nama_kategori"), res.getString("tahun_terbit"), res.getInt("total_halaman")));
            }
            
            detailAuthor.setBookList(bookList);
            
            prepStmt = conn.prepareStatement(sqlSelectTotalBook);
            prepStmt.setString(1, id);
            res = prepStmt.executeQuery();
            while (res.next()) {
                totalBook = res.getInt("total_buku");
            }
            
            detailAuthor.setTotalBook(totalBook);
            
            prepStmt = conn.prepareStatement(sqlSelectAuthor);
            prepStmt.setString(1, id);
            res = prepStmt.executeQuery();
            while (res.next()) {
                detailAuthor.setAuthor(new Author(res.getString("id"), res.getString("nama"), res.getString("jenis_kelamin"), res.getString("negara")));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detailAuthor;
    }
    
    public DetailPublisher selectDetailPublisher(String id) {
        DetailPublisher detailPublisher = new DetailPublisher();
        ArrayList<Book> bookList = new ArrayList();
        String sqlSelectPublisher = "SELECT * FROM penerbit WHERE id = ?";
        String sqlSelectTotalBook = "SELECT * FROM total_buku_penerbit WHERE id = ?";
        String sqlSelectBook = "SELECT * FROM buku_simple WHERE penerbit = ? ORDER BY id ASC";
        int totalBook = 0;
        try {
            prepStmt = conn.prepareStatement(sqlSelectBook);
            prepStmt.setString(1, id);
            ResultSet res = prepStmt.executeQuery();
            while (res.next()) {
                bookList.add(new Book(res.getString("id"), res.getString("judul"), res.getString("penulis"), res.getString("nama_penulis"), res.getString("penerbit"), res.getString("nama_penerbit"), res.getString("kategori"), res.getString("nama_kategori"), res.getString("tahun_terbit"), res.getInt("total_halaman")));
            }
            
            detailPublisher.setBookList(bookList);
            
            prepStmt = conn.prepareStatement(sqlSelectTotalBook);
            prepStmt.setString(1, id);
            res = prepStmt.executeQuery();
            while (res.next()) {
                totalBook = res.getInt("total_buku");
            }
            
            detailPublisher.setTotalBook(totalBook);
            
            prepStmt = conn.prepareStatement(sqlSelectPublisher);
            prepStmt.setString(1, id);
            res = prepStmt.executeQuery();
            while (res.next()) {
                detailPublisher.setPublisher(new Publisher(res.getString("id"), res.getString("nama"), res.getString("alamat"), res.getString("no_telpon"), res.getString("negara")));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detailPublisher;
    }
    
    public DetailMember selectDetailMember(String id) {
        DetailMember detailMember = new DetailMember();
        ArrayList<Borrowing> borrowingList = new ArrayList();
        String sqlSelectMember = "SELECT * FROM member WHERE id = ?";
        String sqlSelectTotalBook = "SELECT * FROM total_buku_member WHERE id = ?";
        String sqlSelectBorrowing = "SELECT * FROM buku_peminjaman_member WHERE member = ? ORDER BY id ASC";
        int totalBook = 0;
        try {
            prepStmt = conn.prepareStatement(sqlSelectBorrowing);
            prepStmt.setString(1, id);
            ResultSet res = prepStmt.executeQuery();
            while (res.next()) {
                borrowingList.add(new Borrowing(res.getString("id"), res.getString("member"), res.getString("nama_member"), res.getString("buku"), res.getString("judul_buku"), res.getString("tanggal_pinjam"), res.getString("tanggal_kembali"), res.getInt("deadline")));
            }
            
            detailMember.setBorrowingList(borrowingList);
            
            prepStmt = conn.prepareStatement(sqlSelectTotalBook);
            prepStmt.setString(1, id);
            res = prepStmt.executeQuery();
            while (res.next()) {
                totalBook = res.getInt("total_buku");
            }
            
            detailMember.setTotalBook(totalBook);
            
            prepStmt = conn.prepareStatement(sqlSelectMember);
            prepStmt.setString(1, id);
            res = prepStmt.executeQuery();
            while (res.next()) {
                detailMember.setMember(new Member(res.getString("id"), res.getString("nama"), res.getString("alamat"), res.getString("no_telpon"), res.getString("jenis_kelamin")));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detailMember;
    }
    
    public ArrayList<Book> selectAllBook() {
        ArrayList<Book> list = new ArrayList();
        String sqlSelect = "SELECT * FROM buku_simple ORDER BY id ASC";
        try {
            prepStmt = conn.prepareStatement(sqlSelect);
            ResultSet res = prepStmt.executeQuery();
            while (res.next()) {
                list.add(new Book(res.getString("id"), res.getString("judul"), res.getString("penulis"), res.getString("nama_penulis"), res.getString("penerbit"), res.getString("nama_penerbit"), res.getString("kategori"), res.getString("nama_kategori"), res.getString("tahun_terbit"), res.getInt("total_halaman")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Category> selectAllCategory() {
        ArrayList<Category> list = new ArrayList();
        String sqlSelect = "SELECT * FROM kategori ORDER BY id ASC";
        try {
            prepStmt = conn.prepareStatement(sqlSelect);
            ResultSet res = prepStmt.executeQuery();
            while (res.next()) {
                list.add(new Category(res.getString("id"), res.getString("nama"), res.getString("label")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Author> selectAllAuthor() {
        ArrayList<Author> list = new ArrayList();
        String sqlSelect = "SELECT * FROM penulis ORDER BY id ASC";
        try {
            prepStmt = conn.prepareStatement(sqlSelect);
            ResultSet res = prepStmt.executeQuery();
            while (res.next()) {
                list.add(new Author(res.getString("id"), res.getString("nama"), res.getString("jenis_kelamin"), res.getString("negara")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Member> selectAllMember() {
        ArrayList<Member> list = new ArrayList();
        String sqlSelect = "SELECT * FROM member ORDER BY id ASC";
        try {
            prepStmt = conn.prepareStatement(sqlSelect);
            ResultSet res = prepStmt.executeQuery();
            while (res.next()) {
                list.add(new Member(res.getString("id"), res.getString("nama"), res.getString("alamat"), res.getString("no_telpon"), res.getString("jenis_kelamin")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Publisher> selectAllPublisher() {
        ArrayList<Publisher> list = new ArrayList();
        String sqlSelect = "SELECT * FROM penerbit ORDER BY id ASC";
        try {
            prepStmt = conn.prepareStatement(sqlSelect);
            ResultSet res = prepStmt.executeQuery();
            while (res.next()) {
                list.add(new Publisher(res.getString("id"), res.getString("nama"), res.getString("alamat"), res.getString("no_telpon"), res.getString("negara")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Borrowing> selectAllBorrowing() {
        ArrayList<Borrowing> list = new ArrayList();
        String sqlSelect = "SELECT * FROM peminjaman_simple ORDER BY id ASC";
        try {
            prepStmt = conn.prepareStatement(sqlSelect);
            ResultSet res = prepStmt.executeQuery();
            while (res.next()) {
                list.add(new Borrowing(res.getString("id"), res.getString("member"), res.getString("nama_member"), res.getString("buku"), res.getString("judul_buku"), res.getString("tanggal_pinjam"), res.getString("tanggal_kembali"), res.getInt("deadline")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void remove(String id, String table) {
        String sqlRemove = "DELETE FROM " + table + " WHERE id = '" + id + "'";
        try {
            prepStmt = conn.prepareStatement(sqlRemove);
            prepStmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateMember(Member member) {
        String sqlUpdate = "UPDATE member SET nama = '" + member.getName() + "',alamat = '" + member.getAddress() + "',no_telpon = '" + member.getPhoneNumber() + "',jenis_kelamin = '" + member.getGender() + "' WHERE id = '" + member.getId() + "'";
        try {
            prepStmt = conn.prepareStatement(sqlUpdate);
            prepStmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateAuthor(Author author) {
        String sqlUpdate = "UPDATE penulis SET nama = '" + author.getName() + "',jenis_kelamin = '" + author.getGender() + "',negara = '" + author.getCountry() + "' WHERE id = '" + author.getId() + "'";
        try {
            prepStmt = conn.prepareStatement(sqlUpdate);
            prepStmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updatePublisher(Publisher publisher) {
        String sqlUpdate = "UPDATE penerbit SET nama = '" + publisher.getName() + "',alamat = '" + publisher.getAddress() + "',no_telpon = '" + publisher.getPhoneNumber() + "',negara = '" + publisher.getCountry() + "' WHERE id = '" + publisher.getId() + "'";
        try {
            prepStmt = conn.prepareStatement(sqlUpdate);
            prepStmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateCategory(Category category) {
        String sqlUpdate = "UPDATE kategori SET nama = '" + category.getName() + "',label = '" + category.getLabel() + "' WHERE id = '" + category.getId() + "'";
        try {
            prepStmt = conn.prepareStatement(sqlUpdate);
            prepStmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateBook(Book book) {
        String sqlUpdate = "UPDATE buku SET judul = ?,tahun_terbit = ?,kategori = ?,penulis = ?,penerbit = ?,total_halaman = ? WHERE id = ?";
        try {
            prepStmt = conn.prepareStatement(sqlUpdate);
            prepStmt.setString(1, book.getTitle());
            prepStmt.setString(2, book.getPublishedYear());
            prepStmt.setString(3, book.getCategory());
            prepStmt.setString(4, book.getAuthor());
            prepStmt.setString(5, book.getPublisher());
            prepStmt.setInt(6, book.getTotalPage());
            prepStmt.setString(7, book.getId());
            prepStmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateBorrowing(Borrowing borrowing) {
        String sqlUpdate = "UPDATE peminjaman SET tanggal_pinjam = ?, tanggal_kembali = ?, deadline = ? WHERE id = ?";
        try {
            prepStmt = conn.prepareStatement(sqlUpdate);
            prepStmt.setString(1, borrowing.getBorrowingDate());
            prepStmt.setString(2, borrowing.getReturningDate());
            prepStmt.setInt(3, borrowing.getBorrowingDuration());
            prepStmt.setString(4, borrowing.getId());
            prepStmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void insertBook(Book book) {
        String sqlInsert = "INSERT INTO buku VALUES(?,?,?,?,?,?,?)";
        try {
            prepStmt = conn.prepareStatement(sqlInsert);
            prepStmt.setString(1, book.getId());
            prepStmt.setString(2, book.getTitle());
            prepStmt.setString(3, book.getPublishedYear());
            prepStmt.setString(4, book.getIdCategory());
            prepStmt.setString(5, book.getIdAuthor());
            prepStmt.setString(6, book.getIdPublisher());
            prepStmt.setInt(7, book.getTotalPage());
            prepStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "New Book entry has been created");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void insertMember(Member member) {
        String sqlInsert = "INSERT INTO member VALUES(?,?,?,?,?)";
        try {
            prepStmt = conn.prepareStatement(sqlInsert);
            prepStmt.setString(1, member.getId());
            prepStmt.setString(2, member.getName());
            prepStmt.setString(3, member.getAddress());
            prepStmt.setString(4, member.getPhoneNumber());
            prepStmt.setString(5, member.getGender());
            prepStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "New Member entry has been created");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void insertPublisher(Publisher publisher) {
        String sqlInsert = "INSERT INTO penerbit VALUES(?,?,?,?,?)";
        try {
            prepStmt = conn.prepareStatement(sqlInsert);
            prepStmt.setString(1, publisher.getId());
            prepStmt.setString(2, publisher.getName());
            prepStmt.setString(3, publisher.getAddress());
            prepStmt.setString(4, publisher.getPhoneNumber());
            prepStmt.setString(5, publisher.getCountry());
            prepStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "New Publisher entry has been created");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void insertAuthor(Author author) {
        String sqlInsert = "INSERT INTO penulis VALUES(?,?,?,?)";
        try {
            prepStmt = conn.prepareStatement(sqlInsert);
            prepStmt.setString(1, author.getId());
            prepStmt.setString(2, author.getName());
            prepStmt.setString(3, author.getGender());
            prepStmt.setString(4, author.getCountry());
            prepStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "New Author entry has been created");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void insertCategory(Category category) {
        String sqlInsert = "INSERT INTO kategori VALUES(?,?,?)";
        try {
            prepStmt = conn.prepareStatement(sqlInsert);
            prepStmt.setString(1, category.getId());
            prepStmt.setString(2, category.getName());
            prepStmt.setString(3, category.getLabel());
            prepStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "New Category entry has been created");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void insertBorrowing(Borrowing borrowing) {
        String sqlInsert = "INSERT INTO peminjaman VALUES(?,?,?,?,?,?)";
        try {
            prepStmt = conn.prepareStatement(sqlInsert);
            prepStmt.setString(1, borrowing.getId());
            prepStmt.setString(2, borrowing.getIdMember());
            prepStmt.setString(3, borrowing.getIdBook());
            prepStmt.setString(4, borrowing.getBorrowingDate());
            prepStmt.setString(5, borrowing.getReturningDate());
            prepStmt.setInt(6, borrowing.getBorrowingDuration());
            prepStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "New Borrowing entry has been created");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
    }

}
