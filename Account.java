public class Account {
    String accountNumber;
    String pin;
    int attempts;
    boolean locked;
    double balance;

    Account(String accountNumber, String pin) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.attempts = 0;
        this.locked = false;
        this.balance = 0.0;
    }
}
