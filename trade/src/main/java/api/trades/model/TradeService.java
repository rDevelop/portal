package api.trades.model;

import java.util.Map;

public interface TradeService {

    Trade create(Trade trade);

    Trade delete(String id);

    Map<String, Trade> findAll();

    Trade findById(String id);

    Trade update(Trade trade);
}
