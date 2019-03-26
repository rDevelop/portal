package trades.repo;


import api.config.RedisConfig;
import api.trades.model.Trade;
import api.trades.repo.TradeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RedisConfig.class)
public class TradeQueryTest {

    @Autowired
    private TradeRepository TradeRepository;


    @Test
    public void getAllTrades() {
        final Map<String, Trade> trades = TradeRepository.findAllTrades();
        for (Map.Entry<String, Trade> entry : trades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }


    @Test
    public void getSome() {
        TradeRepository.listAllTrades();
    }

}
