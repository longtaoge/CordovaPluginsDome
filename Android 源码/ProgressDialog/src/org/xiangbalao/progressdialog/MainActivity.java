package org.xiangbalao.progressdialog;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.cordova.Config;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity implements CordovaInterface {
    //要实现 CordovaInterface接口
    private final ExecutorService threadPool = Executors.newCachedThreadPool();
    //
	protected ProgressDialog dialog;
	private Button button;
	private CordovaWebView mCordovaWebView;
	private Button button2;
	private Handler mHandler= new Handler(){

		@Override
		public void handleMessage(Message msg) {
			dialog.dismiss();
			super.handleMessage(msg);
		}
		
	};
	
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		dialog = ProgressDialog.createDialog(this);
		dialog.setMessage("数据加载中...");
		dialog.show();
		mHandler.sendEmptyMessageDelayed(0, 5000);
		button=(Button) findViewById(R.id.button1);
		button2=(Button)findViewById(R.id.button2);
		mCordovaWebView=(CordovaWebView)findViewById(R.id.mywebview);
	
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				if (!dialog.isShowing()) {
					dialog.show();
					mHandler.sendEmptyMessageDelayed(0, 5000);
				}
				
			}
		});
		button2.setOnClickListener(new OnClickListener()
        {
            
            @Override
            public void onClick(View v)
            
            {
                Config.init(MainActivity.this);
                // 加载外网要添加白名单
                Config.addWhiteListEntry("https://www.baidu.com/", true);
               String urlString="https://www.baidu.com/";
               
              // mCordovaWebView.loadUrl("file:///android_asset/www/index.html"); //加载本地文件
           
               mCordovaWebView.loadUrl(urlString);
         
                
            }
        });
		
		
	}

    @Override
    public void startActivityForResult(CordovaPlugin command, Intent intent, int requestCode)
    {
        
        
    }

    @Override
    public void setActivityResultCallback(CordovaPlugin plugin)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Activity getActivity()
    {
        // TODO Auto-generated method stub
        return this;
    }

    @Override
    public Object onMessage(String id, Object data)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ExecutorService getThreadPool()
    {
        // TODO Auto-generated method stub
        return threadPool ;
    }

}
