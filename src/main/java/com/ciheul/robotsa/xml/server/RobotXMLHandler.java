package com.ciheul.robotsa.xml.server;

import java.io.File;

import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopKeyboard;
import org.sikuli.api.robot.desktop.DesktopMouse;

public class RobotXMLHandler {

	static Keyboard keyboard = new DesktopKeyboard();
	static Mouse mouse = new DesktopMouse();

	public int clickSpotlight(int a, int b) {
		ScreenRegion s = new DesktopScreenRegion();
		Target target = new ImageTarget(new File("/Users/winnuayi/Desktop/spotlight.png"));
		ScreenRegion r = s.find(target);
		
		mouse.click(r.getCenter());
		keyboard.type("sikuli");
		
		return 0;
	}

}
