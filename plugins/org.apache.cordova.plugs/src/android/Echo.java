package org.apache.cordova.plugs;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import android.widget.Toast;
public class Echo extends CordovaPlugin
{
    
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext)
        throws JSONException
    {
        if (action.equals("echo"))
        { //根据action 选择要执行的方法
            String message = args.getString(0)+args.getString(1)+args.getString(2);
            //执行方法
            this.echo(message, callbackContext);
            return true;
        }
        return false;
    }
    
    private void echo(String message, CallbackContext callbackContext)
    {


        if (message != null && message.length() > 0)
        {
            callbackContext.success(message);
             Toast.makeText(this.cordova.getActivity(),message,Toast.LENGTH_LONG).show();
        }
        else
        {
          Toast.makeText(this.cordova.getActivity(),"消息为空",Toast.LENGTH_LONG).show();
            callbackContext.error("Expected one non-empty string argument.");
        }
        
    }
    
}