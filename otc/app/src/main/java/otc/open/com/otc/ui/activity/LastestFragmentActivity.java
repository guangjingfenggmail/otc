package otc.open.com.otc.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import otc.open.com.otc.R;
import otc.open.com.otc.base.BaseActivity;
import otc.open.com.otc.base.BasePresenter;
import otc.open.com.otc.contract.LastestContract;
import otc.open.com.otc.presenter.LastestPresenterImpl;
import otc.open.com.otc.service.bean.LatestBean;
import otc.open.com.otc.ui.adapter.LastestAdapter;
import otc.open.com.otc.ui.fragment.LastestFragment;
import otc.open.com.otc.utils.SwipeRefreshUtil;
import otc.open.com.otc.widget.GridItemDividerDecoration;


/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2018/6/5.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
@Route(path = "/path/lastestfragment")
public class LastestFragmentActivity extends BaseActivity  {
    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void attachView() {

    }

    @Override
    protected void initVaules() {
        Fragment fragment = LastestFragment.getInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.idfragment,fragment).commit();

    }

    @Override
    protected void bindView() {

    }

    @Override
    protected int getInflateLayoutId() {
        return R.layout.activity_lastest_fragment_main;
    }

    @Override
    public void onClick(View v) {

    }
}