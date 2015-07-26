/**
 * 
 */
package com.cc.bcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.preference.PreferenceManager;
import android.telephony.SmsManager;
import android.widget.Toast;

/**
 * @author Chinthaka
 *
 */
public class BootStartUpReciever extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
//		 TODO:// This method is called when the BroadcastReceiver is receiving

		// Start Service On Boot Start Up
//		Intent service = new Intent(context, TestService.class);
//		context.startService(service);
		
		//Start App On Boot Start Up
//		Intent App = new Intent(context, MainActivity.class);
//		App.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//		context.startActivity(App);
		//Toast.makeText(context, "Service Created",Toast.LENGTH_LONG).show();
		simID dd=new simID();
		dd.simno(context);
		String sim=dd.getsim();
		//Toast.makeText(context, sim,1).show();
		SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
		String currentsim=sharedPrefs.getString("simid", "NULL");
		
if(sim.compareTo(currentsim)==0)
{
	Toast.makeText(context, "sim OK",Toast.LENGTH_LONG).show();
	
	}else{
		 //sendSMS(sharedPrefs.getString("prefpno", "N/A"), "in Normal");
		 SmsManager sms = SmsManager.getDefault();
	     sms.sendTextMessage(sharedPrefs.getString("prefpno", "N/A"), null, "Sim card changed", null, null);
		Toast.makeText(context, "sim changed",Toast.LENGTH_LONG).show();
	}
	}
}
