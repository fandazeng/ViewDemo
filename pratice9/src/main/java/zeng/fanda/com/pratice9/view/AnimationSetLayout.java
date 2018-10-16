package zeng.fanda.com.pratice9.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import zeng.fanda.com.pratice9.R;

/**
 * 动画集合
 *
 * @author 曾凡达
 * @date 2018/10/11
 */
public class AnimationSetLayout extends RelativeLayout implements View.OnClickListener {

    private Button mLoadFrameAnimaion;
    private ImageView mFragmeAnimationIcon;

    private Animation mTranslateAnimation;
    private Animation mAlphaAnimation;
    private Animation mScaleAnimation;
    private Animation mRotateAnimation;

    private AnimationSet mAnimationSet;

    public AnimationSetLayout(Context context) {
        super(context);
    }

    public AnimationSetLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AnimationSetLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mLoadFrameAnimaion = findViewById(R.id.btn_load_frame_animation);
        mFragmeAnimationIcon = findViewById(R.id.iv_frame_animation_icon);

        mFragmeAnimationIcon.setOnClickListener(this);
        mLoadFrameAnimaion.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_load_frame_animation) {
//            mAnimationSet = (AnimationSet) AnimationUtils.loadAnimation(getContext(), R.anim.set_anim);
            initAnimationSetByCode();
            mFragmeAnimationIcon.startAnimation(mAnimationSet);
        } else {
            Toast.makeText(getContext(), "I am a lion", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     *  代码方式实现
     */
    public void  initAnimationSetByCode() {
        mTranslateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_PARENT,
                0.2f,Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_PARENT, 0.2f);
        mTranslateAnimation.setRepeatCount(Animation.INFINITE);

        mAlphaAnimation = new AlphaAnimation(1, 0);
        mAlphaAnimation.setRepeatCount(Animation.INFINITE);

        mScaleAnimation = new ScaleAnimation(0.5f, 1.5f, 0.5f, 1.5f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mScaleAnimation.setRepeatCount(Animation.INFINITE);

        mRotateAnimation = new RotateAnimation(90f, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mRotateAnimation.setRepeatCount(Animation.INFINITE);

        mAnimationSet = new AnimationSet(true);

        mAnimationSet.addAnimation(mTranslateAnimation);
        mAnimationSet.addAnimation(mRotateAnimation);
        mAnimationSet.addAnimation(mScaleAnimation);
        mAnimationSet.addAnimation(mAlphaAnimation);

        mAnimationSet.setDuration(1000);
        mAnimationSet.setRepeatMode(Animation.REVERSE);
        mAnimationSet.setInterpolator(new LinearInterpolator());

    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mAnimationSet != null) {
            mAnimationSet.cancel();
        }
    }

}
