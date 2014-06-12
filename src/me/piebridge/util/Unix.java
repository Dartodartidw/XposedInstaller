package me.piebridge.util;

public class Unix {

	static {
		try {
			System.loadLibrary("unix");
		} catch (UnsatisfiedLinkError e) {
			throw new UnsatisfiedLinkError();
		}
	}

	public static native int getppid();

}
