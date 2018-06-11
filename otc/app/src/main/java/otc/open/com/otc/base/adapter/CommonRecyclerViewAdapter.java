package otc.open.com.otc.base.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by zlc on 2017/2/8.
 * RecycleView通用数据适配器
 */

public abstract class CommonRecyclerViewAdapter<T,VH extends CommonRecyclerViewHolder> extends RecyclerView.Adapter<VH>{
    protected Context mContext;
    protected List<T> mDatas;
    protected View mView;
    private VH viewHolder;

    public CommonRecyclerViewAdapter(Context context, List<T> datas){
        this.mContext = context;
        this.mDatas = datas;
    }


    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        mView = convertView();
        viewHolder = createHolder(mView);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return mDatas!=null && mDatas.size()>0 ? mDatas.size() : 0;
    }

    public T getItem(int position){
        return mDatas.get(position);
    }

    @Override
    public  void onBindViewHolder(VH holder, int position){
        setData(holder,getItem(position),position);
    }

    public abstract VH createHolder(View view);

    public abstract View convertView();

    public abstract void setData(VH holder,T item,int position);

}
