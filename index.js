import { NativeModules,processColor } from 'react-native';
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

    return RNAndroidAutoUpdate.UpdateApp(params)
}

export const uiTypeConstant = {
    SIMPLE:RNAndroidAutoUpdate.SIMPLE,
    PLENTIFUL:RNAndroidAutoUpdate.PLENTIFUL,
    CUSTOM:RNAndroidAutoUpdate.CUSTOM
};
