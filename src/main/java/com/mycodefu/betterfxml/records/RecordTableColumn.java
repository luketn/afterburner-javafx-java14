package com.mycodefu.betterfxml.records;

import javafx.scene.control.TableColumn;

public class RecordTableColumn<S,T> extends TableColumn<S,T> {
    public RecordTableColumn() {
        setCellValueFactory();
    }
    public RecordTableColumn(String s) {
        super(s);

        setCellValueFactory();
    }

    private void setCellValueFactory() {
        this.setCellValueFactory(new RecordValueFactory<>());
    }
}
