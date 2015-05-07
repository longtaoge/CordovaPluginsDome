package org.xiangbalao;



import org.xiangbalao.startactivity.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class SecondActivity extends Activity
{  //注意这个 要修改 R资源地址 为项目包名.R
    
   private  Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        setContentView(R.layout.activity_secend);
        
        init();
    }
    private void init()
    {
       button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener()
        {
            
            @Override
            public void onClick(View v)
            {
               finish();
                
            }
        });
        
        
    }



}
