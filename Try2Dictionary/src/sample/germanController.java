package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static sample.Main.Dict.gerDict;
import static sample.Main.Dict.gerDict;

public class germanController extends startController{
    @FXML
    public Button search;
    @FXML
    public TextField gerWord;

    public germanController() throws IOException {
    }

    public void gerMeaning(ActionEvent actionEvent) {

        String userInput = gerWord.getText().toLowerCase(Locale.ROOT);

        //creating the german dictionary
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
            gerDict.put(cellContent.toLowerCase(Locale.ROOT), meanings);
            // meanings: 0 - english word, 1 - english meaning, 2 - german meaning
        }

        //showing the meaning
        //System.out.println("German hashtable size: " + gerDict.size());

        try{
            /*System.out.println("English word: " + gerDict.get(userInput).toArray()[0]);
            System.out.println("English Meaning: " + gerDict.get(userInput).toArray()[1]);
            System.out.println("German Meaning: " + gerDict.get(userInput).toArray()[2]);*/
            Stage germanStage =new Stage();
            germanStage.initModality(Modality.APPLICATION_MODAL);
            germanStage.setTitle("German");

            Text wordText = new Text();
            wordText.setFont(Font.font("Roboto Thin", FontPosture.REGULAR, 14));
            wordText.setText(userInput);
            wordText.setX(244.0);
            wordText.setY(168.0);
            Label label1 = new Label("Word");
            label1.setFont(Font.font("Roboto Thin", FontPosture.REGULAR, 16));
            label1.setLayoutX(99.0);
            label1.setLayoutY(150.0);

            Text engMeaningText = new Text();
            engMeaningText.setFont(Font.font("Roboto Thin", FontPosture.REGULAR, 14));
            engMeaningText.setText((String) gerDict.get(userInput).toArray()[2]);
            engMeaningText.setX(244.0);
            engMeaningText.setY(222.0);
            //engMeaningText.setWrappingWidth(200.0);
            Label label2 = new Label("German Meaning");
            label2.setFont(Font.font("Roboto Thin", FontPosture.REGULAR, 14));
            label2.setLayoutX(99.0);
            label2.setLayoutY(206.0);

            Text gerWordText = new Text();
            gerWordText.setFont(Font.font("Roboto Thin", FontPosture.REGULAR, 14));
            gerWordText.setText((String) gerDict.get(userInput).toArray()[0]);
            gerWordText.setX(244.0);
            gerWordText.setY(248.0);
            Label label3 = new Label("English Word");
            label3.setFont(Font.font("Roboto Thin", FontPosture.REGULAR, 16));
            label3.setLayoutX(99.0);
            label3.setLayoutY(230.0);

            Text gerMeaningText = new Text();
            gerMeaningText.setFont(Font.font("Roboto Thin", FontPosture.REGULAR, 14));
            gerMeaningText.setText((String) gerDict.get(userInput).toArray()[1]);
            gerMeaningText.setX(244.0);
            gerMeaningText.setY(278.0);
            gerMeaningText.setWrappingWidth(200.0);
            Label label4 = new Label("English Meaning");
            label4.setFont(Font.font("Roboto Thin", FontPosture.REGULAR, 16));
            label4.setLayoutX(99.0);
            label4.setLayoutY(260.0);

            Button button= new Button("OK");
            button.setLayoutX(230.0);
            button.setLayoutY(400.0);
            button.setOnAction(e -> germanStage.close());

            Group root = new Group(label1, wordText, label2, engMeaningText, label3, gerWordText, label4, gerMeaningText, button);
            /*Label label1 = new Label("Word: " + userInput);
            Label label2 = new Label("\nEnglish Meaning: " + gerDict.get(userInput).toArray()[2]);
            Label label3= new Label("\nGerman Word: " + gerDict.get(userInput).toArray()[0]);
            Label label4= new Label("\nGerman Meaning: " + gerDict.get(userInput).toArray()[1]);*/

            HBox hbox = new HBox(root);
            hbox.setAlignment(Pos.CENTER);
            FileInputStream input = null;
            try {
                input = new FileInputStream("C:\\Users\\Akanksha Thokade\\Desktop\\UG\\SY\\EDI\\Projects\\Try2Dictionary\\src\\bg.jpeg");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Image image = new Image(input);
            BackgroundImage backgroundimage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            Background background = new Background(backgroundimage);
            hbox.setBackground(background);

            Scene scene = new Scene(hbox, 500, 500);
            germanStage.setScene(scene);
            germanStage.showAndWait();
        }
        catch (NullPointerException e){
            //System.out.println("The word doesn't exist in Dictionary");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Alert!");
            String errorText ="The word doesn't exist in Dictionary";
            alert.setContentText(errorText);
            alert.show();
        }

        //showing the scene
        /*Stage germanStage =new Stage();
        germanStage.initModality(Modality.APPLICATION_MODAL);
        germanStage.setTitle("German");
        String str = "";


        Label label1 = new Label("Word: " + userInput);
        Label label2 = new Label("\nGerman Meaning: " + gerDict.get(userInput).toArray()[2]);
        Label label3= new Label("\nEnglish Word: " + gerDict.get(userInput).toArray()[0]);
        Label label4= new Label("\nEnglish Meaning: " + gerDict.get(userInput).toArray()[1]);
        Button button= new Button("OK");
        button.setOnAction(e -> germanStage.close());
        VBox layout= new VBox(10);
        layout.getChildren().addAll(label1, label2, label3, label4,button);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        germanStage.setScene(scene);
        germanStage.showAndWait();*/
    }
}