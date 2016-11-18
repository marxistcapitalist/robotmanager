package net.robotmanager;

import net.robotmanager.server.ServerManager;

public class Manager {

    private ServerManager serverManager;

    public Manager() {
        this.serverManager = new ServerManager();
    }

    public ServerManager getServerManager() {
        return this.serverManager;
    }

}
