import java.util.HashMap;

public class BankSystem {
    private final HashMap<String, User> users;

    public BankSystem() {
        users = new HashMap<>();
    }

    public boolean register(String username, String password) {
        if (!users.containsKey(username)) {
            users.put(username, new User(username, password));
            return true;
        }
        return false;
    }

    public User login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.authenticate(password)) {
            return user;
        }
        return null;
    }

    void start() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    void start() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
