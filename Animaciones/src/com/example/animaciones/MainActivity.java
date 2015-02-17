package com.example.animaciones;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{
	
	private Button bt1,bt2,bt3,bt4,bt5;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bt1=(Button)findViewById(R.id.bt1);
		bt2=(Button)findViewById(R.id.bt2);
		bt3=(Button)findViewById(R.id.bt3);
		bt4=(Button)findViewById(R.id.bt4);
		bt5=(Button)findViewById(R.id.bt5);
		bt1.setOnClickListener(this);
		bt2.setOnClickListener(this);
		bt3.setOnClickListener(this);
		bt4.setOnClickListener(this);
		bt5.setOnClickListener(this);
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
		if (v.getId()==R.id.bt1)
		{
			Animation animacion = AnimationUtils.loadAnimation(this, R.anim.translacion);
			bt1.startAnimation(animacion);
		}
		else if (v.getId()==R.id.bt2)
		{
			Animation animacion = AnimationUtils.loadAnimation(this, R.anim.rotacion);
			bt2.startAnimation(animacion);
		}
		else if (v.getId()==R.id.bt3)
		{
			Animation animacion = AnimationUtils.loadAnimation(this, R.anim.escalado);
			bt3.startAnimation(animacion);
		}
		else if (v.getId()==R.id.bt4)
		{
			Animation animacion = AnimationUtils.loadAnimation(this, R.anim.opacidad);
			bt4.startAnimation(animacion);
		}
		else if (v.getId()==R.id.bt5)
		{
			Animation animacion = AnimationUtils.loadAnimation(this, R.anim.todos);
			bt5.startAnimation(animacion);
		}
	}
}
