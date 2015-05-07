package org.xiangbalao.activityplugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import android.widget.Toast;
import android.content.Intent;

public class ActivityPlugin extends CordovaPlugin
{
    
    //要启动的Activity
    private String className;
    //方法类型
    private  String START= "start";

    
    public ActivityPlugin()
    {//必须有无参构造
        
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext)
        throws JSONException
    {
       
        if (args.getString(0) != null)
        {   //如果从js 中传递过来的参数列表不为空，取第一个参做为进度框中要显示的内容
            className = args.getString(0);
        }
        
        if (START.equals(action))
        {//根据 action选择要执行的方法，action 是从Js中传递过来的 方法名参数
        Toast.makeText(this.cordova.getActivity(), className,0).show();
             startActivity(className);
            return true;
        }
      
        else
        {
            return false;
        }

    }
    
    public void startActivity(String className) {

        if (className!=null)
        {
            try {
                Intent intent = new Intent().setClass(this.cordova.getActivity(),   Class.forName(className));
                this.cordova.getActivity().startActivity(intent);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
               
            } 
        }
        
    
    }
    
}
