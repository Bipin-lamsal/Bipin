
import java.util.*;
public class AtmProject{
    public static void main(String[]args){
        BankAccount obj1 = new BankAccount("xyz","dxg345");
        //obj1.showMenu();データを守るためにカプセル化します。
        Atm atm = new Atm();
        atm.setBankAccount(obj1);
        atm.showMenu();
    }
}

class Atm{
    BankAccount ba;
    void setBankAccount(BankAccount ba){
        this.ba = ba;
    }

    void showMenu(){     //こちらにwhile loop 
        char option = 'a';
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Costumer Name = "+ba.getCostumerName());
        System.out.println("Costumer Id ="+ba.getCostumerId());
        System.out.println("\n");
        System.out.println("A.Check Balace");
        System.out.println("B.Deposit");
        System.out.println("C.Withdraw");
        System.out.println("D.Previous Transaction");
        System.out.println("E.Exit");
        
        do {
            System.out.println("**********************");
            System.out.println("Enter an option");
            System.out.println("**********************");
            option = scanner.next().charAt(0);
            System.out.println("\n");
            //それぞれのcaseでmenu に関するもの答え
            switch(option){
                case 'A' :
                    System.out.println("*************");
                    System.out.println("Balace ="+ba.balance);
                    System.out.println("*************");
                    System.out.println("\n");
                    break;
                    
                    case 'B' :
                    System.out.println("*************");
                    System.out.println("Enter an amount to deposit:");
                    System.out.println("*************");
                    int amount = scanner.nextInt();
                    ba.deposit(amount);
                    System.out.println("\n");
                    break;
                    
                    case 'C' :
                    System.out.println("*************");
                    System.out.println("Enter an amount to withdarw");
                    System.out.println("*************");
                    int amount2 = scanner.nextInt();
                    ba.withdraw(amount2);
                    System.out.println("\n");
                    break;
                    
                    case 'D' :
                    System.out.println("*************");
                    ba.getPreviousTransaction();
                    System.out.println("*************");
                    System.out.println("\n");
                    break;
                    
                    case 'E':
                        
                        System.out.println("***********");
                        break;
                    
                    default:
                    System.out.println("Invalid option please enter once more");
                    break;
            }
        }
    while(option != 'E') ;
    System.out.println("thank you using our services");   
    }
}

//scannerをつかいます。
class BankAccount{
    int balance;
    int previousTransaction;
    private String costumerName;
    private String costumerId;
    //お客様の名前とidを受ける方法
    BankAccount( String cname, String cid){
        costumerName = cname;
        costumerId = cid;
    }
    
    String getCostumerName(){
        return costumerName;
    }
    String getCostumerId(){
        return costumerId ;
    }
    int getbalance(){
        return balance ;
    }
    
    int getpreviousTransaction(){
        return previousTransaction ;
    }

    void deposit (int amount){
        if (amount >0){
            balance =balance +amount;
            previousTransaction = amount;
        }else{
            System.out.println("error amount");
            System.out.println("please put real amount");
        }
    }
    void withdraw (int amount){
        if (amount >0 && amount<balance){
            balance = balance - amount;
            previousTransaction = amount;
        }else{
            System.out.println("error amount");
            System.out.println("sorry your amount is invalid or your balance is insuffient");
        }
    }
    void getPreviousTransaction(){   //if else 文で
        if (previousTransaction > 0){
            System.out.println("Deposited: "+previousTransaction);
        }else if (previousTransaction < 0){
            System.out.println("withdrawn :"+ Math.abs(previousTransaction));
        }else{
            System.out.println("no transaction occured");
        }
    }
    
}
