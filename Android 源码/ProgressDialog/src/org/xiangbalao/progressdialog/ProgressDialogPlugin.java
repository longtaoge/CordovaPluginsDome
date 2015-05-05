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
        {   //如果从js 中传递过来的参数列表不为空，取第一个参做为进度框中要显示的内容
            content = args.getString(0);
        }
        
        if (SHOWPROGRESS.equals(action))
        {//根据 action选择要执行的方法，action 是从Js中传递过来的 方法名参数
            showProgerss();
            return true;
        }
        else if (CLOSEPROGRESS.equals(action))
        {//根据 action选择要执行的方法，action 是从Js中传递过来的 方法名参数
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
        {//如果进度框是显示状态，则关闭进度框
            dialog.dismiss();
            
        }
    }
    
    /** 
     * 描述:显示进度框 </br>
     * 开发人员：longtaoge</br>
     * 创建时间：2015-5-4</br>
     */ 
    private void showProgerss()
    {
        if (dialog==null)
        {//如果进度框为空，则创建一个进度框
            dialog = ProgressDialog.createDialog(this.cordova.getActivity());
        }
        
        dialog.setMessage(content);
        //为进度框设置显示提醒信息
        if (!dialog.isShowing())
        { //如果进度框没有显示，则显示进度框
            dialog.show();
            
        }
        
    }
    
}
