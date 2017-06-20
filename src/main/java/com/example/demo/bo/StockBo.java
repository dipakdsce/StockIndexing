package com.example.demo.bo;

/**
 * Created by dipak on 16/6/17.
 */

import com.example.demo.model.Stock;

public interface StockBo {

    void save(Stock stock);
    void update(Stock stock);
    void delete(Stock stock);
    Stock findByStockCode(String stockCode);
}

