import { NativeModules } from 'react-native';

const { AndroidAutoUpdate } = NativeModules;

module.exports = {
    checkForNotification(url,params) {
        AndroidAutoUpdate.checkForNotification(url,params)
    },
    checkForDialog(url,params) {
        AndroidAutoUpdate.checkForDialog(url,params)
    }
};