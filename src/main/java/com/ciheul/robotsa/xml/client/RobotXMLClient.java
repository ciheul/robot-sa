package com.ciheul.robotsa.xml.client;

import java.net.URL;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import com.ciheul.robotsa.Context;

public class RobotXMLClient {	
	
	public static void main(String[] args) throws Exception {
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		config.setServerURL(new URL(Context.ROBOT_XML_SERVER_URL));
		
		XmlRpcClient client = new XmlRpcClient();
		client.setConfig(config);
		
		Object result = client.execute("clickSpotlight", new Object[]{4, 5});
		System.out.println(((Integer) result).intValue());
	}
}
