package otc.open.com.otc.helper;

import android.content.Context;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import otc.open.com.otc.service.ServiceApi;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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
public class RetrofitHelper {
    private Context mCntext;
    //初始化
    OkHttpClient client = new OkHttpClient();
    //gson工厂
    GsonConverterFactory factory = GsonConverterFactory.create(new GsonBuilder().create());
    private static RetrofitHelper instance = null;
    private Retrofit mRetrofit = null;
    //单例模式
    public static RetrofitHelper getInstance(Context context){
        if (instance == null){
            instance = new RetrofitHelper(context);
        }
        return instance;
    }
    private RetrofitHelper(Context mContext){
        mCntext = mContext;
        init();
    }

    private void init() {
        resetApp();
    }

    private void resetApp() {
        //初始化retrofit
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Wz.wz)
                .client(client)
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
    public ServiceApi getServer(){
        return mRetrofit.create(ServiceApi.class);
    }
}