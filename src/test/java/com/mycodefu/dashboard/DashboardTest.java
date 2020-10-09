package com.mycodefu.dashboard;

import com.mycodefu.dashboard.tables.TablesView;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;

import static com.mycodefu.App.setGlobalStylesheetToScene;
import static com.mycodefu.MyFxTestUtils.takeScreenshot;
import static org.junit.jupiter.api.Assertions.*;

class DashboardTest extends ApplicationTest {
    static DashboardView dashboardView;
    private Stage stage;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        dashboardView = new DashboardView();
        Scene scene = new Scene(dashboardView.getView());
        setGlobalStylesheetToScene(scene);
        stage.setScene(scene);
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
    void createLights() {
        moveTo("#createLights");
        clickOn(MouseButton.PRIMARY);
        takeScreenshot(dashboardView);

        FlowPane lightsBox = lookup("#lightsBox").query();
        assertEquals(256, lightsBox.getChildren().size());
    }
}