package com.mycodefu.dashboard.tables;

import com.mycodefu.controls.AutocompleteComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import static com.mycodefu.controls.AutocompleteComboBox.createComboBoxWithAutoCompletionSupport;

public class TablesPresenter implements Initializable {

    @FXML
    TableView dataTable;

    @FXML
    AutocompleteComboBox people;
    @FXML
    VBox rightControls;

    ComboBox<AutocompleteComboBox.HideableItem<String>> comboBoxWithAutoCompletionSupport;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.comboBoxWithAutoCompletionSupport = createComboBoxWithAutoCompletionSupport(Arrays.asList("Luke", "Bob", "Jane"), new StringConverter<AutocompleteComboBox.HideableItem<String>>() {
            @Override
            public String toString(AutocompleteComboBox.HideableItem<String> object) {
                if (object != null) {
                    return object.getObject();
                } else {
                    return null;
                }
            }

            @Override
            public AutocompleteComboBox.HideableItem<String> fromString(String string) {
                return new AutocompleteComboBox.HideableItem<>(string, this);
            }
        });
        comboBoxWithAutoCompletionSupport.setEditable(true);
        rightControls.getChildren().add(comboBoxWithAutoCompletionSupport);
    }

    public void addPerson(ActionEvent actionEvent) {
        dataTable.getItems().add(new TableRowData(this.comboBoxWithAutoCompletionSupport.getEditor().getText(), "Buddy"));
    }
}
