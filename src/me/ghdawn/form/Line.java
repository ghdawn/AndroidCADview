package me.ghdawn.form;

import java.util.ArrayList;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Paint.Style;

public class Line implements IShape
{
	private float[] _points;
	private int _count;

	public Line()
	{

	}

	public void add(String spoints)
	{
		String[] Points = spoints.split(" ");
		_points = new float[Points.length * 2];
		int i = 0;
		for (String pointsString : Points)
		{
			String[] eachpoint = pointsString.split(",");
			float x = Float.parseFloat(eachpoint[0]), y = Float
			        .parseFloat(eachpoint[1]);
			_points[i++] = x;
			_points[i++] = y;
		}
		_count = i ;
	}

	public float getX(int index)
	{
		return _points[2 * index];
	}

	public float getY(int index)
	{
		return _points[2 * index + 1];
	}

	public int getCounts()
	{
		return _count;
	}

	@Override
	public void draw(Canvas canvas,float scale)
	{
		// TODO Auto-generated method stub
		Paint paint = new Paint();
		paint.setStyle(Style.STROKE);
		paint.setColor(Color.BLACK);
		for (int i = 0; i < _count-2; i+=2)
        {
	        canvas.drawLine(_points[i]/scale, _points[i+1]/scale, _points[i+2]/scale, _points[i+3]/scale, paint);
        }
	}

}
