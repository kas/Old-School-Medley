package com.kencussionproductions.oldschoolmedley.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.kencussionproductions.oldschoolmedley.OldSchoolMedley;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

		config.useAccelerometer = true;
		config.useCompass = false;
		config.useGLSurfaceView20API18 = true;

		initialize(new OldSchoolMedley(), config);
	}
}
