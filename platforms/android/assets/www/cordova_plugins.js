cordova.define('cordova/plugin_list', function(require, exports, module) {
module.exports = [
    {
        "file": "plugins/com.toast.toast.Toast/www/toast.js",
        "id": "com.toast.toast.Toast.toast",
        "merges": [
            "window.plugins.Toast"
        ]
    },
    {
        "file": "plugins/org.apache.cordova.dialogs/www/notification.js",
        "id": "org.apache.cordova.dialogs.notification",
        "merges": [
            "navigator.notification"
        ]
    },
    {
        "file": "plugins/org.apache.cordova.dialogs/www/android/notification.js",
        "id": "org.apache.cordova.dialogs.notification_android",
        "merges": [
            "navigator.notification"
        ]
    }
];
module.exports.metadata = 
// TOP OF METADATA
{
    "com.toast.toast.Toast": "1.5.2",
    "org.apache.cordova.dialogs": "0.3.0"
}
// BOTTOM OF METADATA
});