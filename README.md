# React Native Auto Update For Android In Notification
React Native Android自动下载更新APK，进度条在通知栏中显示

## Getting Started <a href="https://www.npmjs.com/package/react-native-android-auto-update"><img alt="npm version" src="http://img.shields.io/npm/v/react-native-android-auto-update.svg?style=flat-square"></a>


`$ npm install git+http://git@github.com/React-Sextant/react-native-android-auto-update.git`


`$ react-native link react-native-android-auto-update`

## v0.1.0 usage
[README_old.md](https://github.com/react-sextant/react-native-android-auto-update/blob/master/README_old.md)

## v2.3.0 usage
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

## v2.4.0 usage

 - **完善uiType类型`UiType.CUSTOM`**
 
   - 如果使用`UiType.CUSTOM`类型，本库custom ui不能通过RN生成，只能**自定义XML**实现，
   - 所以默认为对Android有一定基础，没有的话也可以借此机会学习😊，不过本库已为您创建了一个[custom xml](https://github.com/React-Sextant/react-native-android-auto-update/tree/master/android/src/main/res/layout/view_update_dialog_custom.xml)，
   - 如果需要定制化，在本地根android项目中创建一个名为`view_update_dialog_custom.xml`的Layout文件即可覆盖
   - 文件路径：*android / app / src / main / res / layout / view_update_dialog_custom.xml*

`view_update_dialog_custom.xml`元素ID必须按照以下命名
```xml
<!--更新标题-->
<TextView android:id="@+id/tv_update_title" />
<!--更新内容-->
<TextView android:id="@+id/tv_update_content" />

<!--apk版本名-->
<TextView android:id="@+id/tv_version_name" />
<!--apk版本号-->
<TextView android:id="@+id/tv_version_code" />

<!--更新按钮文案-->
<TextView android:id="@+id/btn_update_sure" />
<!--取消按钮文案-->
<Button android:id="@+id/btn_update_cancel" />

...
```
