package otc.open.com.otc.base;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :fengguangjing
 * @createTime: 2018/6/9
 * @version:
 * @modifyTime:
 * @modifyAuthor:
 * @description: ****************************************************************************************************************************************************************************
 */
public interface BaseCallBack<T> extends Callback<T> {

    @Override
    void onResponse(Call<T> call, Response<T> response);

    @Override
    void onFailure(Call<T> call, Throwable t);
}
