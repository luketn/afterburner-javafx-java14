package com.mycodefu.dashboard.tables;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class TablesPresenter implements Initializable {

    @FXML
    TableView dataTable;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void addPerson(ActionEvent actionEvent) {
        dataTable.getItems().add(new TableRowData("Luke", "Buddy"));
    }
}
