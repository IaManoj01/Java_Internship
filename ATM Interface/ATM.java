import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Simulating a user account
        Account account = new Account("user123", "1234");
        
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();
        
        if (account.authenticate(userId, pin)) {
            System.out.println("Authentication Successful!");
            ATMOperations atmOperations = new ATMOperations(account);
            atmOperations.start();
        } else {
            System.out.println("Invalid User ID or PIN. Exiting...");
        }
        
        scanner.close();
    }
}