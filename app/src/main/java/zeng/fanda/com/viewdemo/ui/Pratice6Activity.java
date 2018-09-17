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
@Route(path =  Constant.VIEW_Pratice6Activity)
public class Pratice6Activity extends SupportActivity {

    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;

    @BindView(R.id.pager)
    ViewPager mViewPager;

    List<PageModel> pageModels = new ArrayList<>();

    {
        pageModels.add(new PageModel(R.layout.practice_translation, R.string.title_translation, R.layout.practice_translation));
        pageModels.add(new PageModel(R.layout.practice_rotation, R.string.title_rotation, R.layout.practice_rotation));
        pageModels.add(new PageModel(R.layout.practice_zoom, R.string.title_scale, R.layout.practice_zoom));
        pageModels.add(new PageModel(R.layout.practice_alpha, R.string.title_alpha, R.layout.practice_alpha));
        pageModels.add(new PageModel(R.layout.practice_multi_properties, R.string.title_multi_properties, R.layout.practice_multi_properties));
        pageModels.add(new PageModel(R.layout.practice_interpolator, R.string.title_interpolator, R.layout.practice_interpolator));
        pageModels.add(new PageModel(R.layout.practice_object_animator, R.string.title_object_animator, R.layout.practice_object_animator));
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
}
