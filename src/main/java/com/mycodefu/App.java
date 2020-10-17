package com.mycodefu;

import com.mycodefu.afterburner.injection.Injector;
import com.mycodefu.afterburner.views.FXMLView;
import com.mycodefu.home.HomeView;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        HomeView appView = new HomeView();
        Scene scene = new Scene(appView.getView());
        stage.setTitle(String.format("Java Template (Java %s, JavaFX %s)", System.getProperty("java.version"), System.getProperty("javafx.runtime.version")));
        setGlobalStylesheetToScene(scene);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        Injector.forgetAll();
    }

    public static void main(String[] args) {
        launch(args);
    }



    public static void setGlobalStylesheetToScene(Scene scene) {
        final String uri = App.class.getResource("app.css").toExternalForm();
        scene.getStylesheets().add(uri);
    }

    public static void showModalView(FXMLView view) {
        Parent root = view.getView();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        setGlobalStylesheetToScene(scene);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }
}
