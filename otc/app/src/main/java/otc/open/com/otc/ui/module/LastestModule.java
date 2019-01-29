package otc.open.com.otc.ui.module;

import dagger.Module;
import dagger.Provides;
import otc.open.com.otc.contract.LastestContract;

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
public class LastestModule {
    private final LastestContract.LastestView mView;

    public LastestModule(LastestContract.LastestView mView) {
        this.mView = mView;
    }

    @Provides
    LastestContract.LastestView provideLastestView(){
        return mView;
    }
}
