package com.cc.bcast;

//import android.app.Activity;
import android.content.Context;
//import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
//import android.widget.Toast;
import android.widget.Toast;


//import android.app.Activity;


public class Del  {
//	String MobileNumber="15555215554";
	public void deleteMessage(String MobileNumber,Context cc)
		 {
		 		//Toast.makeText(cc,"in Del"+ MobileNumber, Toast.LENGTH_SHORT).show();
		 
		 Uri uriSms = Uri.parse("content://sms/inbox");
	     Cursor c = cc.getContentResolver().query(uriSms, null, null, null, null); 
	     //c.moveToFirst(); 

	     while (c.moveToNext())
	     {
	      //   System.out.println("Inside if loop");

	         try
	         {
	             String address = c.getString(2);
	             //String MobileNumber = getParameterData().getMobileNumber().trim();

	             //Log.i( LOGTAG, MobileNumber + "," + address );

	             Log.i( "LOGTAG", c.getString(2) );


	             if ( address.trim().equals( MobileNumber ) )
	             {
	                 String pid = c.getString(0);
	                 String uri = "content://sms/conversations/" + pid;
//	                 wait(1000);
	                 cc.getContentResolver().delete(Uri.parse(uri), null, null);
	                 break;
	             }
	         }
	         catch (Exception e)
	         {
	             e.printStackTrace();
	             Toast.makeText(cc,"exception"+ MobileNumber, Toast.LENGTH_SHORT).show();
	         }
	     } 
	 }

//	
	
}
