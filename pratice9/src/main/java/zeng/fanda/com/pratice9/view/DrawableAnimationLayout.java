package zeng.fanda.com.pratice9.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import zeng.fanda.com.pratice9.R;

/**
 * 帧动画
 *
 * @author 曾凡达
 * @date 2018/10/11
 */
public class DrawableAnimationLayout extends RelativeLayout implements View.OnClickListener {

    private Button mLoadFrameAnimaion;
    private ImageView mFragmeAnimationIcon;
    private AnimationDrawable mAnimationDrawable;

    private int[] drawableRes = new int[]{R.mipmap.run1,R.mipmap.run2,R.mipmap.run3,R.mipmap.run4,
            R.mipmap.run5,R.mipmap.run6,R.mipmap.run7,R.mipmap.run8};

    public DrawableAnimationLayout(Context context) {
        super(context);
    }

    public DrawableAnimationLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawableAnimationLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mLoadFrameAnimaion = findViewById(R.id.btn_load_frame_animation);
        mFragmeAnimationIcon = findViewById(R.id.iv_frame_animation_icon);

        mLoadFrameAnimaion.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //可以在 xml 属性中设置
        mFragmeAnimationIcon.setBackgroundResource(R.drawable.frame_run_animation);
        mAnimationDrawable = (AnimationDrawable) mFragmeAnimationIcon.getBackground();
        mAnimationDrawable.start();
//        startFrameAnimation();
    }

    /**
     *  代码方式实现
     */
     private void startFrameAnimation() {
        mAnimationDrawable = new AnimationDrawable();
        for (int resId : drawableRes) {
            mAnimationDrawable.addFrame(getResources().getDrawable(resId),200);
        }
        //设置不是执行一次，即会永久循环播放动画
        mAnimationDrawable.setOneShot(false);
        mFragmeAnimationIcon.setImageDrawable(mAnimationDrawable);
        mAnimationDrawable.start();

    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mAnimationDrawable != null && mAnimationDrawable.isRunning()) {
            mAnimationDrawable.stop();
        }
    }

}
