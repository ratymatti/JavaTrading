package pojo;

import java.math.BigDecimal;

public class MarginAccount extends TradeAccount {
    private BigDecimal margin;

    public MarginAccount(String id, BigDecimal margin) {
        super(id);
        setMargin(margin);
    }

    public MarginAccount(MarginAccount source) {
        super(source.getId());
        setMargin(source.getMargin());
    }


    public BigDecimal getMargin() {
        return this.margin;
    }

    public void setMargin(BigDecimal margin) {
        if (margin == null || margin.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Cash balance must be a non-null positive value");
        }
        this.margin = margin;
    }

    @Override
    public TradeAccount clone() {
        return new MarginAccount(this);
    }
}
