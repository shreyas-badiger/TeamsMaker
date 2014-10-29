package com.example.teamsmaker;

import android.os.Bundle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.InputType;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.*;

public class MainActivity extends Activity {

	Button b;
	EditText ed;
	TextView t,t2;
	public static int m;
	String s;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		ed=(EditText)findViewById(R.id.n);
		b=(Button)findViewById(R.id.b);
		t=(TextView)findViewById(R.id.tv1);
		t2=(TextView)findViewById(R.id.tv2);
		
		Typeface custom_font = Typeface.createFromAsset(getAssets(), "font/b.ttf");
		t.setTypeface(custom_font);
		Typeface custom_font2 = Typeface.createFromAsset(getAssets(), "font/s.ttf");
		t2.setTypeface(custom_font2);
		
		b.setOnClickListener(new View.OnClickListener() {
			
		@Override
		public void onClick(View v) {
				m=Integer.parseInt(ed.getText().toString());
				
				Intent next =new Intent("com.example.teamsmaker.PAGE1");
				startActivity(next);
		}
		});
	}
	
}

