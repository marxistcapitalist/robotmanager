package net.robotmanager.server;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;

import java.net.BindException;

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
        }
        try {
            this.server.start();
            server.dumpStdErr();
        }
        catch(BindException e) {
            System.out.println("Oh no, the server couldn't bind!");
            System.out.println("Check for other applications that may be using port 80, close them, and try again.");
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Oh no, something went wrong!");
        }
        System.out.println("BEEP started!");
    }

    public void stopServer() {
        try {
            this.server.stop();
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Oh no, something went wrong!");
        }

    }

    private HandlerList generateHandlers() {
        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] { new DefaultHandler() });
        return handlers;
    }

}
