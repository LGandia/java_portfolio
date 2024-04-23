class bankAccount {
    private final String accountNumber;
    private double balance;

    public bankAccount(String accountNumber, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.balance = initialDeposit;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Invalid withdrawal amount");
        }
    }

    public void addInterest() {
        balance += balance * 0.03;
    }

    public void getBalance() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println();
    }
}

class Bank {
    private final bankAccount[] accounts;
    private int numberOfAccounts;

    public Bank() {
        accounts = new bankAccount[30];
        numberOfAccounts = 0;
    }

    public void createAccount(String accountNumber, double initialDeposit) {
        if (numberOfAccounts < 30) {
            accounts[numberOfAccounts] = new bankAccount(accountNumber, (long) initialDeposit);
            numberOfAccounts++;
        } else {
            System.out.println("Bank is at full capacity, cannot create new account");
        }
    }

    public bankAccount getAccount(String accountNumber) {
        for (int i = 0; i < numberOfAccounts; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                return accounts[i];
            }
        }
        return null;
    }

    public void addInterestToAllAccounts() {
        for (int i = 0; i < numberOfAccounts; i++) {
            accounts[i].addInterest();
        }
    }
}

public class LLBank {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.createAccount("146532", 80000);
        bank.createAccount("156899", 50000);

        bankAccount account1 = bank.getAccount("146532");

        account1.getBalance();
        account1.deposit(500);
        account1.getBalance();

        bankAccount account2 = bank.getAccount("156899");
        account2.getBalance();
        account2.deposit(102);
        account2.getBalance();

        bank.addInterestToAllAccounts();
        account1.getBalance();
        account2.getBalance();

        account2.withdraw(61605.07);
        account1.deposit(-100);
    }
}
