package otc.open.com.otc.presenter;


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
public class NewsInfoPresenterImpl {
    private NewsInfoContract.NewsInfoView mView;

    public NewsInfoPresenterImpl(NewsInfoContract.NewsInfoView mView) {
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
