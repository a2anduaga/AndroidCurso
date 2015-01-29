package com.example.tresenraya;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	
	private Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, btemp;
	private String turno="X";
	private int[] casillas = new int[9];
	private int cont=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bt1=(Button)findViewById(R.id.bt1);
		bt2=(Button)findViewById(R.id.bt2);
		bt3=(Button)findViewById(R.id.bt3);
		bt4=(Button)findViewById(R.id.bt4);
		bt5=(Button)findViewById(R.id.bt5);
		bt6=(Button)findViewById(R.id.bt6);
		bt7=(Button)findViewById(R.id.bt7);
		bt8=(Button)findViewById(R.id.bt8);
		bt9=(Button)findViewById(R.id.bt9);
		btemp=(Button)findViewById(R.id.empezar);
		bt1.setOnClickListener(this);
		bt2.setOnClickListener(this);
		bt3.setOnClickListener(this);
		bt4.setOnClickListener(this);
		bt5.setOnClickListener(this);
		bt6.setOnClickListener(this);
		bt7.setOnClickListener(this);
		bt8.setOnClickListener(this);
		bt9.setOnClickListener(this);
		btemp.setOnClickListener(this);
		bt1.setEnabled(false);
		bt2.setEnabled(false);
		bt3.setEnabled(false);
		bt4.setEnabled(false);
		bt5.setEnabled(false);
		bt6.setEnabled(false);
		bt7.setEnabled(false);
		bt8.setEnabled(false);
		bt9.setEnabled(false);
		
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
		
		if (v.getId()==R.id.empezar)
		{
			if (btemp.getText().toString().equals("Empezar"))
			{
				btemp.setText("Cancelar");
				bt1.setEnabled(true);
				bt2.setEnabled(true);
				bt3.setEnabled(true);
				bt4.setEnabled(true);
				bt5.setEnabled(true);
				bt6.setEnabled(true);
				bt7.setEnabled(true);
				bt8.setEnabled(true);
				bt9.setEnabled(true);
			}
			else
			{
				btemp.setText("Empezar");
				for (int i=0;i<9;i++)
				{
					casillas[i]=0;
				}
				cont=0;
				bt1.setEnabled(false);
				bt2.setEnabled(false);
				bt3.setEnabled(false);
				bt4.setEnabled(false);
				bt5.setEnabled(false);
				bt6.setEnabled(false);
				bt7.setEnabled(false);
				bt8.setEnabled(false);
				bt9.setEnabled(false);
			}
			bt1.setText("");
			bt2.setText("");
			bt3.setText("");
			bt4.setText("");
			bt5.setText("");
			bt6.setText("");
			bt7.setText("");
			bt8.setText("");
			bt9.setText("");
		}
		else if (v.getId()==R.id.bt1)
		{
			if (bt1.getText().toString().equals("")){
				cont++;
				bt1.setText(turno);
				if (turno.equals("X"))
				{
					casillas[0]=1;
				}
				else
				{
					casillas[0]=2;
				}
				verSiGanador();
				cambiarTurno();
			}
		}
		else if (v.getId()==R.id.bt2)
		{
			if (bt2.getText().toString().equals("")){
				cont++;
				bt2.setText(turno);
				if (turno.equals("X"))
				{
					casillas[1]=1;
				}
				else
				{
					casillas[1]=2;
				}
				verSiGanador();
				cambiarTurno();
			}
		}
		else if (v.getId()==R.id.bt3)
		{
			if (bt3.getText().toString().equals("")){
				cont++;
				bt3.setText(turno);
				if (turno.equals("X"))
				{
					casillas[2]=1;
				}
				else
				{
					casillas[2]=2;
				}
				verSiGanador();
				cambiarTurno();
			}
		}
		else if (v.getId()==R.id.bt4)
		{
			if (bt4.getText().toString().equals("")){
				cont++;
				bt4.setText(turno);
				if (turno.equals("X"))
				{
					casillas[3]=1;
				}
				else
				{
					casillas[3]=2;
				}
				verSiGanador();
				cambiarTurno();
			}
		}
		else if (v.getId()==R.id.bt5)
		{
			if (bt5.getText().toString().equals("")){
				cont++;
				bt5.setText(turno);
				if (turno.equals("X"))
				{
					casillas[4]=1;
				}
				else
				{
					casillas[4]=2;
				}
				verSiGanador();
				cambiarTurno();
			}
		}
		else if (v.getId()==R.id.bt6)
		{
			if (bt6.getText().toString().equals("")){
				cont++;
				bt6.setText(turno);
				if (turno.equals("X"))
				{
					casillas[5]=1;
				}
				else
				{
					casillas[5]=2;
				}
				verSiGanador();
				cambiarTurno();
			}
		}
		else if (v.getId()==R.id.bt7)
		{
			if (bt7.getText().toString().equals("")){
				cont++;
				bt7.setText(turno);
				if (turno.equals("X"))
				{
					casillas[6]=1;
				}
				else
				{
					casillas[6]=2;
				}
				verSiGanador();
				cambiarTurno();
			}
		}
		else if (v.getId()==R.id.bt8)
		{
			if (bt8.getText().toString().equals("")){
				cont++;
				bt8.setText(turno);
				if (turno.equals("X"))
				{
					casillas[7]=1;
				}
				else
				{
					casillas[7]=2;
				}
				verSiGanador();
				cambiarTurno();
			}
		}
		else if (v.getId()==R.id.bt9)
		{
			if (bt9.getText().toString().equals("")){
				cont++;
				bt9.setText(turno);
				if (turno.equals("X"))
				{
					casillas[8]=1;
				}
				else
				{
					casillas[8]=2;
				}
				verSiGanador();
				cambiarTurno();
			}
		}
	}

	private void verSiGanador() {
		
		if ((casillas[0]==1&&casillas[1]==1&&casillas[2]==1) || (casillas[3]==1&&casillas[4]==1&&casillas[5]==1) || (casillas[6]==1&&casillas[7]==1&&casillas[8]==1) || (casillas[0]==1&&casillas[3]==1&&casillas[6]==1) || (casillas[1]==1&&casillas[4]==1&&casillas[7]==1) || (casillas[2]==1&&casillas[5]==1&&casillas[8]==1) || (casillas[0]==1&&casillas[4]==1&&casillas[8]==1) || (casillas[2]==1&&casillas[4]==1&&casillas[6]==1)){
			
			finJuego("Jugador X ganador");
		}
		else if ((casillas[0]==2&&casillas[1]==2&&casillas[2]==2) || (casillas[3]==2&&casillas[4]==2&&casillas[5]==2) || (casillas[6]==2&&casillas[7]==2&&casillas[8]==2) || (casillas[0]==2&&casillas[3]==2&&casillas[6]==2) || (casillas[1]==2&&casillas[4]==2&&casillas[7]==2) || (casillas[2]==2&&casillas[5]==2&&casillas[8]==2) || (casillas[0]==2&&casillas[4]==2&&casillas[8]==2) || (casillas[2]==2&&casillas[4]==2&&casillas[6]==2)){
			
			finJuego("Jugador O ganador");
		}
		else if (cont==9)
		{
			finJuego("Empate");
		}
	}

	private void finJuego(String mensaje) {
		Toast toast=Toast.makeText(this, mensaje, Toast.LENGTH_SHORT);
		toast.show();
		cont=0;
		for (int i=0;i<9;i++)
		{
			casillas[i]=0;
		}
		btemp.setText("Empezar");
		bt1.setEnabled(false);
		bt2.setEnabled(false);
		bt3.setEnabled(false);
		bt4.setEnabled(false);
		bt5.setEnabled(false);
		bt6.setEnabled(false);
		bt7.setEnabled(false);
		bt8.setEnabled(false);
		bt9.setEnabled(false);
	}

	private void cambiarTurno() {
		
		if (turno.equals("X"))
		{
			turno="O";
		}
		else
		{
			turno="X";
		}		
	}
}
