package org.xiangbalao;


import org.xiangbalao.activityplugin.ActivityPlugin;
import org.xiangbalao.startactivity.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;


public class MainActivity extends Activity {
    
 public static Activity mActivity;
 private Button  button1; 
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
       requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
       mActivity=this;
      // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
        setContentView(R.layout.activity_main);
        init();
    }

    private void init()
    {
        button1 =(Button)findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener()
        {
            
            @Override
            public void onClick(View v)
            {
                //利用插件启动Activity
              //  ActivityPlugin mActivityPlugin=new ActivityPlugin();
               // mActivityPlugin.startActivity("org.xiangbalao.SecondActivity");
                //直接启动Activity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
               startActivity(intent);
                
            }
        });
        
    }





}
