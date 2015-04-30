cordova.define("com.toast.toast.Toast.toast", function(require, exports, module) { 
var exec = require('cordova/exec');
var platform = require('cordova/platform');

/**
 * Provides access to notifications on the device.
 */

module.exports = {


    ShowToast: function (content, length) {
        alert("tost中");

        exec(null, null,"ToastPlugin","Toast",[content,length]);
        alert("tost后");

    }

};

});
