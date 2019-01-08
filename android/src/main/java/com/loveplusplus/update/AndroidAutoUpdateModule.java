package com.loveplusplus.update;

import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

import android.app.Activity;

public class AndroidAutoUpdateModule extends ReactContextBaseJavaModule implements LifecycleEventListener {

    public AndroidAutoUpdateModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @ReactMethod
    public void checkForNotification (String url, ReadableMap params){
        final Activity activity = getCurrentActivity();
        //设置apk下载地址
        new Constants().setUPDATE_URL(url);
        //设置apk版本更新信息
        new Constants().setAPK_UPDATE_CONTENT(params.getString("updateMessage"));

        //使用Notification广播更新
        UpdateChecker.checkForNotification(activity);
    }

    @ReactMethod
    public void checkForDialog (String url, ReadableMap params){
        final Activity activity = getCurrentActivity();
        new Constants().setUPDATE_URL(url);
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
