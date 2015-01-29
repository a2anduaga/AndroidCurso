package com.example.prueba;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{
	
	private Button suma;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.suma = (Button)this.findViewById(R.id.Button1);
		this.suma.setOnClickListener(this);
	}
	public void sumar()
	{
		
		String sumaString=suma.getText().toString();
		int sumaInt=Integer.parseInt(sumaString);
		sumaInt++;
		sumaString=String.valueOf(sumaInt);
		suma.setText(sumaString);
		
	}
	@Override
	public void onClick(View v) {
		
		sumar();
	}
}
