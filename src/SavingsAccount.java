import javax.swing.JOptionPane;

public class SavingsAccount {
  public String accountName, accountName2;
  public String accountNo;
  public String accountPinNo;
  public String SecretCode;
  public double accountBalanceAmount = 0;
  public double MBAL = 500;

  public SavingsAccount(String aName, String aNo, String aPin, String sCode, double aDeposit) {
    accountName = aName;
    accountNo = aNo;
    accountPinNo = aPin;
    SecretCode = sCode;
    accountBalanceAmount = aDeposit;
  }

  public void deposit(double amt) {

    amt = Integer.parseInt(JOptionPane.showInputDialog(null, "Amount to Deposit: "));
    if (amt < 0) {
      JOptionPane.showMessageDialog(null, "Invalid Amount");
    }
    accountBalanceAmount = accountBalanceAmount + amt;
    JOptionPane.showMessageDialog(null, "Deposited!");
  }

  public void withdraw(double amt) {
    JOptionPane.showMessageDialog(null, "Balance: " + accountBalanceAmount);

    amt = Integer.parseInt(JOptionPane.showInputDialog(null, "amount to Withdraw: "));
    if (accountBalanceAmount < amt) {
      JOptionPane.showMessageDialog(null, "Balance is not Sufficient");

    } else if (amt < 0) {
      JOptionPane.showMessageDialog(null, "Invalid Amount");

    } else {
      accountBalanceAmount = accountBalanceAmount - amt;
      JOptionPane.showMessageDialog(null, "Successful");
    }
  }

  public void balInquiry() {
    JOptionPane.showMessageDialog(null, "Current Balance: " + accountBalanceAmount);
  }

  public void displayAccntInfo() {
    JOptionPane.showMessageDialog(null,
        "Account Name: " + accountName + "\nAccount Number: " + accountNo + "\nAccount Pin Number: " + accountPinNo);
  }

  public double cashAdvance(int numMonths) {
    double netAmount = (accountBalanceAmount * 2) - (accountBalanceAmount * 0.10);
    double monthlyPayment = (netAmount / numMonths);
    if (accountBalanceAmount == 0) {
      JOptionPane.showMessageDialog(null, "Your Account Balance is Empty!\nDeposit Money First.");
    } else {
      JOptionPane.showMessageDialog(null, "Net amount: " + netAmount + "\nMonthly Payment: " + monthlyPayment);
    }
    return netAmount;
  }

  public void setAccountPinNo(String accPin) {
    accountPinNo = accPin;
  }

  public String getAccountPinNo() {
    return accountPinNo;
  }

  public void setSecCode(String sCode) {
    SecretCode = sCode;
  }

  public String getSecCode() {
    return SecretCode;
  }

}
