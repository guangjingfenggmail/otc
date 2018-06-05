package otc.open.com.otc.base;




import otc.open.com.otc.rx.exception.ApiException;
import rx.Subscriber;


/**
 * Created by gaosheng on 2016/11/6.
 */

public abstract class BaseSubscriber<T> extends Subscriber<T> {

    @Override
    public void onError(Throwable e) {
        ApiException apiException = (ApiException) e;
        onError(apiException);
    }


    /**
     * @param e 错误的一个回调
     */
    protected abstract void onError(ApiException e);

}
