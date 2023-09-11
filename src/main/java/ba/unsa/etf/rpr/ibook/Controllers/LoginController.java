package ba.unsa.etf.rpr.ibook.Controllers;

import ba.unsa.etf.rpr.ibook.App;
import ba.unsa.etf.rpr.ibook.Business.UserManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private Button loginBtn;
    @FXML
    private Button registerBtn;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    private UserManager userManager = new UserManager();

    private void clearFields(){
        if (username != null)
            username.setText("");
        if (password != null)
            password.setText("");
    }

    public void loginBtnClicked(ActionEvent actionEvent) throws IOException {
        if (userManager.fieldsEmpty(username.getText(), password.getText())){
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText("Fields cannot be empty");
            a.showAndWait();
            clearFields();
            return;
        }

        if (userManager.authenticate(username.getText(), password.getText())){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText("Succesfully logged in!");
            a.showAndWait();
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/mainwindow.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.close();
            stage.setTitle("iBook");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
        else{
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText("Username or password is not correct!");
            a.showAndWait();
            clearFields();
        }

    }

    public void registerBtnClicked(ActionEvent actionEvent) throws IOException {
        Parent root = null;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/register.fxml"));
        root = loader.load();
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.close();

        Stage newStage = new Stage();
        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.setResizable(false);
        newStage.show();

    }
}
