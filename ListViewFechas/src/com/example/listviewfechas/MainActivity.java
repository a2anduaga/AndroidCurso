package com.example.listviewfechas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends ListActivity implements OnClickListener{
	
	private Button bt;
	private Spinner dia, mes, año;
	private EditText et;
	private String texto="";
	private ArrayList<String> arrayDia = new ArrayList<String>();
	private ArrayList<String> arrayAño = new ArrayList<String>();
	private List<String> listaArray = null;
	private ArrayAdapter<String> adaptador = null;
	private Bbdd miBd;
	private ArrayList<String[]> entradas = new ArrayList<String[]>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listaArray = new ArrayList<String>();
		adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaArray);
		setListAdapter(adaptador);
		
		bt=(Button)findViewById(R.id.aceptar);
		bt.setOnClickListener(this);
		et=(EditText)findViewById(R.id.et);
		dia=(Spinner) findViewById(R.id.spinner1);
		for (int i=1; i<=31; i++)
		{
			arrayDia.add(String.valueOf(i));
		}
		for (int j=2000;j<=2100;j++)
		{
			arrayAño.add(String.valueOf(j));
		}
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
		miBd = new Bbdd(this, "Entradas", null, 1);
		entradas=miBd.selectAll();
		Iterator<String[]> it = entradas.iterator();	
		while(it.hasNext())
		{	
			String[] obj = it.next();
			listaArray.add(obj[1]+"-"+obj[2]+"-"+obj[3]+"\r\n"+obj[4]);			
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
		
		if (v.getId()==R.id.aceptar)
		{
			texto=dia.getSelectedItem().toString()+"-"+mes.getSelectedItem().toString()+"-"+año.getSelectedItem().toString()+"\r\n"+et.getText().toString();
			miBd.insertarEntrada(dia.getSelectedItem().toString(), mes.getSelectedItem().toString(), año.getSelectedItem().toString(), et.getText().toString());
			listaArray.add(texto);
			adaptador.notifyDataSetChanged();
			et.setText("");
		}
		
	}
	protected void onListItemClick(ListView l, View v,final int position, long id)
	{
		System.out.println(position);
//		listaArray.remove(position);
//		adaptador.notifyDataSetChanged();

	}
}
