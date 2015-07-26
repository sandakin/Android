package com.cc.bcast;

import android.content.Context;
import android.telephony.TelephonyManager;

public class simID {
	String simno;
	
	public String getsim(){
		return simno;
	}

	
	public void simno(Context context){
		
		TelephonyManager tm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE); 
		simno = tm.getSimSerialNumber();
//		editText4.setText(number);
		
	}

}
