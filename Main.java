import java.math.BigDecimal;

import pojo.CashAccount;
import pojo.MarginAccount;

public class Main {
        public static void main(String[] args) {
        CashAccount cashAccount = new CashAccount("C123", new BigDecimal("1000.00"));
        System.out.println("Cash Account Details:");
        System.out.println("ID: " + cashAccount.getId());
        System.out.println("Cash Balance: " + cashAccount.getCashBalance());

        CashAccount clonedCashAccount = (CashAccount) cashAccount.clone();
        System.out.println("Cloned Cash Account Details:");
        System.out.println("ID: " + clonedCashAccount.getId());
        System.out.println("Cash Balance: " + clonedCashAccount.getCashBalance());

        System.out.println();

        MarginAccount marginAccount = new MarginAccount("M456", new BigDecimal("5000.00"));
        System.out.println("Margin Account Details:");
        System.out.println("ID: " + marginAccount.getId());
        System.out.println("Margin: " + marginAccount.getMargin());

        MarginAccount clonedMarginAccount = (MarginAccount) marginAccount.clone();
        System.out.println("Cloned Margin Account Details:");
        System.out.println("ID: " + clonedMarginAccount.getId());
        System.out.println("Margin: " + clonedMarginAccount.getMargin());
    }
}