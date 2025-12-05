package day06;

public class BankAccount {
    private String owner;
    private int accountNumber;
    private int balance;
    public final boolean isValid;

    public BankAccount(String owner, int accountNumber) {
        setOwner(owner);

        if (setAccountNumber(accountNumber)) {
            this.isValid = true;
        } else {
            System.out.println("ERROR: Failed creating account.");
            this.isValid = false;
        }

        this.balance = 0;
    }

    private void setOwner(String owner) { this.owner = owner; }

    private boolean setAccountNumber(int accountNumber) {
        if (accountNumber <= 0) {
            System.out.println("ERROR: Invalid account number!");
            return false;
        }

        this.accountNumber = accountNumber;
        return true;
    }

    public String getOwner() {
        if (!isValid) System.out.println("ERROR: Cannot find account.");
        return owner;
    }

    public int getAccountNumber() {
        if (!isValid) System.out.println("ERROR: Cannot find account.");
        return accountNumber;
    }

    public int getBalance() {
        if (!isValid) System.out.println("ERROR: Cannot find account.");
        return balance;
    }

    public BankAccount deposit(int amount) {
        if (!isValid) {
            System.out.println("ERROR: Cannot find account.");
            return this;
        }

        System.out.println();

        if (amount <= 0) {
            System.out.println("ERROR: Invalid amount.");
            return this;
        }

        balance += amount;
        System.out.printf("You have deposited %d won.\n", amount);

        return this;
    }

    public BankAccount withdraw(int amount) {
        if (!isValid) {
            System.out.println("ERROR: Cannot find account.");
            return this;
        }

        System.out.println();

        if (amount > balance || amount <= 0) {
            System.out.println("ERROR: Invalid amount.");
            return this;
        }

        balance -= amount;
        System.out.printf("You have withdrawn %d won.\n", amount);

        return this;
    }

    public void printBalance() {
        if (isValid) System.out.println("Balance: " + balance);
        else System.out.println("ERROR: Cannot find account.");
    }

    public void print() {
        if (isValid) {
            System.out.println();
            System.out.println("Owner: " + owner);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: " + balance);
        } else System.out.println("ERROR: Cannot find account.");
    }
}