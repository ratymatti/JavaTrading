package pojo;

import java.math.BigDecimal;

public class CashAccount extends TradeAccount {
        private BigDecimal cashBalance;


    public CashAccount(BigDecimal cashBalance, String id) {
        super(id);
        setCashBalance(cashBalance);
    }

    public CashAccount(CashAccount source) {
        super(source.getId());
        setCashBalance(source.getCashBalance());
    }


    public BigDecimal getCashBalance() {
        return this.cashBalance;
    }

    public void setCashBalance(BigDecimal cashBalance) {
        if (cashBalance == null || cashBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Cash balance must be a non-null positive value");
        }
        this.cashBalance = cashBalance;
    }

    @Override
    public TradeAccount clone() {
        return new CashAccount(this);
    }
}
