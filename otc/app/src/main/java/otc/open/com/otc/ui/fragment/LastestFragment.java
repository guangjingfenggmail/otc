package otc.open.com.otc.ui.fragment;

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
import otc.open.com.otc.base.BaseFragment;
import otc.open.com.otc.base.OtcApplication;
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
 * @createTime: 2018/6/13.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class LastestFragment extends BaseFragment<LastestPresenterImpl> implements LastestContract.LastestView,SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.recycleview)
    RecyclerView recycleview;
    @BindView(R.id.swipelayout)
    SwipeRefreshLayout swipelayout;
    private LinearLayoutManager linearLayoutManager;


    LastestAdapter mLastestAdapter;
    List<LatestBean.StorieBean> storiesList = new ArrayList<>();

    public static LastestFragment getInstance(){
        LastestFragment fragment = new LastestFragment();
        return fragment;
    }

    @Override
    protected void attachView() {
        if (mPresenter != null)
            mPresenter.attachView(this);
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onSuccess(LatestBean result) {
        storiesList.clear();
        storiesList.addAll(result.stories);
        mLastestAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFailure(String msg) {

    }

    @Override
    protected LastestPresenterImpl initPresenter() {
        return new LastestPresenterImpl();
    }

    @Override
    protected void initVaules() {
        SwipeRefreshUtil.setSiwpeLayout(swipelayout, getActivity(),this);
        mPresenter.getLastest();
        recycleview.addItemDecoration(new GridItemDividerDecoration(getActivity(), R.dimen.divider_height, R.color.divider_color));
        recycleview.setItemAnimator(new DefaultItemAnimator());
        recycleview.setLayoutManager(linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mLastestAdapter = new LastestAdapter(getActivity(),storiesList);
        recycleview.setAdapter(mLastestAdapter);
    }

    @Override
    protected void bindView() {
        ButterKnife.bind(this,view);
    }

    @Override
    protected int getInflateLayoutId() {
        return R.layout.activity_lastest_main;
    }
}
