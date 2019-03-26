package api.trades.repo;


import api.trades.model.Trade;

import java.util.Map;

public interface TradeRepository {

    Trade saveTrade(Trade trade);

    Trade updateTrade(Trade trade);

    Trade findTrade(String id);

    Map<String, Trade> findAllTrades();

    void deleteTrade(String id);

    void listAllTrades();
}
