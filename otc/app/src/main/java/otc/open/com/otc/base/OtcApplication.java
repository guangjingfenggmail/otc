package otc.open.com.otc.base;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;

import otc.open.com.otc.BuildConfig;
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
        ImageDisplay.initialize(this, null);

        if (BuildConfig.DEBUG) {
            //如果在debug模式下
            // 打印日志,默认关闭
            ARouter.openLog();
            // 开启调试模式，默认关闭(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug();
            // 打印日志的时候打印线程堆栈
            ARouter.printStackTrace();
        }

        ARouter.init(this);

    }

    public static Context getContext() {
        return application;
    }
}
