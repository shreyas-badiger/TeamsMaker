package com.example.teamsmaker;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class Page11 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_page11);
		int n=MainActivity.m;
		EditText []ed= new EditText[n];
		RelativeLayout rv=(RelativeLayout)findViewById(R.id.rv11);
		for(int i=0;i<n;i++)
		{rv.addView(ed[i]);}
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.page11, menu);
		return true;
	}

}
