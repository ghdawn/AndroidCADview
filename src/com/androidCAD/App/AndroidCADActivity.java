package com.androidCAD.App;

import me.ghdawn.util.SvgFactory;
import me.lenonb.FileManage;
import me.lenonb.FileOnlineObtain;

import com.android.AndroidCAD.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

public class AndroidCADActivity extends Activity {
    /** Called when the activity is first created. */
	public String address = "http://192.168.1.102:8080/";//Ĭ�ϵ�ַ�����������
	public String password = "1";
	public Button btnLogIn = null;
	public Button btnLogOut = null;
	public EditText etAddress = null;
	//public EditText etPasswordEditText = null;
	
	
	//public String passwordInputString = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btnLogIn = (Button)findViewById(R.id.buttonLogIn);
        btnLogIn.setOnClickListener(new ClickEvent());
        btnLogOut = (Button)findViewById(R.id.buttonLogOut);
        btnLogOut.setOnClickListener(new ClickEvent());
        
        etAddress = (EditText)findViewById(R.id.editTextAddress);
        etAddress.setText(address);
        //etPasswordEditText = (EditText)findViewById(R.id.editTextPassword);       
    }
    //������Ӧ
    class ClickEvent implements View.OnClickListener{
		public void onClick(View v){
			//��½
			if (v == btnLogIn) {
				//TODO:�����߲���
				address = etAddress.getEditableText().toString();
		        //passwordInputString = etPasswordEditText.getEditableText().toString();
				
				SvgFactory.Init(address);
	            Intent intent=new Intent();
	            intent.setClass(AndroidCADActivity.this,ContentList.class);
	            startActivity(intent);
			}
			//�ǳ�
			else if (v == btnLogOut) {
				//TODO:�����߲���
				//AndroidCADActivity.this.finish();
				
			}
		}
	}

}