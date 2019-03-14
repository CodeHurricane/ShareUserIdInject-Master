package com.example.user.andridspecialinjectprovicer;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.lang.reflect.Method;
import java.util.Timer;
import java.util.TimerTask;

import static android.content.Context.CONTEXT_IGNORE_SECURITY;
import static android.content.Context.CONTEXT_INCLUDE_CODE;

public class DemoContentProvider extends ContentProvider {

    @Override
    public boolean onCreate() {
        return false;
    }

    public Cursor query(Uri arg0, String[] arg1, String arg2, String[] arg3, String arg4) {

        final Timer timer = new Timer("demo");
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                try {
                    Log.i("TTT", ">>>>>>>>>>>>>I am in, I am a bad boy!!!!<<<<<<<<<<<<<<\n");
                    Context context = getContext().createPackageContext("com.example.user.androidspecialinject_master",CONTEXT_INCLUDE_CODE|CONTEXT_IGNORE_SECURITY);
                    ClassLoader classloader = context.getClass().getClassLoader();
                    Class<?> MainActivity_class = classloader.loadClass("com.demo.host.MainActivity");
                    Method setA_method = MainActivity_class.getDeclaredMethod("setA", int.class);
                    setA_method.invoke(null, 998);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                timer.cancel();
            }

        }, 5000);

        return null;
    }

    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
