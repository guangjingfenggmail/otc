package otc.open.com.otc.helper;

import android.content.Context;

import otc.open.com.otc.service.ServiceApi;
import otc.open.com.otc.service.bean.Bean;
import rx.Observable;

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
public class DataManager {
    private ServiceApi mRetrofitService;
    //构造器里获取RetrofitService
    public DataManager(Context context){
        this.mRetrofitService = RetrofitHelper.getInstance(context).getServer();
    }
    //网络请求方法getSearchBooks
    public Observable<Bean> getcall(){
        return mRetrofitService.call();
    }
}
