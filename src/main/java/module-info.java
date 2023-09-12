module ba.unsa.etf.rpr.ibook {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens ba.unsa.etf.rpr.ibook to javafx.fxml;
    exports ba.unsa.etf.rpr.ibook;
    exports ba.unsa.etf.rpr.ibook.Controllers;
    exports ba.unsa.etf.rpr.ibook.Domain;
    opens ba.unsa.etf.rpr.ibook.Domain to javafx.base;
    opens ba.unsa.etf.rpr.ibook.Controllers to javafx.fxml;
}