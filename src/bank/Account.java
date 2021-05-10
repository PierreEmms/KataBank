package bank;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Account {
    private int balance;
    private ArrayList<Integer> history;
    private ArrayList<String> historyTransaction;
    private ArrayList<String> historyDate;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    Account () {
        balance = 50000;
        history = new ArrayList<>();
        historyTransaction = new ArrayList<>();
        historyDate = new ArrayList<>();

        Date date = new Date();
        history.add(balance);
        historyDate.add(sdf.format(date));
        historyTransaction.add("");
    }

    public void getBalance() {
        System.out.println("Your balance: " + balance + "\n");
    }

    private void setBalance(int balance) {
        this.balance = balance;
    }

    public void withDraw(int money) {
        if (balance - money < 0) {
            System.out.println("Not enough money on the account\n");
        } else {
            Date date = new Date();
            historyDate.add(sdf.format(date));
            historyTransaction.add("-" + money + "€");
            setBalance(balance - money);
            history.add(balance);
        }
    }

    public void deposit(int money) {
        Date date = new Date();
        historyDate.add(sdf.format(date));
        historyTransaction.add("+" + money + "€");
        setBalance(balance + money);
        history.add(balance);
    }

    public void seeHistory() {
        for (int i = 0; i < history.size(); i++) {
            System.out.println("Balance: " + history.get(i) + "€" + " at: " + historyDate.get(i) +
                    " " + "(" + historyTransaction.get(i) + ")");
        }
        System.out.println("\n");
    }

}
