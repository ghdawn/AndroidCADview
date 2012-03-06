package me.ghdawn.form;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;



public class Circle implements IShape
{
	private int _cx,_cy,_r;
	
	public Circle(String cx,String cy,String r)
	{
		_cx=Integer.parseInt(cx);
		_cy=Integer.parseInt(cy);
		_r=Integer.parseInt(r);
	}

	@Override
    public void draw(Canvas canvas)
    {
	    // TODO Auto-generated method stub
	    Paint paint = new Paint();
	    paint.setColor(Color.BLACK);
		canvas.drawCircle(_cx, _cy, _r, paint);
    }
	
	
}
