package otc.open.com.otc.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.alibaba.android.arouter.facade.annotation.Route;

import otc.open.com.otc.R;
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
@Route(path = "/path/newsinfo")
public class NewsInfoActivity extends AppCompatActivity implements NewsInfoContract.NewsInfoView {
    WebView webview;
    NewsInfoPresenterImpl mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsinfo_main);
        initVaules();
    }


    protected void initVaules() {
        mPresenter = new NewsInfoPresenterImpl(this);
        webview = (WebView) findViewById(R.id.webview);
        mPresenter.getNewsInfo(getIntent().getStringExtra("ID"));
    }

    @Override
    public void onGetNewsInfo(NewsInfoBean result) {
        if (result != null) {
            webview.getSettings().setDefaultTextEncodingName("utf-8");
            webview.loadData(result.body, "text/html; charset=UTF-8", null);
        }

    }


}
