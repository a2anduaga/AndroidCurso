package com.example.guardarpersonas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Campos extends Activity implements OnClickListener, OnFocusChangeListener{
	
	private Button btguardar, btCancel;
	private EditText etnombre, etapell, ettel, etobs;
	private int index;
	private String n, a, t, o, g;
	private String nuevo, seleccionSpinner;
	private Spinner spinner;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_campos);
		btguardar=(Button)findViewById(R.id.guardarCampos);
		btCancel=(Button)findViewById(R.id.cancelCampos);
		btguardar.setOnClickListener(this);
		btCancel.setOnClickListener(this);
		spinner=(Spinner) findViewById(R.id.spinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.grupoSpinner, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		
		etnombre=(EditText)findViewById(R.id.nombreCampos);
		etnombre.setOnFocusChangeListener(this);
		etapell=(EditText)findViewById(R.id.apellidoCampos);
		etapell.setOnFocusChangeListener(this);
		ettel=(EditText)findViewById(R.id.telCampos);
		ettel.setOnFocusChangeListener(this);
		etobs=(EditText)findViewById(R.id.obsCampos);
		etobs.setOnFocusChangeListener(this);
		n=getIntent().getExtras().getString("nombre");
		a=getIntent().getExtras().getString("apellido");
		t=getIntent().getExtras().getString("tel");
		o=getIntent().getExtras().getString("obs");
		g=getIntent().getExtras().getString("grupo");
		nuevo=getIntent().getExtras().getString("new");
		etnombre.setText(n);
		etapell.setText(a);
		ettel.setText(t);
		etobs.setText(o);
		for (int i=0;i<spinner.getCount();i++){
			if (spinner.getItemAtPosition(i).toString().equals(g)){
			     index = i;
			     break;
			}
		}
		spinner.setSelection(index);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.campos, menu);
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
		
		if (v.getId()==R.id.guardarCampos)
		{
			if (relleno())
			{
				Intent i = getIntent();
				seleccionSpinner=spinner.getSelectedItem().toString();
				i.putExtra("nombre", etnombre.getText().toString());
				i.putExtra("apellido", etapell.getText().toString());
				i.putExtra("telefono", ettel.getText().toString());
				i.putExtra("obs", etobs.getText().toString());
				i.putExtra("nuevo", nuevo);
				i.putExtra("grupo", seleccionSpinner);
				
				setResult(RESULT_OK, i);
				finish(); 
			}
		}
		else if (v.getId()==R.id.cancelCampos)
		{
			Intent intent = getIntent();
			setResult(RESULT_CANCELED, intent);
			finish();
		}
	}

	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		if (v.getId()==(R.id.nombreCampos))
		{
			if (hasFocus)
			{
				etnombre.setText("");
			}
			else
			{
				etnombre.setText(etnombre.getText().toString().toUpperCase());
			}
		}
		if (v.getId()==(R.id.apellidoCampos))
		{
			if (v.hasFocus())
			{
				etapell.setText("");
			}
			else
			{
				etapell.setText(etapell.getText().toString().toUpperCase());
			}
		}
		if (v.getId()==(R.id.telCampos))
		{
			if (v.hasFocus())
			{
				ettel.setText("");
			}
			else
			{
				ettel.setText(ettel.getText().toString().toUpperCase());
			}
		}
		if (v.getId()==(R.id.obsCampos))
		{
			if (v.hasFocus())
			{
				etobs.setText("");
			}
			else
			{
				etobs.setText(etobs.getText().toString().toUpperCase());
			}
		}
	}
	public boolean relleno()
	{
		if ((etnombre.getText().toString().trim().length() == 0) || (etapell.getText().toString().trim().length() == 0) || (ettel.getText().toString().trim().length() == 0) || (etobs.getText().toString().trim().length() == 0))
			return false;
		else 
			return true;
	}
}
