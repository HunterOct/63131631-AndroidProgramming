package ntu.huutuong.sql_book;
public class Book {
    int BookID;
    String BookName;
    int Page;
    Float Price;
    String Description;
    //Tạo getter, setter, constructor

    public Book() {
    }

    public Book(int bookID, String bookName, int page, Float price, String description) {
        BookID = bookID;
        BookName = bookName;
        Page = page;
        Price = price;
        Description = description;
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int bookID) {
        BookID = bookID;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public int getPage() {
        return Page;
    }

    public void setPage(int page) {
        Page = page;
    }

    public Float getPrice() {
        return Price;
    }

    public void setPrice(Float price) {
        Price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}