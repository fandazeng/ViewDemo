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
@Route(path =  Constant.VIEW_Pratice4Activity)
public class Pratice4Activity extends SupportActivity {

    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;

    @BindView(R.id.pager)
    ViewPager mViewPager;

    List<PageModel> pageModels = new ArrayList<>();

    {
        pageModels.add(new PageModel(R.layout.practice_clip_rect, R.string.title_clip_rect, R.layout.practice_clip_rect));
        pageModels.add(new PageModel(R.layout.practice_clip_path, R.string.title_clip_path, R.layout.practice_clip_path));
        pageModels.add(new PageModel(R.layout.practice_translate, R.string.title_translate, R.layout.practice_translate));
        pageModels.add(new PageModel(R.layout.practice_scale, R.string.title_scale, R.layout.practice_scale));
        pageModels.add(new PageModel(R.layout.practice_rotate, R.string.title_rotate, R.layout.practice_rotate));
        pageModels.add(new PageModel(R.layout.practice_skew, R.string.title_skew, R.layout.practice_skew));
        pageModels.add(new PageModel(R.layout.practice_matrix_translate, R.string.title_matrix_translate, R.layout.practice_matrix_translate));
        pageModels.add(new PageModel(R.layout.practice_matrix_scale, R.string.title_matrix_scale, R.layout.practice_matrix_scale));
        pageModels.add(new PageModel(R.layout.practice_matrix_rotate, R.string.title_matrix_rotate, R.layout.practice_matrix_rotate));
        pageModels.add(new PageModel(R.layout.practice_matrix_skew, R.string.title_matrix_skew, R.layout.practice_matrix_skew));
        pageModels.add(new PageModel(R.layout.practice_camera_rotate, R.string.title_camera_rotate, R.layout.practice_camera_rotate));
        pageModels.add(new PageModel(R.layout.pratice_camera_rotate_fixed, R.string.title_camera_rotate_fixed, R.layout.pratice_camera_rotate_fixed));
        pageModels.add(new PageModel(R.layout.practice_camera_rotate_hitting_face, R.string.title_camera_rotate_hitting_face, R.layout.practice_camera_rotate_hitting_face));
        pageModels.add(new PageModel(R.layout.practice_flipboard, R.string.title_flipboard, R.layout.practice_flipboard));
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
