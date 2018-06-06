package otc.open.com.otc.rx.retrofit;

import otc.open.com.otc.rx.BaseHttpResult;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2018/6/6.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class ObectTransformer<Object> implements Observable.Transformer<Object, Object> {

    @Override
    public Observable<Object> call(Observable<Object> tansFormerObservable) {
        return tansFormerObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(ErrorObjectformer.<Object>getInstance());
    }
}