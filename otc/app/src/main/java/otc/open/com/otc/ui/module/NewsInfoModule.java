package otc.open.com.otc.ui.module;

import dagger.Module;
import dagger.Provides;
import otc.open.com.otc.contract.NewsInfoContract;

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
@Module
public class NewsInfoModule {

    private final NewsInfoContract.NewsInfoView mView;

    public NewsInfoModule(NewsInfoContract.NewsInfoView mView) {
        this.mView = mView;
    }

    @Provides
    NewsInfoContract.NewsInfoView providerNewsInfoView(){
        return mView;
    }
}
