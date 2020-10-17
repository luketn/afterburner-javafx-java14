package com.mycodefu.home;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;

import static com.mycodefu.App.setGlobalStylesheetToScene;
import static com.mycodefu.MyFxTestUtils.takeScreenshot;

class HomeTest extends ApplicationTest {
    static HomeView homeView;
    private Stage stage;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        homeView = new HomeView();
        Scene scene = new Scene(homeView.getView());
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
    void create() {
        takeScreenshot(homeView);
    }
}