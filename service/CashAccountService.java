package service;

import java.math.BigDecimal;

import pojo.CashAccount;
import repository.TradeAccountRepository;

public class CashAccountService implements TradeAccountService {

    private TradeAccountRepository repository;

    @Override
    public void deposit(String id, BigDecimal amount) {
        CashAccount account = retrieveTradeAccount(id);
        account.setCashBalance(account.getCashBalance().add(amount));
        updateTradeAccount(account);    
    }

    @Override
    public void withdraw(String id, BigDecimal amount) {
        
    }

    public CashAccount retrieveTradeAccount(String id) {
        return (CashAccount) this.repository.retrieveTradeAccount(id); 
    }

    public void updateTradeAccount(CashAccount tradeAccount) {
        this.repository.updateTradeAccount(tradeAccount);
    }
}
