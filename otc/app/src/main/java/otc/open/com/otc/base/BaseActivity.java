package otc.open.com.otc.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import otc.open.com.otc.base.mvp.IView;

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
public abstract class BaseActivity<P extends BasePresenter> extends FragmentActivity implements
        IView, View.OnClickListener {
    protected View view;
    protected P mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        mPresenter = initPresenter();
        attachView();
        bindView();
        initVaules();
    }

    protected abstract P initPresenter();

    private void attachView() {
        if (mPresenter != null)
            mPresenter.attachView(this);
    }

    protected abstract void initVaules();

    protected abstract void bindView();

    protected abstract int getInflateLayoutId();


    /**
     * @return 显示的内容
     */
    public View getContentView() {
        view = View.inflate(this, getInflateLayoutId(), null);
        return view;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.detachView();
    }
}
