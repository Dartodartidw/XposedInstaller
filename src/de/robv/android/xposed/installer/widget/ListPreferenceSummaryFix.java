package de.robv.android.xposed.installer.widget;

import android.content.Context;
import android.os.Build;
import android.preference.ListPreference;
import android.util.AttributeSet;

public class ListPreferenceSummaryFix extends ListPreference {
	public ListPreferenceSummaryFix(Context context) {
		super(context);
	}

	public ListPreferenceSummaryFix(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public void setValue(String value) {
		super.setValue(value);
		notifyChanged();
	}

	@Override
	public CharSequence getSummary() {
		if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.GINGERBREAD_MR1) {
			return String.format(String.valueOf(super.getSummary()), getEntry());
		} else {
			return super.getSummary();
		}
	}

}
