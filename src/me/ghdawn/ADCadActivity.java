package me.ghdawn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParser;

import android.R.bool;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Picture;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ADCadActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the ImageView as the content view for the Activity
        setContentView(R.layout.main);
        // Create a new ImageView
        ImageView imageView =(ImageView)findViewById(R.id.imageView);  
        TextView t=(TextView)findViewById(R.id.tbView);
	    t.setText("OK");
        // Set the background color to white
        imageView.setBackgroundColor(Color.WHITE);
        /*	t.setText("1");
	       download("http://192.168.1.101:8080/breeze.gif", "baidu");
	       
	       File file=new File("baidu");
	       InputStream sin=new FileInputStream(file);
	        //SVG svg=SVGParser.getSVGFromInputStream(sin);*/
	         SVG svg = SVGParser.getSVGFromResource(getResources(), R.raw.images);
	        //BitmapDrawable bitmap=new BitmapDrawable(sin);
	        Drawable drawable=svg.createPictureDrawable();
	       // drawable.setBounds(10, 20, 200, 300);
	         // Get a drawable from the parsed SVG and set it as the drawable for the ImageView
	         imageView.setImageDrawable(drawable);
      
       
        RelativeLayout root=(RelativeLayout) findViewById(R.id.RelativeLayout1);
        final DrawView draw=new DrawView(this);
        draw.setMinimumWidth(300);
        draw.setMinimumHeight(500);
        draw.setOnTouchListener(new OnTouchListener()
        {
			
			@Override
			public boolean onTouch(View v, MotionEvent event)
			{
				// TODO Auto-generated method stub
			
				draw.currentX=event.getX();
				draw.currentY=event.getY();
				draw.invalidate();
				return true;
			}
		});
        root.addView(draw);
    }
    public void download(String urlString, String filename) throws IOException 
    {   
	    // 构造URL   
	    URL url = new URL(urlString);   
	    // 打开连接   
	    URLConnection con = url.openConnection();   
	    // 输入流   
	    InputStream is = con.getInputStream();   

	    
	    // 1K的数据缓冲   
	    byte[] bs = new byte[1024];   
	    // 读取到的数据长度   
	    int len;   
	    // 输出的文件流   
	    OutputStream os = new FileOutputStream(filename);   
	    // 开始读取   
	    while ((len = is.read(bs)) != -1) {   
	      os.write(bs, 0, len);   
	    }   
	    
	    // 完毕，关闭所有链接   
	    os.close();   
	    is.close();  
	     
	  } 
}