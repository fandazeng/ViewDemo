package zeng.fanda.com.viewdemo.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author 曾凡达
 * @date 2018/9/4
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.openDebug();
        ARouter.openLog();
        ARouter.init(this);
    }
}
