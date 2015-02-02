package com.example.guardarpersonas;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import android.app.Activity;
import android.content.Context;
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
	
	private Button btVolver, btAceptar, btBuscar, btVolcar;
	private EditText etNombre, etApel, etTel, etObs;
	private RadioButton rN, rA, rT, rO, rGr;
	private RadioGroup rg;
	private LinearLayout ll;
	private Spinner spinner;
	private Intent i;
	private int index, seleccionado;
	private String selec;
	private Bbdd miBd;
	ArrayList<String[]> arrayPersonasBuscar = new ArrayList<String[]>();
	ArrayList<String[]> arrayPersonasOrdenadas = new ArrayList<String[]>();
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
		btVolcar=(Button)findViewById(R.id.volcar);
		btVolcar.setOnClickListener(this);
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
		miBd = new Bbdd(this, "Personas", null, 1);
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
			intent.putExtra("id", seleccionado);
			
			setResult(1, intent);
			finish(); 
		}
		else if (v.getId()==R.id.buscar)
		{
			btAceptar.setEnabled(false);
			arrayPersonasBuscar=null;
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
		else if (v.getId()==R.id.volcar)
		{
			Intent i = getIntent();
			switch(checkedRadioButtonId)
			{
				case R.id.nombreRadio:
					if (rN.isChecked())
					{
						arrayPersonasOrdenadas=miBd.selectAllOrdered("NOMBRE");
					}
				break;
				case R.id.apellRadio:
					if (rA.isChecked())
					{
						arrayPersonasOrdenadas=miBd.selectAllOrdered("APELLIDO");
					}
				break;
				case R.id.telRadio:
					if (rT.isChecked())
					{
						arrayPersonasOrdenadas=miBd.selectAllOrdered("TELEFONO");
					}
				break;
				case R.id.obsRadio:
					if (rO.isChecked())
					{
						arrayPersonasOrdenadas=miBd.selectAllOrdered("OBSERVACIONES");
					}
				break;
				case R.id.grRadio:
					if (rGr.isChecked())
					{
						arrayPersonasOrdenadas=miBd.selectAllOrdered("GRUPO");
					}
				break;
				default:arrayPersonasOrdenadas=miBd.selectAllOrdered("_ID"); 
						break;
			}
			try {
				FileOutputStream fichero = openFileOutput("fichero.txt", Context.MODE_PRIVATE);
				DataOutputStream dos = new DataOutputStream(fichero);
				Iterator<String[]> it = arrayPersonasOrdenadas.iterator();	
				while(it.hasNext())
				{	
					String[] obj = it.next();
					for (int j=0; j<obj.length; j++)
					{
						String cadenaOutput = new String(obj[j]);
						dos.writeBytes(cadenaOutput + "\t");
					}
					dos.writeBytes("\r\n");
				}
				dos.close();
				fichero.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Intent ver = new Intent(this, TablaContactos.class);
			startActivity(ver);
		}
	}

	private void buscarPersonas(int op, String cadena) {
		switch(op)
		{
			case 1: arrayPersonasBuscar = miBd.buscarNombre(etNombre.getText().toString());
					Iterator<String[]> it = arrayPersonasBuscar.iterator();	
					while(it.hasNext())
					{	
						String[] obj = it.next();					
						crearBoton(obj);		    
					}
			break;
			case 2: arrayPersonasBuscar = miBd.buscarApellido(etApel.getText().toString());
					Iterator<String[]> it2 = arrayPersonasBuscar.iterator();	
					while(it2.hasNext())
					{	
						String[] obj = it2.next();					
						crearBoton(obj);		    
					}
			break;
			case 3: arrayPersonasBuscar = miBd.buscarTel(etTel.getText().toString());
					Iterator<String[]> it3 = arrayPersonasBuscar.iterator();	
					while(it3.hasNext())
					{	
						String[] obj = it3.next();					
						crearBoton(obj);		    
					}
			break;
			case 4: arrayPersonasBuscar = miBd.buscarObs(etObs.getText().toString());
					Iterator<String[]> it4 = arrayPersonasBuscar.iterator();	
					while(it4.hasNext())
					{	
						String[] obj = it4.next();					
						crearBoton(obj);		    
					}
			break;
			case 5: arrayPersonasBuscar = miBd.buscarGrupo(spinner.getSelectedItem().toString());
					Iterator<String[]> it5 = arrayPersonasBuscar.iterator();	
					while(it5.hasNext())
					{	
						String[] obj = it5.next();					
						crearBoton(obj);		    
					}
			break;
 		}
		
	}

	private void crearBoton(String[] persona) {
		Button bt = new Button(this);
		arrayBotonesBuscar.add(bt);
		bt.setText(String.valueOf(arrayBotonesBuscar.size()));
		bt.setId(Integer.parseInt(persona[0]));
		final String n = persona[1];
		final String a = persona[2];
		final String t = persona[3];
		final String o = persona[4];
		final String g = persona[5];
		bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	seleccionado = view.getId();
            	etNombre.setText(n);
            	etApel.setText(a);
            	etTel.setText(t);
            	etObs.setText(o);
            	for (int i=0;i<spinner.getCount();i++){
        			if (spinner.getItemAtPosition(i).toString().equals(g)){
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
