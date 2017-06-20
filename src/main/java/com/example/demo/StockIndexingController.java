package com.example.demo;

/**
 * Created by dipak on 13/6/17.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.atomic.AtomicLong;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpHeaders.USER_AGENT;

@RestController
public class StockIndexingController {

    @RequestMapping("/stocks")
    public String index() throws Exception{
        String urlString = "http://finance.google.com/finance/info?client=ig&q=NASDAQ%3AAAPL,GOOG";
        URL obj = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));

        String inputLine;

        StringBuffer response = new StringBuffer();

        while((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();

        return response.toString();


    }

    @RequestMapping("stocks/list")
    public String listStocks() throws Exception {

        String excelFilePath = "/home/dipak/Code/StockIndexing/src/main/resources/excelSheet/Stock.xlsx";
        ReadExcel readExcelobj = new ReadExcel(excelFilePath);

        return readExcelobj.insertIntoDatabase();
    }
}
