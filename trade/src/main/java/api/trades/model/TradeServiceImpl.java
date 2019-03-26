package api.trades.model;

import api.trades.repo.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    private TradeRepository repository;

    @Override
    public Trade create(Trade trade) {
        repository.saveTrade(trade);
        return trade;
    }

    @Override
    public Trade delete(String id) {
        Trade trade = findById(id);
        if(trade != null){
            repository.deleteTrade(trade.getId());
        }
        return trade;
    }

    @Override
    public Map<String, Trade> findAll() {
        return repository.findAllTrades();
    }

    @Override
    public Trade findById(String id) {
        return repository.findTrade(id);
    }

    @Override
    public Trade update(Trade trade) {
        repository.updateTrade(trade);
        return trade;
    }
}
