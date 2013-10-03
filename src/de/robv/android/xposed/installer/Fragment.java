package de.robv.android.xposed.installer;

import android.animation.Animator;

public class Fragment extends android.support.v4.app.Fragment {

	/**
	 * Called when a fragment loads an animation.
	 */
	public Animator onCreateAnimator(int transit, boolean enter, int nextAnim) {
		return null;
	}
}