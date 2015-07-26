package com.cc.bcast;



import android.os.Bundle;
import android.app.Activity;

import android.text.Html;
import android.text.method.LinkMovementMethod;

import android.widget.TextView;

public class Help extends Activity {
	//Button button1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_help);
		 TextView textView = (TextView) findViewById (R.id.help);
		 textView.setMovementMethod (LinkMovementMethod.getInstance());
		    textView.setText (Html.fromHtml (getString (R.string.help)));
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.bcast, menu);
//		return true;
//	}


	
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//
//		switch (item.getItemId()) {
//
//		
//		
//		}
//return true;
//}
	 

}
