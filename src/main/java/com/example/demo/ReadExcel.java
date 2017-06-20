package com.example.demo;

import com.example.demo.bo.StockBo;
import com.example.demo.model.Stock;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by dipak on 13/6/17.
 */


public class ReadExcel {
    private String fileName;
    private String[] stringCell = new String[1000];

    private String[] symbol;
    private String[] name;
    private double[] marketCap;
    private String[] sector;
    private String[] industry;
    private int numOfRows;

    public ReadExcel(String fileName) throws Exception {


        this.fileName = fileName;
        FileInputStream fs = new FileInputStream(new File(this.fileName));


        Workbook wb = WorkbookFactory.create(new File(this.fileName));
        Sheet sheet = wb.getSheetAt(0);
        int numOfRows = sheet.getPhysicalNumberOfRows();
        this.numOfRows = numOfRows;

        //String[] symbol = new String[numOfRows];
        this.symbol = new String[numOfRows];
        // String[] name = new String[numOfRows];
        this.name = new String[numOfRows];
        // String[] sector = new String[numOfRows];
        this.sector = new String[numOfRows];
        // String[] industry = new String[numOfRows];
        this.industry = new String[numOfRows];
        //double[] marketCap = new double[numOfRows];
        this.marketCap = new double[numOfRows];

        int i = 0;
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            this.symbol[i] = row.getCell(0).getStringCellValue();
            this.name[i] = row.getCell(1).getStringCellValue();
            this.marketCap[i] = row.getCell(2).getNumericCellValue();
            this.sector[i] = row.getCell(3).getStringCellValue();
            this.industry[i] = row.getCell(4).getStringCellValue();
            i++;

        }

        fs.close();
    }


    public String insertIntoDatabase() {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
        StockBo stockBo = (StockBo)appContext.getBean("StockBo");

        for(int i=0; i< this.numOfRows ; i++) {
            Stock stock = new Stock();
            stock.setStockDetails(this.symbol[i], this.name[i], this.marketCap[i], this.sector[i], this.industry[i]);

            stockBo.save(stock);
        }

        return "Insertion Success";
    }
}