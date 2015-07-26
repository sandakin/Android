package com.cc.bcast;





import android.R.color;
import android.os.Bundle;
import android.preference.PreferenceManager;

import android.app.Activity;
import android.app.AlertDialog;


import android.content.DialogInterface;
import android.content.Intent;
//import android.content.Context;
//import android.content.Context;
import android.content.SharedPreferences;

import android.graphics.Color;

//import android.telephony.ServiceState;

//import android.telephony.SmsMessage;
//import android.telephony.TelephonyManager;
//import android.telephony.gsm.GsmCellLocation;


import android.text.Html;
import android.text.method.PasswordTransformationMethod;
import android.view.Menu;


import android.view.MenuItem;

//import android.content.res.AssetFileDescriptor;


import android.widget.EditText;
import android.widget.Toast;


import android.widget.TextView;


public class Bcast extends Activity {
	private static final int RESULT_SETTINGS = 1;
//	Button button1;
	//EditText editText1,editText2,editText3,editText4;
	//	String finalUrl = "http://api.openweathermap.org/data/2.5/weather?q=london&mode=xml";
	TextView text,text2;
	@Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_bcast);
      text=(TextView)findViewById(R.id.textView11);
      text2=(TextView)findViewById(R.id.textView12);
      
     pw();
  
      showUserSettings();
   // addListenerOnButton();
//    loadSavedPreferences();
   }
   
