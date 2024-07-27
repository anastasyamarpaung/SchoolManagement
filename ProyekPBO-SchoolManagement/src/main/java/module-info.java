module com.example.demofex {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.demofex.Data to javafx.base;
    opens com.example.demofex to javafx.fxml;
    exports com.example.demofex;
    exports com.example.demofex.Controller;
    opens com.example.demofex.Controller to javafx.fxml;
}