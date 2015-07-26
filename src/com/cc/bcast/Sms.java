package com.cc.bcast;

import android.media.AudioManager;

import android.os.Bundle;
import android.preference.PreferenceManager;

import android.content.BroadcastReceiver;
//import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.telephony.SmsManager;

import android.telephony.SmsMessage;

import android.widget.Toast;




public class Sms extends BroadcastReceiver
{
	private AudioManager myAudioManager;
	String ns = Context.AUDIO_SERVICE;
	 
 
	
    @Override
    public void onReceive(Context context, Intent intent) 
    {
//    	Bcast s=new Bcast();
    	//s.loadSavedPreferences();
    	SharedPreferences prefn=PreferenceManager.getDefaultSharedPreferences(context);
    	String pw = prefn.getString("prefpw", null);
    	
    	String silent = prefn.getString("prefskey", null);
    	String normal = prefn.getString("prefnkey", null);
    	String locat = prefn.getString("preflkey", null);
    	
    	//Toast.makeText(context, name+name1+name2, Toast.LENGTH_LONG).show();
    	 
    	myAudioManager = (AudioManager)context.getSystemService(ns);
        //---get the SMS message passed in---
        Bundle bundle = intent.getExtras();        
        SmsMessage[] msgs = null;
        String messageReceived = "";            
        if (bundle != null)
        {
            //---retrieve the SMS message received---
           Object[] pdus = (Object[]) bundle.get("pdus");
            msgs = new SmsMessage[pdus.length];            
            for (int i=0; i<msgs.length; i++)

            {
                msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);                
                messageReceived += msgs[i].getMessageBody().toString();
                messageReceived += "\n";    
                              
                }
            }
        Del nn =new Del();
        for (SmsMessage msg : msgs) {
            if (msg.getMessageBody().equals(pw+" "+silent)) {
            	abortBroadcast();
            	// Toast.makeText(context, "this"+messageReceived, Toast.LENGTH_SHORT).show();
            	 myAudioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
            	           	
            	 Toast.makeText(context,  "in silent", Toast.LENGTH_SHORT).show(); 
            	    
            	 //String nums=msg.getOriginatingAddress();
            	 
            	 nn.deleteMessage(msg.getOriginatingAddress(),context);
            	 sendSMS(msg.getOriginatingAddress(), "in silent");
            	            	 
            }else if (msg.getMessageBody().equals(pw+" "+normal)){
            	abortBroadcast();
            	// Toast.makeText(context, messageReceived, Toast.LENGTH_SHORT).show();
            	 myAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
            	 Toast.makeText(context,  "in Normal", Toast.LENGTH_SHORT).show(); 
         	    
            	// String numn=msg.getOriginatingAddress();
            	
            	 nn.deleteMessage(msg.getOriginatingAddress(),context);
            	 sendSMS(msg.getOriginatingAddress(), "in Normal");
            	 
            } else if (msg.getMessageBody().equals(pw+" "+locat)){
            	abortBroadcast();
           	// Toast.makeText(context, messageReceived, Toast.LENGTH_SHORT).show();
           	 getloc gg=new getloc();
           	 gg.get(context);
          // 	Toast.makeText(context, gg.getlat()+gg.getlon(), Toast.LENGTH_SHORT).show();
        //   	https://maps.google.com/?q=28.417,77.173(My location in the middle of no where)
       //    	sendSMS(msg.getOriginatingAddress(), "https://www.google.com/maps/@"+gg.getlat()+","+gg.getlon()+",10z(Here)");
          	
           	 //myAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
           	if(gg.getstat().equals("ok"))
           	{sendSMS(msg.getOriginatingAddress(), "phone location:- https://maps.google.com/?q="+gg.getlat().toString()+","+gg.getlon().toString());    	
           	nn.deleteMessage(msg.getOriginatingAddress(),context);
           		
           	}else if(gg.getstat().equals("online"))
           	{sendSMS(msg.getOriginatingAddress(), "phone location(not 100% accurate).Open this link using a Web Browser https://maps.google.com/?q="+gg.getlat().toString()+","+gg.getlon().toString());    	
           	nn.deleteMessage(msg.getOriginatingAddress(),context);
           		
           	}else if(gg.getstat().equals("onlinena"))
           	{
           			getids obj2 =new getids();
    		obj2.getid(context);
           		//sendSMS(msg.getOriginatingAddress(),"phone location(not 100%  olna ) http://www.opencellid.org/#&action=locations.cell&mcc="+obj2.getmcc()+"&mnc="+obj2.getmnc()+"&lac="+obj2.getLac()+"&cellid="+obj2.getCid());    	
    		sendSMS(msg.getOriginatingAddress(),"phone location(not 100% accurate).Open this link using a Web Browser http://www.open-electronics.org/celltrack/cell.php?hex=0&mcc="+obj2.getmcc()+"&mnc="+obj2.getmnc()+"&lac="+obj2.getLac()+"&cid="+obj2.getCid());    	

    		nn.deleteMessage(msg.getOriginatingAddress(),context);
           	}else if(gg.getstat().equals("offline"))
           	{	getids obj2 =new getids();
    		obj2.getid(context);
    		//http://www.open-electronics.org/celltrack/cell.php?hex=0&mcc=413&mnc=1&lac=60300&cid=28481
           		//	sendSMS(msg.getOriginatingAddress(),"phone location(not 100% ofln ) http://www.opencellid.org/#&action=locations.cell&mcc="+obj2.getmcc()+"&mnc="+obj2.getmnc()+"&lac="+obj2.getLac()+"&cellid="+obj2.getCid());    	
    		sendSMS(msg.getOriginatingAddress(),"phone location(not 100% accurate).Open this link using a Web Browser http://www.open-electronics.org/celltrack/cell.php?hex=0&mcc="+obj2.getmcc()+"&mnc="+obj2.getmnc()+"&lac="+obj2.getLac()+"&cid="+obj2.getCid());    	
             nn.deleteMessage(msg.getOriginatingAddress(),context);
           	}
            
            }else if(msg.getMessageBody().matches(pw+".*"))
            {	
            	abortBroadcast();
            	nn.deleteMessage(msg.getOriginatingAddress(),context);
            }
            
         
            //end if
        }
             

       }  
    
    private void sendSMS(String phoneNumber, String message)
    {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);
     }
    
//    
    
    }
