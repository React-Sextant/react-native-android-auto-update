package com.loveplusplus.update;

import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.Promise;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import android.app.Activity;
import android.content.Intent;

public class AndroidAutoUpdateModule extends ReactContextBaseJavaModule implements LifecycleEventListener {

    private static ReactApplicationContext context;
    public AndroidAutoUpdateModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.context = reactContext;
    }

    @ReactMethod
    public void goToDownload (String url){
        final Activity activity = getCurrentActivity();
        Intent intent = new Intent(activity.getApplicationContext(), DownloadService.class);
        intent.putExtra(Constants.APK_DOWNLOAD_URL, url);
        activity.startService(intent);
    }

    public static void sendProgress(int msg) {
        context.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit("LUOKUN_LOAD_PROGRESS", msg);
    }
    public static void sendError(String msg) {
        context.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit("LUOKUN_LOAD_ERROR", msg);
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
        return "RNAndroidAutoUpdate";
    }
}
