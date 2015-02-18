package com.example.brujulabotones;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

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

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void norte(View v)
	{
		Toast toast = Toast.makeText(this, "Norte!!!!!!!", Toast.LENGTH_LONG);
		toast.show();
	}
	public void sur(View v)
	{
		Toast toast = Toast.makeText(this, "sur!!!!!!!", Toast.LENGTH_LONG);
		toast.show();
	}
	public void este(View v)
	{
		Toast toast = Toast.makeText(this, "este!!!!!!!", Toast.LENGTH_LONG);
		toast.show();
	}
	public void oeste(View v)
	{
		Toast toast = Toast.makeText(this, "o este!!!!!!!", Toast.LENGTH_LONG);
		toast.show();
	}
}
