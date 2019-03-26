import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Trade } from '../models/trade.model';
import { TradeService } from './trade.service';

@Component({
  selector: 'app-trade',
  templateUrl: './trade.component.html',
  styles: []
})
export class TradeComponent implements OnInit {

  trades: Trade[];

  constructor(private router: Router, private tradeService: TradeService) {

  }

  ngOnInit() {
    // console.log('Init getTrades');
    this.tradeService.getTrades()
      .subscribe( data => {
        this.trades = data;
        // console.log('data: ' + data);
      });
  };

  deleteTrade(trade: Trade): void {
    this.tradeService.deleteTrade(trade)
      .subscribe( data => {
        this.trades = this.trades.filter(u => u !== trade);
      });
  };

}


