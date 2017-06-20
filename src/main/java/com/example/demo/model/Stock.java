package com.example.demo.model;

import java.io.Serializable;

/**
 * Created by dipak on 16/6/17.
 */
public class Stock implements Serializable{

    private String symbol;
    private String name;
    private double marketCap;
    private String sector;
    private String industry;

    public void setStockDetails(String symbol, String name, double marketCap, String sector, String industry) {
        this.symbol = symbol;
        this.name = name;
        this.marketCap = marketCap;
        this.sector = sector;
        this.industry = industry;
    }
}
