package com.example.brujulaconbotones;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.Button;

public class MiBoton extends Button{
	
	public MiBoton(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public MiBoton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}
	public MiBoton(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		Paint pincel = new Paint(Paint.ANTI_ALIAS_FLAG);
		pincel.setColor(Color.WHITE);
		canvas.drawCircle(100, 100, 20, pincel);
	}
}
