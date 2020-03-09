import { NativeModules,DeviceEventEmitter,processColor } from 'react-native';
import normalizeColor from 'react-native/Libraries/Color/normalizeColor'

const { RNAndroidAutoUpdate } = NativeModules;
const colorProps = ["titleTextColor","contentTextColor","updateBtnBgColor","updateBtnTextColor","cancelBtnBgColor","cancelBtnTextColor"];

export function UpdateApp(params) {
    //process color to return int
    Object.keys(params).forEach(item=>{
        if(colorProps.includes(item)){
            params[item] = processColor(normalizeColor(params[item]));
            if(typeof params[item] !== 'number'){
                delete params[item]
            }
        }
    });

    //process native event in params callback
    if(params.hasOwnProperty("UpdateDownloadListener")&&typeof params.UpdateDownloadListener === "function"){
        DeviceEventEmitter.removeAllListeners("UpdateDownloadListener");
        DeviceEventEmitter.addListener("LK_UpdateDownloadListener",(msg)=>{
            params.UpdateDownloadListener.apply(this,msg.split("|"))
        })
    }
    if(params.hasOwnProperty("OnBtnClickListener")&&typeof params.OnBtnClickListener === "function"){
        DeviceEventEmitter.removeAllListeners("OnBtnClickListener");
        DeviceEventEmitter.addListener("LK_OnBtnClickListener",async (msg)=>{
            if(msg==="onCancelBtnClick"){
                RNAndroidAutoUpdate.setCancelBtnClickDisable(await Boolean(params.OnBtnClickListener.call(this,msg)))
            }else if(msg==="onUpdateBtnClick"){
                RNAndroidAutoUpdate.setUpdateBtnClickDisable(await Boolean(params.OnBtnClickListener.call(this,msg)))
            }}
        )
    }

    return RNAndroidAutoUpdate.UpdateApp(params)
}

export const uiTypeConstant = {
    SIMPLE:RNAndroidAutoUpdate.SIMPLE,
    PLENTIFUL:RNAndroidAutoUpdate.PLENTIFUL,
    CUSTOM:RNAndroidAutoUpdate.CUSTOM
};
