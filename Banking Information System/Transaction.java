import java.util.Date;

public class Transaction {
    private final String type;
    private final double amount;
    private final double balanceAfterTransaction;
    private final Date date;

    public Transaction(String type, double amount, double balanceAfterTransaction) {
        this.type = type;
        this.amount = amount;
        this.balanceAfterTransaction = balanceAfterTransaction;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return date + " | " + type + ": " + amount + " | Balance: " + balanceAfterTransaction;
    }
}
