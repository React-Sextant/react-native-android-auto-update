import { NativeModules,DeviceEventEmitter } from 'react-native';

const { RNAndroidAutoUpdate } = NativeModules;

module.exports = {
    goToDownload(url,progressback,errback) {
        RNAndroidAutoUpdate.goToDownload(url)
        typeof progressback === 'function'&&DeviceEventEmitter.addListener('LUOKUN_LOAD_PROGRESS', (msg) => {
            progressback(msg)
        });
        typeof errback === 'function'&&DeviceEventEmitter.addListener('LUOKUN_LOAD_ERROR',(err)=>{
            errback(err)
        });
    }
};
