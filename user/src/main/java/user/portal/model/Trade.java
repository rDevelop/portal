package user.portal.model;

import java.io.Serializable;

public class Trade implements Serializable {

    private long id;
    private String symbol;
    private Side side;
    private double quantity;
    public Trade(long id, String symbol, Side side, double quantity) {
        this.id = id;
        this.symbol = symbol;
        this.side = side;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public Side getSide() {
        return side;
    }

    public double getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", side=" + side +
                ", quantity=" + quantity +
                '}';
    }

    public enum Side {
        BUY, SELL, DEL
    }
}