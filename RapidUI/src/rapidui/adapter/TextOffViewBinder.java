package rapidui.adapter;

import java.lang.annotation.Annotation;

import rapidui.ValueCallback;
import rapidui.annotation.adapter.BindToTextOff;
import android.os.Build;
import android.view.View;
import android.widget.Switch;
import android.widget.ToggleButton;

public class TextOffViewBinder extends ViewBinder {
	@Override
	public void bindValue(View v, Object value) {
		if (v instanceof ToggleButton) {
			((ToggleButton) v).setTextOff((CharSequence) value);
		} else if (Build.VERSION.SDK_INT >= 14 && v instanceof Switch) {
			((Switch) v).setTextOff((CharSequence) value);
		}
	}

	@Override
	public int[] getIds(Annotation annotation) {
		return ((BindToTextOff) annotation).value();
	}

	@Override
	public Object bindListener(View v, final ValueCallback<Object> listener) {
		return null;
	}

	@Override
	public void unbindListener(View v, Object boundResult) {
	}
}
