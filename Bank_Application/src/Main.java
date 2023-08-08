import java.util.Arrays;
import java.util.*;
import java.io.*;
public class Main {

    public static String generateRandAccNo()
    {
        int max = 100000000;
        int min = 900000000;
        int rand = (int)(Math.random()*(max-min+1)+min);
        String random = String.valueOf(rand);
        return random;
    }
    public static void main(String[] args) {

        System.out.println("Which bank account you need to create SBI or HDFC");
        System.out.println("Please enter 1 for SBI ,enter 2 for HDFC");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        RBIBankInterface bankAccount;
        System.out.println("Enter password and intial deposit");
        String password = sc.next();
        Integer initialBalance = sc.nextInt();
        String accountNo = generateRandAccNo();
        if(option==1)
        {
            bankAccount = new sbiBank(accountNo,password,initialBalance);
        }
        else
        {
            bankAccount = new hdfcBank(accountNo,password,initialBalance);
        }

        System.out.println(bankAccount.depositMoney(10000));
        System.out.println(bankAccount.withdrawMoney(40000,password));
        System.out.println(bankAccount.checkBalance(password));




    }
}