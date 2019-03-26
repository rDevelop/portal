package api.trades.repo;

import api.trades.model.Trade;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

import static java.lang.StrictMath.abs;

@Repository
public class TradeRepositoryImpl implements TradeRepository {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TradeRepositoryImpl.class);
    private static final String KEY = "TRADE";

    private RedisTemplate<String, Trade> redisTemplate;
    private HashOperations hashOperations;

    @Autowired
    public TradeRepositoryImpl(RedisTemplate<String, Trade> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    public Trade saveTrade(final Trade trade) {
        if(trade.getId() == null) {
            Integer absHash = abs(new Integer(trade.hashCode()));
            String key = absHash.byteValue() + "T" + trade.getSymbol();
            LOGGER.info("Key: " + key);
            trade.setId(key);
        }
        if (hashOperations.get(KEY, trade.getId()) != null)  {
            trade.setStatus("duplicate");
            LOGGER.info("EXISSTS");
            return trade;

        }
        LOGGER.info("{}: {}: {} ", "saveTrade " , trade.getId(), trade);
        hashOperations.put(KEY, trade.getId(), trade);
        trade.setStatus("saved");




        redisTemplate.convertAndSend("chat", "Saving shit!");
        return trade;

    }

    public Trade updateTrade(final Trade trade) {
        hashOperations.put(KEY, trade.getId(), trade);
        trade.setStatus("updated");
        return trade;
    }

    public Trade findTrade(final String id) {
        return (Trade) hashOperations.get(KEY, id);
    }

    public Map<String, Trade> findAllTrades() {
        return hashOperations.entries(KEY);
    }

    public void deleteTrade(final String id) {
        hashOperations.delete(KEY, id);
    }

    public void listAllTrades() {
        final Map<String, Trade> keys = hashOperations.entries(KEY);
        for (Map.Entry<String, Trade> entry : keys.entrySet()) {
            LOGGER.info("{}:{} ", entry.getKey(), entry.getValue());
        }
    }
}