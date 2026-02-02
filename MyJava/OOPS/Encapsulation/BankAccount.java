package OOPS.Encapsulation;

// Encapsulation: Data hiding and control over the data
// Access modifiers: private, protected, public, default
// private: only accessible within the class
// protected: accessible within the class and subclasses
// public: accessible from anywhere
// default: accessible within the package

class Bank{
    private double balance;

    public Bank(double balance, String accountNumber){ // constructor
        this.balance = balance;
    }

    public double getBalance(){
        
        return balance;
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
        }
        else{
            System.out.println("Invalid amount");
        }
    }
    public void withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
        }
        else{
            System.out.println("Insufficient balance");
        }
    }
}

public class BankAccount{
    public static void main(String[] args){
        Bank bnk = new Bank(1000, "1234567890");
        bnk.deposit(100);
        bnk.withdraw(200);
        System.out.println(bnk.getBalance());
    }
}
