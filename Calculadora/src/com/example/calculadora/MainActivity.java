package com.example.calculadora;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	
	private TextView tv;
	private Button bt0;
	private Button bt1;
	private Button bt2;
	private Button bt3;
	private Button bt4;
	private Button bt5;
	private Button bt6;
	private Button bt7;
	private Button bt8;
	private Button bt9;
	private Button btPunto;
	private Button btSuma;
	private Button btResta;
	private Button btMulti;
	private Button btDiv;
	private Button btIgual;
	private Button btC;
	private float num1=0;
	private char op='s';
	private boolean ultimo=false;
 	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv=(TextView)findViewById(R.id.tv);
		bt0=(Button)findViewById(R.id.boton0);
		bt1=(Button)findViewById(R.id.boton1);
		bt2=(Button)findViewById(R.id.boton2);
		bt3=(Button)findViewById(R.id.boton3);
		bt4=(Button)findViewById(R.id.boton4);
		bt5=(Button)findViewById(R.id.boton5);
		bt6=(Button)findViewById(R.id.boton6);
		bt7=(Button)findViewById(R.id.boton7);
		bt8=(Button)findViewById(R.id.boton8);
		bt9=(Button)findViewById(R.id.boton9);
		btSuma=(Button)findViewById(R.id.botonSuma);
		btResta=(Button)findViewById(R.id.botonResta);
		btDiv=(Button)findViewById(R.id.botonDiv);
		btMulti=(Button)findViewById(R.id.botonMulti);
		btIgual=(Button)findViewById(R.id.botonIgual);
		btPunto=(Button)findViewById(R.id.botonPunto);
		btC=(Button)findViewById(R.id.botonC);
		this.bt0.setOnClickListener(this);
		this.bt1.setOnClickListener(this);
		this.bt2.setOnClickListener(this);
		this.bt3.setOnClickListener(this);
		this.bt4.setOnClickListener(this);
		this.bt5.setOnClickListener(this);
		this.bt6.setOnClickListener(this);
		this.bt7.setOnClickListener(this);
		this.bt8.setOnClickListener(this);
		this.bt9.setOnClickListener(this);
		this.btSuma.setOnClickListener(this);
		this.btResta.setOnClickListener(this);
		this.btDiv.setOnClickListener(this);
		this.btMulti.setOnClickListener(this);
		this.btIgual.setOnClickListener(this);
		this.btPunto.setOnClickListener(this);
		this.btC.setOnClickListener(this);
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
		
		
		switch (v.getId()){
		
		case (R.id.boton0):
			if (String.valueOf(tv.getText()).equals("0") || !ultimo)
			{
				tv.setText("0");
			}
			else tv.setText(String.valueOf(tv.getText())+"0");
			ultimo=true;
			break;
		case (R.id.boton1):
			if (String.valueOf(tv.getText()).equals("0") || !ultimo)
			{
				tv.setText("1");
			}
			else tv.setText(String.valueOf(tv.getText())+"1");
			ultimo=true;
			break;
		case (R.id.boton2):
			if (String.valueOf(tv.getText()).equals("0") || !ultimo)
			{
				tv.setText("2");
			}
			else tv.setText(String.valueOf(tv.getText())+"2");
			ultimo=true;
			break;
		case (R.id.boton3):
			if (String.valueOf(tv.getText()).equals("0") || !ultimo)
			{
				tv.setText("3");
			}
			else tv.setText(String.valueOf(tv.getText())+"3");
			ultimo=true;
			break;
		case (R.id.boton4):
			if (String.valueOf(tv.getText()).equals("0") || !ultimo)
			{
				tv.setText("4");
			}
			else tv.setText(String.valueOf(tv.getText())+"4");
			ultimo=true;
			break;
		case (R.id.boton5):
			if (String.valueOf(tv.getText()).equals("0") || !ultimo)
			{
				tv.setText("5");
			}
			else tv.setText(String.valueOf(tv.getText())+"5");
			ultimo=true;
			break;
		case (R.id.boton6):
			if (String.valueOf(tv.getText()).equals("0") || !ultimo)
			{
				tv.setText("6");
			}
			else tv.setText(String.valueOf(tv.getText())+"6");
			ultimo=true;
			break;
		case (R.id.boton7):
			if (String.valueOf(tv.getText()).equals("0") || !ultimo)
			{
				tv.setText("7");
			}
			else tv.setText(String.valueOf(tv.getText())+"7");
			ultimo=true;
			break;
		case (R.id.boton8):
			if (String.valueOf(tv.getText()).equals("0") || !ultimo)
			{
				tv.setText("8");
			}
			else tv.setText(String.valueOf(tv.getText())+"8");
			ultimo=true;
			break;
		case (R.id.boton9):
			if (String.valueOf(tv.getText()).equals("0") || !ultimo)
			{
				tv.setText("9");
			}
			else tv.setText(String.valueOf(tv.getText())+"9");
			ultimo=true;
			break;
		case (R.id.botonSuma):
			
			if (num1==0)
			{
				num1=Float.parseFloat(String.valueOf(tv.getText()));
				op='s';
			}
			else
			{
				operacion();
				op='s';
			}
			tv.setText(String.valueOf(num1));
			ultimo=false;
			break;
		case (R.id.botonResta):
			
			if (num1==0)
			{
				num1=Float.parseFloat(String.valueOf(tv.getText()));
				op='r';
			}
			else
			{
				operacion();
				op='r';
			}
			tv.setText(String.valueOf(num1));
			ultimo=false;
			break;
			
		case (R.id.botonDiv):
			
			if (num1==0)
			{
				num1=Float.parseFloat(String.valueOf(tv.getText()));
				op='d';
			}
			else
			{
				operacion();
				op='d';
			}
			tv.setText(String.valueOf(num1));
			ultimo=false;
			break;
		case (R.id.botonMulti):
			
			if (num1==0)
			{
				num1=Float.parseFloat(String.valueOf(tv.getText()));
				op='m';
			}
			else
			{
				operacion();
				op='m';
			}
			tv.setText(String.valueOf(num1));
			ultimo=false;
			break;
		case (R.id.botonIgual):
			
			operacion();
			op='a';
			tv.setText(String.valueOf(num1));
			ultimo=false;
			num1=0;
			break;
			
		case (R.id.botonPunto):
			if (String.valueOf(tv.getText()).equals("") || !ultimo)
			{
				tv.setText("0"+".");
			}
			else
			{
				tv.setText(String.valueOf(tv.getText())+".");
			}
			ultimo=true;
			break;
			
		case (R.id.botonC):
			ultimo=false;
			op='a';
			num1=0;
			tv.setText("0");
			break;
		
		default:break;
		}
			
	}
	
	public void operacion()
	{
		switch (op){
		
		case 's': num1+=Float.parseFloat(String.valueOf(tv.getText()));		  
				  break;
				  
		case 'r': num1-=Float.parseFloat(String.valueOf(tv.getText()));
		  		  break;
		  		  
		case 'd': num1/=Float.parseFloat(String.valueOf(tv.getText()));
		  		  break;
		  		 
		case 'm': num1*=Float.parseFloat(String.valueOf(tv.getText()));
		  		  break;
		  		 
		default:break;
		
		}
	}
}
