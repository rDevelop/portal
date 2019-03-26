package trades.controllers;

import api.config.RedisConfig;
import api.trades.model.Trade;
import api.trades.model.TradeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RedisConfig.class)
public class TradeControllerTest {

    @Autowired
    private TradeService tradeService;

    @Test
    public void create() {
        tradeService.create(new Trade("1", "ROB", "100", "1000000000"));
        System.out.println(tradeService.findById("1"));

    }

    @Test
    public void findOne() {
        System.out.println(tradeService.findById("1"));

    }

    @Test
    public void update(){

        String id = "3";
        Trade trade = new Trade(id, "IBM", "10", "1000000000");
        assert(trade.getId() == id);
        tradeService.create(trade);
        assert(tradeService.findById(id).getSymbol().equals("IBM"));
        trade.setSymbol("HOG");
        tradeService.update(trade);
        assert(tradeService.findById(id).getSymbol().equals("HOG"));
        findAllTrades();

    }

    @Test
    public void delete() {
        String id = "4";
        tradeService.create(new Trade(id, "IBM", "-100", "1000000000"));
        System.out.println(tradeService.findById(id));
        tradeService.delete(id);
        System.out.println(tradeService.findById(id));
        findAllTrades();
    }

    @Test
    public void findAllTrades() {
        List<Trade> trades = new ArrayList<>();
        tradeService.findAll().forEach((o, o2) -> trades.add((Trade) o2));
        trades.forEach(o -> System.out.println(o));
    }
}
