package com.mycodefu.dashboard.tables;

import com.mycodefu.controls.AutocompleteComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class TablesPresenter implements Initializable {

    @FXML
    TableView dataTable;

    @FXML
    AutocompleteComboBox people;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        people.initAutocompleteWithItems(Arrays.asList("Luke", "Bob", "Jane"));
    }

    public void addPerson(ActionEvent actionEvent) {
        dataTable.getItems().add(new TableRowData(people.getEditor().getText(), "Buddy"));
    }
}
