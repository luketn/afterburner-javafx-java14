package com.mycodefu.dashboard;

import com.mycodefu.dashboard.light.LightView;
import com.mycodefu.dashboard.tables.TablesView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static com.mycodefu.App.showModalView;

public class DashboardPresenter implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        theEnd = rb.getString("theEnd");
        String dateLabel = rb.getString("date");
        message.setText(dateLabel + ": " + date + theEnd);

        System.out.println("Initialized by JavaFX.");
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
        for (int i = 0; i < 255; i++) {
            final int red = i;
            LightView view = new LightView((f) -> red);
            view.getViewAsync(lightsBox.getChildren()::add);
        }
    }

    public void launch() {
        TablesView tablesView = new TablesView();
        showModalView(tablesView);
    }
}
