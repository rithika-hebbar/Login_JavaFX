/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Ex4 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        Text title = new Text("Welcome");
        title.getStyleClass().add("fancytext");
        grid.add(title, 0, 0,2,1);
        Label username = new Label("User name:");
        grid.add(username,0,1);
        Label password = new Label("Password:");
        grid.add(password, 0,2);
        TextField usertext = new TextField();
        grid.add(usertext,1,1);
        usertext.setPromptText("Enter Username");
        PasswordField passtext = new PasswordField();
        grid.add(passtext,1,2);
        passtext.setPromptText("Enter Password");
        Button btn = new Button("Sign in");
        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        hbox.getChildren().add(btn);
        grid.add(hbox,1,4);
        Separator sep = new Separator();
        sep.setPrefWidth(10);
        grid.add(sep,0,6,2,1);
        Text outputtext = new Text();
        grid.add(outputtext,1,7);
        Reflection r = new Reflection();
        r.setBottomOpacity(0.2);
        r.setFraction(12);
        r.setTopOffset(10);
        r.setTopOpacity(0.2);
        btn.setEffect(r);
        btn.setStyle("-fx-background-color: lightyellow; -fx-text-fill: darkblue");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                outputtext.setFill(Color.CRIMSON);
                if((!usertext.getText().isEmpty()))
                    outputtext.setText("Welcome "+ usertext.getText());
                else
                    outputtext.setText("Please fill in your details!");
            }
        });
        Scene scene = new Scene(grid,400,350);        
        scene.getStylesheets().add(Ex4.class.getResource("ex4css.css").toExternalForm());
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
