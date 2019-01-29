package otc.open.com.otc.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;


import com.alibaba.android.arouter.launcher.ARouter;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import otc.open.com.otc.R;
import otc.open.com.otc.base.adapter.CommonRecyclerViewAdapter;
import otc.open.com.otc.base.adapter.CommonRecyclerViewHolder;
import otc.open.com.otc.service.bean.LatestBean;
import otc.open.com.otc.utils.ImageDisplay;

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

        return mView;
    }

    @Override
    public LastestViewHolder createHolder(View view) {
        return new LastestViewHolder(view);
    }

    @Override
    public void setData(LastestViewHolder holder,final LatestBean.StorieBean item, int position) {
        holder.txtTitle.setText(item.title);
//        Glide.with(mContext).load(item.images.get(0))
//                .crossFade(0)
//                .into(holder.image);  //crossFade是个淡入淡出效果
        ImageDisplay.with(holder.image).holderImage(R.mipmap.ic_launcher).failureImage(mContext.getResources().getDrawable(R.mipmap.ic_launcher),
                ScalingUtils.ScaleType.FIT_XY).display(item.images.get(0));
        holder.txtTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(mContext, NewsInfoActivity.class);
//                intent.putExtra("ID",item.id);
//                intent.putExtra("TITLE",item.title);
//                mContext.startActivity(intent);

                ARouter.getInstance()
                        .build("/path/newsinfo") //内容就是想跳转去那个module注解的path
                        .withString("ID", item.id)
                        .withString("TITLE",item.title)
                        .navigation();


            }
        });
    }

    static class LastestViewHolder extends CommonRecyclerViewHolder{
        SimpleDraweeView image;
        TextView txtTitle;

        LastestViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.image);
            txtTitle = view.findViewById(R.id.txtTitle);
        }
    }
}
