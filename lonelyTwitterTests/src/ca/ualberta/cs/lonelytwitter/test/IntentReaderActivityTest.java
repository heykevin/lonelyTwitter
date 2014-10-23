package ca.ualberta.cs.lonelytwitter.test;

//import android.annotation.SuppressLint;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.webkit.WebView.FindListener;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;

//@SuppressLint("NewApi") 
public class IntentReaderActivityTest extends
		ActivityInstrumentationTestCase2<IntentReaderActivity>
{

	public IntentReaderActivityTest()
	{

		super(IntentReaderActivity.class);
	}

	// TODO: Add your code here:
	public void testSendText()
	{

		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY,
				"testing send text");

		setActivityIntent(intent);
		IntentReaderActivity ira = getActivity();

		assertEquals(ira.getText(), "testing send text");
	}

	public void testDisplayText()
	{

		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY,
				"testing display text");
		setActivityIntent(intent);

		IntentReaderActivity ira = getActivity();
		TextView tv = (TextView) ira
				.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		assertEquals(tv.getText(), "testing display text");
	}

	public void testDoubleText()
	{

		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "Bye");
		intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY,
				IntentReaderActivity.DOUBLE);
		
		setActivityIntent(intent);
		IntentReaderActivity ira = getActivity();
		
		assertEquals(ira.getText(), "ByeBye");
	}
}
