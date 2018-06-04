package otc.open.com.otc.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import otc.open.com.otc.R;
import otc.open.com.otc.service.bean.Bean;

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
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.VHolder> {

    List<Bean> list;
    Context context;

    public MyAdapter(List<Bean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public VHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LinearLayout.inflate(context, R.layout.layout_item, null);
        VHolder holder = new VHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(VHolder holder, int position) {
        holder.t.setText(list.get(position).getTitle());
        String split = list.get(position).getImage();
        holder.dra.setImageURI(split);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class VHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.t)
        TextView t;
        @BindView(R.id.dra)
        SimpleDraweeView dra;

        public VHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
