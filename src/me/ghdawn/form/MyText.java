package me.ghdawn.form;



import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class MyText implements IShape
{
	String _text;
	float _x,_y;
	public MyText(String string)
	{
		_text=string;
	}
	public void setPos(String pos)
    {
	    pos=pos.replace(')', ' ');
	    String[] posi=pos.split(" ");
	    _x=Float.parseFloat(posi[posi.length-2]);
	    _y=Float.parseFloat(posi[posi.length-1]);
    }
	
	public void draw(Canvas canvas)
	{
		// TODO Auto-generated method stub
		Paint paint = new Paint();
		paint.setTextSize(6f);
		paint.setStyle(Style.STROKE);
		paint.setColor(Color.BLACK);
		canvas.drawText(_text, _x, _y, paint);
	}
	
 

}
