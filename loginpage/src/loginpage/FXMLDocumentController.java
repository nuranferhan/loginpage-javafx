/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginpage;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FXMLDocumentController implements Initializable {

     @FXML
    private Hyperlink create_acc;

    @FXML
    private Label f;

    @FXML
    private Label f1;

    @FXML
    private Hyperlink login_acc;

    @FXML
    private Button login_btn;

    @FXML
    private AnchorPane login_form;

    @FXML
    private Label nferhan;

    @FXML
    private Label nferhan1;

    @FXML
    private PasswordField password;

    @FXML
    private Button signup_btn;

    @FXML
    private AnchorPane signup_form;

    @FXML
    private PasswordField su_password;

    @FXML
    private TextField su_username;
    
    @FXML
    private TextField su_email;
    
    @FXML
    private TextField username;
    
    // DATABASE TOOLS
    private Connection connect;
    private PreparedStatement statement;
    private ResultSet result;
    
    public Connection connectDb(){
        try{
            connect = DriverManager.getConnection("jdbc:mysql://localhost/admin","root","");
            return connect;
            
        }
        catch(Exception e){e.printStackTrace();}
        return null;
    }
    
    public void login(ActionEvent event){
        connect = connectDb();
        try{
            String sql= "SELECT * FROM data WHERE username = ? and password = ?";
            statement = connect.prepareStatement(sql);
            statement.setString(1, username.getText());
            statement.setString(2, password.getText());
            result = statement.executeQuery();
            
            if(result.next()){
                JOptionPane.showMessageDialog(null,"Successfully Login", "Message", JOptionPane.INFORMATION_MESSAGE);
                login_btn.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
                Scene scene = new Scene (root);
                Stage stage = new Stage ();
                stage.setScene(scene);
                stage.setTitle("Simple Dashboard");
                stage.show();
            }
            else{ 
                JOptionPane.showMessageDialog(null, "Wrong Username/Password", "Message", JOptionPane.ERROR_MESSAGE);
            
            
            }
        }
        catch(Exception e){e.printStackTrace();}
    
    }
    public void signup(ActionEvent event){
        connect = connectDb();
        
        try{
            String sql = "INSERT INTO data VALUES(?,?,?)";
            statement = connect.prepareStatement(sql);
            statement.setString(1, su_username.getText());
            statement.setString(2, su_password.getText());
            statement.setString(3, su_email.getText());
            statement.execute();
            
            JOptionPane.showMessageDialog(null,"Successfully Create new Account", "Message", JOptionPane.INFORMATION_MESSAGE);
                
        }
        catch(Exception e){e.printStackTrace();}
        
    }
    
    public void changeForm(ActionEvent event){
        if(event.getSource() == login_acc){
            signup_form.setVisible(false);
            signup_form.setVisible(true);
        }
        else if (event.getSource() == create_acc){
            signup_form.setVisible(true);
            signup_form.setVisible(false);
        }
    }
    public void exit (){
        
        System.exit(0);
    }
    
    public void textfield (MouseEvent event){
        if(event.getSource() == username){
            username.setStyle("-fx-background-color: #fff;"
                    + "-fx-border-width:3px;");
            password.setStyle("-fx-background-color:#e0f0ff;"
                    + "-fx-border-width:1px;");
        }else if(event.getSource() == password){
            username.setStyle("-fx-background-color:#e0f0ff;"
                    + "-fx-border-width:1px;");
            password.setStyle("-fx-background-color:#fff;"
                    + "-fx-border-width:3px;");
        }
    }

    public void su_textfield (MouseEvent event){
        if(event.getSource() == su_username){
            su_username.setStyle("-fx-background-color: #fff;"
                    + "-fx-border-width:3px;");
            su_password.setStyle("-fx-background-color:#e0f0ff;"
                    + "-fx-border-width:1px;");
            su_email.setStyle("-fx-background-color:#e0f0ff;"
                    + "-fx-border-width:1px;");
        }else if(event.getSource() == su_password){
            su_username.setStyle("-fx-background-color: #e0f0ff;"
                    + "-fx-border-width:1px;");
            su_password.setStyle("-fx-background-color:#fff;"
                    + "-fx-border-width:3px;");
            su_email.setStyle("-fx-background-color:#e0f0ff;"
                    + "-fx-border-width:1px;");
            
        }else if(event.getSource() == su_email){
            su_username.setStyle("-fx-background-color: #e0f0ff;"
                    + "-fx-border-width:1px;");
            su_password.setStyle("-fx-background-color:#e0f0ff;"
                    + "-fx-border-width:1px;");
            su_email.setStyle("-fx-background-color:#fff;"
                    + "-fx-border-width:3px;");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        username.setStyle("-fx-background-color: #fff;"
                    + "-fx-border-width:3px;");
        
        DropShadow original = new DropShadow (50, Color.valueOf("#6404df"));
        f.setEffect(original);
        f1.setEffect(original);
        
        f.setOnMouseEntered((MouseEvent event) ->{
            DropShadow shadow = new DropShadow(50, Color.valueOf("#6404df"));
            f.setStyle("-fz-text-fill: #fff");
            f.setEffect(shadow);
    });
        f.setOnMouseExited((MouseEvent event) ->{
            DropShadow shadow = new DropShadow(20, Color.valueOf("#6404df"));
            f.setStyle("-fz-text-fill: #6a9ae7");
            f.setEffect(shadow);
        });        
        
        f1.setOnMouseEntered((MouseEvent event) ->{
            DropShadow shadow = new DropShadow(50, Color.valueOf("#6404df"));
            f1.setStyle("-fz-text-fill: #fff");
            f1.setEffect(shadow);
    });
        f1.setOnMouseExited((MouseEvent event) ->{
            DropShadow shadow = new DropShadow(20, Color.valueOf("#6404df"));
            f1.setStyle("-fz-text-fill: #6a9ae7");
            f1.setEffect(shadow);
        }); 
    }    
    

    
}
