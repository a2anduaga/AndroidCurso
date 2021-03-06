package com.example.dibujos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class VistaPunto extends View{

	public VistaPunto(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	protected void onDraw(Canvas canvas)
	{
		Paint paint = new Paint();
		paint.setColor(Color.RED);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(10);
		canvas.drawPoint(20, 20, paint);
		canvas.drawPoint(50, 50, paint);
		canvas.drawPoint(100, 100, paint);
		
		Paint pincelLinea = new Paint();
		pincelLinea.setColor(Color.BLACK);
		
		canvas.drawLine(20, 20, 50, 50, pincelLinea);
		canvas.drawLine(50, 50, 100, 100, pincelLinea);
	}
}
