package com.cc.bcast;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;

public class data {

	
	int bv = Build.VERSION.SDK_INT;

	boolean turnOnDataConnection(boolean ON,Context context)
	 {

	     try{
	      if(bv == Build.VERSION_CODES.FROYO)

	         {
	          Method dataConnSwitchmethod;
	            Class<?> telephonyManagerClass;
	            Object ITelephonyStub;
	            Class<?> ITelephonyClass;

	            TelephonyManager telephonyManager = (TelephonyManager) context
	                    .getSystemService(Context.TELEPHONY_SERVICE);

	            telephonyManagerClass = Class.forName(telephonyManager.getClass().getName());
	            Method getITelephonyMethod = telephonyManagerClass.getDeclaredMethod("getITelephony");
	            getITelephonyMethod.setAccessible(true);
	            ITelephonyStub = getITelephonyMethod.invoke(telephonyManager);
	            ITelephonyClass = Class.forName(ITelephonyStub.getClass().getName());

	            if (ON) {
	                dataConnSwitchmethod = ITelephonyClass
	                        .getDeclaredMethod("enableDataConnectivity");
	            } else {
	                dataConnSwitchmethod = ITelephonyClass
	                        .getDeclaredMethod("disableDataConnectivity");   
	            }
	            dataConnSwitchmethod.setAccessible(true);
	            dataConnSwitchmethod.invoke(ITelephonyStub);

	           }
	         else
	           {
	             //log.i("App running on Ginger bread+");
	             final ConnectivityManager conman = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
	             final Class<?> conmanClass = Class.forName(conman.getClass().getName());
	             final Field iConnectivityManagerField = conmanClass.getDeclaredField("mService");
	             iConnectivityManagerField.setAccessible(true);
	             final Object iConnectivityManager = iConnectivityManagerField.get(conman);
	             final Class<?> iConnectivityManagerClass =  Class.forName(iConnectivityManager.getClass().getName());
	             final Method setMobileDataEnabledMethod = iConnectivityManagerClass.getDeclaredMethod("setMobileDataEnabled", Boolean.TYPE);
	             setMobileDataEnabledMethod.setAccessible(true);
	             setMobileDataEnabledMethod.invoke(iConnectivityManager, ON);
	           }


	         return true;
	     }catch(Exception e){
	                        Log.e("TAG","error turning on/off data");

	                        return false;
	                        }

	 }
	
	public boolean netCheckin(Context context) {
	    try {
	        ConnectivityManager nInfo = (ConnectivityManager)context. getSystemService(Context.CONNECTIVITY_SERVICE);
	        nInfo.getActiveNetworkInfo().isConnectedOrConnecting();
	        Log.d("tag", "Net avail:"
	            + nInfo.getActiveNetworkInfo().isConnectedOrConnecting());
	        ConnectivityManager cm = (ConnectivityManager)context. getSystemService(Context.CONNECTIVITY_SERVICE);
	        NetworkInfo netInfo = cm.getActiveNetworkInfo();
	        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
	            Log.d("tag", "Network available:true");
	            return true;
	        } else {
	            Log.d("tag", "Network available:false");
	            return false;
	        }
	    } catch (Exception e) {
	        return false;
	    }
	}
	
}
