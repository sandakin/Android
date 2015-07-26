package com.cc.bcast;

import android.content.Context;

import android.util.Log;


public class getloc {
//	private Getxmll obj;
//	private getids obj2;
	private String lat="0",lon="0",mnc,mcc,cid,lac,gpstatus;
	
    
	String finalUrl = "http://www.opencellid.org/cell/get?key=21c6a850-0b95-4396-b85c-d5eee7cf956c";
	
	public String getlat(){
	    return lat;
	 }
	public String getlon(){
	    	return lon;
	}
	
	public String getstat(){
    	return gpstatus;
}
	public void nogps(Context ct){
		getids obj2 =new getids();
		obj2.getid(ct);
		
		cid=obj2.getCid();
		lac=obj2.getLac();
		mcc=obj2.getmcc();
		mnc=obj2.getmnc();
//		cid="199226";
//		lac="20300";
//		mcc="413";
//		mnc="8";
		// Toast.makeText(ct,"here", Toast.LENGTH_LONG).show();
		
		Log.i("me","before sm");
//		        SmsManager sms = SmsManager.getDefault();
//		        sms.sendTextMessage("15555215556", null, finalUrl+"&mcc="+mcc+"&mnc="+mnc+"&lac="+lac+"&cellid="+cid, null, null);
		
		
		try{
			  data dt= new data();
			  if(!dt.netCheckin(ct)){
				  dt.turnOnDataConnection(true, ct);
			  }
			  
			   
			Getxmll obj = new Getxmll(finalUrl+"&mcc="+mcc+"&mnc="+mnc+"&lac="+lac+"&cellid="+cid); 
		  
		    
	      obj.fetchXML();
	      Log.i("me","Fetch");
	     while(obj.parsingComplete);
//	     lat= obj.getlat();
//	     lon= obj.getlon();
//	     gpstatus="online";
		      if(obj.getstat().toString().equals("ok"))
	      {
			     lat= obj.getlat();
			     lon= obj.getlon();
			     gpstatus="online";
	      }else if(obj.getstat().toString().equals("fail"))
	      {
	    	  lat="netowrk connection error";
	    	  lon="netowrk connection error";
	    	  gpstatus="onlinena";
	      }else //if(obj.getstat().toString().equals("Null"))
	      {
	    	  lat="N/A";
	    	  lon="N/A";
	    	  gpstatus="offline";
	      }
		     	}catch (Exception e) {
		     		//Toast.makeText(ct,"connection here error", Toast.LENGTH_LONG).show();
		    	 Log.e("me",e.toString());
		     	}
//	      if(obj.dd.equals("coner"))
//	      {
//	    	  Toast.makeText(getApplicationContext(),"connection error", Toast.LENGTH_LONG).show();
//	      }
//	      else if(obj.dd.equals("reader"))
//	      {
//	    	  Toast.makeText(getApplicationContext(),"xml error", Toast.LENGTH_LONG).show();
//	      }
	}
	
	public void get(Context ct)
	{
		
//		AppLocationManager appLocationManager = new AppLocationManager(ct);
//		 lat=appLocationManager.getLatitude();
//		 lon= appLocationManager.getLongitude();
//		
//		 gpstatus="ok";
	    GPSTracker mGPS = new GPSTracker(ct);
			 if(mGPS.canGetLocation ){
				    mGPS.getLocation();
				    lat=Double.toString(mGPS.getLatitude());
				    lon=Double.toString(mGPS.getLongitude());
				    if(lat.equals("0.0")||lon.equals("0.0"))
				    	nogps(ct);
				    else{
				    	 gpstatus="ok";
				    }
				   
				    }
			 else{
				        nogps(ct);
				    }	    
	}
	
	

}
