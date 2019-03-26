import { Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Trade } from '../models/trade.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class TradeService {

  constructor(private http: HttpClient) {}

  private tradeUrl = 'http://localhost:9100/api/trades';
  // private userUrl = '/api';

  public getTrades() {
    return this.http.get<Trade[]>(this.tradeUrl);
  }

  public deleteTrade(trade) {
    return this.http.delete(this.tradeUrl + '/' + trade.id);
  }

  public createTrade(trade) {
    console.log('create the trade ' + trade);
    return this.http.post<Trade>(this.tradeUrl, trade);
  }

}
