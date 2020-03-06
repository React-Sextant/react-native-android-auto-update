package com.loveplusplus.update;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

import java.util.HashMap;
import java.util.Map;

import constacne.UiType;
import model.UiConfig;
import model.UpdateConfig;
import update.UpdateAppUtils;


public class AndroidAutoUpdateModule extends ReactContextBaseJavaModule {

    private static ReactApplicationContext context;
    public AndroidAutoUpdateModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.context = reactContext;
    }

    @ReactMethod
    public void UpdateApp(ReadableMap map){
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
        if(map.hasKey("force")){
            updateConfig.setForce(map.getBoolean("force"));
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
                .update();
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put("SIMPLE", UiType.SIMPLE);
        constants.put("PLENTIFUL", UiType.PLENTIFUL);
        constants.put("CUSTOM", UiType.CUSTOM);

        return constants;
    }

    @Override
    public String getName() {
        return "RNAndroidAutoUpdate";
    }
}
