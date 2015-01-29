package com.example.guardarpersonas;

import java.util.ArrayList;
import java.util.Iterator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class Buscar extends Activity implements OnClickListener{
	
	private Button btVolver, btAceptar, btBuscar;
	private EditText etNombre, etApel, etTel, etObs;
	private RadioButton rN, rA, rT, rO, rGr;
	private RadioGroup rg;
	private LinearLayout ll;
	private Spinner spinner;
	private Intent i;
	private int index;
	private String selec;
	ArrayList<Persona> array;
	ArrayList<Persona> arrayPersonasBuscar = new ArrayList<Persona>();
	ArrayList<Button> arrayBotonesBuscar = new ArrayList<Button>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buscar);
		spinner=(Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.grupoSpinner, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		ll=(LinearLayout)findViewById(R.id.botonesLL);
		btVolver=(Button)findViewById(R.id.volver);
		btVolver.setOnClickListener(this);
		btAceptar=(Button)findViewById(R.id.aceptar);
		btAceptar.setOnClickListener(this);
		btBuscar=(Button)findViewById(R.id.buscar);
		btBuscar.setOnClickListener(this);
		etNombre=(EditText)findViewById(R.id.buscarNombre);
		etApel=(EditText)findViewById(R.id.buscarApellido);
		etTel=(EditText)findViewById(R.id.buscarTel);
		etObs=(EditText)findViewById(R.id.buscarObs);
		rg = (RadioGroup) findViewById(R.id.radioGr);
		rg.setOnClickListener(this);
		rN = (RadioButton)findViewById(R.id.nombreRadio);
		rN.setOnClickListener(this);
		rA = (RadioButton)findViewById(R.id.apellRadio);
		rA.setOnClickListener(this);
		rT = (RadioButton)findViewById(R.id.telRadio);
		rT.setOnClickListener(this);
		rO = (RadioButton)findViewById(R.id.obsRadio);
		rO.setOnClickListener(this);
		rGr = (RadioButton)findViewById(R.id.grRadio);
		rGr.setOnClickListener(this);
		i = getIntent();
		array=(ArrayList<Persona>) i.getExtras().getSerializable("array");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.buscar, menu);
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
		
		int checkedRadioButtonId = rg.getCheckedRadioButtonId();
		
		if(v.getId()==R.id.volver)
		{
			setResult(RESULT_CANCELED, i);
			finish();
		}
		else if (v.getId()==R.id.aceptar)
		{
			Intent intent = getIntent();
			
			intent.putExtra("n", etNombre.getText().toString());
			intent.putExtra("a", etApel.getText().toString());
			intent.putExtra("t", etTel.getText().toString());
			intent.putExtra("o", etObs.getText().toString());
			intent.putExtra("g", spinner.getSelectedItem().toString());
			
			setResult(1, intent);
			finish(); 
		}
		else if (v.getId()==R.id.buscar)
		{
			btAceptar.setEnabled(false);
			arrayPersonasBuscar.clear();
			arrayBotonesBuscar.clear();
			ll.removeAllViews();
			selec=spinner.getSelectedItem().toString();
			switch(checkedRadioButtonId)
			{
				case R.id.nombreRadio:
					if (rN.isChecked())
					{
						buscarPersonas(1, etNombre.getText().toString());
					}
				break;
				case R.id.apellRadio:
					if (rA.isChecked())
					{
						buscarPersonas(2, etApel.getText().toString());
					}
				break;
				case R.id.telRadio:
					if (rT.isChecked())
					{
						buscarPersonas(3, etTel.getText().toString());
					}
				break;
				case R.id.obsRadio:
					if (rO.isChecked())
					{
						buscarPersonas(4, etObs.getText().toString());
					}
				break;
				case R.id.grRadio:
					if (rGr.isChecked())
					{
						selec=spinner.getSelectedItem().toString();
						buscarPersonas(5, selec);
					}
				break;
				default: break;
			}
		}
	}

	private void buscarPersonas(int op, String cadena) {
		switch(op)
		{
			case 1: Iterator<Persona> it = array.iterator();	
					while(it.hasNext())
					{	
						Persona obj = it.next();					
						if (obj.getNombre().contains(etNombre.getText().toString().toUpperCase()))
						{
							crearBoton(obj);
						}			    
					}
			break;
			case 2: Iterator<Persona> it2 = array.iterator();
					while(it2.hasNext())
					{	
						Persona obj = it2.next();
						if (obj.getApellido().contains(etApel.getText().toString().toUpperCase()))
						{
							crearBoton(obj);
						}	    
			}
			break;
			case 3: Iterator<Persona> it3 = array.iterator();
					while(it3.hasNext())
					{	
						Persona obj = it3.next();
						if (obj.getTel().contains(etTel.getText().toString().toUpperCase()))
						{
							crearBoton(obj);
						}
			}
			break;
			case 4: Iterator<Persona> it4 = array.iterator();
					while(it4.hasNext())
					{	
						Persona obj = it4.next();
						if (obj.getObs().contains(etObs.getText().toString().toUpperCase()))
						{
							crearBoton(obj);
						}
			}
			break;
			case 5: Iterator<Persona> it5 = array.iterator();
			while(it5.hasNext())
			{	
				Persona obj = it5.next();
				if (obj.getGrupo().contains(spinner.getSelectedItem().toString()))
				{
					crearBoton(obj);
				}
			}
			break;
 		}
		
	}

	private void crearBoton(Persona persona) {
		Button bt = new Button(this);
		arrayBotonesBuscar.add(bt);
		arrayPersonasBuscar.add(persona);
		bt.setText(String.valueOf(arrayBotonesBuscar.size()));
		bt.setId(arrayBotonesBuscar.size()-1);
		bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	
            	etNombre.setText(arrayPersonasBuscar.get(view.getId()).getNombre());
            	etApel.setText(arrayPersonasBuscar.get(view.getId()).getApellido());
            	etTel.setText(arrayPersonasBuscar.get(view.getId()).getTel());
            	etObs.setText(arrayPersonasBuscar.get(view.getId()).getObs());
            	for (int i=0;i<spinner.getCount();i++){
        			if (spinner.getItemAtPosition(i).toString().equals(arrayPersonasBuscar.get(view.getId()).getGrupo())){
        			     index = i;
        			     break;
        			}
        		}
        		spinner.setSelection(index);
            	btAceptar.setEnabled(true);
            }
        });
		ll.addView(bt);
	}
	
}
