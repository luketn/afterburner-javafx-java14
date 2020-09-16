package com.mycodefu.dashboard.light;

import java.util.function.Function;

import com.mycodefu.afterburner.views.FXMLView;
import javafx.scene.Parent;

public class LightView extends FXMLView {

    public LightView(Function<String, Object> injectionContext) {
        super(injectionContext);
    }

    @Override
    public Parent getView() {
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException ex) {
        }
        return super.getView(); //To change body of generated methods, choose Tools | Templates.
    }

}
