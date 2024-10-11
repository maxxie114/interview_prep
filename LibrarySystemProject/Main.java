import src.Book;
import src.Library;
import src.User;

public class Main {
    public static void main(String[] args) {
        // Create a new library
        Library library = new Library();
        
        // Create a new book and add it to the library
        Book book = new Book("1234", "Java Programming", "John Doe");
        library.addBook(book);
        
        // Create a new user and add it to the user database
        User user = new User("101", "Alice");
        library.addUser(user);
        
        // Search for user by name
        User foundUser = library.searchUser( "Alice");
        System.out.println("User search result by Name:" + foundUser.getName() + " with userId " + foundUser.getUserId());
        
        // Search for book by title
        Book foundBook = library.searchBook("Java Programming");
        System.out.println("Book Title found by title:" + foundBook.getTitle() + " by " + 
            foundBook.getAuthor() + " with ISBN " + foundBook.getIsbn());
        
        // Search for book by ISBN
        Book foundBookByIsbn = library.searchBookByIsbn("1234");
        System.out.println("Book Title found by ISBN:" + foundBookByIsbn.getTitle());
    }
}
