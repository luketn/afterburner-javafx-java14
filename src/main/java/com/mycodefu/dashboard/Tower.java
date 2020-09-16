package com.mycodefu.dashboard;

public class Tower {

    public void init() {
        System.out.println("Tower.init()");
    }

    public String readyToTakeoff() {
        System.out.println("Ready to take-off");
        return "ok from tower";
    }

}
