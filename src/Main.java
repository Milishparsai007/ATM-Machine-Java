import java.util.Scanner;

class global
{
    static int userPin=213487;
}
//class User
//{
//    float balance;
//    int userPin;
//
//    public void setBalance(float balance) {
//        this.balance = balance;
//    }
//
//    public void setUserPin() {
//        this.userPin = global.userPin;
//    }
//
//    public float getBalance() {
//        return balance;
//    }
//}

class ATM {
    float balance;
    public void welcome()
    {
        System.out.println("---- Welcome to the ATM Machine ----");
        System.out.println("-- Enter your Pin : ");
        Scanner sc=new Scanner(System.in);
        int pin=sc.nextInt();

        if (validatePin(pin))
        {
           menu();
        }
        else
        {
            System.out.println("!! Incorrect pin !!");
        }
    }
    public boolean validatePin(int pin)
    {
        return pin == global.userPin;
    }
    public void menu()
    {
        System.out.println("* * * This is the menu of ATM interface * * *\n" +
                "-- Please select one of the below options --");
        System.out.println("1. Check Balance\n" +
                "2. Withdraw Money\n" +
                "3. Deposit Money\n" +
                "4. Exit");
        Scanner sc=new Scanner(System.in);
        int choice=sc.nextInt();
        if (choice>4 || choice<1)
        {
            System.out.println("!! Please select a valid option !!");
        }
        else
        {
            if(choice==1)
            {
                float bal=checkBal();
                System.out.println("-Your A/C balance is : "+bal);
                System.out.println();
                menu();
            }
            else if(choice==2)
            {
                System.out.println("-Enter the amount : ");
                Scanner am=new Scanner(System.in);
                float amount=am.nextFloat();
                float bal=withdrawMoney(amount);
                System.out.println("-Remaining balance in your A/C is : "+bal);
                System.out.println();
                menu();
            }
            else if(choice==3)
            {
                System.out.println("-Enter the amount : ");
                Scanner am=new Scanner(System.in);
                float amount=am.nextFloat();
                float bal=depositMoney(amount);
                System.out.println("-Remaining balance in your A/C is : "+bal);
                System.out.println();
                menu();
            }
            else
            {
                System.out.println("* * Thank you for using our service! * *");
            }
        }
    }

    public float checkBal()
    {
        return balance;
    }

    public float withdrawMoney(float amount)
    {
        if(balance==0 || balance<amount)
        {
            System.out.println("!! Your account has insufficient balance !!");
        }
        else
        {
            balance-=amount;
        }
        return balance;
    }
    public float depositMoney(float amount)
    {
        balance+=amount;
        return amount;
    }
}
class Main
{
    public static void main(String[] args) {
        ATM atm=new ATM();
        atm.welcome();
    }
}