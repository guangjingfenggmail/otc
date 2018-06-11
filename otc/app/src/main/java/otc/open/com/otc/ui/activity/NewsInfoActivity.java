package otc.open.com.otc.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import butterknife.BindView;
import butterknife.ButterKnife;
import otc.open.com.otc.R;
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
public class NewsInfoActivity extends BaseActivity<NewsInfoPresenterImpl> implements NewsInfoContract.NewsInfoView {
    @BindView(R.id.webview)
    WebView webview;

    @Override
    protected NewsInfoPresenterImpl initPresenter() {
        return new NewsInfoPresenterImpl();
    }

    @Override
    protected void initVaules() {
        mPresenter.getNewsInfo(getIntent().getStringExtra("ID"));
    }

    @Override
    protected void bindView() {
        ButterKnife.bind(this);
    }

    @Override
    protected int getInflateLayoutId() {
        return R.layout.activity_newsinfo_main;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onSuccess(NewsInfoBean result) {
        if (result!=null){
            webview.getSettings().setDefaultTextEncodingName("utf-8");
            webview.loadData(result.body,"text/html; charset=UTF-8",null);
        }

    }

    @Override
    public void onFailure(String msg) {

    }


}
