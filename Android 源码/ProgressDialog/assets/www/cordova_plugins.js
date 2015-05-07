cordova.define('cordova/plugin_list', function(require, exports, module) {
module.exports = [
    {
        "file": "plugins/com.toast.toast/www/toast.js",
        "id": "com.toast.toast.toast",
        "merges": [
            "window.plugins"
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
    },
    {
        "file": "plugins/org.apache.cordova.plugs/www/echo.js",
        "id": "org.apache.cordova.plugs.echo",
        "merges": [
            "navigator.notification"
        ]
    },
    {
        "file": "plugins/org.apache.cordova.plugs/www/echo.js",
        "id": "org.apache.cordova.plugs.echo",
        "merges": [
            "echo"
        ]
    },
    {
        "file": "plugins/org.xiangbalao.progressdialog/www/progrress_dialog.js",
        "id": "org.xiangbalao.progressdialog.progrress_dialog",
        "merges": [
            "xiangbalao"
        ]
    }
];
module.exports.metadata = 
// TOP OF METADATA
{
    "com.toast.toast": "1.5.2",
    "org.apache.cordova.dialogs": "0.3.0",
    "org.apache.cordova.plugs": "0.3.0",
    "org.xiangbalao.progressdialog": "0.1.0"
}
// BOTTOM OF METADATA
});