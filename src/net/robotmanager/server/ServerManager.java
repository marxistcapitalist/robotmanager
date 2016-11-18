package net.robotmanager.server;

import org.eclipse.jetty.server.Server;

public class ServerManager {

    private Server server;

    public void startServer() {
        if(server == null) {
            System.out.println("Hold up, I don't have a server! Let me get one for you...");
            this.server = new Server(8080);
            try {
                this.server.start();
                server.dumpStdErr();
            }
            catch(Exception e) {
                e.printStackTrace();
                System.out.println("Oh no, something went wrong!");
            }
        }
        System.out.println("BEEP started!");
    }

}
