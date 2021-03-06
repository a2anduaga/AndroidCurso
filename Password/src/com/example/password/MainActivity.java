package com.example.password;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{
	
	private Button bt;
	private EditText et;
	private String pass = "eztokasmaubiar";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bt=(Button)findViewById(R.id.boton);
		et=(EditText)findViewById(R.id.editText1);
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
		
		Intent i = new Intent(this, MensajeActivity.class);
		
		if (et.getText().toString().equals(pass))
		{
			i.putExtra("mensaje", "Correcto");	
		}
		else
		{		
			i.putExtra("mensaje", "Error");			
		}
		
		startActivity(i);
	}
}
