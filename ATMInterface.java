import java.util.*;
class BankAccount
{
    private double bal;
    public BankAccount(double ibal) 
    {
        this.bal=ibal;
    }

    public double checkBalance() 
    {
        return bal;
    }

    public void deposit(double amt)
    {
        bal+=amt;
    }

    public boolean withdraw(double amt) 
    {
        if(amt<=bal) 
        {
            bal-=amt;
            return true;
        } 
        else 
        {
            System.out.println("Insufficient Balance.\n");
            return false;
        }
    }
}
class ATM 
{
    private BankAccount account;
    public ATM(BankAccount account) 
    {
        this.account=account;
    }

    public void Menu() 
    {
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void Option(int opt) 
    {
        Scanner s=new Scanner(System.in);
        double amount;
        switch(opt) 
        {
            case 1:
                System.out.println("Your balance is: $" + account.checkBalance());
                System.out.println();
                break;
            case 2:
                System.out.print("Enter deposit amount: $");
                amount=s.nextDouble();
                account.deposit(amount);
                System.out.println("Deposit Successful.\n");
                break;
            case 3:
                System.out.print("Enter withdrawal amount: $");
                amount=s.nextDouble();
                if(account.withdraw(amount))
                {
                    System.out.println("Withdrawal Successful.\n");
                }
                break;
            case 4:
                System.out.println("Exiting. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Option.");
        }
    }
}
public class ATMInterface 
{
    public static void main(String[] args) 
    {
        BankAccount userAccount = new BankAccount(1000);
        ATM atm=new ATM(userAccount);
        Scanner sc=new Scanner(System.in);
        int option;
        System.out.println("Welcome to the ATM!\nYou can deposit, withdraw or check your balance.\n");
        while(true) 
        {
            atm.Menu();
            System.out.print("\nChoose an option: ");
            option=sc.nextInt();
            atm.Option(option);
        }
    }
}