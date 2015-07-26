package com.cc.bcast;

import java.io.InputStream;

import java.net.HttpURLConnection;
import java.net.URL;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.content.Context;
import android.util.Log;



public class Getxmll  {
	private String stat="0"  ;
	private String lat="0" ;
	String lon;
	private String urlString = null;
	
//	 private String urlString = "http://www.opencellid.org/cell/get?key=21c6a850-0b95-4396-b85c-d5eee7cf956c&mcc=260&mnc=2&lac=10250&cellid=26511";
	   private XmlPullParserFactory xmlFactoryObject;
	   public volatile boolean parsingComplete = true;
Context context;
public String dd="ok";

public Getxmll(String url){
    this.urlString = url;
 }

public String getlat(){
    return lat;
 }
public String getlon(){
    	return lon;
 }	 
public String getstat(){
	return stat;
}

public void parseXMLAndStoreIt(XmlPullParser myParser) {
	 //Toast.makeText(getApplicationContext(),"here", Toast.LENGTH_LONG).show();
	      int event;
	   
	    //  String text=null;
	      try {
	         event = myParser.getEventType();
	         while (event != XmlPullParser.END_DOCUMENT) {
	            String name=myParser.getName();
	            switch (event){
	               case XmlPullParser.START_TAG:
	            	   if(name.equals("rsp")){
	                      stat = myParser.getAttributeValue(null,"stat");
	                  }
	               case XmlPullParser.TEXT:
	          //  text = myParser.getText();
	               break;

	               case XmlPullParser.END_TAG:
	            	   if(name.equals("cell")){
	                       lat = myParser.getAttributeValue(null,"lat");
	                       lon = myParser.getAttributeValue(null,"lon"); 
	                  }
	                  else{
	                  }
	                  break;
	                  }		 
	                  event = myParser.next(); 

	              }
	                 parsingComplete = false;
	  
	      } catch (Exception e) {
	         e.printStackTrace();
	         Log.e(e.toString(),"ffhuhu");
	         parsingComplete = false;
	        
	      }

	   }

	 public void fetchXML(){

	      Thread thread = new Thread(new Runnable(){
	         @Override
	         public void run() {
	            try {
	            	Thread.sleep(2000);
	            	// Log.i("me","thread"); 
	            	//Toast.makeText(context,"start", Toast.LENGTH_LONG).show();
	               URL url = new URL(urlString);
	               HttpURLConnection conn = (HttpURLConnection) 
	               url.openConnection();
	                  conn.setReadTimeout(10000 /* milliseconds */);
	                  conn.setConnectTimeout(10000 /* milliseconds */);
	                  conn.setRequestMethod("GET");
	                  conn.setDoInput(true);
	                  conn.connect();
	            InputStream stream = conn.getInputStream();

	            xmlFactoryObject = XmlPullParserFactory.newInstance();
	            XmlPullParser myparser = xmlFactoryObject.newPullParser();

	            myparser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES
	            , false);
	            myparser.setInput(stream, null);
	            parseXMLAndStoreIt(myparser);
	            stream.close();
	            
	           //conn.disconnect();
	            } catch (Exception e) {
	               e.printStackTrace();
	               Log.e(e.toString(),"huhu");
	             parsingComplete = false;
	            dd="coner";
	            }
	        }
	    });

	    thread.start(); 
	    


	   }
	 
	
	   
		
}