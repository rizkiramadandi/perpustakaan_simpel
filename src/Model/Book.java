package Model;

/*@author Rizki Ramadandi*/
public class Book {

    private String id, title, idAuthor, author, idPublisher, publisher, idCategory, category, publishedYear;
    private int totalPage;

    public Book() {
    }

    public Book(String id, String title, String idAuthor, String author, String idPublisher, String publisher, String idCategory, String category, String publishedYear, int totalPage) {
        this.id = id;
        this.title = title;
        this.idAuthor = idAuthor;
        this.author = author;
        this.idPublisher = idPublisher;
        this.publisher = publisher;
        this.idCategory = idCategory;
        this.category = category;
        this.publishedYear = publishedYear;
        this.totalPage = totalPage;
    }

    public String getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(String idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getIdPublisher() {
        return idPublisher;
    }

    public void setIdPublisher(String idPublisher) {
        this.idPublisher = idPublisher;
    }

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(String publishedYear) {
        this.publishedYear = publishedYear;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
