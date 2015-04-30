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
        {
            String message = args.getString(0);
            this.echo(message, callbackContext);
            return true;
        }
        return false;
    }
    
    private void echo(String message, CallbackContext callbackContext)
    {
        Toast.makeText(this.cordova.getActivity(),"",Toast.LENGTH_LONG).show();

        if (message != null && message.length() > 0)
        {
            callbackContext.success(message);
        }
        else
        {
            callbackContext.error("Expected one non-empty string argument.");
        }
        
    }
    
}