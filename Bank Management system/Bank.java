import java.util.*;

abstract class Account{
    protected String accNO;
    protected String name;
    protected double balance;

    public Account(String accNO,String name,double balance){
        this.accNO=accNO;
        this.name=name;
        this.balance=balance;
    }

    public void deposit(double money){
        if(money>0){
            balance+=money;
        }
    }

    public void withdraw(double money){
        if(money > 0 && balance>=money){
            balance-=money;
        }
    }

    public void displayDetails(){
        System.out.println("Account Number : "+ accNO);
        System.out.println("Account Holder name: "+ name);
        System.out.println("Balance: "+balance);
    }
    public void showBalance(){
        System.out.println("Balance: "+balance);
    }

    public abstract void calculateInterest();
    
}

class SavingsAccount extends Account{

    public SavingsAccount(String accNO, String name, double balance){
        super(accNO, name, balance);
    }

    @Override
    public void calculateInterest(){
        double interest=balance*0.04;
        balance+=interest;
        System.out.println("Intrest added: "+interest);
    }
}

class CurrentAccount extends Account{
    public CurrentAccount(String accNO, String name, double balance){
        super(accNO, name, balance);
    }

    @Override
    public void calculateInterest() {
        System.out.println("NO intereset for current account");
    }
}


class Bank{
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        Account account=null;

        while(true){
            System.out.println("1. Create an account\n");
            System.out.println("2. Deposit money\n");
            System.out.println("3. Withdraw money\n");
            System.out.println("4. Check balance\n");
            System.out.println("5. Calculate interest\n");
            System.out.println("6. Displaying account details\n");
            System.out.println("7. Exit");

            int choice=sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("1.Savings  2.Current");

                    int type=sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter the account number: ");
                    String accNo=sc.nextLine();

                    System.out.println("Enter the name:");
                    String name=sc.nextLine();

                    System.out.println("Enter the balance");
                    double balance=sc.nextDouble();

                    if(type==1){
                        account = new SavingsAccount(accNo,name,balance);
                    }
                    else if(type==2){
                        account = new CurrentAccount(accNo,name,balance);
                    }

                    System.out.println("Account created successfully\n");
                    break;
                case 2:
                    if(account == null){
                        System.out.println("Please create account first\n");
                        break;
                    }
                    System.out.println("Enter deposit money: ");
                    account.deposit(sc.nextDouble());
                    break;
                case 3:
                    if(account == null){
                        System.out.println("Please create account first\n");
                        break;
                    }
                    System.out.println("Enter withdraw money: ");
                    account.withdraw(sc.nextDouble());
                    break;
                case 4:
                    if(account==null){
                        System.out.println("Please create account first\n");
                        break;
                    }
                    account.showBalance();
                    break;
                case 5:
                    if(account == null){
                        System.out.println("Please create account first\n");
                        break;
                    }
                    account.calculateInterest();
                    break;
                case 6:
                    if(account == null){
                        System.out.println("Please create account first\n");
                        break;
                    }
                    account.displayDetails();
                    break;
                case 7:
                    System.out.println("Exit the program");
                    System.exit(0);
                default:
                    break;
            }

        }
    }
}