package com.loveplusplus.update;


import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.FileProvider;

import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

import android.app.Activity;
import java.io.File;
import java.util.List;

public class AndroidAutoUpdateModule extends ReactContextBaseJavaModule implements LifecycleEventListener {

    public AndroidAutoUpdateModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @ReactMethod
    public void checkForNotification (String url, ReadableMap params){
        final Activity activity = getCurrentActivity();
        //设置apk下载地址
        new Constants().setAPK_DOWNLOAD_URL(url);
        //设置apk版本更新信息
        new Constants().setAPK_UPDATE_CONTENT(params.getString("updateMessage"));
        //设置versionCode
        new Constants().setAPK_VERSION_CODE(params.getString("versionCode"));

        //使用Notification广播更新
        UpdateChecker.checkForNotification(activity);
    }

    @ReactMethod
    public void checkForDialog (String url, ReadableMap params){
        final Activity activity = getCurrentActivity();
        new Constants().setAPK_DOWNLOAD_URL(url);
        new Constants().setAPK_UPDATE_CONTENT(params.getString("updateMessage"));

        //使用Dialog询问更新
        UpdateChecker.checkForDialog(activity);
    }


    @Override
    public void onHostResume() {

    }
    @Override
    public void onHostPause() {

    }

    @Override
    public void onHostDestroy() {
    }

    @Override
    public String getName() {
        return "AndroidAutoUpdate";
    }
}
