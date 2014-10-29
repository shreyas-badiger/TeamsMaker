package com.example.teamsmaker;

import java.util.List;
import java.util.Random;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class page1 extends Activity {
	
	LinearLayout ll,dummy,l1,l2;
	Button b;

	
	int i;
	
	static EditText et[]=new EditText[MainActivity.m];
	static RatingBar rb[]=new RatingBar[MainActivity.m];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.page1);
		int nn=MainActivity.m;
		dummy = (LinearLayout)findViewById(R.id.dummy);
		ll = (LinearLayout)findViewById(R.id.lvtop);
		 l1 = (LinearLayout)findViewById(R.id.lv11);
		  l2 = (LinearLayout)findViewById(R.id.lv22);
		 for(i=0;i<nn;i++){
			rb[i]=new RatingBar(this);
			//rb[i]= new RatingBar(this, null,R.style.myRb);
			et[i]= new EditText(this);
			rb[i].setNumStars(5);
			rb[i].setStepSize(1);
			l1.addView(et[i]);
			l2.addView(rb[i]);
		}
		 
		 b=new Button(this);
		 b.setText("TeamUp");
		 b.setWidth(LayoutParams.MATCH_PARENT);
		 b.setHeight(LayoutParams.MATCH_PARENT);
		 dummy.addView(b);
		
		 b.setOnClickListener(new View.OnClickListener() {
			 String names[]=new String[MainActivity.m];
				   float rating[]=new float[MainActivity.m];
			@Override
			public void onClick(View arg0) {
				for(i=0;i<MainActivity.m;i++)
				{
					names[i]=et[i].getText().toString();
					rating[i]=rb[i].getRating();
					
				}
				Intent next =new Intent("com.example.teamsmaker.PAGE2");
				next.putExtra("rr", rating);
				next.putExtra("nn", names);
				startActivity(next);
			}
			});
		

}
	/*@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}*/
	
}
