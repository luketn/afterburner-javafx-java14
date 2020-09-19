package com.mycodefu.controls;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.ComboBox;

import java.util.List;

public class AutocompleteComboBox extends ComboBox<String> {
    public void initAutocompleteWithItems(List<String> data){
        final ObservableList<String> items = FXCollections.observableArrayList(data);

        this.getEditor().textProperty().addListener((ov, o, n) -> {
            if (n.equals(this.getSelectionModel().getSelectedItem())) {
                return;
            }

            this.hide();
            final FilteredList<String> filtered = items.filtered(s -> s.toLowerCase().contains(n.toLowerCase()));
            if (filtered.isEmpty()) {
                this.getItems().setAll(items);
            } else {
                this.getItems().setAll(filtered);
                this.show();
            }
        });
    }
}
