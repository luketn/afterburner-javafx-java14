package com.mycodefu.dashboard.tables;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

public class TablesPresenter implements Initializable {

    @FXML
    TableView dataTable;

    @FXML
    TextField personTextField;
    AutoCompletionBinding<String> namesAutocompleteBinding;
    Set<String> names = new HashSet<>(Arrays.asList(new String[]{"Luke", "Bob", "Fred", "Jane", "Amanda", "Smithy", "Nessa", "Brin"}));

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        namesAutocompleteBinding = TextFields.bindAutoCompletion(personTextField, names);
        personTextField.setOnKeyPressed(event -> {
            switch(event.getCode()) {
                case ENTER: {
                    addPerson();
                    break;
                }
            }
        });
    }

    public void addPerson() {
        String name = personTextField.getText().trim();
        if (name.isBlank()) {
            return;
        }

        if (!names.contains(name)) {
            names.add(name);
            namesAutocompleteBinding.dispose();
            namesAutocompleteBinding = TextFields.bindAutoCompletion(personTextField, names);
        }
        dataTable.getItems().add(new TableRowData(name, "Friend"));

        personTextField.setText("");
        personTextField.requestFocus();
    }
}
