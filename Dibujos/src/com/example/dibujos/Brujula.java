package com.example.dibujos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;

public class Brujula extends View{

	public Brujula(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	protected void onDraw(Canvas canvas)
	{
		canvas.drawColor(Color.BLACK);
		
		Paint crucetaExterior = new Paint();
		crucetaExterior.setColor(Color.WHITE);
		canvas.drawLine(50, canvas.getHeight()/2, 430, canvas.getHeight()/2, crucetaExterior);
		canvas.drawLine(canvas.getWidth()/2, 174, canvas.getWidth()/2, 554, crucetaExterior);
		
		Paint crucetaInterior = new Paint();
		crucetaInterior.setColor(Color.GRAY);
		canvas.drawLine((float) (canvas.getWidth()/2-Math.cos(Math.PI/4)*canvas.getWidth()/6), (float) (canvas.getHeight()/2-Math.sin(Math.PI/4)*canvas.getWidth()/6), (float) (canvas.getWidth()/2+Math.cos(Math.PI/4)*canvas.getWidth()/6), (float) (canvas.getHeight()/2+Math.sin(Math.PI/4)*canvas.getWidth()/6), crucetaInterior);
		canvas.drawLine((float) (canvas.getWidth()/2-Math.cos(Math.PI/4)*canvas.getWidth()/6), (float) (canvas.getHeight()/2+Math.sin(Math.PI/4)*canvas.getWidth()/6), (float) (canvas.getWidth()/2+Math.cos(Math.PI/4)*canvas.getWidth()/6), (float) (canvas.getHeight()/2-Math.sin(Math.PI/4)*canvas.getWidth()/6), crucetaInterior);
		
		Paint circulo = new Paint(Paint.ANTI_ALIAS_FLAG);
		circulo.setColor(Color.GRAY);
		circulo.setStyle(Paint.Style.STROKE);
		circulo.setStrokeWidth(2);
		canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight()/2, canvas.getWidth()/6, circulo);
		
		Paint norte = new Paint(Paint.ANTI_ALIAS_FLAG);
		norte.setColor(Color.WHITE);
		canvas.drawCircle(canvas.getWidth()/2, 174, 20, norte);
		
		Paint sur = new Paint(Paint.ANTI_ALIAS_FLAG);
		sur.setColor(Color.RED);
		canvas.drawCircle(canvas.getWidth()/2, 554, 20, sur);
		
		Paint este = new Paint(Paint.ANTI_ALIAS_FLAG);
		este.setColor(Color.YELLOW);
		canvas.drawCircle(50, canvas.getHeight()/2, 20, este);
		
		Paint oeste = new Paint(Paint.ANTI_ALIAS_FLAG);
		oeste.setColor(Color.BLUE);
		canvas.drawCircle(430, canvas.getHeight()/2, 20, oeste);
		
		Paint punto = new Paint();
		punto.setColor(Color.BLACK);
		punto.setStyle(Paint.Style.STROKE);
		punto.setStrokeWidth(4);
		canvas.drawPoint(canvas.getWidth()/2, 174, punto);
		canvas.drawPoint(canvas.getWidth()/2, 554, punto);
		canvas.drawPoint(50, canvas.getHeight()/2, punto);
		canvas.drawPoint(430, canvas.getHeight()/2, punto);
		
		Paint marcas = new Paint();
		marcas.setColor(Color.RED);
		marcas.setStyle(Paint.Style.STROKE);
		marcas.setStrokeWidth(4);
		canvas.drawPoint((float) (canvas.getWidth()/2-Math.cos(Math.PI/8)*canvas.getWidth()/6), (float) (canvas.getHeight()/2-Math.sin(Math.PI/8)*canvas.getWidth()/6), marcas);
		canvas.drawPoint((float) (canvas.getWidth()/2+Math.cos(Math.PI/8)*canvas.getWidth()/6), (float) (canvas.getHeight()/2-Math.sin(Math.PI/8)*canvas.getWidth()/6), marcas);
		canvas.drawPoint((float) (canvas.getWidth()/2-Math.cos(Math.PI/8)*canvas.getWidth()/6), (float) (canvas.getHeight()/2+Math.sin(Math.PI/8)*canvas.getWidth()/6), marcas);
		canvas.drawPoint((float) (canvas.getWidth()/2+Math.cos(Math.PI/8)*canvas.getWidth()/6), (float) (canvas.getHeight()/2+Math.sin(Math.PI/8)*canvas.getWidth()/6), marcas);
		canvas.drawPoint((float) (canvas.getWidth()/2-Math.cos(Math.PI/2.6)*canvas.getWidth()/6), (float) (canvas.getHeight()/2-Math.sin(Math.PI/2.6)*canvas.getWidth()/6), marcas);
		canvas.drawPoint((float) (canvas.getWidth()/2+Math.cos(Math.PI/2.6)*canvas.getWidth()/6), (float) (canvas.getHeight()/2-Math.sin(Math.PI/2.6)*canvas.getWidth()/6), marcas);
		canvas.drawPoint((float) (canvas.getWidth()/2-Math.cos(Math.PI/2.6)*canvas.getWidth()/6), (float) (canvas.getHeight()/2+Math.sin(Math.PI/2.6)*canvas.getWidth()/6), marcas);
		canvas.drawPoint((float) (canvas.getWidth()/2+Math.cos(Math.PI/2.6)*canvas.getWidth()/6), (float) (canvas.getHeight()/2+Math.sin(Math.PI/2.6)*canvas.getWidth()/6), marcas);
		
		Paint texto = new Paint(Paint.ANTI_ALIAS_FLAG);
		texto.setColor(Color.MAGENTA);
		Typeface fuente = Typeface.create(Typeface.MONOSPACE, Typeface.BOLD);
		texto.setTextSize(20);
		texto.setTypeface(fuente);
		canvas.drawText("PUNTOS CARDINALES", 150, 80, texto);
	}
}
