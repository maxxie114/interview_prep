package src;

public class User {
    // Initialize userId and name
    private String userId;
    private String name;

    public User(String userId, String name) {
        // Set userId and name
        this.userId = userId;
        this.name = name;
    }

    // Get name of a user
    public String getName() {
        return this.name;
    }

    // Get userId of a user
    public String getUserId() {
        return this.userId;
    }   
}
