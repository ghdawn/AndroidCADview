package com.androidCAD.App;

import me.ghdawn.util.SvgFactory;

import com.android.AndroidCAD.R;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.AbsoluteLayout;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;

public class PictureDisplay extends Activity
{
	private LinearLayout ll;
	private LayoutParams parm;

	@Override  
    protected void onCreate(Bundle savedInstanceState)  
    {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.picturedisplay);
        Bundle mbBundle = getIntent().getExtras();
        String FileName = mbBundle.getString("FileName");
        
        ll = (LinearLayout) findViewById(R.id.twill); 
        parm = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
        
        Bitmap bmp = SvgFactory.getBitmap(FileName);
        ImageView imp = new TouchView(this,LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.FILL_PARENT);
        imp.setImageBitmap(bmp);
       
        
        imp.setBackgroundColor(Color.WHITE);
        imp.setScaleType(ScaleType.FIT_CENTER);
        imp.setLayoutParams(parm);


        //ImageAdapter iAdapter = new ImageAdapter(this);
        //iAdapter = new ImageAdapter(this); 
        //ViewScroll vScroll = new ViewScroll(this, bmp);  
          
        ll.addView(imp,parm);
    }
}