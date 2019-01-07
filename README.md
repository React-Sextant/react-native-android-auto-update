# React Native Auto Update For Android

## future
```javascript
import RNAndroidAutoUpdate from "react-native-android-auto-update";
```
```
//使用Dialog
RNAndroidAutoUpdate.checkForDialog(
    'http://example.com/your.apk',
    {
        updateMessage:'updateMessage',
        versionCode:"2"
    }
);
```
```
//使用Notification
RNAndroidAutoUpdate.checkForNotification(
    'http://example.com/your.apk',
    {
        updateMessage:'updateMessage',
        versionCode:"2"
    }
);
```

## undo
1.[ ] 未能拿到MainActivity.this
2.[ ] debugger下反馈http error
3.[ ] 基于上一个尝试使用okHttp
4.[ ] android.app.notificationchannel 老版本兼容

## reference
 - [1] [android-auto-update](https://github.com/feicien/android-auto-update)
 - [1] [react-native-android-auto-update](https://github.com/ribuluo000/react-native-android-auto-update)
