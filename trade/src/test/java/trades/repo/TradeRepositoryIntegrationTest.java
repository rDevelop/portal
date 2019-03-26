package trades.repo;

import api.config.RedisConfig;
import api.trades.model.Trade;
import api.trades.repo.TradeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RedisConfig.class)
public class TradeRepositoryIntegrationTest {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Test.class);

    @Autowired
    private TradeRepository TradeRepository;

    @Test
    public void whenSavingTrade_thenAvailableOnRetrieval() throws Exception {
        //long id, String symbol, Side side, double quantity
        final Trade trade = new Trade("1", "IBM", "100", "1000");
        TradeRepository.saveTrade(trade);
        final Trade retrievedTrade = TradeRepository.findTrade(trade.getId());
        assertEquals(trade.getId(), retrievedTrade.getId());

    }

    @Test
    public void whenUpdatingTrade_thenAvailableOnRetrieval() throws Exception {
        final Trade trade = new Trade("2", "GOOG", "10", "2000");
        TradeRepository.saveTrade(trade);
        trade.setQuantity("4000");
        trade.setPrice("40");
        TradeRepository.saveTrade(trade);
        final Trade retrievedTrade = TradeRepository.findTrade(trade.getId());
        LOGGER.info("{}: {} ", retrievedTrade.getId(), retrievedTrade.getSymbol());
        LOGGER.info("{}: {} ", trade.getQuantity(), retrievedTrade.getQuantity());

        assert(trade.getQuantity() != retrievedTrade.getQuantity() && trade.getSymbol().equals(retrievedTrade.getSymbol()));

    }

    @Test
    public void whenSavingTrades_thenAllShouldAvailableOnRetrieval() throws Exception {
        final Trade engTrade = new Trade("700","UBS", "100", "20_000");
        final Trade medTrade = new Trade("800", "FB", "-100", "100_000");
        TradeRepository.saveTrade(engTrade);
        TradeRepository.saveTrade(medTrade);
        Map<String, Trade> retrievedTrade = TradeRepository.findAllTrades();
        retrievedTrade.forEach((o, o2) -> System.out.println((Trade)o2));
        LOGGER.info("{}:{} ", "Size " , retrievedTrade.size());
        //assertEquals(retrievedTrade.size(), 4);
        assert(retrievedTrade.size() > 2);


    }

//    @Test
//    public void whenDeletingTrade_thenNotAvailableOnRetrieval() throws Exception {
//        final Trade trade = new Trade("Eng2015001", "John Doe", Trade.Gender.MALE, 1);
//        TradeRepository.saveTrade(trade);
//        TradeRepository.deleteTrade(trade.getId());
//        final Trade retrievedTrade = TradeRepository.findTrade(trade.getId());
//        assertNull(retrievedTrade);
//    }


}