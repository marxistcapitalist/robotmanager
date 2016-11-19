package net.robotmanager.server;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;

public class ServerManager {

    private Server server;

    public void startServer() {
        if(server == null) {
            this.server = new Server();

            // HTTP Server Connector
            ServerConnector http = new ServerConnector(server);
            http.setHost("localhost");
            http.setPort(80);
            http.setIdleTimeout(30000);

            server.addConnector(http);
            server.setHandler(this.generateHandlers());

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

    private HandlerList generateHandlers() {
        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] { new DefaultHandler() });
        return handlers;
    }

}
