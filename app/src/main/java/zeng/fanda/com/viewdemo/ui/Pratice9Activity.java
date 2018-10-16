package zeng.fanda.com.viewdemo.ui;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportActivity;
import zeng.fanda.com.viewdemo.PageFragment;
import zeng.fanda.com.viewdemo.R;
import zeng.fanda.com.viewdemo.base.Constant;

/**
 * @author 曾凡达
 * @date 2018/9/4
 */
@Route(path =  Constant.VIEW_Pratice9Activity)
public class Pratice9Activity extends SupportActivity {

    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;

    @BindView(R.id.pager)
    ViewPager mViewPager;

    List<PageModel> pageModels = new ArrayList<>();

    {
        pageModels.add(new PageModel(R.layout.drawable_animation_layout, R.string.frame_animation, R.layout.drawable_animation_layout));
        pageModels.add(new PageModel(R.layout.tween_animation_translate, R.string.translate_animation, R.layout.tween_animation_translate));
        pageModels.add(new PageModel(R.layout.tween_animation_alpha, R.string.alpha_animation, R.layout.tween_animation_alpha));
        pageModels.add(new PageModel(R.layout.tween_animation_scale, R.string.scale_animation, R.layout.tween_animation_scale));
        pageModels.add(new PageModel(R.layout.tween_animation_rotate, R.string.rotate_animation, R.layout.tween_animation_rotate));
        pageModels.add(new PageModel(R.layout.tween_animation_set, R.string.set_animation, R.layout.tween_animation_set));
        pageModels.add(new PageModel(R.layout.layout_animation, R.string.layout_animation, R.layout.layout_animation));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pratice_1);
        ButterKnife.bind(this);
        mViewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                PageModel pageModel = pageModels.get(position);
                return PageFragment.newInstance(pageModel.sampleLayoutRes, pageModel.practiceLayoutRes);
            }

            @Override
            public int getCount() {
                return pageModels.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getString(pageModels.get(position).titleRes);
            }
        });

        mTabLayout.setupWithViewPager(mViewPager);
    }

    private class PageModel {
        @LayoutRes
        int sampleLayoutRes;
        @StringRes
        int titleRes;
        @LayoutRes int practiceLayoutRes;

        PageModel(@LayoutRes int sampleLayoutRes, @StringRes int titleRes, @LayoutRes int practiceLayoutRes) {
            this.sampleLayoutRes = sampleLayoutRes;
            this.titleRes = titleRes;
            this.practiceLayoutRes = practiceLayoutRes;
        }
    }

    @Override
    public void onBackPressedSupport() {
        super.onBackPressedSupport();
//        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }

}
