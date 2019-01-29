package otc.open.com.otc.ui.component;

import dagger.Component;
import otc.open.com.otc.ui.activity.NewsInfoActivity;
import otc.open.com.otc.ui.module.NewsInfoModule;

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
@Component(modules = NewsInfoModule.class)
public interface NewsInfoComponent {

    void inject(NewsInfoActivity activity);
}
