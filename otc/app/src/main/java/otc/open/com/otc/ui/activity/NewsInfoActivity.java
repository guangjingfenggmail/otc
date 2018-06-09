package otc.open.com.otc.ui.activity;

import android.view.View;

import otc.open.com.otc.base.BaseActivity;
import otc.open.com.otc.contract.NewsInfoContract;
import otc.open.com.otc.presenter.NewsInfoPresenterImpl;
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
public class NewsInfoActivity extends BaseActivity<NewsInfoPresenterImpl> implements NewsInfoContract.NewsInfoView{
    @Override
    protected NewsInfoPresenterImpl initPresenter() {
        return new NewsInfoPresenterImpl();
    }

    @Override
    protected void initVaules() {

    }

    @Override
    protected void bindView() {

    }

    @Override
    protected int getInflateLayoutId() {
        return 0;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onSuccess(NewsInfoBean result) {

    }

    @Override
    public void onFailure(String msg) {

    }
}
