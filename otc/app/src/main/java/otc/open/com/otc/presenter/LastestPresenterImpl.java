package otc.open.com.otc.presenter;


import java.util.HashMap;

import otc.open.com.otc.base.BaseFragment;
import otc.open.com.otc.base.BasePresenter;
import otc.open.com.otc.base.mvp.IModel;
import otc.open.com.otc.contract.LastestContract;
import otc.open.com.otc.model.LastestModel;
import otc.open.com.otc.service.bean.LatestBean;
import otc.open.com.otc.service.bean.NewsInfoBean;
import otc.open.com.otc.ui.activity.LastestActivity;
import otc.open.com.otc.ui.fragment.LastestFragment;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by GaoSheng on 2016/11/26.
 * 20:51
 *
 * @VERSION V1.4
 * com.example.gs.mvpdemo.presenter
 */

public class LastestPresenterImpl extends BasePresenter<LastestContract.LastestView> implements
        LastestContract.LastestPresenter {
//    public static final String MODEL_KEY = "getLastest";

    @Override
    public void getLastest() {
//        ((LastestModel) getiModelMap().get(MODEL_KEY)).latest(new LastestModel.LastestCallBack<LatestBean>() {
        new LastestModel().latest(new LastestModel.LastestCallBack() {
            @Override
            public void onResponse(Call<LatestBean> call, Response<LatestBean> response) {
                getIView().onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<LatestBean> call, Throwable t) {
                getIView().onFailure(t.getMessage());
            }
        });

    }

//    @Override
//    public HashMap<String, IModel> getiModelMap() {
//        return null;
//    }
//
//    @Override
//    public HashMap<String, IModel> loadModelMap(IModel... models) {
//        return null;
//    }
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
