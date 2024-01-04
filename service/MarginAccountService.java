package service;

import java.math.BigDecimal;

import pojo.MarginAccount;
import repository.TradeAccountRepository;

public class MarginAccountService implements TradeAccountService {

    private TradeAccountRepository repository;

    @Override
    public void deposit(String id, BigDecimal amount) {
        MarginAccount account = retrieveTradeAccount(id);    
        account.setMargin(account.getMargin().add(amount));
        updateTradeAccount(account);
    }

    @Override
    public void withdraw(String id, BigDecimal amount) {
        MarginAccount account = retrieveTradeAccount(id);   
        account.setMargin(account.getMargin().subtract(amount));
        updateTradeAccount(account);
    }

    public MarginAccount retrieveTradeAccount(String id) {
        return (MarginAccount) this.repository.retrieveTradeAccount(id); 
    }

    public void updateTradeAccount(MarginAccount tradeAccount) {
        this.repository.updateTradeAccount(tradeAccount);
    }

    public void deleteTradeAccount(String id) {
        this.repository.deleteTradeAccount(id);
    }

    public void createTradeAccount(MarginAccount tradeAccount) {
        this.repository.createTradeAccount(tradeAccount);
    }

}