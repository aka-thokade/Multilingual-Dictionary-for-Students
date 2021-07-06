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
import javafx.scene.text.FontWeight;
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

import static sample.Main.Dict.engDict;

public class englishController extends startController{
    @FXML
    public Button search;
    @FXML
    public TextField engWord;

    public englishController() throws IOException {
    }

    public void engMeaning(ActionEvent actionEvent) {

        String userInput = engWord.getText().toLowerCase(Locale.ROOT);

        //creating the english dictionary
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
            engDict.put(cellContent.toLowerCase(Locale.ROOT), meanings);
            // meanings: 0 - german word, 1 - english meaning, 2 - german meaning
        }

        //System.out.println("English hastable size: " +engDict.size());

        //showing the meaning
        try{
            /*System.out.println("German word: " + engDict.get(userInput).toArray()[0]);
            System.out.println("English Meaning: " + engDict.get(userInput).toArray()[1]);
            System.out.println("German Meaning: " + engDict.get(userInput).toArray()[2]);*/
            Stage englishStage =new Stage();
            englishStage.initModality(Modality.APPLICATION_MODAL);
            englishStage.setTitle("English");

            Text wordText = new Text();
            wordText.setFont(Font.font("Roboto", FontPosture.REGULAR, 14));
            wordText.setText(userInput);
            wordText.setX(244.0);
            wordText.setY(168.0);
            Label label1 = new Label("Word");
            label1.setFont(Font.font("Roboto Thin", FontPosture.REGULAR, 16));
            label1.setLayoutX(99.0);
            label1.setLayoutY(150.0);

            Text engMeaningText = new Text();
            engMeaningText.setFont(Font.font("Roboto Thin", FontPosture.REGULAR, 14));
            engMeaningText.setText((String) engDict.get(userInput).toArray()[1]);
            engMeaningText.setX(244.0);
            engMeaningText.setY(222.0);
            //engMeaningText.setWrappingWidth(200.0);
            Label label2 = new Label("English Meaning");
            label2.setFont(Font.font("Roboto Thin", FontPosture.REGULAR, 14));
            label2.setLayoutX(99.0);
            label2.setLayoutY(206.0);

            Text gerWordText = new Text();
            gerWordText.setFont(Font.font("Roboto Thin", FontPosture.REGULAR, 14));
            gerWordText.setText((String) engDict.get(userInput).toArray()[0]);
            gerWordText.setX(244.0);
            gerWordText.setY(248.0);
            Label label3 = new Label("German Word");
            label3.setFont(Font.font("Roboto Thin", FontPosture.REGULAR, 16));
            label3.setLayoutX(99.0);
            label3.setLayoutY(230.0);

            Text gerMeaningText = new Text();
            gerMeaningText.setFont(Font.font("Roboto Thin", FontPosture.REGULAR, 14));
            gerMeaningText.setText((String) engDict.get(userInput).toArray()[2]);
            gerMeaningText.setX(244.0);
            gerMeaningText.setY(278.0);
            gerMeaningText.setWrappingWidth(200.0);
            Label label4 = new Label("German Meaning");
            label4.setFont(Font.font("Roboto Thin", FontPosture.REGULAR, 16));
            label4.setLayoutX(99.0);
            label4.setLayoutY(260.0);

            Button button= new Button("OK");
            button.setLayoutX(230.0);
            button.setLayoutY(400.0);
            button.setOnAction(e -> englishStage.close());

            Group root = new Group(label1, wordText, label2, engMeaningText, label3, gerWordText, label4, gerMeaningText, button);
            /*Label label1 = new Label("Word: " + userInput);
            Label label2 = new Label("\nEnglish Meaning: " + engDict.get(userInput).toArray()[1]);
            Label label3= new Label("\nGerman Word: " + engDict.get(userInput).toArray()[0]);
            Label label4= new Label("\nGerman Meaning: " + engDict.get(userInput).toArray()[2]);*/

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
            englishStage.setScene(scene);
            englishStage.showAndWait();
        }
        catch (NullPointerException e){
            //System.out.println("The word doesn't exist in Dictionary");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Alert!");
            String errorText = "The word doesn't exist in Dictionary";
            alert.setContentText(errorText);
            alert.show();
        }

        //showing the scene
        /*Stage englishStage =new Stage();
        englishStage.initModality(Modality.APPLICATION_MODAL);
        englishStage.setTitle("English");
        String str = "";

        Label label1 = new Label("Word: " + userInput);
        Label label2 = new Label("\nEnglish Meaning: " + engDict.get(userInput).toArray()[1]);
        Label label3= new Label("\nGerman Word: " + engDict.get(userInput).toArray()[0]);
        Label label4= new Label("\nGerman Meaning: " + engDict.get(userInput).toArray()[2]);
        Button button= new Button("OK");
        button.setOnAction(e -> englishStage.close());
        VBox layout= new VBox(10);
        layout.getChildren().addAll(label1, label2, label3, label4,button);
        layout.setAlignment(Pos.CENTER);
        Scene scene1= new Scene(layout);
        englishStage.setScene(scene1);
        englishStage.showAndWait();*/
    }
}