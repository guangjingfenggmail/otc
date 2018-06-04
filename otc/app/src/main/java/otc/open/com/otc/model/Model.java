package otc.open.com.otc.model;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import otc.open.com.otc.helper.DataManager;
import otc.open.com.otc.presenter.PresenterInter;
import otc.open.com.otc.service.bean.TickerJson;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

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
public class Model {
    Context context;

    public Model(Context context) {
        this.context = context;
    }

    public void info(final PresenterInter pre){
        DataManager dataManager=new DataManager(context);
        CompositeSubscription compositeSubscription=new CompositeSubscription();
        compositeSubscription.add(
                //observerble 被观察者
                dataManager.getcall()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        //订阅
                        .subscribe(
                                //观察者
                                new Observer<TickerJson>() {
                                    @Override
                                    public void onCompleted() {
                                        Log.d("xxx", "onCompleted: "+"onCompleted");
                                    }

                                    @Override
                                    public void onError(Throwable e) {

                                    }

                                    @Override
                                    public void onNext(TickerJson bean) {
                                        Gson gson = new Gson();
                                        Log.d("jiba", "onNext: "+gson.toJson(bean));
                                        pre.onSuccessP(bean);
                                    }
                                })
        );
    }
}
