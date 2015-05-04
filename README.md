# CordovaPluginsDome
CordovaPluginsDome
![](https://github.com/longtaoge/CordovaPluginsDome/blob/master/www/codova_plugin.gif)



## 自定义Cordova插件 ##

### 第一步编写JAVA代码 ###

#### 1命令行新建 项目 ####

例如：

    1 cordova create plugins  org.apache.cordova.plugs  plugins

    2 cd  plugins

    3 cordova platform add android




Cordova 会创建一个带CordovaLib （Library项目） 的 Android 项目，这个就是Cordova的库

文件，插件的开发基于这个Library

![](https://github.com/longtaoge/CordovaPluginsDome/blob/master/cordova_image/cordovaplgin1.png)

#### 2将项目导入eclispe 得到两个工程，展开工程目录如下： ####

![](https://github.com/longtaoge/CordovaPluginsDome/blob/master/cordova_image/cordovaplgin2.png)


   其中，第一个工程MainActivity-CordovaLib就是我们要用的Library
  第二个工程plugins 是一个依赖MainActivity-CordovaLib 的Android 项目

#### 3编写Android平台的 JAVA代码插件 ####


　　Java 代码可以直接在生成的项目中编写，也可以新创建一个单独的工程，这里我新创建一个Android 工程,目录结构如下：


![](https://github.com/longtaoge/CordovaPluginsDome/blob/master/cordova_image/cordovaplgin3png)

##### 1新建ProgressDialogPlugin 类，继承CordovaPlugin #####

  CordovaPlugin 是Cordova 的js桥，必须继承这个类，
##### 2 重写继承自 CordovaPlugin的方法 #####

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


　　　这里action 参数是指要执行的方法名，
　　　args 是在JS中传递过来的字符品参数数组
　　　showProgerss()和 closeProgress();是我们根据action 要选择执行的方法

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
　　　


这里的MainActivity仅时为了测试插件代码，并不打包到插件中去。需要说明的是，一般情况下，插件不要带资源文件，因为资源文件会涉及到R文件的导入问题，在插件使用时，需要使用插件时手动导入R资源



----------

### 第二步编写js代码 ###

#### 1用前端编辑工具打开刚才创建的Cordova项目， 我这里是用的WebStorm 目录结构如下： ####

![](https://github.com/longtaoge/CordovaPluginsDome/blob/master/cordova_image/cordovaplgin4.png)


#### 2新建文件夹，并相要用到的文件放到相应的文件夹下 ####

![](https://github.com/longtaoge/CordovaPluginsDome/blob/master/cordova_image/cordovaplgin5.png)

#### 3在www 文件夹下新建js 文件 ####


    /TODO 导入依赖库
    var exec = require('cordova/exec');
    var platform = require('cordova/platform');

    module.exports = {
    // TODO JS 中调用的 js方法，参数列表可根据业务需求定
    showdalog: function (message) {

        //TODO 第三个参数为 参数（回调方法,null,类名，方法名，[参数1，参数2，……]）
        exec(null,null, "ProgressDialogPlugin", "show", [message]);

    },

    closedalog: function () {

        //TODO 第三个参数为 参数（回调方法,null,类名，方法名，[参数1，参数2，……]）
        exec(null,null, "ProgressDialogPlugin", "close", []);

    }
    }



js 文件必须改入相应的依赖模块，并且重写

     exec(<successFunction>, <failFunction>, <service>, <action>, [<args>])方法

----------

### 第三步配置plugin.xml ###

  Plugin.xml文件是Cordova 识别插件时最重要的文件，会根据这个文件生成Android 项目的源代码，如果这一步出现差错，前面所的有工作将前功尽弃。


![](https://github.com/longtaoge/CordovaPluginsDome/blob/master/cordova_image/cordovaplgin6.png)

#### 参数说明 ####

      Id="org.xiangbalao.progressdialog"  插件ID, cordova 将根据 ID生成 plugins 下的目录结构
    <name>						插件名
    <description> 					插件描述
    <author>						作者
    <keywords> 					关键字
    <license>	  					许可协议
    <engine >  						支持的引擎及版本号
    <platform name="android">  		android 平台的配置
     <js-module>					//指定JS路径
     <merges target="xiangbalao" />  		这里是在JS中调该插件的前缀

    <feature name="ProgressDialogPlugin">     插件名
     <param name="android-package" 					value="org.xiangbalao.progressdialog.ProgressDialogPlugin"/>  插件的完整类路径 </feature>

     Java 本地代码映射，由两部分组成，前面是在插件文件中的路径，后面是将要生成的JAVA源码的包路径名，就是要把这些文件放到哪个目录下
    <source-file src="src/android/ProgressDialogPlugin.java"    插件中的目录 target-dir="src/org/xiangbalao/progressdialog"/>     // 将要生成的Android 源码中的存放目录




#### 举例 ####


     <?xml version="1.0" encoding="UTF-8"?>
     <plugin
        xmlns="http://apache.org/cordova/ns/plugins/1.0"
        xmlns:android="http://schemas.android.com/apk/res/android"
        id="org.xiangbalao.progressdialog"
        version="0.1.0">
    <!--TODO 域名空间，插件ID,版本号 cordova 将根据 ID生成 plugins 下的目录结构 -->
    <name>进度条</name><!--插件名-->
    <description>加载动画</description><!--插件描述-->
    <author>longtaoge</author><!--作者-->
    <keywords>progress</keywords><!--关键字-->
    <license>Apache 2.0 License</license><!--许可协议-->
    <engines>
        <engine name="cordova" version=">=3.0"/>
        <!--支持的引擎及版本号-->
    </engines>
    <!-- TODO android 平台的配置-->
    <platform name="android">
        <js-module src="www/progrress_dialog.js" name="progrress_dialog">
            <!--TODO  这里是在JS中调该插件的前缀-->
            <merges target="xiangbalao" />
        </js-module>
        <config-file target="res/xml/config.xml" parent="/*">
            <feature name="ProgressDialogPlugin">
                <!--TODO 插件的完整类路径-->
                <param name="android-package" value="org.xiangbalao.progressdialog.ProgressDialogPlugin"/>
            </feature>
        </config-file>
        <!--TODO Java 本地代码映射，由两部分组成，前面是在插件文件中的路径，就是要把这些文件放到哪个目录下 -->
        <source-file src="src/android/ProgressDialogPlugin.java" target-dir="src/org/xiangbalao/progressdialog"/>
        <source-file src="src/android/ProgressDialog.java" target-dir="src/org/xiangbalao/progressdialog"/>
        <source-file src="src/android/pageload_icon1.png" target-dir="res/drawable-hdpi"/>
        <source-file src="src/android/pageload_icon2.png" target-dir="res/drawable-hdpi"/>
        <source-file src="src/android/styles.xml" target-dir="res/values"/>
        <source-file src="src/android/progress_round2.xml" target-dir="res/anim"/>
        <source-file src="src/android/customprogressdialog.xml" target-dir="res/layout"/>
    </platform>
</plugin>

