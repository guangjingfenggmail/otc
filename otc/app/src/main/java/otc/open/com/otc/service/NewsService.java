package otc.open.com.otc.service;


import otc.open.com.otc.base.OtcApplication;
import otc.open.com.otc.model.LastestModel;
import otc.open.com.otc.rx.RetrofitManager;
import otc.open.com.otc.rx.exception.ApiException;
import otc.open.com.otc.rx.retrofit.CommonSubscriber;
import otc.open.com.otc.rx.retrofit.ObectTransformer;
import otc.open.com.otc.service.api.NewsApi;
import otc.open.com.otc.service.bean.LatestBean;

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
public class NewsService {


    /**
     *
     * @param callBack
     */
    public static  void latest(final LastestModel.LastestCallBack callBack){
        //        RetrofitManager.getService(NewsApi.class).latest()
//                .compose(new CommonTransformer<LatestBean>())
//                .subscribe(new CommonSubscriber<LatestBean>(OtcApplication.getContext()) {
//                    @Override
//                    public void onNext(LatestBean callback) {
//                        callBack.onSuccess(callback);
//                    }
//
//                    @Override
//                    protected void onError(ApiException e) {
//                        super.onError(e);
//                        callBack.onFailure(e.message);
//                    }
//                });
        RetrofitManager.getService(NewsApi.class).latest()
                .compose(new ObectTransformer<LatestBean>())
                .subscribe(new CommonSubscriber<LatestBean>(OtcApplication.getContext()) {
                    @Override
                    public void onNext(LatestBean callback) {
//                        Gson gson = new Gson();
//                        LatestBean bean = gson.fromJson(gson.toJson(callBack),LatestBean.class);
                        callBack.onSuccess(callback);
                    }

                    @Override
                    protected void onError(ApiException e) {
                        super.onError(e);
                        callBack.onFailure(e.message);
                    }
                });
    }


}
