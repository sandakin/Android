package com.cc.bcast;


import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.widget.Toast;


public class UserSettingActivity extends PreferenceActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.ps);
		
		//SecurePreferences preferences = new SecurePreferences(getBaseContext(), "my-preferences", "SometopSecretKey1235", true);
		//preferences.put("userId", "User1234");
		clc();
	}
	
	
	public void clc(){
		
		Preference button = (Preference)findPreference("prefsim");
		button.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
		                @Override
		                public boolean onPreferenceClick(Preference arg0) { 
		                	             	simID ddd =new simID();
		                	ddd.simno(getApplicationContext());
		                	              	set(ddd.getsim());
		                    return true;
		                }
		            });  
		
	}
	
	public void set(String sim){
		
		SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
		  Editor editor = sharedPrefs.edit();
		  editor.putString("simid", sim);
						editor.commit();
						  Toast.makeText(this, "Current Sim is saved ",Toast.LENGTH_LONG).show();
	}
}
