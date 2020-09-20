package com.mycodefu;

import com.mycodefu.dashboard.tables.TablesView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputControl;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.robot.Motion;
import org.testfx.util.WaitForAsyncUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testfx.assertions.api.Assertions.assertThat;

class ApplicationLaunchTest extends FxRobot {
    static TablesView tablesView;

    public static class DemoApplication extends Application {
        @Override
        public void start(Stage stage) {
            tablesView = new TablesView();
            stage.setScene(new Scene(tablesView.getView()));
            stage.show();
            stage.setAlwaysOnTop(true);
        }
    }

    @BeforeEach
    void setup() throws Exception {
        ApplicationTest.launch(DemoApplication.class);
    }

    @AfterEach
    void cleanup() throws Exception {
        FxToolkit.cleanupStages();
    }

    @Test
    void should_contain_add_person_button() {
        Button addPersonButton = lookup("#addPerson").queryButton();
        assertThat(addPersonButton).hasText("Add Person");
    }

    @Test
    void should_click_on_button() throws InterruptedException {
        TableView dataTable = lookup("#dataTable").queryTableView();
        assertEquals(2, dataTable.getItems().size());

        TextInputControl personTextField = lookup("#personTextField").queryTextInputControl();
        clickOn(personTextField);
        personTextField.setText("Luke");

        Button addPersonButton = lookup("#addPerson").queryButton();
        clickOn(addPersonButton, Motion.DIRECT, MouseButton.PRIMARY);

        WaitForAsyncUtils.waitForFxEvents();

//        assertEquals(3, dataTable.getItems().size());
    }

}