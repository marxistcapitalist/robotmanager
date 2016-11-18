package net.robotmanager;

import javafx.fxml.FXML;

/**
 * Created by Ethan on 11/14/2016.
 */
public class FXController {

    private Manager manager;

    @FXML
    protected void actionServerStart() {
        System.out.println("RRRRR starting up...");
        manager.getServerManager().startServer();
    }

    @FXML
    protected void actionServerStop() {
        System.out.println("RERRrrr shutting down...");
        System.out.println("BEEP stopped!");
    }

    @FXML
    protected void exit() {
        System.exit(0);
    }

    public void passManager(Manager m) {
        this.manager = m;
    }

}
