public class Transaction {
    private String type;
    private double amount;
    private String recipientAccount;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public Transaction(String type, double amount, String recipientAccount) {
        this.type = type;
        this.amount = amount;
        this.recipientAccount = recipientAccount;
    }

    // @Override
    public String toString() {
        if (recipientAccount != null) {
            return type + ": Rs." + amount + " to " + recipientAccount;
        }
        return type + ": Rs." + amount;
    }
}
