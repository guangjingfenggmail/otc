package otc.open.com.otc.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.alibaba.android.arouter.facade.annotation.Route;

import javax.inject.Inject;

import otc.open.com.otc.R;
import otc.open.com.otc.contract.NewsInfoContract;
import otc.open.com.otc.presenter.NewsInfoPresenter;
import otc.open.com.otc.service.bean.NewsInfoBean;
import otc.open.com.otc.ui.component.DaggerNewsInfoComponent;
import otc.open.com.otc.ui.module.NewsInfoModule;

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
    @Inject
    NewsInfoPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsinfo_main);
        initVaules();
    }


    protected void initVaules() {
        DaggerNewsInfoComponent.builder()
                .newsInfoModule(new NewsInfoModule(this))
                .build().inject(this);
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
