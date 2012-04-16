package me.ghdawn;

import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;

import org.xml.sax.SAXException;

import me.ghdawn.form.Circle;
import me.ghdawn.form.Line;

import me.ghdawn.util.SVGParase;
import me.lenonb.FileManage;
import me.lenonb.FileOnlineObtain;
import me.lenonb.IFileObtain;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import android.widget.TextView;

public class ADCadActivity extends Activity
{
	/** Called when the activity is first created. */
	Bitmap bitmap;
	int scale = 0;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		// Set the ImageView as the content view for the Activity
		setContentView(R.layout.main);

		// Create a new ImageView
		ImageView imageView = (ImageView) findViewById(R.id.imageView);
		TextView t = (TextView) findViewById(R.id.tbView);
		EditText tbpath = (EditText) findViewById(R.id.tbpath);
		tbpath.setText("http://192.168.0.153:8080/");
		EditText tbname = (EditText) findViewById(R.id.tbname);
		Button btdraw = (Button) findViewById(R.id.btBut);
		Button btscale = (Button) findViewById(R.id.scale);
		// bitmap=BitmapFactory.decodeResource(getResources(), R.raw.taoyan);
		btscale.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				scale++;
				Log.d("myTag", "" + scale);
				Bitmap bmp = bitmap;
				Matrix matrix = new Matrix();
				ImageView imageView;
				matrix.postScale((float) (1 + (scale) / 10.0),
				        (float) (1 + (scale) / 10.0));
				Bitmap dstbmp = Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(),
				        bmp.getHeight(), matrix, false);
				imageView = (ImageView) findViewById(R.id.imageView);
				imageView.setImageBitmap(dstbmp);
			}
		});
		imageView.setBackgroundColor(Color.WHITE);
		btdraw.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				ImageView imageView = (ImageView) findViewById(R.id.imageView);
				TextView t = (TextView) findViewById(R.id.tbView);
				EditText tbpath = (EditText) findViewById(R.id.tbpath);
				EditText tbname = (EditText) findViewById(R.id.tbname);
				//DrawSvg(imageView, t, tbpath.getText().toString(), tbname.getText().toString());
				DrawSvg(tbpath.getText().toString(), tbname.getText().toString());
				Log.d("myTag", "ok1");
				System.gc();
			}
		});
		// t.setText("OK");
		Log.d("myTag", "drawClick");
		// Set the background color to white
		// imageView.setBackgroundColor(Color.WHITE);

	}
	
	private void DrawSvg(String path,String name)
	{
		  Uri uri = Uri.parse(path+name+".svg");   
	       Intent it = new Intent(Intent.ACTION_VIEW, uri);   
	       startActivity(it);  

	}
	private void DrawSvg(ImageView imageView, TextView t, String path,
	        String name)
	{
		try
		{
			EditText tbpath = (EditText) findViewById(R.id.tbpath);
			EditText tbname = (EditText) findViewById(R.id.tbname);
			InputStream is = null;// = download(path + name + ".svg");

			IFileObtain obtain = new FileOnlineObtain();
			FileManage manage = new FileManage(obtain, tbpath.getText()
			        .toString());
			is = manage.getFile(tbname.getText().toString());
			
			bitmap = Bitmap.createBitmap(1024, 768, Config.ALPHA_8);
			Canvas canvas = new Canvas(bitmap);
			Paint paint = new Paint();
			paint.setColor(Color.BLACK);

			SVGParase svgParase = new SVGParase(is);

			t.setText("12324");

			ArrayList<Circle> circles = svgParase.getCircles();
			ArrayList<Line> lines = svgParase.getLines();

			for (Circle circle : circles)
			{
				circle.draw(canvas, 3);
			}
			for (Line line : lines)
			{
				line.draw(canvas, 3);
			}
			t.setText("" + lines.get(0).getX(0) + "," + lines.get(0).getY(0));

			imageView.setImageBitmap(bitmap);

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
	}

}