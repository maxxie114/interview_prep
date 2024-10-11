package src;

import java.util.*;

import src.User.*;  
import src.Book.*;

public class Library {

    private Map<String, Book> books; // Maps ISBN to Book
    private Map<String, User> users; // Maps userId to User

    // Constructor
    public Library() {
        // define arrays books and users 
        this.books = new HashMap<String, Book>();
        this.users = new HashMap<String, User>();
    }

    // Add a book to the library
    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    // Remove a book from the library
    public void removeBook(String isbn) {
        books.remove(isbn);
    }

    // Add a user to the library
    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    // Remove a user from the library
    public void removeUser(String userId) {
        users.remove(userId);
    }

    // Search for a user in the system by name
    public User searchUser(String name) {
        // Iterate through users
        for (User user : users.values()) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    // Search for a book in the system by title
    public Book searchBook(String title) {
        // Iterate through books
        for (Book book : books.values()) {
            // If book's title matches title
            if (book.getTitle().equals(title)) {
                // Return book
                return book;
            }
        }
        // Return null
        return null;
    }

    // Search for a book in the system by ISBN
    public Book searchBookByIsbn(String isbn) {
        // Return book with isbn
        return books.get(isbn);
    }
}