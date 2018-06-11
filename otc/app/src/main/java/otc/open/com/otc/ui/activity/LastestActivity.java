package otc.open.com.otc.ui.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import otc.open.com.otc.R;
import otc.open.com.otc.base.BaseActivity;
import otc.open.com.otc.contract.LastestContract;
import otc.open.com.otc.presenter.LastestPresenterImpl;
import otc.open.com.otc.service.bean.LatestBean;
import otc.open.com.otc.ui.adapter.LastestAdapter;
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
public class LastestActivity extends BaseActivity<LastestPresenterImpl> implements LastestContract.LastestView,SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.recycleview)
    RecyclerView recycleview;
    @BindView(R.id.swipelayout)
    SwipeRefreshLayout swipelayout;
    private LinearLayoutManager linearLayoutManager;


    LastestAdapter mLastestAdapter;
    List<LatestBean.StorieBean> storiesList = new ArrayList<>();

    @Override
    protected LastestPresenterImpl initPresenter() {
        return new LastestPresenterImpl();
    }

    @Override
    protected void initVaules() {
        SwipeRefreshUtil.setSiwpeLayout(swipelayout,this,this);
        mPresenter.getLastest();
        recycleview.addItemDecoration(new GridItemDividerDecoration(this, R.dimen.divider_height, R.color.divider_color));
        recycleview.setItemAnimator(new DefaultItemAnimator());
        recycleview.setLayoutManager(linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mLastestAdapter = new LastestAdapter(this,storiesList);
        recycleview.setAdapter(mLastestAdapter);

    }

    @Override
    protected void bindView() {
        ButterKnife.bind(this);
    }

    @Override
    protected int getInflateLayoutId() {
        return R.layout.activity_lastest_main;
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void onSuccess(LatestBean callback) {
        storiesList.clear();
        storiesList.addAll(callback.stories);
        mLastestAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFailure(String str) {

    }

    @Override
    public void onRefresh() {

    }
}