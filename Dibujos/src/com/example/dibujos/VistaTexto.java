package com.example.dibujos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;

public class VistaTexto extends View{

	public VistaTexto(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	protected void onDraw(Canvas canvas)
	{
		canvas.drawColor(Color.BLACK);
		Paint pintar = new Paint(Paint.ANTI_ALIAS_FLAG);
		pintar.setColor(Color.WHITE);
		Typeface fuente = Typeface.create(Typeface.MONOSPACE, Typeface.NORMAL);
		pintar.setTypeface(fuente);
		pintar.setTextSize(40);
		canvas.drawText("Kaixo Txubi", 20, canvas.getHeight()/2, pintar);
	}
}
