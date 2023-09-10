module ba.unsa.etf.rpr.ibook {
    requires javafx.controls;
    requires javafx.fxml;


    opens ba.unsa.etf.rpr.ibook to javafx.fxml;
    exports ba.unsa.etf.rpr.ibook;
    exports ba.unsa.etf.rpr.ibook.Controllers;
    opens ba.unsa.etf.rpr.ibook.Controllers to javafx.fxml;
}