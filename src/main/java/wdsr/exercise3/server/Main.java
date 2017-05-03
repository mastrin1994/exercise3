package wdsr.exercise3.server;

import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.undertow.Undertow;

public class Main {
	private static final Logger log = LoggerFactory.getLogger(Main.class);
	
    public static final String SERVER_HOST = "localhost";
    public static final int SERVER_PORT = 8080;

    public static void main( String[] args ) {
        final UndertowJaxrsServer server = new UndertowJaxrsServer().start( Undertow.builder().addHttpListener( SERVER_PORT, SERVER_HOST ) );
        server.deploy( new ServerApplication() );
        log.info("Server listening on http://{}:{}", SERVER_HOST, SERVER_PORT);
        
        Runtime.getRuntime().addShutdownHook( new Thread() {
            public void run() {
                server.stop();
            }
        } );
    }
}
