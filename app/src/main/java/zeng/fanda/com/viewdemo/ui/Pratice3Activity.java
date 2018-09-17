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
@Route(path =  Constant.VIEW_Pratice3Activity)
public class Pratice3Activity extends SupportActivity {

    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;

    @BindView(R.id.pager)
    ViewPager mViewPager;

    List<PageModel> pageModels = new ArrayList<>();

    {
        pageModels.add(new PageModel(R.layout.practice_draw_text, R.string.title_draw_text, R.layout.practice_draw_text));
        pageModels.add(new PageModel(R.layout.practice_static_layout, R.string.title_static_layout, R.layout.practice_static_layout));
        pageModels.add(new PageModel(R.layout.practice_set_text_size, R.string.title_set_text_size, R.layout.practice_set_text_size));
        pageModels.add(new PageModel(R.layout.practice_set_typeface, R.string.title_set_typeface, R.layout.practice_set_typeface));
        pageModels.add(new PageModel(R.layout.practice_set_fake_bold_text, R.string.title_set_fake_bold_text, R.layout.practice_set_fake_bold_text));
        pageModels.add(new PageModel(R.layout.practice_set_strike_thru_text, R.string.title_set_strike_thru_text, R.layout.practice_set_strike_thru_text));
        pageModels.add(new PageModel(R.layout.practice_set_underline_text, R.string.title_set_underline_text, R.layout.practice_set_underline_text));
        pageModels.add(new PageModel(R.layout.practice_set_text_skew_x, R.string.title_set_text_skew_x, R.layout.practice_set_text_skew_x));
        pageModels.add(new PageModel(R.layout.practice_set_text_scale_x, R.string.title_set_text_scale_x, R.layout.practice_set_text_scale_x));
        pageModels.add(new PageModel(R.layout.practice_set_text_align, R.string.title_set_text_align, R.layout.practice_set_text_align));
        pageModels.add(new PageModel(R.layout.practice_get_font_spacing, R.string.title_get_font_spacing, R.layout.practice_get_font_spacing));
        pageModels.add(new PageModel(R.layout.practice_measure_text, R.string.title_measure_text, R.layout.practice_measure_text));
        pageModels.add(new PageModel(R.layout.practice_get_text_bounds, R.string.title_get_text_bounds, R.layout.practice_get_text_bounds));
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
