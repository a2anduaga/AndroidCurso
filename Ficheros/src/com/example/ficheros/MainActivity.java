package com.example.ficheros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{

	private Button acep, visu;
	private EditText et;
	private String linea, todo="";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		acep=(Button)findViewById(R.id.aceptar);
		visu=(Button)findViewById(R.id.visualizar);
		et=(EditText)findViewById(R.id.et);
		acep.setOnClickListener(this);
		visu.setOnClickListener(this);
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
		
		if (v.getId()==R.id.aceptar)
		{
			FileOutputStream fichero;
			try {
				fichero = openFileOutput("fichero.txt", Context.MODE_PRIVATE);
				DataOutputStream dos = new DataOutputStream(fichero);
				dos.writeBytes(et.getText().toString());
				et.setText("");
				dos.close();
				fichero.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if (v.getId()==R.id.visualizar)
		{
			try {
				FileInputStream fi = openFileInput("fichero.txt");
				DataInputStream entrada = new DataInputStream(fi);
				
				while ((linea=entrada.readLine())!=null) {
					todo=todo+linea+"\r\n";
				}
			et.setText(todo);
			entrada.close();
			fi.close();
			todo="";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
