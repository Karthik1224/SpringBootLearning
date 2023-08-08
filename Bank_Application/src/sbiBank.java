public class sbiBank implements RBIBankInterface{

    private String AcNo;
    private String pass;
    private double balance;
    private double rateofInterest;

    public sbiBank(String AcNo,String pass,double balance)
    {
        this.AcNo=AcNo;
        this.pass=pass;
        this.balance = balance;
    }
    public String depositMoney(int money) {

        if(money > 0) {
            balance += money;
            return "Money : " + money + " has been credited to your account.Now available balance is " + balance + "";
        }
        else {
            return "Money entered is negative";
        }
    }

    public String withdrawMoney(int money, String password) {

        if(password.equals(pass))
        {
            if(money <= balance)
            {
                balance -= money;
                return "Money with drawn : "+money+" remaining balance is "+balance+"";

            }
            else {
                return "Insufficient balance";
            }
        }
        else
        {
            return "you have entered wrong password,try again";
        }

    }

    public String checkBalance(String password) {
        if(password.equals(pass))
        {
            return "Availabe balance :"+balance+"";
        }
        else {
            return "wrong password";
        }
    }

    public Double calculateTotalInterest(int time) {
        Double simpleInterest = (balance*time*rateofInterest)/100;
        return simpleInterest;
    }
}
