package com.example.copiasumaresta;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tv1;
	private TextView tv2;
	private Button bSumar;
	private Button bRestar;
	private Button bCopiar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.tv1 = (TextView)this.findViewById(R.id.tv1);
		this.tv2 = (TextView)this.findViewById(R.id.tv2);
		this.bSumar = (Button)this.findViewById(R.id.botonSuma);
		this.bRestar = (Button)this.findViewById(R.id.botonResta);
		this.bCopiar = (Button)this.findViewById(R.id.botonCopy);
		
		bSumar.setOnClickListener(bSumar_onClickListener);
		bRestar.setOnClickListener(bRestar_onClickListener);
		bCopiar.setOnClickListener(bCopiar_onClickListener);
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
	private Button.OnClickListener bSumar_onClickListener = new OnClickListener() {
        public void onClick(final View v) {
        	
        	String sumaString=tv1.getText().toString();
    		int sumaInt=Integer.parseInt(sumaString);
    		sumaInt++;
    		sumaString=String.valueOf(sumaInt);
    		tv1.setText(sumaString);
    		
        }
    };
    private Button.OnClickListener bRestar_onClickListener = new OnClickListener() {
        public void onClick(final View v) {
                  
        	String sumaString=tv1.getText().toString();
    		int sumaInt=Integer.parseInt(sumaString);
    		sumaInt--;
    		sumaString=String.valueOf(sumaInt);
    		tv1.setText(sumaString);
        	
        }
    };
    private Button.OnClickListener bCopiar_onClickListener = new OnClickListener() {
        public void onClick(final View v) {
             
        	String cadena = tv1.getText().toString();
    		tv1.setText("0");
    		tv2.setText(cadena);
        	
        }
    };
//	public void sumar(View view)
//	{
//		
//		String sumaString=tv1.getText().toString();
//		int sumaInt=Integer.parseInt(sumaString);
//		sumaInt++;
//		sumaString=String.valueOf(sumaInt);
//		tv1.setText(sumaString);
//	}
//	public void restar(View view)
//	{
//		
//		String sumaString=tv1.getText().toString();
//		int sumaInt=Integer.parseInt(sumaString);
//		sumaInt--;
//		sumaString=String.valueOf(sumaInt);
//		tv1.setText(sumaString);
//	}
//	public void copiar(View view)
//	{
//		
//		String cadena = tv1.getText().toString();
//		tv1.setText("0");
//		tv2.setText(cadena);
//	}
}
