package com.cc.bcast;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class ActivityOfYourChoice extends Activity { 
	 
    @Override 
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
         Toast.makeText(this, "Use the application to clear data",Toast.LENGTH_LONG).show();
    } 
}