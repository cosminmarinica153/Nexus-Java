public class Deposit {
    private int balance;

    public Deposit(int initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void addFunds(int amount) {
        balance += amount;
    }

    public boolean withdrawFunds(int amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}