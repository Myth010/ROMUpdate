package com.myth.romupdater;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.app.*;


public class MainActivity extends Activity implements OnMenuItemClickListener
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Button button2 = (Button) findViewById(R.id.button2);
		
		button2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String command[]={"su", "-c", "ls /data"};
				Shell shell = new Shell();
				String text = shell.sendShellCommand(command);
				setNewTextInTextView(text);
				
			}
		});
	}
	public void setNewTextInTextView(String text) {
		TextView tv = new TextView(this);
		tv.setText(text);
		setContentView(tv);
	}
	


	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Item selection handling
		switch (item.getItemId()) {
			case R.id.menu_settings:
			    Intent settings = new Intent(this, mainsettings.class);
				startActivity(settings);
				return true;
			default:
			    return super.onOptionsItemSelected(item);
		}
	}
	public void pathPopup(View view)
	{
	    PopupMenu popup = new PopupMenu(this, view);
	    MenuInflater inflater = popup.getMenuInflater();
	    inflater.inflate(R.menu.actions, popup.getMenu());
	    popup.setOnMenuItemClickListener(this);
	    popup.show();
	}
	@Override
	public boolean onMenuItemClick(MenuItem item)
	{
	    switch (item.getItemId())
		{
	        case R.id.path1:
	            Intent action1 = new Intent(this, path1.class);
	            startActivity(action1);
	            return true;
	        case R.id.path2:
	            Intent action2 = new Intent(this, path2.class);
	            startActivity(action2);
	            return true;
			case R.id.menu_settings:
			    Intent intent = new Intent(this, mainsettings.class);
				startActivity(intent);
				return true;
	        default:
	            return false;
	    }
	}
}
