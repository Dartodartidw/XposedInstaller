package de.robv.android.xposed.installer;

import android.os.Bundle;
import de.robv.android.xposed.installer.util.NavUtil;
import de.robv.android.xposed.installer.util.ThemeUtil;

public abstract class XposedBaseActivity extends Activity {
	public boolean leftActivityWithSlideAnim = false;
	public int mTheme = -1;

	@Override
	protected void onCreate(Bundle savedInstanceBundle) {
		ThemeUtil.setTheme(this);
		super.onCreate(savedInstanceBundle);
	}

	@Override
	protected void onResume() {
		super.onResume();
		ThemeUtil.reloadTheme(this);

		if (leftActivityWithSlideAnim)
			NavUtil.setTransitionSlideLeave(this);
		leftActivityWithSlideAnim = false;
	}

	public void setLeftWithSlideAnim(boolean newValue) {
		this.leftActivityWithSlideAnim = newValue;
	}
}
