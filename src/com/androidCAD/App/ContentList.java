package com.androidCAD.App;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.ghdawn.util.SvgFactory;

import com.android.AndroidCAD.R;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class ContentList extends ListActivity implements OnItemLongClickListener{ 
	// private List<String> data = new ArrayList<String>(); 
	private String serverString = "";
	public String[] resourceList; 
	public int resourceNum;
	public PictureDisplay pictureDisplay = new PictureDisplay();
	public Bundle mBundle = new Bundle();
	@Override 
	public void onCreate(Bundle savedInstanceState) { 
	   super.onCreate(savedInstanceState); 
	   
	   SimpleAdapter adapter = new SimpleAdapter(this,getData(),R.layout.picturelist, new String[]{"title","info","img"}, new int[]{R.id.title,R.id.info,R.id.img}); 
	   setListAdapter(adapter);
	}
	//������ʾ�ļ����ԵĹ��ܣ�δ���
	public boolean onItemLongClick(AdapterView parent, View view, int position,  long id) {  
		//Log.e("CallLogActivity", view.toString() + "position=" + position);  
		CharSequence number = ((TextView) view).getText();  
		Toast t = Toast.makeText(this, number + " is long clicked", Toast.LENGTH_LONG);  
		t.show();
		return true;
	}
	//
	@Override  
	protected void onListItemClick(ListView arg0, View arg1, int arg2, long arg3) {  
		
		Intent intent=new Intent();
        intent.setClass(ContentList.this,PictureDisplay.class);
        
        mBundle.putString("FileName",SvgFactory.getFileList()[arg2]);
        intent.putExtras(mBundle);
        startActivity(intent);

		/*ֱ���������ʾ
		Uri uri = Uri.parse(serverString+resourceList[arg2]+".svg");
		Intent it = new Intent(Intent.ACTION_VIEW,uri);
		startActivity(it);
		*/
	}

	private List<Map<String, Object>> getData() {
		//TODO����ȡ��Ŀ¼�µ�ͼƬ����
		 
		 List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(); 
		 resourceList = SvgFactory.getFileList();
		 if (resourceList == null) 
		 {
			Toast.makeText(this, "δ�ҵ��ļ��б�", Toast.LENGTH_LONG).show();
		 }
		 else 
		 {
			 resourceNum = resourceList.length;
			 for (int i = 0; i < resourceNum; i++) {
				 Map<String, Object> map = new HashMap<String, Object>();
				 map.put("title", resourceList[i]); 
				 map.put("info", "svg");
				 map.put("img", R.drawable.ic_launcher); 
				 list.add(map);
			}
		 }
		 return list; 
	} 
}
