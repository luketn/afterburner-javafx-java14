package com.mycodefu.dashboard;

import com.mycodefu.dashboard.light.LightView;
import com.mycodefu.dashboard.tables.TablesView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

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

    private String theVeryEnd;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //fetched from dashboard.properties
        this.theVeryEnd = rb.getString("theEnd");
    }

    public void createLights() {
        for (int i = 0; i < 255; i++) {
            final int red = i;
            LightView view = new LightView((f) -> red);
            view.getViewAsync(lightsBox.getChildren()::add);
        }
    }

    public void launch() {
        message.setText("Date: " + date + " -> " + prefix + tower.readyToTakeoff() + happyEnding + theVeryEnd);

        TablesView tablesView = new TablesView();
        showModalView(tablesView);
    }
}
