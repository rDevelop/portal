package api.trades.model;

import java.io.Serializable;
import java.util.Objects;

public class Trade implements Serializable {

    private String id;
    private String symbol;
    private String quantity;
    private String price;
    private String status;

    public Trade() {}

    public Trade(String id, String symbol, String quantity, String price) {
        this.id = id;
        this.symbol = symbol;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    public enum Side {
        BUY, SELL, DEL
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trade)) return false;
        Trade trade = (Trade) o;
        return Objects.equals(getId(), trade.getId()) &&
                Objects.equals(getSymbol(), trade.getSymbol()) &&
                Objects.equals(getPrice(), trade.getPrice()) &&
                Objects.equals(getQuantity(), trade.getQuantity()) &&
                Objects.equals(getStatus(), trade.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSymbol(), getPrice(), getQuantity(), getStatus());
    }
}