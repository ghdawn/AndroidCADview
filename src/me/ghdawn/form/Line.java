package me.ghdawn.form;

import java.util.ArrayList;

import android.graphics.Canvas;
import android.graphics.Point;


public class Line implements IShape
{
	private ArrayList<Point> _points;
	
	public Line()
	{
		_points=new ArrayList<Point>(2);
	}
	
	public void add(String spoints)
	{
		String[] Points=spoints.split(" ");
		for (String pointsString : Points)
        {
	        String[] eachpoint=pointsString.split(",");
	        int x=Integer.parseInt(eachpoint[0]),y=Integer.parseInt(eachpoint[1]);
	        _points.add(new Point(x,y));
        }
	}
	
	public int getCounts()
	{
		return _points.size();
	}

	@Override
    public void draw(Canvas canvas)
    {
	    // TODO Auto-generated method stub
	    
    }

	
	
}
