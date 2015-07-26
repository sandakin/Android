package com.cc.bcast;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;

public class getids {
	
private String cid,lac,mcc,mnc,num;

public String getCid(){
	return cid;
}	 
public String getLac(){
	return lac;
}
public String getmcc(){
	return mcc;
}
public String getmnc(){
	return mnc;
}
public String getnum(){
	return num;
}



public  void getid(Context context){
	 TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
   GsmCellLocation loc = (GsmCellLocation) tm.getCellLocation();
   String networkOperator = tm.getNetworkOperator();
   cid=Integer.toString(loc.getCid());
   
   lac=Integer.toString(loc.getLac());

	 
	 num = tm.getLine1Number();
   
   
  

   if (networkOperator != null) {
       mcc = networkOperator.substring(0, 3);
       mnc = networkOperator.substring(3);
   }
}
 


 

}
