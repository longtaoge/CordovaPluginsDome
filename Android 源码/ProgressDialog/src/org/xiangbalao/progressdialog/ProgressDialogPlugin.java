package org.xiangbalao.progressdialog;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class ProgressDialogPlugin extends CordovaPlugin
{
    protected ProgressDialog dialog;
    
    private String SHOWPROGRESS = "show";
    
    private String CLOSEPROGRESS = "close";
    
    private String content = "数据加载中...";
    
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext)
        throws JSONException
    {
        
        if (args.getString(0) != null)
        {
            content = args.getString(0);
        }
        
        if (SHOWPROGRESS.equals(action))
        {
            
            showProgerss();
            return true;
        }
        else if (CLOSEPROGRESS.equals(action))
        {
            closeProgress();
            return true;
        }
        else
        {
            return false;
        }
        
    }
    
    private void closeProgress()
    {
        if (dialog.isShowing())
        {
            dialog.dismiss();
            
        }
    }
    
    private void showProgerss()
    {
        if (dialog==null)
        {
            dialog = ProgressDialog.createDialog(this.cordova.getActivity());
        }
    
        dialog.setMessage(content);
        if (!dialog.isShowing())
        {
            dialog.show();
            
        }
        
    }
    
}
