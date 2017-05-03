package wdsr.exercise3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import wdsr.exercise3.record.rest.RecordApplication;

public class Main {
	private static final Logger log = LoggerFactory.getLogger(Main.class);
	
	public static final String SERVER_HOST = "localhost";
	public static final int SERVER_PORT = 8080;
	
	public static void main(String[] args) {
		MyServer server = new MyServer(SERVER_HOST, SERVER_PORT);
		server.deploy(RecordApplication.class, "Records inventory", "/", "/");
        log.info("Server listening on http://{}:{}", SERVER_HOST, SERVER_PORT);		
	}
}
