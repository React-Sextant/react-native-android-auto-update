# React Native Auto Update For Android In Notification
React Native Android自动下载更新APK，进度条在通知栏中显示

## Getting Started

`$ npm install git+https://git@github.com/zhijiasoft/react-native-android-auto-update.git`


`$ react-native link react-native-android-auto-update`

## usage

```javascript
import {NativeModules} from 'react-native';

NativeModules.RNAndroidAutoUpdate.goToDownload('http://example.com/your.apk');
```

`Progress` and `Error` callback
```javascript
import RNAndroidAutoUpdate from 'react-native-android-auto-update';

RNAndroidAutoUpdate.goToDownload(
    'http://example.com/your.apk',
    progress => console.log(progress),
    err => alert(err),

);
```

=============================

如果遇到`Could not resolve com.android.support:**`或者下载jcenter()较慢时，可以改成国内镜像https://www.jianshu.com/p/76a36a37d74c
```
repositories {
    maven { url 'https://maven.aliyun.com/repository/jcenter' }
    maven { url 'https://maven.aliyun.com/repository/google' }
}
```

## todo-list
 - [ ] 未更新至`android-auto-update` v2.0
 - [ ] 未启用推送通知更新

## core
 - [DownloadService.java](https://github.com/zhijiasoft/react-native-android-auto-update/blob/master/android/src/main/java/com/loveplusplus/update/DownloadService.java)

## reference
 - [1] [android-auto-update](https://github.com/feicien/android-auto-update)
 - [1] [react-native-android-auto-update](https://github.com/ribuluo000/react-native-android-auto-update)
