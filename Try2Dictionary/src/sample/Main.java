package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

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
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import static sample.Main.Dict.engDict;
import static sample.Main.Dict.gerDict;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
        primaryStage.setTitle("Multilingual Dictionary");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    static class Dict {
        protected static Hashtable<String, List> engDict = new Hashtable<String, List>();
        protected static Hashtable<String, List> gerDict = new Hashtable<String, List>();
    }

    public static void main(String[] args) {
        launch(args);
        //System.out.println("In main");
        /*int userInputLang;
        Scanner scanner = new Scanner(System.in);

        FileInputStream fis= null;
        try {
            fis = new FileInputStream(new File("C:\\Users\\Akanksha Thokade\\Desktop\\UG\\SY\\EDI\\Projects\\Try1Dictionary\\res\\DictionaryData.xls"));
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
        try {
            HSSFSheet sheet = wb.getSheetAt(0);
            //evaluating cell type
            FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();

            while (true) {
                System.out.println("Enter input language (1. Eng 2. Ger 3. Exit): ");
                userInputLang = scanner.nextInt();
                switch (userInputLang) {
                    case 1 -> endWordMeaning(sheet);
                    case 2 -> gerWordMeaning(sheet);
                    case 3 -> System.exit(0);
                }
            }

        } catch (NullPointerException e) {
            System.out.println("Data couldn't be loaded.");
        }*/

    }

    /*static void engWordMeaning(HSSFSheet sheet) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter word: ");
        String userInput = scanner.nextLine();
        for(Row row: sheet)     //iteration over row using for each loop
        {
            List<String> meanings = new ArrayList<>();
            DataFormatter formatter = new DataFormatter();
            String cellContent;

            for (int i = 1; i < 4; ++i) {
                //to add meanings of the word in a list
                cellContent = formatter.formatCellValue(row.getCell(i));
                meanings.add(cellContent);
            }

            cellContent = formatter.formatCellValue(row.getCell(0));
            engDict.put(cellContent, meanings);
        }

        //showing the meaning
        try{
            System.out.println("German word: " + engDict.get(userInput).toArray()[0]);
            System.out.println("English Meaning: " + engDict.get(userInput).toArray()[1]);
            System.out.println("German Meaning: " + engDict.get(userInput).toArray()[2]);
        }
        catch (NullPointerException e){
            System.out.println("The word doesn't exist in Dictionary");
        }

        scanner.close();
    }*/

   /* private static void gerWordMeaning(HSSFSheet sheet) {

        String userInput;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter word: ");
        userInput = scanner.nextLine();
        for(Row row: sheet)     //iteration over row using for each loop
        {
            List<String> meanings = new ArrayList<>();
            DataFormatter formatter = new DataFormatter();
            String cellContent;

            cellContent = formatter.formatCellValue(row.getCell(0));
            meanings.add(cellContent);
            for (int i = 2; i < 4; ++i) {
                //to add meanings of the word in a list
                cellContent = formatter.formatCellValue(row.getCell(i));
                meanings.add(cellContent);
            }

            cellContent = formatter.formatCellValue(row.getCell(1));
            gerDict.put(cellContent, meanings);
        }

        //showing the meaning
        try{
            System.out.println("English word: " + gerDict.get(userInput).toArray()[0]);
            System.out.println("English Meaning: " + gerDict.get(userInput).toArray()[1]);
            System.out.println("German Meaning: " + gerDict.get(userInput).toArray()[2]);
        }
        catch (NullPointerException e){
            System.out.println("The word doesn't exist in Dictionary");
        }

        scanner.close();
    }*/

}