package com.igio90.fridainjectorexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;

import com.igio90.fridainjector.FridaAgent;
import com.igio90.fridainjector.FridaInjector;
import com.igio90.fridainjector.OnMessage;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements OnMessage {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            // build an instance of FridaInjector providing binaries for arm/arm64/x86/x86_64 as needed
            // assets/frida-inject-12.8.2-android-arm64

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                    while(true)
                    {

                        SystemClock.sleep(5000);
                        FridaInjector fridaInjector = new FridaInjector.Builder(MainActivity.this)
                                .withX86Injector("frida-inject-14.0.8-android-x86")
                                .build();

                        // build an instance of FridaAgent
                        FridaAgent fridaAgent = new FridaAgent.Builder(MainActivity.this)
                                .withAgentFromAssets("agent.js")
                                .withOnMessage(MainActivity.this)
                                .build();

                        // register a custom interface
                        fridaAgent.registerInterface("activityInterface", Interfaces.ActivityInterface.class);

                        String[] QQS = new String[]{"1948126147","2121644093"};

                        fridaInjector.inject(fridaAgent, "com.tencent.mobileqq", false, "2121644093");

                        Log.e("FridaAndroidInject", "mobileqq pid: ");
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
                }
            }).start();


    }

    @Override
    public void onMessage(String data) {
        try {
            JSONObject object = new JSONObject(data);
            Log.e("FridaAndroidInject", "whatsapp pid: " + object.getString("pid"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
