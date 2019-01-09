# React Native Auto Update For Android In Notification
React Native Android自动下载更新APK，进度条在通知栏中显示

## Getting Started

`$ npm install git://github.com/zhijiasoft/react-native-android-auto-update.git`


`$ react-native link react-native-android-auto-update`

## usage

```javascript
import {NativeModules} from 'react-native';

NativeModules.RNAndroidAutoUpdate.goToDownload('http://example.com/your.apk');
```
=============================

If **react-native <= 0.56** or 
**com.android.support:appcompat-v7 <= 27.0.1**

`app > build.gradle`
```
android {
    //...
    configurations {
        all*.exclude group: 'com.android.support', module: 'support-v4'
        all*.exclude group: 'com.android.support', module: 'support-annotations'
    }
}
```

如果遇到`Could not resolve com.android.support:**`或者下载jcenter()较慢时，可以改成国内镜像https://www.jianshu.com/p/76a36a37d74c
```
repositories {
    maven { url 'https://maven.aliyun.com/repository/jcenter' }
    maven { url 'https://maven.aliyun.com/repository/google' }
}
```

## todo-list
 - [x] 未适配android 8- 以下的版本
 - [ ] 未启用推送通知更新
 - [ ] 代码冗余

## core
 - DownloadService.java

## reference
 - [1] [android-auto-update](https://github.com/feicien/android-auto-update)
 - [1] [react-native-android-auto-update](https://github.com/ribuluo000/react-native-android-auto-update)
