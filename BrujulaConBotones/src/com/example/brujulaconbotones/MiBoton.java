package com.example.brujulaconbotones;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.widget.Button;

public class MiBoton extends Button{
	
	public int color;
	public float x,y,r;
	
	public MiBoton(Context context, float x, float y, float r, int color) {
		super(context);
		this.color=color;
		this.x=x;
		this.y=y;
		this.r=r;
	}
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		Paint pincel = new Paint(Paint.ANTI_ALIAS_FLAG);
		pincel.setColor(color);
		pincel.setStyle(Style.STROKE);
		pincel.setStrokeWidth(2);
		canvas.drawCircle(x, y, r, pincel);
	}
}
