package com.example.guardarpersonas;

import java.util.ArrayList;
import java.util.Iterator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements OnClickListener{
	
	
	private Button btNuevo, btEditar, btBorrar, btBuscar;
	private EditText nombre, apellido, tel, obs, grupo;
	private LinearLayout ll;
	private ArrayList<Persona> arrayPersonas = new ArrayList<Persona>();
	private ArrayList<Button> arrayBotones = new ArrayList<Button>();
	private int seleccionado;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btNuevo=(Button)findViewById(R.id.nuevo);
		btBorrar=(Button)findViewById(R.id.borrar);
		btEditar=(Button)findViewById(R.id.editar);
		btBuscar=(Button)findViewById(R.id.buscarMain);
		nombre=(EditText)findViewById(R.id.nombre);
		apellido=(EditText)findViewById(R.id.apellido);
		tel=(EditText)findViewById(R.id.tel);
		obs=(EditText)findViewById(R.id.obs);
		grupo=(EditText)findViewById(R.id.grupo);
		ll=(LinearLayout)findViewById(R.id.botones);
		btNuevo.setOnClickListener(this);
		btBorrar.setOnClickListener(this);
		btEditar.setOnClickListener(this);
		btBuscar.setOnClickListener(this);
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
		
//		if (v.getId()==R.id.guardar)
//		{
//			if (!editando && relleno())
//			{
//				arrayPersonas.add(new Persona(nombre.getText().toString(), apellido.getText().toString(), tel.getText().toString(), obs.getText().toString()));
//				Button bt = new Button(this);
//				arrayBotones.add(bt);
//				bt.setText(String.valueOf(arrayBotones.size()));
//				bt.setId(arrayBotones.size()-1);
//				bt.setOnClickListener(new View.OnClickListener() {
//		            public void onClick(View view) {
//		            	seleccionado=view.getId();
//		            	nombre.setText(arrayPersonas.get(view.getId()).getNombre());
//		            	apellido.setText(arrayPersonas.get(view.getId()).getApellido());
//		            	tel.setText(arrayPersonas.get(view.getId()).getTel());
//		            	obs.setText(arrayPersonas.get(view.getId()).getObs());
//		            	btBorrar.setEnabled(true);
//		            	btEditar.setEnabled(true);
//		            	btGuardar.setEnabled(false);
//		            	nombre.setEnabled(false);
//		    			apellido.setEnabled(false);
//		    			tel.setEnabled(false);
//		    			obs.setEnabled(false);
//		            }
//		        });
//				ll.addView(bt);
//				btGuardar.setEnabled(false);
//				btBorrar.setEnabled(false);
//				btEditar.setEnabled(false);
//				nombre.setText("");
//				apellido.setText("");
//				tel.setText("");
//				obs.setText("");
//				nombre.setEnabled(false);
//				apellido.setEnabled(false);
//				tel.setEnabled(false);
//				obs.setEnabled(false);
//			}
//			else
//			{
//				if (relleno())
//				{
//					arrayPersonas.get(seleccionado).setNombre(nombre.getText().toString());
//					arrayPersonas.get(seleccionado).setApellido(apellido.getText().toString());
//					arrayPersonas.get(seleccionado).setTel(tel.getText().toString());
//					arrayPersonas.get(seleccionado).setObs(obs.getText().toString());
//					editando=false;
//					btGuardar.setEnabled(false);
//					btBorrar.setEnabled(false);
//					btEditar.setEnabled(false);
//					nombre.setText("");
//					apellido.setText("");
//					tel.setText("");
//					obs.setText("");
//					nombre.setEnabled(false);
//					apellido.setEnabled(false);
//					tel.setEnabled(false);
//					obs.setEnabled(false);
//				}
//			}
//			btNuevo.setText("New");
//			
//		}
		if (v.getId()==R.id.nuevo)
		{
			Intent i = new Intent(this, Campos.class);
			i.putExtra("new", "si");
			startActivityForResult(i,1);
//			if (btNuevo.getText().toString().equals("Cancel"))
//			{
//				btNuevo.setText("New");
//				editando=false;
//				btGuardar.setEnabled(false);
//				btBorrar.setEnabled(false);
//				btEditar.setEnabled(false);
//				nombre.setText("");
//				apellido.setText("");
//				tel.setText("");
//				obs.setText("");
//				nombre.setEnabled(false);
//				apellido.setEnabled(false);
//				tel.setEnabled(false);
//				obs.setEnabled(false);
//			}
//			else
//			{
//				btNuevo.setText("Cancel");
//				nombre.setEnabled(true);
//				apellido.setEnabled(true);
//				tel.setEnabled(true);
//				obs.setEnabled(true);
//				nombre.setText("");
//				apellido.setText("");
//				tel.setText("");
//				obs.setText("");
//				btGuardar.setEnabled(true);
//				btBorrar.setEnabled(false);
//				btEditar.setEnabled(false);
//			}
			
		}
		else if (v.getId()==R.id.borrar)
		{
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle(R.string.texto);
			builder.setMessage(R.string.mensaje);
			builder.setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		        	   
		        	    arrayBotones.get(seleccionado).setVisibility(View.GONE);
			   			arrayBotones.remove(seleccionado);
			   			arrayPersonas.remove(seleccionado);
			   			int index=0;
			   			Iterator<Button> nombreIterator = arrayBotones.iterator();
			   			while(nombreIterator.hasNext()){
			   				Button elemento = nombreIterator.next();
			   				elemento.setId(index);
			   				elemento.setText(String.valueOf(index+1));
			   				index++;
			   			}
			   			
			   			btBorrar.setEnabled(false);
			   			btEditar.setEnabled(false);
			   			nombre.setText("");
			   			apellido.setText("");
			   			tel.setText("");
			   			obs.setText("");
			   			grupo.setText("");
		           }
		       });
			builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		               // No hacer nada
		           }
		       });
			
			AlertDialog dialog = builder.create();
			dialog.show();
			
		}
		else if (v.getId()==R.id.editar)
		{
			Intent i = new Intent(this, Campos.class);
			i.putExtra("nombre", nombre.getText().toString());
			i.putExtra("apellido", apellido.getText().toString());
			i.putExtra("tel", tel.getText().toString());
			i.putExtra("obs", obs.getText().toString());
			i.putExtra("grupo", grupo.getText().toString());
			i.putExtra("new", "no");
			startActivityForResult(i,1);
//			btNuevo.setText("Cancel");
//			editando=true;
//			btGuardar.setEnabled(true);
//			nombre.setEnabled(true);
//			apellido.setEnabled(true);
//			tel.setEnabled(true);
//			obs.setEnabled(true);
//			btEditar.setEnabled(false);
		}
		else if (v.getId()==R.id.buscarMain)
		{
			Intent i = new Intent(this, Buscar.class);
			i.putExtra("array", arrayPersonas);
			startActivityForResult(i,2);
		}
	}
	protected void onActivityResult(int id, int result, Intent data)
	{
		if (result==RESULT_OK)
		{
			if(data.getExtras().getString("new").equals("si"))
			{
				Button bt = new Button(this);
				arrayBotones.add(bt);
				Persona persona = new Persona(data.getExtras().getString("nombre"), data.getExtras().getString("apellido"), data.getExtras().getString("telefono"), data.getExtras().getString("obs"), data.getExtras().getString("grupo"));
				arrayPersonas.add(persona);
				bt.setText(String.valueOf(arrayBotones.size()));
				bt.setId(arrayBotones.size()-1);
				bt.setOnClickListener(new View.OnClickListener() {
		            public void onClick(View view) {
		            	seleccionado=view.getId();
		            	nombre.setText(arrayPersonas.get(view.getId()).getNombre());
		            	apellido.setText(arrayPersonas.get(view.getId()).getApellido());
		            	tel.setText(arrayPersonas.get(view.getId()).getTel());
		            	obs.setText(arrayPersonas.get(view.getId()).getObs());
		            	grupo.setText(arrayPersonas.get(view.getId()).getGrupo());
		            	btBorrar.setEnabled(true);
		            	btEditar.setEnabled(true);
		            	nombre.setEnabled(false);
		    			apellido.setEnabled(false);
		    			tel.setEnabled(false);
		    			obs.setEnabled(false);
		    			grupo.setEnabled(false);
		            }
		        });
				ll.addView(bt);
				btBorrar.setEnabled(false);
				btEditar.setEnabled(false);
				nombre.setText("");
				apellido.setText("");
				tel.setText("");
				obs.setText("");
				grupo.setText("");
				nombre.setEnabled(false);
				apellido.setEnabled(false);
				tel.setEnabled(false);
				obs.setEnabled(false);
				grupo.setEnabled(false);
			}
			else if(data.getExtras().getString("new").equals("no"))
			{
				arrayPersonas.get(seleccionado).setNombre(data.getExtras().getString("nombre"));
				arrayPersonas.get(seleccionado).setApellido(data.getExtras().getString("apellido"));
				arrayPersonas.get(seleccionado).setTel(data.getExtras().getString("telefono"));
				arrayPersonas.get(seleccionado).setObs(data.getExtras().getString("obs"));
				arrayPersonas.get(seleccionado).setGrupo(data.getExtras().getString("grupo"));
				nombre.setText(data.getExtras().getString("nombre"));
				apellido.setText(data.getExtras().getString("apellido"));
				tel.setText(data.getExtras().getString("telefono"));
				obs.setText(data.getExtras().getString("obs"));
				grupo.setText(data.getExtras().getString("grupo"));
				nombre.setEnabled(false);
				apellido.setEnabled(false);
				tel.setEnabled(false);
				obs.setEnabled(false);
				grupo.setEnabled(false);
			}
		}
		else if (result==1)
		{
			nombre.setText(data.getExtras().getString("n"));
			apellido.setText(data.getExtras().getString("a"));
			tel.setText(data.getExtras().getString("t"));
			obs.setText(data.getExtras().getString("o"));
			grupo.setText(data.getExtras().getString("g"));
			nombre.setEnabled(false);
			apellido.setEnabled(false);
			tel.setEnabled(false);
			obs.setEnabled(false);
			grupo.setEnabled(false);
			btBorrar.setEnabled(true);
			btEditar.setEnabled(true);
		}
	
	}
}