package otc.open.com.otc.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;

import java.util.ArrayList;
import java.util.List;

import otc.open.com.otc.R;
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
@Route(path = "/path/lastest")
public class LastestActivity extends AppCompatActivity implements LastestContract.LastestView,SwipeRefreshLayout.OnRefreshListener {
    RecyclerView recycleview;
    SwipeRefreshLayout swipelayout;
    private LinearLayoutManager linearLayoutManager;
    private LastestPresenterImpl mPresenter;


    LastestAdapter mLastestAdapter;
    List<LatestBean.StorieBean> storiesList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lastest_main);

        initVaules();
    }


    protected void initVaules() {
        mPresenter = new LastestPresenterImpl(this);
        recycleview = (RecyclerView) findViewById(R.id.recycleview);
        swipelayout = (SwipeRefreshLayout) findViewById(R.id.swipelayout);

        SwipeRefreshUtil.setSiwpeLayout(swipelayout,this,this);
        recycleview.addItemDecoration(new GridItemDividerDecoration(this, R.dimen.divider_height, R.color.divider_color));
        recycleview.setItemAnimator(new DefaultItemAnimator());
        recycleview.setLayoutManager(linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mLastestAdapter = new LastestAdapter(this,storiesList);
        recycleview.setAdapter(mLastestAdapter);

        mPresenter.getLastest();

    }

    @Override
    public void onGetLastest(LatestBean result) {
        storiesList.clear();
        storiesList.addAll(result.stories);
        mLastestAdapter.notifyDataSetChanged();
    }


    @Override
    public void onRefresh() {

    }
}