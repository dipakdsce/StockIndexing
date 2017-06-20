package com.example.demo;

import com.fasterxml.jackson.databind.util.JSONPObject;

/**
 * Created by dipak on 13/6/17.
 */
public class StockIndex {

    private String symbol;
    private String name;
    private double marketCap;
    private String sector;
    private String industry;


    public void setter (String Symbol, String name, double marketCap, String sector, String industry) {
        this.symbol = symbol;
        this.name = name;
        this.marketCap = marketCap;
        this.sector = sector;
        this.industry = industry;
    }
}
