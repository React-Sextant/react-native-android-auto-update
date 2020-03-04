# React Native Auto Update For Android In Notification
React Native Android自动下载更新APK，进度条在通知栏中显示

## Getting Started <a href="https://www.npmjs.com/package/react-native-android-auto-update"><img alt="npm version" src="http://img.shields.io/npm/v/react-native-android-auto-update.svg?style=flat-square"></a>


`$ npm install react-native-android-auto-update@latest`


`$ react-native link react-native-android-auto-update`

## v0.1.0 usage
[README_old.md](https://github.com/react-sextant/react-native-android-auto-update/blob/master/README_old.md)

## v2.0 usage

reference by [https://github.com/teprinciple/UpdateAppUtils](https://github.com/teprinciple/UpdateAppUtils)

```javascript
import {NativeModules} from 'react-native';

NativeModules.RNAndroidAutoUpdate.UpdateApp({
  apkUrl:"www.baidu.com",
  updateTitle:"发现新版本V2.0.0",
  updateContent:"1、Kotlin重构版\n2、支持自定义UI\n3、增加md5校验\n4、更多功能等你探索",
  force:true,
  uiType:NativeModules.RNAndroidAutoUpdate.PLENTIFUL,
});
```
