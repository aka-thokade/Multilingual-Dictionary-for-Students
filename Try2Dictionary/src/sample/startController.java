package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import static sample.Main.Dict.engDict;
import static sample.Main.Dict.gerDict;

public class startController {

    @FXML
    public Button eng;
    @FXML
    public Button ger;

    FileInputStream fis;

    //creating workbook instance that refers to .xls file
    HSSFWorkbook wb;

    HSSFSheet sheet;
    FormulaEvaluator formulaEvaluator;

        /*while (true) {
            System.out.println("Enter input language (1. Eng 2. Ger 3. Exit): ");
            userInputLang = scanner.nextInt();
            switch (userInputLang) {
                case 1 -> endWordMeaning(sheet);
                case 2 -> gerWordMeaning(sheet);
                case 3 -> System.exit(0);
            }
        }*/

    public startController() throws IOException {
        try {
            fis = new FileInputStream(new File("C:\\Users\\Akanksha Thokade\\Desktop\\UG\\SY\\EDI\\Projects\\Try2Dictionary\\res\\DictionaryData3.xls"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            wb = new HSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            //creating a Sheet object to retrieve the object
            sheet = wb.getSheetAt(0);
            //evaluating cell type
            formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();

        } catch (NullPointerException e) {
            System.out.println("Data couldn't be loaded.");
        }
    }

    public void engWindow(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        Parent root= FXMLLoader.load(getClass().getResource("English.fxml"));
        primaryStage.setTitle("English");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void gerWindow(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        Parent root= FXMLLoader.load(getClass().getResource("German.fxml"));
        primaryStage.setTitle("German");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}
