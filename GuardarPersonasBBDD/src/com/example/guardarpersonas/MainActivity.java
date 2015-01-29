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
	private ArrayList<Button> arrayBotones = new ArrayList<Button>();
	private ArrayList<String[]> personas = new ArrayList<String[]>();
	private int seleccionado, index=0;
	private Bbdd miBd;
	
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
		miBd = new Bbdd(this, "Personas", null, 1);
		cargarBotones();
	}
	private void cargarBotones() {
		
		personas = miBd.selectAll();
		Iterator<String[]> it = personas.iterator();	
		while(it.hasNext())
		{	
			String[] obj = it.next();
			añadirBoton(obj);
		}
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
		

		if (v.getId()==R.id.nuevo)
		{
			Intent i = new Intent(this, Campos.class);
			i.putExtra("new", "si");
			startActivityForResult(i,1);

			
		}
		else if (v.getId()==R.id.borrar)
		{
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle(R.string.texto);
			builder.setMessage(R.string.mensaje);
			builder.setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		        	    
		        	    int indice=0;
		        	    Iterator<Button> it = arrayBotones.iterator();
			   			while(it.hasNext()){
			   				Button boton = it.next();
			   				if (boton.getId()==seleccionado)
			   				{
			   					indice = arrayBotones.indexOf(boton);
			   					break;
			   				}	   				
			   			}
			   			arrayBotones.get(indice).setVisibility(View.GONE);
	   					arrayBotones.remove(indice);
			   			miBd.borrarPersona(seleccionado);
			   			
			   			int index=0;
			   			Iterator<Button> nombreIterator = arrayBotones.iterator();
			   			while(nombreIterator.hasNext()){
			   				Button elemento = nombreIterator.next();
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
			i.putExtra("id", seleccionado);
			i.putExtra("new", "no");
			startActivityForResult(i,1);

		}
		else if (v.getId()==R.id.buscarMain)
		{
			Intent i = new Intent(this, Buscar.class);
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
				bt.setText(String.valueOf(arrayBotones.size()));
				index=data.getExtras().getInt("id");
				bt.setId(index);
				bt.setOnClickListener(new View.OnClickListener() {
		            public void onClick(View view) {
		            	seleccionado=view.getId();
		            	String name = miBd.mostrarNombre(seleccionado);
		            	nombre.setText(name);
		            	String apel = miBd.mostrarApellido(seleccionado);
		            	apellido.setText(apel);
		            	String telefono = miBd.mostrarTel(seleccionado);
		            	tel.setText(telefono);
		            	String obser = miBd.mostrarObs(seleccionado);
		            	obs.setText(obser);
		            	String grup = miBd.mostrarGrupo(seleccionado);
		            	grupo.setText(grup);
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
				seleccionado=data.getExtras().getInt("id");
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
			seleccionado = data.getExtras().getInt("id");
			nombre.setEnabled(false);
			apellido.setEnabled(false);
			tel.setEnabled(false);
			obs.setEnabled(false);
			grupo.setEnabled(false);
			btBorrar.setEnabled(true);
			btEditar.setEnabled(true);
		}
	
	}
	public void añadirBoton(final String[] persona)
	{
		Button bt = new Button(this);
		arrayBotones.add(bt);
		bt.setText(String.valueOf(arrayBotones.size()));
		index=Integer.parseInt(persona[0]);
		bt.setId(index);
		bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	seleccionado=view.getId();
            	System.out.println(seleccionado);
            	nombre.setText(miBd.mostrarNombre(seleccionado));
            	apellido.setText(miBd.mostrarApellido(seleccionado));
            	tel.setText(miBd.mostrarTel(seleccionado));
            	obs.setText(miBd.mostrarObs(seleccionado));
            	grupo.setText(miBd.mostrarGrupo(seleccionado));
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
}