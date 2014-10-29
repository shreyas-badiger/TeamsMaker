package com.example.teamsmaker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class Splash extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.splash);
		
		Thread timer= new Thread(){
			public void run(){
				try{
					sleep(2000);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				finally{
					Intent mainPage=new Intent("com.example.teamsmaker.MAINACTIVITY");
					startActivity(mainPage);
				}
			}
		};
		timer.start();
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
