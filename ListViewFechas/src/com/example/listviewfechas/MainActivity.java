package com.example.listviewfechas;

import java.util.ArrayList;
import java.util.Iterator;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	
	private Button bt;
	private Spinner dia, mes, año;
	private EditText et;
	private ArrayList<String> arrayDia = new ArrayList<String>();
	private ArrayList<String> arrayAño = new ArrayList<String>();
	private ListView lista = null;
	private Bbdd miBd;
	private Context contexto=this;
	// "entradas" es lo que recibes desde la Base de Datos
	private ArrayList<String[]> entradas = new ArrayList<String[]>();
	// Se volcaran las "entradas" en el ArrayList "datos" de tipo 'Lista_entrada'
	private ArrayList<Lista_entrada> datos = new ArrayList<Lista_entrada>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		miBd = new Bbdd(this, "Entradas", null, 1);
		entradas=miBd.selectAll();
		Iterator<String[]> it = entradas.iterator();	
		// Por cada row de la tabla, añade objeto de tipo "Lista_entrada" al arrayList "datos"
		while(it.hasNext())
		{	
			int imagen=0;
			String[] obj = it.next();
			if (Integer.parseInt(obj[3])<1950)
			{
				imagen = R.drawable.image;
			}
			else
			{
				imagen = R.drawable.image2;
			}
			datos.add(new Lista_entrada(imagen, obj[1]+"-"+obj[2]+"-"+obj[3], obj[4]));			
		}
		lista = (ListView)findViewById(R.id.listView);
		
		adaptador();
		
		bt=(Button)findViewById(R.id.aceptar);
		bt.setOnClickListener(this);
		et=(EditText)findViewById(R.id.et);
		
		for (int i=1; i<=31; i++)
		{
			arrayDia.add(String.valueOf(i));
		}
		for (int j=1900;j<=2000;j++)
		{
			arrayAño.add(String.valueOf(j));
		}
		// Los 3 spinners (dia - mes - año) y sus adaptadores (adapter1, 2 y 3)
		dia=(Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayDia);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		dia.setAdapter(adapter1);
		mes=(Spinner) findViewById(R.id.spinner2);
		ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
		        R.array.mes, android.R.layout.simple_spinner_item);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mes.setAdapter(adapter2);
		año=(Spinner) findViewById(R.id.spinner3);
		ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayAño);
		adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		año.setAdapter(adapter3);
		
		// Borrar item del ListView si clickas sobre él
		lista.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id)
			{
				// Borrar objeto del arrayList, actualizar adaptador de la lista y borrar de Base de Datos
				datos.remove(posicion);
				((Lista_adaptador)lista.getAdapter()).notifyDataSetChanged();
				miBd.borrarEntrada(posicion);
				CustomToast miToast = new CustomToast(contexto, Toast.LENGTH_LONG);
				miToast.show("Item borrado!");
			}
		});
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
			// Insertar a la Base de Datos, añadir a arrayList y actualizar adpatador de la lista
			miBd.insertarEntrada(dia.getSelectedItem().toString(), mes.getSelectedItem().toString(), año.getSelectedItem().toString(), et.getText().toString());
			int imagen=0;
			if (Integer.parseInt(año.getSelectedItem().toString())<1950)
			{
				imagen = R.drawable.image;
			}
			else
			{
				imagen = R.drawable.image2;
			}
			datos.add(new Lista_entrada(imagen, dia.getSelectedItem().toString()+"-"+mes.getSelectedItem().toString()+"-"+año.getSelectedItem().toString(), et.getText().toString()));
			((Lista_adaptador)lista.getAdapter()).notifyDataSetChanged();
			et.setText("");
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
					// Por cada item, crea los dos TextView (fecha y asunto) y la imagen
					TextView fecha = (TextView)view.findViewById(R.id.tvFecha);
					if (fecha!=null)
					{
						fecha.setText(((Lista_entrada)entrada).getFecha());
					}
					TextView asunto = (TextView)view.findViewById(R.id.tvAsunto);
					if (asunto!=null)
					{
						asunto.setText(((Lista_entrada)entrada).getAsunto());
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
