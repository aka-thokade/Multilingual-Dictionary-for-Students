package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

public class Main {

    public static void main(String[] args) {

        String userInput;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter word: ");
        userInput = scanner.nextLine();

        Hashtable<String, List> my_dict = new Hashtable<String, List>();

        FileInputStream fis= null;
        try {
            fis = new FileInputStream(new File("C:\\Users\\Akanksha Thokade\\Desktop\\UG\\SY\\EDI\\Projects\\Try1Dictionary\\res\\Data.xls"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//creating workbook instance that refers to .xls file

        HSSFWorkbook wb= null;
        try {
            wb = new HSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
//creating a Sheet object to retrieve the object
        HSSFSheet sheet=wb.getSheetAt(0);
//evaluating cell type
        FormulaEvaluator formulaEvaluator=wb.getCreationHelper().createFormulaEvaluator();
        for(Row row: sheet)     //iteration over row using for each loop
        {
            List<String> meanings = new ArrayList<>();
            DataFormatter formatter = new DataFormatter();
            String cellContent;

            for (int i = 1; i < 4; ++i){
                //to add meanings of the word in a list
                cellContent = formatter.formatCellValue(row.getCell(i));
                meanings.add(cellContent);
            }

            cellContent = formatter.formatCellValue(row.getCell(0));
            my_dict.put(cellContent, meanings);

            System.out.println(my_dict.get(userInput));

            System.out.println();
        }

        scanner.close();
    }
}
