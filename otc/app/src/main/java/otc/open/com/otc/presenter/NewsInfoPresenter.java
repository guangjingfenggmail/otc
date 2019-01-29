package otc.open.com.otc.presenter;


import javax.inject.Inject;

import otc.open.com.otc.contract.NewsInfoContract;
import otc.open.com.otc.model.NewsInfoModel;
import otc.open.com.otc.service.bean.NewsInfoBean;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :fengguangjing
 * @createTime: 2018/6/9
 * @version:
 * @modifyTime:
 * @modifyAuthor:
 * @description: ****************************************************************************************************************************************************************************
 */
public class NewsInfoPresenter {
    private NewsInfoContract.NewsInfoView mView;

    @Inject
    public NewsInfoPresenter(NewsInfoContract.NewsInfoView mView) {
        this.mView = mView;
    }

    public void getNewsInfo(String id) {
        new NewsInfoModel().getNewsInfo(id, new NewsInfoModel.NewsInfoCallBack() {
            @Override
            public void onSuccess(NewsInfoBean result) {
                mView.onGetNewsInfo(result);
            }

            @Override
            public void onFailure(String msg) {
            }
        });
    }
}
