import java.math.BigDecimal;

import pojo.CashAccount;
import pojo.MarginAccount;
import pojo.TradeAccount;
import repository.TradeAccountRepository;
import service.CashAccountService;
import service.MarginAccountService;

public class Main {
        
    public static void main(String[] args) {
        TradeAccountRepository repository = new TradeAccountRepository();
        CashAccountService cashAccountService = new CashAccountService(repository);
        MarginAccountService marginAccountService = new MarginAccountService(repository);

        // Create CashAccount and MarginAccount objects
        CashAccount cashAccount = new CashAccount("1", BigDecimal.valueOf(1000));
        MarginAccount marginAccount = new MarginAccount("2", BigDecimal.valueOf(2000));

        // Add the accounts to the repository
        cashAccountService.createTradeAccount(cashAccount);
        marginAccountService.createTradeAccount(marginAccount);

        // Deposit and withdraw amounts
        cashAccountService.deposit("1", BigDecimal.valueOf(500));
        cashAccountService.withdraw("1", BigDecimal.valueOf(200));
        marginAccountService.deposit("2", BigDecimal.valueOf(1000));
        marginAccountService.withdraw("2", BigDecimal.valueOf(500));

        // Retrieve and print the updated account balances
        CashAccount updatedCashAccount = cashAccountService.retrieveTradeAccount("1");
        MarginAccount updatedMarginAccount = marginAccountService.retrieveTradeAccount("2");
        System.out.println("Updated CashAccount balance: " + updatedCashAccount.getCashBalance());
        System.out.println("Updated MarginAccount margin: " + updatedMarginAccount.getMargin());

        // Delete the accounts
        cashAccountService.deleteTradeAccount("1");
        marginAccountService.deleteTradeAccount("2");
    }
}