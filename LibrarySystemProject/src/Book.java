package src;

public class Book {
    // Initialize title, author, and isbn
    private String isbn;
    private String title;
    private String author;

    public Book(String isbn, String title, String author) {
        // Set isbn, title, and author
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    // Get title of a book
    public String getTitle() {
        return this.title;
    }

    // Get author of a book
    public String getAuthor() {
        return this.author;
    }

    // Get ISBN of a book
    public String getIsbn() {
        return this.isbn;
    }
}
