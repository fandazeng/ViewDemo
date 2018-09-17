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
@Route(path =  Constant.VIEW_Pratice2Activity)
public class Pratice2Activity extends SupportActivity {

    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;

    @BindView(R.id.pager)
    ViewPager mViewPager;

    List<PageModel> pageModels = new ArrayList<>();

    {
        pageModels.add(new PageModel(R.layout.practice_linear_gradient, R.string.title_linear_gradient, R.layout.practice_linear_gradient));
        pageModels.add(new PageModel(R.layout.practice_radial_gradient, R.string.title_radial_gradient, R.layout.practice_radial_gradient));
        pageModels.add(new PageModel(R.layout.practice_sweep_gradient, R.string.title_sweep_gradient, R.layout.practice_sweep_gradient));
        pageModels.add(new PageModel(R.layout.practice_bitmap_shader, R.string.title_bitmap_shader, R.layout.practice_bitmap_shader));
        pageModels.add(new PageModel(R.layout.practice_compose_shader, R.string.title_compose_shader, R.layout.practice_compose_shader));
        pageModels.add(new PageModel(R.layout.practice_lighting_color_filter, R.string.title_lighting_color_filter, R.layout.practice_lighting_color_filter));
        pageModels.add(new PageModel(R.layout.practice_porterduff_color_filter, R.string.title_porterduff_color_filter, R.layout.practice_porterduff_color_filter));
        pageModels.add(new PageModel(R.layout.practice_color_matrix_color_filter, R.string.title_color_matrix_color_filter, R.layout.practice_color_matrix_color_filter));
        pageModels.add(new PageModel(R.layout.practice_xfermode, R.string.title_xfermode, R.layout.practice_xfermode));
        pageModels.add(new PageModel(R.layout.practice_stroke_cap, R.string.title_stroke_cap, R.layout.practice_stroke_cap));
        pageModels.add(new PageModel(R.layout.practice_stroke_join, R.string.title_stroke_join, R.layout.practice_stroke_join));
        pageModels.add(new PageModel(R.layout.practice_stroke_miter, R.string.title_stroke_miter, R.layout.practice_stroke_miter));
        pageModels.add(new PageModel(R.layout.practice_path_effect, R.string.title_path_effect, R.layout.practice_path_effect));
        pageModels.add(new PageModel(R.layout.practice_shadow_layer, R.string.title_shader_layer, R.layout.practice_shadow_layer));
        pageModels.add(new PageModel(R.layout.practice_mask_filter, R.string.title_mask_filter, R.layout.practice_mask_filter));
        pageModels.add(new PageModel(R.layout.practice_fill_path, R.string.title_fill_path, R.layout.practice_fill_path));
        pageModels.add(new PageModel(R.layout.practice_text_path, R.string.title_text_path, R.layout.practice_text_path));
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
