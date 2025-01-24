/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginpage;

import java.awt.event.MouseEvent;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Lenovo
 */
public class LoginPage extends Application {
    
    private double x = 0;
    private double y = 0;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        root.setOnMousePressed((MouseEvent event) ->{
            x = event.getSceneX();
            y = event.getSceneY();
            
        });
        
        root.setOnMouseDragged((MouseEvent event) ->{
            stage.setX(event.getScreenx() - x);
            stage.setY(event.getScreenY() - y);
            
                  
    });
        stage.initStyle(StageStyle.TRANSPARENT);

    public static void main(String[] args) {
        launch(args);
    }
    
}
}
