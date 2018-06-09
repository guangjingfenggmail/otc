package otc.open.com.otc.model;

import android.support.annotation.NonNull;

import com.google.gson.Gson;

import otc.open.com.otc.base.BaseModel;
import otc.open.com.otc.base.OtcApplication;
import otc.open.com.otc.rx.RetrofitManager;
import otc.open.com.otc.rx.exception.ApiException;
import otc.open.com.otc.rx.retrofit.CommonSubscriber;
import otc.open.com.otc.rx.retrofit.CommonTransformer;
import otc.open.com.otc.rx.retrofit.ObectTransformer;
import otc.open.com.otc.service.NewsService;
import otc.open.com.otc.service.bean.LatestBean;


/**
 * Created by GaoSheng on 2016/11/26.
 * 20:53
 *
 * @VERSION V1.4
 * com.example.gs.mvpdemo.model
 * 主要做一些数据处理呀,网路请求呀
 */

public class LastestModel extends BaseModel {

    /**
     *
     * @param callBack
     */
    public void latest(@NonNull final LastestCallBack
                               callBack) {

        NewsService.latest(callBack);

    }


    public interface LastestCallBack {
        /**
         *
         * @param callback
         */
        void onSuccess(LatestBean callback);

        /**
         *
         * @param str
         */
        void onFailure(String str);

    }

}
