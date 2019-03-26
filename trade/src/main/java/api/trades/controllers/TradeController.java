package api.trades.controllers;

import api.trades.model.Trade;
import api.trades.model.TradeService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@RequestMapping({"/api"})
@RequestMapping({"/api/trades"})
public class TradeController {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TradeController.class);


    @Autowired
    private TradeService tradeService;

    @PostMapping
    public Trade create(@RequestBody Trade trade){
        LOGGER.info("{}:{} ", "Trade", trade);
        Trade newTrade = tradeService.create(trade);
        LOGGER.info("{}:{} ", "NewTrade", newTrade);
        return newTrade;

    }

    @GetMapping(path = {"/{id}"})
    public Trade findOne(@PathVariable("id") String id){
        return tradeService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public Trade update(@PathVariable("id") String id, @RequestBody Trade trade){
        trade.setId(id);
        return tradeService.update(trade);
    }

    @DeleteMapping(path ={"/{id}"})
    public Trade delete(@PathVariable("id") String id) {
        return tradeService.delete(id);
    }

    @GetMapping
    public List<Trade> findAll(){
        List<Trade> trades = new ArrayList<>();
        tradeService.findAll().forEach((o, o2) -> trades.add((Trade)o2));
        LOGGER.info("{}:{} ", "Trades", trades);

        return trades;
    }
}
