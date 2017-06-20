package com.example.demo.dao.impl;

/**
 * Created by dipak on 16/6/17.
 */

import java.util.List;

import com.example.demo.dao.StockDao;
import com.example.demo.model.Stock;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class StockDaoImpl extends HibernateDaoSupport implements StockDao{

    public void save(Stock stock) {
        getHibernateTemplate().save(stock);
    }

    public void update(Stock stock) {
        getHibernateTemplate().update(stock);
    }

    public void delete(Stock stock) {
        getHibernateTemplate().delete(stock);
    }

    public Stock findByStockCode(String stockCode) {
        List list = getHibernateTemplate().find(
                "from Stock where stockCode=?", stockCode);

        return (Stock)list.get(0);
    }
}
