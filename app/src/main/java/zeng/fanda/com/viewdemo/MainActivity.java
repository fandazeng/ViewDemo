package zeng.fanda.com.viewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportActivity;
import zeng.fanda.com.viewdemo.adapter.PraticeTypeAdapter;
import zeng.fanda.com.viewdemo.base.Constant;
import zeng.fanda.com.viewdemo.di.DaggerMainCompoment;
import zeng.fanda.com.viewdemo.model.TypeBean;
import zeng.fanda.com.viewdemo.ui.Pratice9Activity;
import zeng.fanda.com.viewdemo.utils.EntranceUtils;

public class MainActivity extends SupportActivity {

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    @Inject
    PraticeTypeAdapter mPraticeTypeAdapter;

    private List<TypeBean> mTypeBeanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DaggerMainCompoment.builder().build().inject(this);
        initListData();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mPraticeTypeAdapter);
        mPraticeTypeAdapter.setNewData(mTypeBeanList);
        mPraticeTypeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ARouter.getInstance().build(mTypeBeanList.get(position).path)
                        .navigation(MainActivity.this);

//                ARouter.getInstance().build(mTypeBeanList.get(position).path)
//                        .withTransition(R.anim.slide_in_right,R.anim.slide_out_left)
//                        .navigation(MainActivity.this);

            }
        });
    }

    private void initListData() {
        mTypeBeanList = new ArrayList<>();
        mTypeBeanList.add(new TypeBean("View基础练习", Constant.VIEW_Pratice1Activity));
        mTypeBeanList.add(new TypeBean("Paint基础练习", Constant.VIEW_Pratice2Activity));
        mTypeBeanList.add(new TypeBean("Paint文本绘制", Constant.VIEW_Pratice3Activity));
        mTypeBeanList.add(new TypeBean("Canvas对绘制的辅助", Constant.VIEW_Pratice4Activity));
        mTypeBeanList.add(new TypeBean("绘制的顺序", Constant.VIEW_Pratice5Activity));
        mTypeBeanList.add(new TypeBean("补间动画", Constant.VIEW_Pratice9Activity));
        mTypeBeanList.add(new TypeBean("属性动画(上手)", Constant.VIEW_Pratice6Activity));
        mTypeBeanList.add(new TypeBean("属性动画(进阶)", Constant.VIEW_Pratice7Activity));
        mTypeBeanList.add(new TypeBean("布局", Constant.VIEW_Pratice8Activity));
    }
}
