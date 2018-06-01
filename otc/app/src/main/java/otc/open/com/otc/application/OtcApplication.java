package otc.open.com.otc.application;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2018/6/1.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class OtcApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }

}
