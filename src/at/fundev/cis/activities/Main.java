package at.fundev.cis.activities;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import at.fundev.cis.R;
import at.fundev.cis.R.layout;
import at.fundev.cis.R.menu;

public class Main extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
