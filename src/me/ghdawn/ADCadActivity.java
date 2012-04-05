package me.ghdawn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.xml.sax.SAXException;

import me.ghdawn.form.Circle;
import me.ghdawn.form.Line;

import me.ghdawn.util.FileManage;
import me.ghdawn.util.SVGParase;

import android.R.bool;
import android.R.string;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
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
        int width=1024,height=768;
        // Create a new ImageView
        ImageView imageView =(ImageView)findViewById(R.id.imageView);  
        TextView t=(TextView)findViewById(R.id.tbView);
        EditText tbpath=(EditText)findViewById(R.id.tbpath);
        EditText tbname=(EditText)findViewById(R.id.tbname);
        Button btdraw=(Button)findViewById(R.id.btBut);
        imageView.setBackgroundColor(Color.WHITE);
        btdraw.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				ImageView imageView =(ImageView)findViewById(R.id.imageView);  
		        TextView t=(TextView)findViewById(R.id.tbView);
		        EditText tbpath=(EditText)findViewById(R.id.tbpath);
		        EditText tbname=(EditText)findViewById(R.id.tbname);
				 DrawSvg(imageView, t, tbpath.getText().toString(), tbname.getText().toString());
				  Log.d("myTag", "ok1");
			}
		});
	 //   t.setText("OK");
	    Log.d("myTag", "HHH");
        // Set the background color to white
     //   imageView.setBackgroundColor(Color.WHITE);
        
       
    }
	private void DrawSvg(ImageView imageView, TextView t, String path,
			String name)
    {
	    try
        {
	    	
	       InputStream is= download(path+name+".svg", "baidu");
	       //FileManage fileManage=new FileManage();
	       
	       // BitmapDrawable bitmapDrawable=new BitmapDrawable((is));
	        Bitmap bitmap;
	        
	        bitmap=Bitmap.createBitmap(1024, 768, Config.ALPHA_8);
	        Canvas canvas=new Canvas(bitmap);
	        Paint paint=new Paint();
	        paint.setColor(Color.BLACK);
	       // t.setText("1");
	        SVGParase svgParase=new SVGParase(is);
	       
	        t.setText("12324");

	
			//canvas.drawLine(lines.get(0).getX(0)/10, lines.get(0).getY(0)/10, lines.get(0).getX(1)/10, lines.get(0).getY(1)/10, paint);
			ArrayList<Circle> circles=svgParase.getCircles();
			ArrayList<Line> lines=svgParase.getLines();
			//ArrayList<MyText> texts=svgParase.getTexts();
			for (Circle circle : circles)
            {
	            circle.draw(canvas, 1);
            }
			for (Line line : lines)
            {
	            line.draw(canvas, 1);
            }
	        t.setText(""+lines.get(0).getX(0)+","+lines.get(0).getY(0));
			//canvas.drawLine(lines.get(0).getX(0)/10, lines.get(0).getY(0)/10, lines.get(0).getX(1)/10, lines.get(0).getY(1)/10, paint);
			//imageView.setImageDrawable(bitmapDrawable);
	        imageView.setImageBitmap(bitmap);
	        imageView.setVisibility(1);
        }
        catch (IOException e)
        {
	        // TODO Auto-generated catch block
        	Log.d("myTag","e1");
	        e.printStackTrace();
        }
        /*	t.setText("1");
	      
	       
	       File file=new File("baidu");
       */
        catch (SAXException e)
        {
	        // TODO Auto-generated catch block
        	Log.d("myTag","e2");
	        e.printStackTrace();
        }
    }
    public InputStream download(String urlString, String filename) throws IOException 
    {   
	    // 构造URL   
	    URL url = new URL(urlString);   
	    // 打开连接   
	    URLConnection con = url.openConnection();   
	    // 输入流   
	    InputStream is = con.getInputStream();   

	    return is;/*
	    // 1K的数据缓冲   
	    byte[] bs = new byte[1024];   
	    // 读取到的数据长度   
	    int len;   
	    // 输出的文件流   
	    File file=new File(filename);
	    file.createNewFile();
	    OutputStream os = new FileOutputStream(filename);   
	    // 开始读取   
	    while ((len = is.read(bs)) != -1) {   
	      os.write(bs, 0, len);   
	    }   
	    
	    // 完毕，关闭所有链接   
	    os.close();   
	    is.close();  
	    */ 
	  } 
}