package otc.open.com.otc.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import otc.open.com.otc.R;
import otc.open.com.otc.adapter.MyAdapter;
import otc.open.com.otc.presenter.impl.PresenterImpl;
import otc.open.com.otc.service.bean.Bean;
import otc.open.com.otc.viewInter.ViewInter;
import rx.subscriptions.CompositeSubscription;

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
public class XMainActivity extends AppCompatActivity implements ViewInter {
    private XRecyclerView xre;
    private List<Bean> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xmain);

        xre = findViewById(R.id.xre);
        PresenterImpl presenter=new PresenterImpl(this,this);
        presenter.info();


    }

    @Override
    public void onSuccessV(Bean bean) {
        list.add(new Bean());
        list.add(new Bean());
        list.add(new Bean());
        MyAdapter adapter=new MyAdapter(list,XMainActivity.this);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(XMainActivity.this,2,GridLayoutManager.VERTICAL,false);
        xre.setLayoutManager(gridLayoutManager);
        xre.setAdapter(adapter);

    }

    @Override
    protected void onStop() {
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        compositeSubscription.unsubscribe();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}