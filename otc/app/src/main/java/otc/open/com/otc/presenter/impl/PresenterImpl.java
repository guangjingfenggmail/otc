package otc.open.com.otc.presenter.impl;

import android.content.Context;

import otc.open.com.otc.model.Model;
import otc.open.com.otc.presenter.PresenterInter;
import otc.open.com.otc.service.bean.TickerJson;
import otc.open.com.otc.viewInter.ViewInter;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2018/6/1.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class PresenterImpl implements PresenterInter {

    Model model;
    private ViewInter vi;
    Context context;

    public PresenterImpl(ViewInter vi, Context context) {
        this.vi = vi;
        this.context = context;
        model=new Model(context);
    }


    public void info(){
        model.info(this);
    }

    @Override
    public void onSuccessP(TickerJson bean) {
        vi.onSuccessV(bean);
    }
}
