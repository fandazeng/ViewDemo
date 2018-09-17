package zeng.fanda.com.viewdemo.di;

import dagger.Component;
import zeng.fanda.com.viewdemo.MainActivity;

/**
 * @author 曾凡达
 * @date 2018/9/4
 */
@Component
public interface MainCompoment {
    void inject(MainActivity mainActivity);
}
