package me.ghdawn.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import me.ghdawn.form.Circle;
import me.ghdawn.form.Line;
import me.ghdawn.form.MyText;
import me.lenonb.FileManage;
import me.lenonb.FileOnlineObtain;

import org.xml.sax.SAXException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.util.Log;

public class SvgFactory
{
	static FileManage fileManage;
	private static Bitmap bitmap;

	public static void Init(String path)
	{
		fileManage = new FileManage(new FileOnlineObtain(), path);
	}
	
	public static String[] Search(String fileName)
	{
		return fileManage.Search(fileName);
	}
	
	public static String[] getFileList()
	{
		return fileManage.getFileList();
	}
	public static Bitmap getBitmap(String fileName)
	{
		try
		{
			InputStream is = fileManage.getFile(fileName);
			
			bitmap = Bitmap.createBitmap(1024, 768, Config.ALPHA_8);
			Canvas canvas = new Canvas(bitmap);
			Paint paint = new Paint();
			paint.setColor(Color.BLACK);

			SVGParase svgParase = new SVGParase(is);

			ArrayList<Circle> circles = svgParase.getCircles();
			ArrayList<Line> lines = svgParase.getLines();
			ArrayList<MyText> texts=svgParase.getTexts();
			for (Circle circle : circles)
			{
				circle.draw(canvas);
			}
			for (Line line : lines)
			{
				line.draw(canvas);
			}
			for (MyText myText : texts)
            {
	            myText.draw(canvas);
            }
			return bitmap;

		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			Log.d("myTag", "e1");
			e.printStackTrace();
		}

		catch (SAXException e)
		{
			// TODO Auto-generated catch block
			Log.d("myTag", "e2");
			e.printStackTrace();
		}

		return null;
		
		
	}
	
}
