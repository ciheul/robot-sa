package com.ciheul.robotsa.xml.server;

import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;

import com.ciheul.robotsa.Context;

public class RobotXMLServer {

	private static final int port = Context.ROBOT_XML_SERVER_PORT;

	public static void main(String[] args) throws Exception {
		WebServer webServer = new WebServer(port);
		XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();
		
		DefaultHandlerMapping phm = new DefaultHandlerMapping();
		phm.addHandler(RobotXMLHandler.class);
		xmlRpcServer.setHandlerMapping(phm);		
		
		XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) xmlRpcServer
				.getConfig();
		serverConfig.setEnabledForExceptions(true);
		serverConfig.setContentLengthOptional(false);
		
		System.out.println("Robot SA Server is running...");
		webServer.start();
	}
}
