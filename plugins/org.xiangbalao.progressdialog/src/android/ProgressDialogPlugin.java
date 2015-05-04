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
    
    /**
     * 根据 action（方法名）参数选择择行相应的方法，
     * args 第一个参数为要显示的内容
     * 开发人员：longtaoge
     */
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

    /**
     * 描述: 关闭进度条</br>
     * 开发人员：longtaoge</br>
     * 创建时间：2015-5-4</br>
     */
    private void closeProgress()
    {
        if (dialog.isShowing())
        {
            dialog.dismiss();

        }
    }

    /**
     * 描述:显示进度条 </br>
     * 开发人员：longtaoge</br>
     * 创建时间：2015-5-4</br>
     */
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
