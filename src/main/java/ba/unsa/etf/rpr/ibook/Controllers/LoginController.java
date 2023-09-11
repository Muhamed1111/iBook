package ba.unsa.etf.rpr.ibook.Controllers;

import ba.unsa.etf.rpr.ibook.Dao.DaoFactory;
import ba.unsa.etf.rpr.ibook.Domain.Author;
import ba.unsa.etf.rpr.ibook.Exceptions.BookException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class LoginController {

    private Button loginBtn;
    private Button registerBtn;
    private TextField usernameField;
    private PasswordField passwordField;

    public void loginBtnClicked(ActionEvent actionEvent) throws IOException {
        Parent root = null;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/hello-view.fxml"));
        root = loader.load();
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.close();

        Stage newStage = new Stage();
        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.setResizable(false);
        newStage.show();

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
