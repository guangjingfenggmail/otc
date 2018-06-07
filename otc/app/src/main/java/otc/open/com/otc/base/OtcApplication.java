package otc.open.com.otc.base;

import android.app.Application;
import android.content.Context;

import otc.open.com.otc.utils.ImageDisplay;


/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2018/6/5.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class OtcApplication extends Application {
    private static OtcApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        ImageDisplay.initialize(this,null);

    }

    public static Context getContext(){
        return application;
    }
}
