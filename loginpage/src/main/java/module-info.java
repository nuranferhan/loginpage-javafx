module org.example.loginpage {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.loginpage to javafx.fxml;
    exports org.example.loginpage;
}