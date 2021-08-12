import javax.swing.JOptionPane;

public class UstpCoop {
  public static void main(String[] args) {

    int select = 0;
    int selection = 0;
    int selectionSecret = 0;
    int chosen = 0;
    int chosenSecret = 0;
    int start = 0;
    int i = 0;
    boolean quit = false;
    boolean exit = false;
    SavingsAccount Sav1 = new SavingsAccount(null, null, null, null, 0);
    SavingsAccount Sav2 = new SavingsAccount(null, null, null, null, 0);
    SavingsAccount Sav3 = new SavingsAccount(null, null, null, null, 0);
    SavingsAccount Sav4 = new SavingsAccount(null, null, null, null, 0);
    SavingsAccount Sav5 = new SavingsAccount(null, null, null, null, 0);
    SavingsAccount Sav[] = { Sav1, Sav2, Sav3, Sav4, Sav5 };

    while (exit != true) {
      select = Integer.parseInt(JOptionPane.showInputDialog(null,
          "1. Create New Account\n2. Account Transaction\n3. Get Pin Number\n4. Exit Program", null,
          JOptionPane.PLAIN_MESSAGE));

      if (select == 1) {

        if (i >= 5) {
          JOptionPane.showMessageDialog(null, "There are already 5 accounts!");
        } else {
          Sav[i].accountName = JOptionPane.showInputDialog(null, "Name: ");

          Sav[i].accountNo = JOptionPane.showInputDialog(null, "Account Number: ");

          Sav[i].accountPinNo = JOptionPane.showInputDialog(null, "Account Pin Number: ");

          Sav[i].SecretCode = JOptionPane.showInputDialog(null, "Secret Code: ");

          Sav[i].accountBalanceAmount = Double.parseDouble(JOptionPane.showInputDialog(null, "Amount to Deposit: "));

          i++;
          start = 0;
        }

      } else if (select == 2) {

        int pin = Integer.parseInt(JOptionPane.showInputDialog(null, "Account Pin Number: "));
        selection = 0;

        try {
          while (Integer.parseInt(Sav[selection].getAccountPinNo()) != pin) {

            selection++;
          }
          if (Integer.parseInt(Sav[selection].getAccountPinNo()) == pin) {
            chosen = Integer.parseInt(Sav[selection].getAccountPinNo());
          }
        } catch (ArrayIndexOutOfBoundsException e) {
          JOptionPane.showMessageDialog(null, "Account doesn't exist!");
        }

        if (chosen == pin) {
          do {

            int in = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Deposit\n2. Withdraw\n3. Balance Inquiry\n"
                + "4. Display Account Info\n5. Cash Advance\n" + "6. Change Pin Number\n7. Exit Account Transaction",
                null, JOptionPane.PLAIN_MESSAGE));

            switch (in) {
              case 1:
                double d = 0;
                Sav[selection].deposit(d);
                break;
              case 2:
                double w = 0;
                Sav[selection].withdraw(w);
                break;
              case 3:
                Sav[selection].balInquiry();
                break;
              case 4:
                Sav[selection].displayAccntInfo();
                break;
              case 5:
                int m = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter months to pay Cash Advance: "));
                Sav[selection].cashAdvance(m);
                break;
              case 6:
                int sCode = Integer.parseInt(JOptionPane.showInputDialog(null, "Secret Code: "));

                while (Integer.parseInt(Sav[selectionSecret].getSecCode()) != sCode) {
                  selectionSecret++;
                }
                if (Integer.parseInt(Sav[selectionSecret].getSecCode()) == sCode) {
                  chosenSecret = Integer.parseInt(Sav[selectionSecret].getSecCode());
                }

                if (chosenSecret == sCode) {
                  String newAccountNumber = JOptionPane.showInputDialog(null, "New Account Number: ");
                  Sav[selectionSecret].accountPinNo = newAccountNumber;
                  JOptionPane.showMessageDialog(null, "Account Pin Number: " + Sav[selectionSecret].accountPinNo);
                  selectionSecret = 0;
                } else {
                  JOptionPane.showMessageDialog(null, "Invalid Secret Code");
                }
                break;

              case 7:
                selection = 0;
                quit = true;
                break;
            }
          } while (!quit);
        } else {
          JOptionPane.showMessageDialog(null, "\nInvalid Pin Number or you have no account");
        }

      } else if (select == 3) {
        quit = false;

        int sCode = Integer.parseInt(JOptionPane.showInputDialog(null, "Secret Code: "));

        while (Integer.parseInt(Sav[selectionSecret].getSecCode()) != sCode) {
          selectionSecret++;
        }
        if (Integer.parseInt(Sav[selectionSecret].getSecCode()) == sCode) {
          chosenSecret = Integer.parseInt(Sav[selectionSecret].getSecCode());
        }

        if (chosenSecret == sCode) {
          do {
            int in = 1;
            switch (in) {
              case 1:
                JOptionPane.showMessageDialog(null, "Account Pin Number: " + Sav[selectionSecret].accountPinNo);
                selectionSecret = 0;
                quit = true;
                break;
            }
          } while (!quit);

        } else {
          JOptionPane.showMessageDialog(null, "Invalid Secret Code");

        }

      } else if (select == 4) {
        exit = true;
        System.exit(0);
      }

    }

  }
}