//	@Override
//	public boolean onKeyDown(int keycode, KeyEvent e) {
//		 final Context context = this;
//	    switch(keycode) {
//	        case KeyEvent.KEYCODE_MENU:
//	          	Intent intent = new Intent(context, home.class);
//		    	startActivity(intent); 
//	            return true;
//	    }
//
//	    return super.onKeyDown(keycode, e);
//	}
   
	
	
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {

		case R.id.action_settings:
			Intent i = new Intent(this, UserSettingActivity.class);
			startActivityForResult(i, RESULT_SETTINGS);
			return true;

		case R.id.item1:
//			Toast.makeText(getApplicationContext(),"activity", Toast.LENGTH_LONG).show();
			Intent i2 = new Intent(this, Help.class);
			startActivityForResult(i2, RESULT_SETTINGS);
			// setContentView(R.layout.activity_help);
//			alert.show();
			 return true;
		default:
	        return super.onOptionsItemSelected(item);
		}

		//return true; 
	    
	}

	
   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      getMenuInflater().inflate(R.menu.bcast, menu);
      return true;
   }
   
   @Override
   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       super.onActivityResult(requestCode, resultCode, data);

       switch (requestCode) {
       case RESULT_SETTINGS:
           showUserSettings();
           break;

       }

   }

   private void showUserSettings() {
       SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
      // SharedPreferences sharedPrefs=getApplicationContext(). getSharedPreferences("new", Context.MODE_PRIVATE);
       String pw=sharedPrefs.getString("prefpw", "N/A");
       String fphone=sharedPrefs.getString("prefpno", "N/A");
       String skey=sharedPrefs.getString("prefskey", "N/A");
       String nkey=sharedPrefs.getString("prefnkey", "N/A");
       String lkey=sharedPrefs.getString("preflkey", "N/A");
       String simid=sharedPrefs.getString("simid", "N/A");
       
       TextView pw1 = (TextView) findViewById(R.id.textView1);
       TextView pw2 = (TextView) findViewById(R.id.textView2);
       TextView fphone1 = (TextView) findViewById(R.id.textView3);
       TextView fphone2 = (TextView) findViewById(R.id.textView4);
       TextView skey1 = (TextView) findViewById(R.id.textView5);
       TextView skey2 = (TextView) findViewById(R.id.textView6);
       TextView nkey1 = (TextView) findViewById(R.id.textView7);
       TextView nkey2 = (TextView) findViewById(R.id.textView8);
       TextView lkey1 = (TextView) findViewById(R.id.textView9);
       TextView lkey2 = (TextView) findViewById(R.id.textView10);
       TextView simid1 = (TextView) findViewById(R.id.textView11);
       TextView simid2= (TextView) findViewById(R.id.textView12);
       
       
       simID ddd =new simID();
   	    ddd.simno(getApplicationContext());
   	              	ddd.getsim();
   	   
   	              	
       if(pw.compareTo("N/A")==0||pw.compareTo("")==0)
       {
    	   String text = ""+pw+"<font color=\"#D80000\"> ✖</font> ";
    	  
    	   pw1.setBackgroundColor(Color.RED);
    	   pw2.setText(Html.fromHtml(text));
       }else{

    	   
    	  String text = ""+pw+"<font color=\"#009933\"> ✔</font> ";
    	  
    	     pw1.setBackgroundColor(Color.rgb(100, 255, 130));
    	    pw1.setBackgroundColor(color.background_light);
    	       pw2.setText(Html.fromHtml(text)); 
       }
       
       if(fphone.compareTo("N/A")==0||fphone.compareTo("")==0)
       {   String text = ""+fphone+"<font color=\"#D80000\"> ✖</font> ";
    	   
    	   fphone1.setBackgroundColor(Color.RED);
    	   fphone2.setText(Html.fromHtml(text));
       }else{
    	   String text = ""+fphone+"<font color=\"#009933\"> ✔</font> ";
    	   fphone1.setBackgroundColor(color.background_light);
    	   fphone2.setText(Html.fromHtml(text)); 
       }
       
       if(skey.compareTo("N/A")==0||skey.compareTo("")==0)
       {String text = ""+skey+"<font color=\"#D80000\"> ✖</font> ";
    	   skey1.setBackgroundColor(Color.RED);
    	   skey2.setText(Html.fromHtml(text));
       }else{
    	   String text = ""+skey+"<font color=\"#009933\"> ✔</font> ";
    	   skey1.setBackgroundColor(color.background_light);
    	   skey2.setText(Html.fromHtml(text)); 
       }
       
       if(nkey.compareTo("N/A")==0||nkey.compareTo("")==0)
       {String text = ""+nkey+"<font color=\"#D80000\"> ✖</font> ";
    	   nkey1.setBackgroundColor(Color.RED);
    	   nkey2.setText(Html.fromHtml(text));
       }else{
    	   String text = ""+nkey+"<font color=\"#009933\"> ✔</font> ";
    	   nkey1.setBackgroundColor(color.background_light);
    	   nkey2.setText(Html.fromHtml(text)); 
       }
       
       if(lkey.compareTo("N/A")==0||lkey.compareTo("")==0)
       {String text = ""+lkey+"<font color=\"#D80000\"> ✖</font> ";
    	   lkey1.setBackgroundColor(Color.RED);
    	   lkey2.setText(Html.fromHtml(text));
       }else{
    	   String text = ""+lkey+"<font color=\"#009933\"> ✔</font> ";
    	   lkey1.setBackgroundColor(color.background_light);
    	   lkey2.setText(Html.fromHtml(text)); 
       }
       
       if(simid.compareTo("N/A")==0||lkey.compareTo("")==0)
       {String text = "<font color=\"#D80000\">Not set ✖</font> ";
    	   simid1.setBackgroundColor(Color.RED);
    	   simid2.setText(Html.fromHtml(text));
       }else if(simid.compareTo(ddd.getsim())!=0) {
    	   String text = "<font color=\"#D80000\">Current SIM is not added to the APP ✖</font> "; 
    	   simid1.setBackgroundColor(Color.RED);
    	   simid2.setText(Html.fromHtml(text));
    	 
       }else{
    	   String text = "OK<font color=\"#009933\"> ✔</font> ";
    	   simid1.setBackgroundColor(color.background_light);
    	   simid2.setText(Html.fromHtml(text));  
    	   
       }
       
//       StringBuilder builder = new StringBuilder();
//
//       builder.append("\n Password: "
//               + sharedPrefs.getString("prefpw", "NULL"));
//
//       builder.append("\n SIM ID:  "
//               + sharedPrefs.getString("simid", "NULL"));
//
//       builder.append("\n Friends Phone Number: "
//               + sharedPrefs.getString("prefpno", "NULL"));
//       builder.append("\n Silent Mode Keyword: "
//               + sharedPrefs.getString("prefskey", "NULL"));
//       builder.append("\n Normal Mode Keyword: "
//               + sharedPrefs.getString("prefnkey", "NULL"));
       

      
   }
   

   
   public void pw(){
   	
   	AlertDialog.Builder alert = new AlertDialog.Builder(this);
   	AlertDialog.Builder alert2 = new AlertDialog.Builder(this);
   	alert2.setTitle("Login");
   	alert2.setMessage("Configure A Password");
  	
   	final Intent i = new Intent(this, UserSettingActivity.class);	
   	alert2.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
   		
   	   	public void onClick(DialogInterface dialog, int whichButton) {
   	   	
   	   	startActivityForResult(i, RESULT_SETTINGS);	
   	 
   	   	  }
   	   	});
   	
   	
   	SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
   	final String aa=sp. getString("prefpw", "NULL");
   	alert.setTitle("Login");
   	alert.setMessage("Enter Password");

   	// Set an EditText view to get user input 
   	final EditText input = new EditText(this);
   	
   	input.setTransformationMethod(PasswordTransformationMethod.getInstance());
   	alert.setView(input);

   	alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
   	public void onClick(DialogInterface dialog, int whichButton) {
   		
   	  String value = input.getText().toString();
//   	   Do something with value!
   	  if(aa.compareTo(value)==0){
   		  
   		  Toast.makeText(getApplicationContext(),"Login OK", Toast.LENGTH_LONG).show();
   	  }else{
   		  Toast.makeText(getApplicationContext(),"Wrong password", Toast.LENGTH_LONG).show();
   		  pw();
   	  }
   	
   	  }
   	});

   	alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
   	  public void onClick(DialogInterface dialog, int whichButton) {
   	    // Canceled.
   		  Bcast.this.finish();
   	  }
   	});
   	if(aa.compareTo("NULL")==0){
   		alert2.show();
   	}else{
   	alert.show();
   	}
//   	alert.show();
   }
   
   
   
//   public void addListenerOnButton() {
//		 
//		button1 = (Button) findViewById(R.id.button1);
//
//		button1.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View arg0) {
//}
//
//		});
//		
//	}
			
				
	  
	


  
   
}
