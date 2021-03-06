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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class Borrar extends Activity implements OnClickListener{
	
	private Bbdd mibd;
	private Button todos, borrar, volver;
	private ListView lista = null;
	private ArrayList<String[]> entradas = new ArrayList<String[]>();
	private ArrayList<Lista_entrada> datos = new ArrayList<Lista_entrada>();
	private Intent i;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_borrar);
		
		volver=(Button)findViewById(R.id.vuelta);
		todos=(Button)findViewById(R.id.selectAll);
		borrar=(Button)findViewById(R.id.aceptarBorrar);
		volver.setOnClickListener(this);
		todos.setOnClickListener(this);
		borrar.setOnClickListener(this);
		i=getIntent();
		mibd = new Bbdd(this, "Personas", null, 1);
		entradas=mibd.selectAll();
		Iterator<String[]> it = entradas.iterator();	
		// Por cada row de la tabla, a�ade objeto de tipo "Lista_entrada" al arrayList "datos"
		while(it.hasNext())
		{	
			String[] obj = it.next();
			datos.add(new Lista_entrada(R.drawable.ic_launcher, obj[1], obj[2], obj[0]));			
		}
		lista = (ListView)findViewById(R.id.listView);
		adaptador();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.borrar, menu);
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
	public void onClick(View v) {

		if (v.getId()==R.id.vuelta)
		{
			setResult(2, i);
			finish();
		}
		if (v.getId()==R.id.aceptarBorrar)
		{
			int size = lista.getChildCount();
			for (int i=0; i<size;i++)
			{
				LinearLayout layout = (LinearLayout) lista.getChildAt(i);
				CheckBox check = (CheckBox) layout.getChildAt(0);
				if (check.isChecked())
				{
					LinearLayout layout2 = (LinearLayout) layout.getChildAt(2);
					TextView tv = (TextView) layout2.getChildAt(2);
					mibd.borrarPersona(Integer.parseInt(tv.getText().toString()));
				}
			}
			entradas=mibd.selectAll();
			datos.clear();
			Iterator<String[]> it = entradas.iterator();	
			// Por cada row de la tabla, a�ade objeto de tipo "Lista_entrada" al arrayList "datos"
			while(it.hasNext())
			{	
				String[] obj = it.next();
				datos.add(new Lista_entrada(R.drawable.ic_launcher, obj[1], obj[2], obj[0]));			
			}
			((Lista_adaptador)lista.getAdapter()).notifyDataSetChanged();
			// desmarcar todos los checkbox 
			for (int i=0; i<size;i++)
			{
				LinearLayout layout = (LinearLayout) lista.getChildAt(i);
				CheckBox check = (CheckBox) layout.getChildAt(0);
				check.setChecked(false);
			}
		}
		if (v.getId()==R.id.selectAll)
		{
			// tambien podria hacerlo con la variable de tipo boton "todos"
			// if (todos.getText().equals("Nada"))
			// y borrar la linea :' Button b = (Button)v; '
			Button b = (Button)v;
			int size = lista.getChildCount();
			if (b.getText().equals("Nada"))
			{
				for (int i=0; i<size;i++)
				{
					LinearLayout layout = (LinearLayout) lista.getChildAt(i);
					CheckBox check = (CheckBox) layout.getChildAt(0);
					check.setChecked(false);
					b.setText("Todos");
				}
			}
			else{
				for (int i=0; i<size;i++)
				{
					LinearLayout layout = (LinearLayout) lista.getChildAt(i);
					CheckBox check = (CheckBox) layout.getChildAt(0);
					check.setChecked(true);
					b.setText("Nada");
				}
			}
		}
		
	}
	private void adaptador() {
		// Enlazar adaptador a la ListView lista
		lista.setAdapter(new Lista_adaptador(this, R.layout.entrada, datos)
		{
			// Por cada entrada (item) de la lista
			public void onEntrada(Object entrada, View view)
			{
				if (entrada!=null)
				{
					TextView nombre = (TextView)view.findViewById(R.id.tvNombreList);
					if (nombre!=null)
					{
						nombre.setText(((Lista_entrada)entrada).getNombre());
					}
					TextView apellido = (TextView)view.findViewById(R.id.tvApellidoList);
					if (apellido!=null)
					{
						apellido.setText(((Lista_entrada)entrada).getApellido());
					}
					TextView id = (TextView)view.findViewById(R.id.tvId);
					if (id!=null)
					{
						id.setText(((Lista_entrada)entrada).getId());
					}
					ImageView imagen = (ImageView)view.findViewById(R.id.imagen);
					if (imagen!=null)
					{
						imagen.setImageResource(((Lista_entrada)entrada).getIdImagen());
					}
				}
			}
		});
		
	}
}
