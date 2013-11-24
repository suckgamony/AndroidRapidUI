package rapidui;

import rapidui.test.unittest.R;
import android.app.Instrumentation;
import android.content.Context;
import android.test.SingleLaunchActivityTestCase;
import android.test.UiThreadTest;
import android.view.KeyEvent;
import android.view.View;

public class BasicTest extends SingleLaunchActivityTestCase<TestActivity> {
	private TestActivity activity;
	
	public BasicTest() {
		super("rapidui.test.unittest", TestActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		activity = getActivity();
	}
	
	public void testCamelCaseToUnderlinedLowerCase() {
		assertEquals("test", ResourceUtils.toLowerUnderscored("test"));
		assertEquals("camel_case", ResourceUtils.toLowerUnderscored("camelCase"));
		assertEquals("pascal_case", ResourceUtils.toLowerUnderscored("PascalCase"));
		assertEquals("underlined_camel_case", ResourceUtils.toLowerUnderscored("Underlined_Camel_Case"));
		assertEquals("xml_document", ResourceUtils.toLowerUnderscored("XMLDocument"));
		assertEquals("simple_xml_parser", ResourceUtils.toLowerUnderscored("SimpleXMLParser"));
		assertEquals("ab123", ResourceUtils.toLowerUnderscored("AB123"));
		assertEquals("ab123", ResourceUtils.toLowerUnderscored("ab123"));
		assertEquals("a_b123", ResourceUtils.toLowerUnderscored("aB123"));
		assertEquals("html4_document", ResourceUtils.toLowerUnderscored("HTML4Document"));
	}

	public void testMenu() {
		activity.settingsMenuClicked = false;
		
		final Instrumentation inst = getInstrumentation();
		
		inst.sendKeyDownUpSync(KeyEvent.KEYCODE_MENU);
		inst.invokeMenuActionSync(activity, R.id.action_settings, 0);
		
		assertEquals(true, activity.settingsMenuClicked);
	}
	
	public void testFindViewsById() {
		final View textHelloWorld = activity.findViewById(R.id.text_hello_world);
		assertSame(textHelloWorld, activity.textHelloWorld);
		assertSame(textHelloWorld, activity.mTextHelloWorld);
		assertSame(textHelloWorld, activity.helloWorld);
		
		final View button1 = activity.findViewById(R.id.button1);
		assertSame(button1, activity.button1);
	}
	
	public void testSystemServices() {
		assertSame(activity.getSystemService(Context.ALARM_SERVICE), activity.alarmManager);
		assertSame(activity.getSystemService(Context.AUDIO_SERVICE), activity.audioManager);
		assertSame(activity.getSystemService(Context.LOCATION_SERVICE), activity.locationManager);
	}
	
	@UiThreadTest
	public void testEventHandlers() {
		activity.button1Clicked = false;
		assertTrue(activity.button1.performClick());
		assertTrue(activity.button1Clicked);
		
		activity.button2Clicked = false;
		assertTrue(activity.button2.performClick());
		assertTrue(activity.button2Clicked);
	}
}
