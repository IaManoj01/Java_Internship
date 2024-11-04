import java.util.ArrayList;
import java.util.List;

public class Account {
    private String userId;
    private String pin;
    private double balance;
    private List<Transaction> transactionHistory;

    public Account(String userId, String pin) {
        this.userId = userId;
        this.pin = pin;
        this.balance = 0;
        this.transactionHistory = new ArrayList<>();
    }

    public boolean authenticate(String userId, String pin) {
        return this.userId.equals(userId) && this.pin.equals(pin);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add(new Transaction("Deposit", amount));
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdraw", amount));
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void transfer(double amount, String recipientAccount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Transaction("Transfer", amount, recipientAccount));
            System.out.println("Transferred: $" + amount + " to " + recipientAccount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void showTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            System.out.println("Transaction History:");
            for (Transaction transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }

    // New method to get the balance
    public double getBalance() {
        return balance;
    }
}
