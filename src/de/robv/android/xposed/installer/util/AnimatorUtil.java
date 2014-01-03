package de.robv.android.xposed.installer.util;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.support.v4.app.Fragment;
import de.robv.android.xposed.installer.R;

public final class AnimatorUtil {
	private AnimatorUtil() {}

	public static Animation createSlideAnimation(Fragment fragment, int anim) {
		switch (anim) {
			case R.anim.slide_in_left:
				return createSlideAnimation(fragment, true, true);
			case R.anim.slide_in_right:
				return createSlideAnimation(fragment, false, true);
			case R.anim.slide_out_left:
				return createSlideAnimation(fragment, true, false);
			case R.anim.slide_out_right:
				return createSlideAnimation(fragment, false, false);
		}
		return null;
	}

	public static Animation createSlideAnimation(Fragment fragment, boolean left, boolean in) {
		int parentWidth = fragment.getActivity().findViewById(android.R.id.content).getWidth();
		if (left)
			parentWidth = -parentWidth;
		
		int from, to;
		if (in) {
			from = parentWidth;
			to = 0;
		} else {
			from = 0;
			to = parentWidth;
		}
		
		Animation animator = new TranslateAnimation(from, to, 0, 0);
		animator.setDuration(fragment.getResources().getInteger(android.R.integer.config_mediumAnimTime));
		return animator;
	}
}
