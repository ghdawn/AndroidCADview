package me.ghdawn.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.Config;
import me.lenonb.FileManage;

public class SVGFactory
{
	SVGParase svgParase;
	FileManage manage;
	
	public void Init(String path)
	{
		
	}
	
	public Bitmap createBitmap(String name)
	{
		return Bitmap.createBitmap(1024, 768, Config.ALPHA_8);
	}
}
