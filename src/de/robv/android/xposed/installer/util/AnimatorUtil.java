package de.robv.android.xposed.installer.util;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.support.v4.app.Fragment;
import de.robv.android.xposed.installer.R;

public final class AnimatorUtil {
	private AnimatorUtil() {}

	public static Animator createSlideAnimation(Fragment fragment, int anim) {
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

	public static Animator createSlideAnimation(Fragment fragment, boolean left, boolean in) {
		int parentWidth = fragment.getActivity().findViewById(R.id.action_bar_activity_content).getWidth();
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
		
		if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.GINGERBREAD_MR1) {
			return null;
		}
		ObjectAnimator animator = ObjectAnimator.ofFloat(fragment, "x", from, to);
		animator.setDuration(fragment.getResources().getInteger(android.R.integer.config_mediumAnimTime));
		return animator;
	}
}
