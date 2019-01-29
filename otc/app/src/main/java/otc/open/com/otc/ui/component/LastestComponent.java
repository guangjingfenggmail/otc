package otc.open.com.otc.ui.component;

import dagger.Component;
import otc.open.com.otc.ui.activity.LastestActivity;
import otc.open.com.otc.ui.module.LastestModule;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2019/1/29.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
@Component(modules = LastestModule.class)
public interface LastestComponent {

    void inject(LastestActivity activity);
}
