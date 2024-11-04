import java.util.Scanner;

public class ATMOperations {
    private Account account;
    private Scanner scanner = new Scanner(System.in);

    public ATMOperations(Account account) {
        this.account = account;
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nATM Options:");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance"); 
            System.out.println("6. Quit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  
            
            switch (choice) {
                case 1 -> account.showTransactionHistory();
                case 2 -> withdraw();
                case 3 -> deposit();
                case 4 -> transfer();
                case 5 -> checkBalance(); // Calls the new checkBalance method
                case 6 -> {
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    exit = true;
                }
                default -> System.out.println("Invalid option, please try again.");
            }
        }
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    private void transfer() {
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();
        System.out.print("Enter recipient account number: ");
        String recipientAccount = scanner.next();
        account.transfer(amount, recipientAccount);
    }

    // New method to check balance
    private void checkBalance() {
        System.out.println("Current Balance: Rs." + account.getBalance());
    }
}
