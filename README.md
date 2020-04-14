# React Native Auto Update For Android In Notification
React Native Android自动下载更新APK，进度条在通知栏中显示

## Getting Started <a href="https://www.npmjs.com/package/react-native-android-auto-update"><img alt="npm version" src="http://img.shields.io/npm/v/react-native-android-auto-update.svg?style=flat-square"></a>


`$ npm install git+http://git@github.com/React-Sextant/react-native-android-auto-update.git`


`$ react-native link react-native-android-auto-update`

## v0.1.0 usage
[README_old.md](https://github.com/react-sextant/react-native-android-auto-update/blob/master/README_old.md)

## v2.3.0 usage

### Android Config
> 需要在`MainApplication.java`手动添加一些配置：

```java
import update.UpdateAppUtils;

...

@Override
public void onCreate() {
  super.onCreate();
  UpdateAppUtils.init(this); // 修复context空指针
}
```
### JavaScript
[👉全部的UpdateAppUtils Api说明](https://github.com/teprinciple/UpdateAppUtils/tree/5afcb34f0d4a9bb11cec81119fdc1f14197a1114#api%E8%AF%B4%E6%98%8E)
```javascript
import {UpdateApp,UiType} from 'react-native-android-auto-update'

UpdateApp({
  apkUrl:"http://.example.com/demo.apk",
  updateTitle:"发现新版本V2.3.0",
  updateContent:"1、Kotlin重构版\n2、支持自定义UI\n3、增加md5校验\n4、更多功能等你探索",
  force:true,
  uiType:UiType.PLENTIFUL,
  titleTextColor:"red",
  UpdateDownloadListener:(type,msg)=>{
    //@param type: onStart | onDownload | onFinish | onError
    if(type === "onDownload"){
       console.log(msg);   // progress
    }else if(type === "onError"){
       alert(msg);         // error message
    }
  },
  OnBtnClickListener:(type)=>{
    console.log(type);     // onCancelBtnClick, onUpdateBtnClick
    return false;          // 事件是否消费，是否需要传递下去。false-会执行原有点击逻辑，true-只执行本次设置的点击逻辑
  }
});
```
