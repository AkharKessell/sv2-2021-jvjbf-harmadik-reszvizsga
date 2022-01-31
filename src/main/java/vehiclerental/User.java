package vehiclerental;

public class User {
    private String userName;
    private String email;
    private int balance;

    public User(String userName, String email, int balance) {
        this.userName = userName;
        this.email = email;
        this.balance = balance;
    }

    public void minusBalance(int amount) {
        this.balance -= amount;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getEmail() {
        return this.email;
    }

    public int getBalance() {
        return this.balance;
    }
}
