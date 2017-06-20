package com.example.demo.bo.impl;

import com.example.demo.bo.StockBo;
import com.example.demo.dao.StockDao;
import com.example.demo.model.Stock;

/**
 * Created by dipak on 16/6/17.
 */
public class StockBoImpl implements StockBo {

    StockDao stockDao;

    public  void setStockDao(StockDao stockDao) {
        this.stockDao = stockDao;
    }

    public void save(Stock stock) {
       stockDao.save(stock);
    }

    public void delete(Stock stock) {
        stockDao.delete(stock);
    }

    public void update(Stock stock) {
        stockDao.update(stock);
    }

    public Stock findByStockCode(String stockCode) {
        return stockDao.findByStockCode(stockCode);
    }
}