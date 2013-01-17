package com.myth.romupdater;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;

public class mainsettings extends Activity	{

	@Override
	public void onCreate(Bundle savedInstanceState)	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainsettings);
	}
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
