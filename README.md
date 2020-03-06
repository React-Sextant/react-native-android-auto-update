# React Native Auto Update For Android In Notification
React Native Android自动下载更新APK，进度条在通知栏中显示

## Getting Started <a href="https://www.npmjs.com/package/react-native-android-auto-update"><img alt="npm version" src="http://img.shields.io/npm/v/react-native-android-auto-update.svg?style=flat-square"></a>


`$ npm install git+http://git@github.com/React-Sextant/react-native-android-auto-update.git`


`$ react-native link react-native-android-auto-update`

## v0.1.0 usage
[README_old.md](https://github.com/react-sextant/react-native-android-auto-update/blob/master/README_old.md)

## v2.0 usage

reference by [https://github.com/teprinciple/UpdateAppUtils](https://github.com/teprinciple/UpdateAppUtils)

```javascript
import {UpdateApp,uiTypeConstant} from 'react-native-android-auto-update'

UpdateApp({
  apkUrl:"http://.example.com/demo.apk",
  updateTitle:"发现新版本V2.0.0",
  updateContent:"1、Kotlin重构版\n2、支持自定义UI\n3、增加md5校验\n4、更多功能等你探索",
  force:true,
  uiType:uiTypeConstant.PLENTIFUL,
  titleTextColor:"red",
  UpdateDownloadListener:(type,msg)=>{
    //@param type: onStart | onDownload | onFinish | onError
    if(type === "onDownload"){
       console.log(msg);   // progress
    }else if(type === "msg"){
       alert(msg);         // error message
    }
  },
  OnBtnClickListener:(type)=>{
    console.log(type);      // onCancelBtnClick, onUpdateBtnClick
    return false;
  }
});
```
