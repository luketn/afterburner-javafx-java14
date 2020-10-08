package com.mycodefu.dashboard;

import com.mycodefu.dashboard.light.LightView;
import com.mycodefu.dashboard.tables.TablesView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import java.net.URL;
import java.time.LocalDate;
import java.util.Random;
import java.util.ResourceBundle;

import static com.mycodefu.App.showModalView;

public class DashboardPresenter implements Initializable {
    @FXML
    Node root;

    @FXML
    Label message;

    @FXML
    Pane lightsBox;

    @Inject
    Tower tower;

    @Inject
    private String prefix;

    @Inject
    private String happyEnding;

    @Inject
    private LocalDate date;

    private String theEnd;

    private static Random random = new Random();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        theEnd = rb.getString("theEnd");
        String dateLabel = rb.getString("date");
        message.setText(dateLabel + ": " + date + theEnd);

        System.out.println("Initialized by JavaFX.");

        root.setOnKeyPressed(keyEvent -> {
            if (keyEvent.isControlDown()) {
                switch (keyEvent.getCode()){
                    case NUMPAD1, DIGIT1: {
                        createLights(10);
                        break;
                    }
                    case NUMPAD2, DIGIT2: {
                        createLights(20);
                        break;
                    }
                    case NUMPAD3, DIGIT3: {
                        createLights(30);
                        break;
                    }
                    case P: {
                        lightsBox.getChildren().clear();
                        break;
                    }
                }
            }
        });
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Dashboard constructed.");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("Dashboard about to be destroyed.");
    }

    public void createLights() {
        createLights(255);
    }
    public void createLights(int lightCount) {
        for (int i = 0; i < lightCount; i++) {
            final int red = random.nextInt(255);
            LightView view = new LightView((f) -> red);
            view.getViewAsync(lightsBox.getChildren()::add);
        }
    }

    public void launch() {
        TablesView tablesView = new TablesView();
        showModalView(tablesView);
    }
}
