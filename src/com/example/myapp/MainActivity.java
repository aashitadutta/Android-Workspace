package com.example.myapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
Button play_song,stop_song;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String string = getString(R.string.hello);
        Toast.makeText(getApplicationContext(),"onCreate() callback",Toast.LENGTH_SHORT).show();
        
        play_song=(Button) findViewById(R.id.button1);
        stop_song=(Button) findViewById(R.id.button2);
        play_song.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent service = new Intent(MainActivity.this, ServiceRun.class);
				startService(service);
				Toast.makeText(getApplicationContext(),"Playing Song",Toast.LENGTH_SHORT).show();
			}
		});
        stop_song.setOnClickListener(new View.OnClickListener(){
        	@Override
			public void onClick(View v) {
				Intent service = new Intent(MainActivity.this, ServiceRun.class);
				stopService(service);
				Toast.makeText(getApplicationContext(),"Song is stopped",Toast.LENGTH_SHORT).show();
			}
		});
        
    }
    @Override
    protected void onStart(){
    	super.onStart();
    	Toast.makeText(getApplicationContext(),"onStart()callback",Toast.LENGTH_SHORT).show();
    }
   
    @Override
    protected void onResume(){
    	super.onResume();
    	Toast.makeText(getApplicationContext(),"Application is started",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause(){
    	super.onPause();
    	Toast.makeText(getApplicationContext(),"onPause()callback",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop(){
    	super.onStop();
    	Toast.makeText(getApplicationContext(),"onStop()callback",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy(){
    	super.onDestroy();
    	Toast.makeText(getApplicationContext(),"onDestroy()callback",Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
}
