package otc.open.com.otc.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import otc.open.com.otc.R;
import otc.open.com.otc.base.adapter.CommonRecyclerViewAdapter;
import otc.open.com.otc.base.adapter.CommonRecyclerViewHolder;
import otc.open.com.otc.service.bean.LatestBean;

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
public class LastestAdapter extends CommonRecyclerViewAdapter<LatestBean.StorieBean,LastestAdapter.LastestViewHolder> {

    public LastestAdapter(Context context, List<LatestBean.StorieBean> datas) {
        super(context, datas);
    }

    @Override
    public View convertView() {
        mView = View.inflate(mContext, R.layout.adapter_lastest_item, null);
        ButterKnife.bind(this, mView);
        return mView;
    }

    @Override
    public LastestViewHolder createHolder(View view) {
        return new LastestViewHolder(view);
    }

    @Override
    public void setData(LastestViewHolder holder,LatestBean.StorieBean item, int position) {
        holder.txtTitle.setText(item.title);
        DraweeController failureImageDraweeController = Fresco.newDraweeControllerBuilder()
                .setUri(item.images.get(0))
                .setTapToRetryEnabled(false)  //同时设置不可重试.
                .setOldController(holder.image.getController())
                .build();
        holder.image.setController(failureImageDraweeController);
    }

    static class LastestViewHolder extends CommonRecyclerViewHolder{
        @BindView(R.id.image)
        SimpleDraweeView image;
        @BindView(R.id.txtTitle)
        TextView txtTitle;

        LastestViewHolder(View view) {
            super(view);

        }
    }
}
