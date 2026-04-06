import java.util.Scanner;

class Account{
    String accountNumber;
    String pin;
    int attempts;
    boolean locked;
    
    Account(String accountNumber, String pin){
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.attempts = 0;
        this.locked = false;
    }
    
}

public class main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        Account[] user = new Account[10]; // max 10 users
        int userCount = 0;
        
        OUTER:
        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 3:
                    //exit
                    break OUTER;
                case 1:
                    {
                        //create account
                        if (userCount >= user.length) {
                            System.out.println("User limit reached.");
                            continue;
                        }       System.out.print("Enter new account number: ");
                        String accountNumber = scan.nextLine();
                        System.out.print("Set 4 digit PIN: ");
                        String pin = scan.nextLine();
                        user[userCount] = new Account(accountNumber, pin);
                        userCount++;
                        System.out.println("Account created.");
                        break;
                    }
                case 2:
                    {
                        //login
                        System.out.print("Enter account number: ");
                        String accountNumber = scan.nextLine();
                        Account currentAccount = null;
                        for (int i = 0; i < userCount; i++) { //go through existing accounts and find if the user input exists
                            if (user[i].accountNumber.equals(accountNumber)) {
                                currentAccount = user[i];
                                break;
                            }
                        }       if (currentAccount == null){
                            System.out.println("Account not found.");
                            continue;
                        }       if (currentAccount.locked){
                            System.out.println("Account is locked.");
                            continue;
                        }       for (int i = 0; i < 3; i++) { //3 login attempts
                            System.out.print("Enter PIN: ");
                            String pinInput = scan.nextLine();
                            
                            if (pinInput.equals(currentAccount.pin)) {
                                System.out.println("Login successful.");
                                currentAccount.attempts = 0;
                                break;
                            } else {
                                currentAccount.attempts++;
                                System.out.println("Incorrect PIN.");
                                
                                if (currentAccount.attempts >= 3) {
                                    currentAccount.locked = true;
                                    System.out.println("You have done 3 attempts. Account is now locked.");
                                    break;
                                }
                            }
                        }      
                        break;
                    }
                default:
                    break;
            }
        }
    }
}