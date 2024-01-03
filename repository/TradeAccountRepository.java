package repository;

import java.util.HashMap;
import java.util.Map;

import pojo.TradeAccount;

public class TradeAccountRepository {
    private Map<String, TradeAccount> datastore = new HashMap<>();

    public void createTradeAccount(TradeAccount tradeAccount) {
        this.datastore.put(tradeAccount.getId(), tradeAccount.clone());
    }

    public TradeAccount retrieveTradeAccount(String id) {
        return datastore.get(id).clone();
    }

    public void updateTradeAccount(TradeAccount tradeAccount) {
        if (!datastore.containsKey(tradeAccount.getId())) {
            throw new IllegalArgumentException("TradeAccount with ID " + tradeAccount.getId() + " does not exist. Please use createTradeAccount()");
        }
        this.datastore.replace(tradeAccount.getId(), tradeAccount.clone());
    }

    public void deleteTradeAccount(String id) {
        if (!datastore.containsKey(id)) {
            throw new IllegalArgumentException("TradeAccount with ID " + id + " does not exist.");
        }
        this.datastore.remove(id);
    }
    
}
