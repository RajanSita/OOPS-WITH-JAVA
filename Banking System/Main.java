import java.util.*;

// Interface
interface Account {
    void deposit(double amount);
    void withdraw(double amount);
    double calculateInterest();
    void viewBalance();
}

// SavingsAccount class
class SavingsAccount implements Account {
    private String accountHolder;
    private double balance;
    private double interestRate = 0.04; // 4% interest

    public SavingsAccount(String accountHolder, double initialDeposit) {
        this.accountHolder = accountHolder;
        this.balance = initialDeposit;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be greater than 0.");
            return;
        }
        balance += amount;
        System.out.println(" " + amount + " deposited in Savings Account.");
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be greater than 0.");
            return;
        }
        if (balance >= amount) {
            balance -= amount;
            System.out.println(" " + amount + " withdrawn from Savings Account.");
        } else {
            System.out.println("Insufficient balance in Savings Account.");
        }
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }

    @Override
    public void viewBalance() {
        System.out.println("Savings Account Balance:  " + balance);
    }

    public void addAnnualInterest() {
        double interest = calculateInterest();
        balance += interest;
        System.out.println(" " + interest + " interest added to Savings Account.");
    }
}

// CurrentAccount class
class CurrentAccount implements Account {
    private String accountHolder;
    private double balance;
    private double overdraftLimit = 10000;

    public CurrentAccount(String accountHolder, double initialDeposit) {
        this.accountHolder = accountHolder;
        this.balance = initialDeposit;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be greater than 0.");
            return;
        }
        balance += amount;
        System.out.println(" " + amount + " deposited in Current Account.");
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be greater than 0.");
            return;
        }
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            System.out.println(" " + amount + " withdrawn from Current Account.");
        } else {
            System.out.println("Overdraft limit exceeded.");
        }
    }

    @Override
    public double calculateInterest() {
        return 0; // No interest on current accounts
    }

    @Override
    public void viewBalance() {
        System.out.println("Current Account Balance:  " + balance);
    }

    public void showOverdraftLimit() {
        System.out.println("Overdraft limit is  " + overdraftLimit);
    }
}

// Bank class
class Bank {
    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account added successfully.\n");
    }

    public void showAllBalances() {
        System.out.println("\n--- All Accounts ---");
        for (Account acc : accounts) {
            acc.viewBalance();
        }
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        System.out.println("=== Welcome to Rajan's Bank System ===");

        System.out.print("Enter account holder name: ");
        String name = sc.next();

        System.out.print("Enter initial deposit amount: ");
        double deposit = sc.nextDouble();

        System.out.print("Choose Account Type (1 - Savings, 2 - Current): ");
        int accType = sc.nextInt();

        Account account = null;

        if (accType == 1) {
            account = new SavingsAccount(name, deposit);
        } else if (accType == 2) {
            account = new CurrentAccount(name, deposit);
        } else {
            System.out.println("Invalid account type.");
            sc.close();
            return;
        }

        bank.addAccount(account);

        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Balance");
            System.out.println("4. Calculate Interest");
            if (account instanceof SavingsAccount) {
                System.out.println("5. Add Annual Interest");
            } else if (account instanceof CurrentAccount) {
                System.out.println("5. Show Overdraft Limit");
            }
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double wit = sc.nextDouble();
                    account.withdraw(wit);
                    break;
                case 3:
                    account.viewBalance();
                    break;
                case 4:
                    System.out.println("Interest:  " + account.calculateInterest());
                    break;
                case 5:
                    if (account instanceof SavingsAccount) {
                        ((SavingsAccount) account).addAnnualInterest();
                    } else if (account instanceof CurrentAccount) {
                        ((CurrentAccount) account).showOverdraftLimit();
                    }
                    break;
                case 6:
                    System.out.println("Thank you for using Rajan's Bank!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 6);

        sc.close();
    }
}
