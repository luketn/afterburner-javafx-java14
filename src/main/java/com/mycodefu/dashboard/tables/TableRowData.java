package com.mycodefu.dashboard.tables;

import javafx.beans.property.SimpleStringProperty;

public class TableRowData {
    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleStringProperty description = new SimpleStringProperty();

    public TableRowData(String name, String description) {
        setName(name);
        setDescription(description);
    }

    public TableRowData() {
        this("", "");
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }
}
