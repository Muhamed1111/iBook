package ba.unsa.etf.rpr.ibook.Controllers;


import ba.unsa.etf.rpr.ibook.Business.BookManager;
import ba.unsa.etf.rpr.ibook.Domain.Author;
import ba.unsa.etf.rpr.ibook.Domain.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class HomeController {
    @FXML
    private TextField searchBar;
    @FXML
    private ChoiceBox<String> options;

    @FXML
    private TableView<Book> bookTable;
    @FXML
    private TableColumn<Book, String> colTitle;
    @FXML
    private TableColumn<Book, Author> colAuthor;
    @FXML
    private TableColumn<Book, String> colGenre;
    private BookManager bookManager=new BookManager();
    private List<Book> books= null;

    private ObservableList<Book> observableList = FXCollections.observableArrayList();

    @FXML
    public void initialize(){
        options.getItems().addAll("by Book", "by Author", "by Genre");
        books=bookManager.getAllBooks();
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colAuthor.setCellFactory(column -> new TableCell<Book,Author>(){
            @Override
            protected void updateItem(Author author, boolean b) {
                super.updateItem(author, b);
                if (b || author == null){
                    setText(null);
                }
                else{
                    setText(author.getName());
                }
            }
        });
        bookTable.setItems(observableList);
    }




    @FXML
    public void search(ActionEvent actionEvent){
        observableList.clear();
        if(options.getValue().equals("by Book")){
            List<Book> giveBooks= bookManager.getByTitle(books,searchBar.getText());
            observableList.addAll(giveBooks);
        }
        else if (options.getValue().equals("by Author")){
            List<Book> getAuthor= bookManager.getByAuthorName(books,searchBar.getText());
            observableList.addAll(getAuthor);
        }
        else if(options.getValue().equals("by Genre")){
            List<Book> giveGenre= bookManager.getByGenre(books,searchBar.getText());
            observableList.addAll(giveGenre);
        }
    }


}
