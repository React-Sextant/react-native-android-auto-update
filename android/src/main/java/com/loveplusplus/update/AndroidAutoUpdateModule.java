package com.loveplusplus.update;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import constacne.DownLoadBy;
import constacne.UiType;
import model.UiConfig;
import model.UpdateConfig;
import update.UpdateAppUtils;
import listener.OnBtnClickListener;
import listener.UpdateDownloadListener;


public class AndroidAutoUpdateModule extends ReactContextBaseJavaModule {

    boolean disabledCancel = false;
    boolean disabledUpdate = false;
    ReadableMap mReadableMap;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();


    private static ReactApplicationContext context;
    public AndroidAutoUpdateModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.context = reactContext;
    }

    @ReactMethod
    public void UpdateApp(final ReadableMap map){
        mReadableMap = map;
        String apkUrl = "";
        String updateTitle = "";
        String updateContent = "";

        if(map.hasKey("apkUrl")){
            apkUrl = map.getString("apkUrl");
        }
        if(map.hasKey("updateTitle")){
            updateTitle = map.getString("updateTitle");
        }
        if(map.hasKey("updateContent")){
            updateContent = map.getString("updateContent");
        }

        //updateConfig
        UpdateConfig updateConfig = new UpdateConfig();
        if(map.hasKey("isDebug")){
            updateConfig.setDebug(map.getBoolean("isDebug"));
        }
        if(map.hasKey("force")){
            updateConfig.setForce(map.getBoolean("force"));
        }
        if(map.hasKey("apkSavePath")){
            updateConfig.setApkSavePath(map.getString("apkSavePath"));
        }
        if(map.hasKey("apkSaveName")){
            updateConfig.setApkSaveName(map.getString("apkSaveName"));
        }
        if(map.hasKey("downloadBy")){
            updateConfig.setDownloadBy(map.getInt("downloadBy"));
        }
        if(map.hasKey("needCheckMd5")){
            updateConfig.setNeedCheckMd5(map.getBoolean("needCheckMd5"));
        }
        if(map.hasKey("checkWifi")){
            updateConfig.setCheckWifi(map.getBoolean("checkWifi"));
        }
        if(map.hasKey("isShowNotification")){
            updateConfig.setShowNotification(map.getBoolean("isShowNotification"));
        }
        if(map.hasKey("serverVersionName")){
            updateConfig.setServerVersionName(map.getString("serverVersionName"));
        }
        if(map.hasKey("serverVersionCode")){
            updateConfig.setServerVersionCode(map.getInt("serverVersionCode"));
        }
        if(map.hasKey("alwaysShow")){
            updateConfig.setAlwaysShow(map.getBoolean("alwaysShow"));
        }
        if(map.hasKey("thisTimeShow")){
            updateConfig.setThisTimeShow(map.getBoolean("thisTimeShow"));
        }
        if(map.hasKey("alwaysShowDownLoadDialog")){
            updateConfig.setAlwaysShowDownLoadDialog(map.getBoolean("alwaysShowDownLoadDialog"));
        }
        if(map.hasKey("showDownloadingToast")){
            updateConfig.setShowDownloadingToast(map.getBoolean("showDownloadingToast"));
        }


        // uiConfig
        UiConfig uiConfig = new UiConfig();
        if(map.hasKey("uiType")){
            uiConfig.setUiType(map.getString("uiType"));
        }
        if(map.hasKey("titleTextSize")){
            uiConfig.setTitleTextSize((float)map.getInt("titleTextSize"));
        }
        if(map.hasKey("titleTextColor")){
            uiConfig.setTitleTextColor(map.getInt("titleTextColor"));
        }
        if(map.hasKey("contentTextSize")){
            uiConfig.setContentTextSize((float)map.getInt("contentTextSize"));
        }
        if(map.hasKey("contentTextColor")){
            uiConfig.setContentTextColor(map.getInt("contentTextColor"));
        }
        if(map.hasKey("updateBtnBgColor")){
            uiConfig.setUpdateBtnBgColor(map.getInt("updateBtnBgColor"));
        }
        if(map.hasKey("updateBtnTextColor")){
            uiConfig.setUpdateBtnTextColor(map.getInt("updateBtnTextColor"));
        }
        if(map.hasKey("updateBtnTextSize")){
            uiConfig.setUpdateBtnTextSize((float)map.getInt("updateBtnTextSize"));
        }
        if(map.hasKey("updateBtnText")){
            uiConfig.setUpdateBtnText(map.getString("updateBtnText"));
        }
        if(map.hasKey("cancelBtnBgColor")){
            uiConfig.setCancelBtnBgColor(map.getInt("cancelBtnBgColor"));
        }
        if(map.hasKey("cancelBtnTextColor")){
            uiConfig.setCancelBtnTextColor(map.getInt("cancelBtnTextColor"));
        }
        if(map.hasKey("cancelBtnTextSize")){
            uiConfig.setCancelBtnTextSize((float)map.getInt("cancelBtnTextSize"));
        }
        if(map.hasKey("cancelBtnText")){
            uiConfig.setCancelBtnText(map.getString("cancelBtnText"));
        }
        if(map.hasKey("downloadingToastText")){
            uiConfig.setDownloadingToastText(map.getString("downloadingToastText"));
        }
        if(map.hasKey("downloadingBtnText")){
            uiConfig.setDownloadingBtnText(map.getString("downloadingBtnText"));
        }
        if(map.hasKey("downloadFailText")){
            uiConfig.setDownloadFailText(map.getString("downloadFailText"));
        }


        // TODO: RN require() to getResourceId
        uiConfig.setUpdateLogoImgRes(context.getResources().getIdentifier("ic_launcher","mipmap",context.getPackageName()));



        UpdateAppUtils
                .getInstance()
                .apkUrl(apkUrl)
                .updateTitle(updateTitle)
                .updateContent(updateContent)
                .uiConfig(uiConfig)
                .updateConfig(updateConfig)
                .setUpdateDownloadListener(new UpdateDownloadListener() {
                    @Override
                    public void onStart() {
                        context.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                                .emit("LK_UpdateDownloadListener", "onStart");
                    }

                    @Override
                    public void onDownload(int progress) {
                        context.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                                .emit("LK_UpdateDownloadListener", "onDownload|"+progress);
                    }

                    @Override
                    public void onFinish() {
                        context.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                                .emit("LK_UpdateDownloadListener", "onFinish");
                    }

                    @Override
                    public void onError(Throwable e) {
                        context.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                                .emit("LK_UpdateDownloadListener", "onError|"+e.getMessage());
                    }
                })
                .setCancelBtnClickListener(new OnBtnClickListener(){

                    @Override
                    public boolean onClick() {
                        if(map.hasKey("__OnBtnClickListener")){
                            context.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                                    .emit("LK_OnBtnClickListener", "onCancelBtnClick");
                            lock.lock();

                            try {
                                condition.await();
                                return disabledCancel;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                                return disabledCancel;
                            } finally {
                                lock.unlock();
                            }
                        }else {
                            return false;
                        }
                    }
                })
                .setUpdateBtnClickListener(new OnBtnClickListener(){

                    //TODO: onClick need to be a async function
                    @Override
                    public boolean onClick() {
                        if(map.hasKey("__OnBtnClickListener")){
                            context.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                                    .emit("LK_OnBtnClickListener", "onUpdateBtnClick");
                            lock.lock();

                            try {
                                condition.await();
                                return disabledUpdate;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                                return disabledUpdate;
                            } finally {
                                lock.unlock();
                            }
                        }else {
                            return false;
                        }
                    }
                })
                .update();

    }

    @ReactMethod
    public void deleteInstalledApk(){
        UpdateAppUtils.getInstance().deleteInstalledApk();
    }

    @ReactMethod
    public void setCancelBtnClickDisable(final boolean bool){
        if(mReadableMap.hasKey("__OnBtnClickListener")){
            lock.lock();
            try {
                condition.signal();
                disabledCancel = bool;
            } finally {
                lock.unlock();
            }
        }
    }

    @ReactMethod
    public void setUpdateBtnClickDisable(boolean bool){
        if(mReadableMap.hasKey("__OnBtnClickListener")){
            lock.lock();
            try {
                condition.signal();
                disabledUpdate = bool;
            } finally {
                lock.unlock();
            }
        }
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put("SIMPLE", UiType.SIMPLE);
        constants.put("PLENTIFUL", UiType.PLENTIFUL);
        constants.put("CUSTOM", UiType.CUSTOM);
        constants.put("APP", DownLoadBy.APP);
        constants.put("BROWSER", DownLoadBy.BROWSER);

        return constants;
    }

    @Override
    public String getName() {
        return "RNAndroidAutoUpdate";
    }
}
