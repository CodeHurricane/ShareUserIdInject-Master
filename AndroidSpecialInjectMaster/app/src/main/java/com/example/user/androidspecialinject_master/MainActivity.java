package com.example.user.androidspecialinject_master;

import android.content.ContentResolver;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static int sA = 1;

    public static void setA(int a) {
        sA = a;
    }

    public static int getA() {
        return sA;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ContentResolver resolver = getContentResolver();
        Uri uri = Uri.parse("content://demo_contentprovider");
        resolver.query(uri, null, null, null, null);
        new Thread(){
            public void run() {
                while (true) {
                    Log.i("TTT", "" + getA());
                    setA(getA() + 1);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
