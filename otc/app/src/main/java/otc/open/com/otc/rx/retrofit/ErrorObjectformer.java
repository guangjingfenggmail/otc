package otc.open.com.otc.rx.retrofit;

import otc.open.com.otc.rx.exception.ErrorType;
import otc.open.com.otc.rx.exception.ExceptionEngine;
import otc.open.com.otc.rx.exception.ServerException;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by gaosheng on 2016/11/6.
 * 23:00
 * com.example.gaosheng.myapplication.transformer
 */

public class ErrorObjectformer<Object> implements Observable.Transformer<Object, Object> {

    private static ErrorObjectformer errorTransformer = null;
    private static final String TAG = "ErrorTransformer";

    @Override
    public Observable<Object> call(Observable<Object> responseObservable) {
        return responseObservable.map(new Func1<Object, Object>() {
            @Override
            public Object call(Object httpResult) {
                if (httpResult == null)
                    throw new ServerException(ErrorType.EMPTY_BEAN, "解析对象为空");
                return  httpResult;
            }
        }).onErrorResumeNext(new Func1<Throwable, Observable<? extends Object>>() {
            @Override
            public Observable<? extends Object> call(Throwable throwable) {
                //ExceptionEngine为处理异常的驱动器throwable
                throwable.printStackTrace();
                return Observable.error(ExceptionEngine.handleException(throwable));
            }
        });

    }

    /**
     * @return 线程安全, 双层校验
     */
    public static <Object> ErrorObjectformer<Object> getInstance() {

        if (errorTransformer == null) {
            synchronized (ErrorObjectformer.class) {
                if (errorTransformer == null) {
                    errorTransformer = new ErrorObjectformer<>();
                }
            }
        }
        return errorTransformer;

    }
}
