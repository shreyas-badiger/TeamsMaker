package com.example.teamsmaker;

import java.util.Arrays;
import java.util.Random;

import android.app.Activity;
import com.example.teamsmaker.page1;
import android.app.ActionBar.LayoutParams;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.*;

public class page2 extends Activity {
	static int count=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		count++;
		int i;
		int n=MainActivity.m;
		TextView tv1,tv2,tv3,tv4;
		Button b;
		 
		String names[]=new String[n];
		String team1_names[]=new String[n];
		String team2_names[]=new String[n];
		float team1_ratings[]=new float[n];
		float team2_ratings[]=new float[n];
		float sum=0;
		float t1,T1,T2;
		int stack[] = new int[100];
		float rating[]=new float[n];
		int top=-1,done=0;
		StringBuilder builder1_names=new StringBuilder();
		StringBuilder builder1_ratings=new StringBuilder();
		StringBuilder builder2_names=new StringBuilder();
		StringBuilder builder2_ratings=new StringBuilder();
		
		LinearLayout topi;
		if(count==1){ 
			names=getIntent().getStringArrayExtra("nn");
			rating=getIntent().getFloatArrayExtra("rr");}
		else{
			rating = getIntent().getFloatArrayExtra("r"); 
			names =getIntent().getStringArrayExtra("n");}
		
		for(i=0;i<n;i++)
    		sum+=rating[i];
	    T2=(int)sum/2;
	    T1=sum-T2;
	    i=0;
	    t1=0;
	    while(done==0 && T1>0)
	      {
	      for(;i<n;i++)
	          {
	          	t1+=rating[i];
	        	stack[++top]=i;
	          	if(t1==T1)
	          		{
	          			done=1;
	          			break;
	          		}
	          	if(t1>T1)
	          		{
	              		i=stack[top--];
	              		t1-=rating[i];
	          		}
	          }
		
	     if(done==0)
	         {
	    	 	if(top>=0)
	          		{
	    	 			i=stack[top--];
	              		t1-=rating[i];
	              		i++;
	          		}
	    	 	else
	    	 		{
	    	 			T1--;
	    	 			i=0;
	    	 		}
	         }
	      }
	    int list2[]=new int[n+top+5];
	    int j;
	    for(j=0;j<n;j++)
	    	list2[j]=j;
		for(i=0;i<=top;i++)
        {	
			
			team1_names[i]=names[stack[i]];
			builder1_names.append(team1_names[i].toString()+"\n");
			team1_ratings[i]=rating[stack[i]];
			builder1_ratings.append(team1_ratings[i]+"\n");
			list2[j]=stack[i];
			j++;
		}
		for(i=0;i<j;i++)
			for(int k=i;k<j;k++)
				if(list2[i]>list2[k])
				{
					int temp=list2[i];
					list2[i]=list2[k];
					list2[k]=temp;
				}
		list2[j]=0;
		for(i=0;i<j;i++)
    	{
			if(list2[i]==list2[i+1]){i++;}
			else		
			{
				if(list2[i]<n)
				{
					int ii=list2[i];team2_names[ii]=names[ii];
				builder2_names.append(team2_names[ii].toString()+"\n");
				team2_ratings[ii]=rating[ii];
				builder2_ratings.append(team2_ratings[ii]+"\n");}
			}
    	}
	    
		setContentView(R.layout.page2);
		topi=(LinearLayout)findViewById(R.id.top);
			
		tv1= (TextView)findViewById(R.id.names1);
		tv2= (TextView)findViewById(R.id.ratings1);
		tv3= (TextView)findViewById(R.id.names2);
		tv4= (TextView)findViewById(R.id.ratings2);
		
		int d1=(int) (1 + (Math.random() * 2));
	    switch(d1){
	    case 1:
	    	tv1.setText(builder1_names);
			tv2.setText(builder1_ratings.toString());
			tv3.setText(builder2_names);
			tv4.setText(builder2_ratings.toString());
			break;
	    case 2:
	    	tv1.setText(builder2_names);
			tv2.setText(builder2_ratings.toString());
			tv3.setText(builder1_names);
			tv4.setText(builder1_ratings.toString());
			break;
	    }
		
		Button reteam=new Button(this);
		reteam.setBackgroundResource(R.drawable.design2);
		reteam.setText(" Not Happy :/ ");
		reteam.setWidth(LayoutParams.MATCH_PARENT);
		reteam.setHeight(LayoutParams.MATCH_PARENT);
		topi.addView(reteam);
		final float rating2[]=new float[n];
		final String names2[]=new String[n];
		for(i=0;i<n;i++)
			{rating2[i]=rating[i];names2[i]=names[i];}
			 reteam.setOnClickListener(new View.OnClickListener() {

				 
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					shuffleArray(rating2,names2);
					Intent next =new Intent("com.example.teamsmaker.PAGE2");
					next.putExtra("r" ,rating2);
					next.putExtra("n", names2);
					startActivity(next);
				}
			});
	
	}
	 void shuffleArray(float[] ar,String[] sr)
	  {
	    Random rnd = new Random();
	    for (int i = ar.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      float a = ar[index];
	      ar[index] = ar[i];
	      ar[i] = a;
	      String b=sr[index];
	      sr[index]=sr[i];
	      sr[i]=b;
	    }
	  }

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed(
				);
	}
	
	
		
		
		
	}


