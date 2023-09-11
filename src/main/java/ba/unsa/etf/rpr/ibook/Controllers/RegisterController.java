package ba.unsa.etf.rpr.ibook.Controllers;

import ba.unsa.etf.rpr.ibook.App;
import ba.unsa.etf.rpr.ibook.Business.UserManager;
import ba.unsa.etf.rpr.ibook.Dao.DaoFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import ba.unsa.etf.rpr.ibook.Domain.User;
import javafx.stage.Stage;

public class RegisterController {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField repeatpassword;
    @FXML
    private Button registerBtn;
    private UserManager userManager = new UserManager();

    private void clearFields(){
        if (password != null)
            password.setText("");
        if (username != null)
            username.setText("");
        if (repeatpassword != null)
            repeatpassword.setText("");
    }

    public void register(ActionEvent actionEvent){
        Boolean validUsername = userManager.validUsername(username.getText());
        if (!validUsername){
            Alert a= new Alert(Alert.AlertType.WARNING);
            a.setHeaderText("Username exists or empty");
            a.setContentText("Username already exists or empty!");
            a.showAndWait();
            clearFields();
        }

        if (!userManager.passwordsMatch(password.getText(), repeatpassword.getText())){
            Alert a= new Alert(Alert.AlertType.WARNING);
            a.setHeaderText("Passwords don't match");
            a.setContentText("Passwords don't match");
            a.showAndWait();
            clearFields();
        }
        User u = new User();
        u.setUsername(username.getText());
        u.setPassword(password.getText());
        try{
            DaoFactory.userDao().add(u);
            Alert a= new Alert(Alert.AlertType.CONFIRMATION);
            a.setHeaderText("Account made succesfully");
            a.setContentText("Account made succesfully. Please log in now.");
            a.showAndWait();
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("FXMLFiles/login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.close();
            stage.setTitle("Login");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        }
        catch (Exception e){
            Alert a= new Alert(Alert.AlertType.WARNING);
            a.setHeaderText("Unable to make your account");
            a.setContentText("Unable to make your account");
            a.showAndWait();
            clearFields();
        }


    }
}
