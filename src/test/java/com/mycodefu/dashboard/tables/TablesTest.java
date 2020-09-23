package com.mycodefu.dashboard.tables;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputControl;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testfx.assertions.api.Assertions.assertThat;

class TablesTest extends ApplicationTest {
    static TablesView tablesView;

    @Override
    public void start(Stage stage) {
        tablesView = new TablesView();
        stage.setScene(new Scene(tablesView.getView()));
        stage.show();
        stage.toFront();
    }

    @AfterEach
    void cleanup() throws Exception {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    @Test
    void should_contain_add_person_button() {
        Button addPersonButton = lookup("#addPerson").queryButton();
        assertThat(addPersonButton).hasText("Add Person");
    }

    @Test
    void add_person() {
        TableView<TableRowData> tableView = lookup("#dataTable").queryTableView();

        assertEquals(2, tableView.getItems().size());

        TextInputControl personTextField = lookup("#personTextField").queryTextInputControl();
        clickOn(personTextField);
        write("Big Nessy");
        assertThat(personTextField.getText()).isEqualTo("Big Nessy");

        moveTo("#addPerson");
        clickOn(MouseButton.PRIMARY);

        assertEquals(3, tableView.getItems().size());

        TableRowData tableRowData = tableView.getItems().get(2);
        assertEquals("Big Nessy", tableRowData.name());
        assertEquals("Friend", tableRowData.description());
    }

}