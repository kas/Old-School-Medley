package com.kencussionproductions.oldschoolmedley.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.kencussionproductions.oldschoolmedley.OldSchoolMedley;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = "Old School Medley";
		config.useGL30 = true;
		config.width = OldSchoolMedley.WIDTH;
		config.height = OldSchoolMedley.HEIGHT;
		config.resizable = false;
		
		new LwjglApplication(new OldSchoolMedley(), config);
	}
}
