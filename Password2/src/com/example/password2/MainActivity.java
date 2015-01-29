package com.example.password2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	
	private LinearLayout ll;
	private  Button bt;
	private EditText et;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ll = (LinearLayout)findViewById(R.id.ll);
		et = (EditText)findViewById(R.id.editText1);
		bt = (Button)findViewById(R.id.boton);
		bt.setOnClickListener(this);
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

	@Override
	public void onClick(View v) {
		
		Intent i = new Intent(this, Comprobacion.class);
		i.putExtra("pass", et.getText().toString());
		startActivityForResult(i,1);
	}
	protected void onActivityResult(int id, int result, Intent data)
	{
		if (result==RESULT_OK)
		{
			TextView tv = new TextView(this);
			tv.setText("Correcto");
			ll.addView(tv);
			
		}
	}
}
