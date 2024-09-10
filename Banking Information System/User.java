public class User {
    private final  String username;
    private final String password;
    private final BankAccount account;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.account = new BankAccount();
    }

    public String getUsername() {
        return username;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public BankAccount getAccount() {
        return account;
    }
}
