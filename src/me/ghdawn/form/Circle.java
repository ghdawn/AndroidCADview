package me.ghdawn.form;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class Circle implements IShape
{
	private float _cx, _cy, _r;

	public Circle(String cx, String cy, String r)
	{
		_cx = Float.parseFloat(cx);
		_cy = Float.parseFloat(cy);
		_r = Float.parseFloat(r);
	}

	@Override
	public void draw(Canvas canvas,float scale)
	{
		// TODO Auto-generated method stub
		Paint paint = new Paint();
		paint.setStyle(Style.STROKE);
		paint.setColor(Color.BLACK);
		canvas.drawCircle(_cx/scale, _cy/scale, _r/scale, paint);
		
	}

}
