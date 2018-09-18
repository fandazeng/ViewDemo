package zeng.fanda.com.pratice7.keyframe;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;

import zeng.fanda.com.pratice7.R;


/**
 * @author 曾凡达
 * @date 2018/9/17
 */
public class KeyFrameLayout extends RelativeLayout {

    private KeyFrameView mAnimationView;

    private Button mStartAnimation;

    private ObjectAnimator mObjectAnimator;

    public KeyFrameLayout(Context context) {
        super(context);
    }

    public KeyFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public KeyFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        mAnimationView = findViewById(R.id.animation_view);
        mStartAnimation = findViewById(R.id.btn_start_animation);

        // 在0%处开始
        Keyframe keyframe1 = Keyframe.ofFloat(0, 0);
        // 时间经过50%的时候，动画完成度100%
        Keyframe keyframe2 = Keyframe.ofFloat(0.5f, 100);
        //时间到 100%时，动画完成度倒退到80%，即反弹20%
        Keyframe keyframe3 = Keyframe.ofFloat(1f, 80);

        PropertyValuesHolder holder = PropertyValuesHolder.ofKeyframe("progress", keyframe1, keyframe2, keyframe3);
        mObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(mAnimationView, holder);
        mObjectAnimator.setInterpolator(new FastOutSlowInInterpolator());
        mObjectAnimator.setDuration(2000);

        mObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Log.d("animation value ===", valueAnimator.getAnimatedValue().toString());
            }
        });

        mStartAnimation.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mObjectAnimator.start();
            }
        });
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mObjectAnimator.end();
    }
}
