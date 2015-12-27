package com.example.administrator.tabshostdemo.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.tabshostdemo.logging.DebugLog;
import com.example.administrator.tabshostdemo.R;
import com.example.administrator.tabshostdemo.activitys.base.MainTabFragmentActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread welcomeThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(500);  //Delay of 5 seconds
                } catch (Exception e) {

                } finally {

                    route();
                }
            }
        };
        welcomeThread.start();
    }

    private void route() {
        DebugLog.v("verbose","ok");
        startActivity(new Intent(MainActivity.this, MainTabFragmentActivity.class));
    }
}
