package otc.open.com.otc.presenter;


import java.util.HashMap;

import otc.open.com.otc.base.BasePresenter;
import otc.open.com.otc.base.mvp.IModel;
import otc.open.com.otc.contract.LastestContract;
import otc.open.com.otc.model.LastestModel;
import otc.open.com.otc.service.bean.LatestBean;
import otc.open.com.otc.ui.activity.LastestActivity;

/**
 * Created by GaoSheng on 2016/11/26.
 * 20:51
 *
 * @VERSION V1.4
 * com.example.gs.mvpdemo.presenter
 */

public class LastestPresenterImpl extends BasePresenter<LastestActivity> implements
        LastestContract.LastestPresenter {
//    public static final String MODEL_KEY = "getLastest";

    @Override
    public void getLastest() {
//        ((LastestModel) getiModelMap().get(MODEL_KEY)).latest(new LastestModel.LastestCallBack<LatestBean>() {
        new LastestModel().latest(new LastestModel.LastestCallBack() {
            @Override
            public void onSuccess(LatestBean result) {
                getIView().onSuccess(result);
            }

            @Override
            public void onFailure(String str) {
                getIView().onFailure(str);
            }
        });

    }

    @Override
    public HashMap<String, IModel> getiModelMap() {
        return null;
    }

    @Override
    public HashMap<String, IModel> loadModelMap(IModel... models) {
        return null;
    }
//    @Override
//    public HashMap<String, IModel> getiModelMap() {
//        return loadModelMap(new LastestModel());
//    }
//
//    @Override
//    public HashMap<String, IModel> loadModelMap(IModel... models) {
//        HashMap<String, IModel> map = new HashMap<>();
//        map.put(MODEL_KEY, models[0]);
//        return map;
//    }
}
