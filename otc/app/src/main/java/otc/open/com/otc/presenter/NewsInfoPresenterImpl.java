package otc.open.com.otc.presenter;

import java.util.HashMap;

import otc.open.com.otc.base.BasePresenter;
import otc.open.com.otc.base.mvp.IModel;
import otc.open.com.otc.contract.NewsInfoContract;
import otc.open.com.otc.model.NewsInfoModel;
import otc.open.com.otc.service.bean.NewsInfoBean;
import otc.open.com.otc.ui.activity.NewsInfoActivity;

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
public class NewsInfoPresenterImpl extends BasePresenter<NewsInfoActivity> implements
        NewsInfoContract.NewsInfoPresenter{
    @Override
    public HashMap<String, IModel> getiModelMap() {
        return null;
    }

    @Override
    public HashMap<String, IModel> loadModelMap(IModel... models) {
        return null;
    }

    @Override
    public void getNewsInfo(String id) {
        new NewsInfoModel().getNewsInfo(id, new NewsInfoModel.NewsInfoCallBack() {
            @Override
            public void onSuccess(NewsInfoBean result) {
                getIView().onSuccess(result);
            }

            @Override
            public void onFailure(String msg) {
                getIView().onFailure(msg);
            }
        });
    }
}