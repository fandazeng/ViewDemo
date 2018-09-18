package zeng.fanda.com.pratice7.argbevaluator;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;

import zeng.fanda.com.pratice7.R;

/**
 * @author 曾凡达
 * @date 2018/9/18
 */
public class ArgbEvalulatorLayout extends RelativeLayout {

    private ArgbEvaluatorView mAnimationView;

    private Button mStartAnimation;

    private ObjectAnimator mObjectAnimator;

    public ArgbEvalulatorLayout(Context context) {
        super(context);
    }

    public ArgbEvalulatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ArgbEvalulatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        mAnimationView = findViewById(R.id.animation_view);
        mStartAnimation = findViewById(R.id.btn_start_animation);

        mObjectAnimator = ObjectAnimator.ofInt(mAnimationView, "color", 0xffff0000,0xff00ff00);
        mObjectAnimator.setInterpolator(new LinearInterpolator());
        mObjectAnimator.setEvaluator(new ArgbEvaluator());
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
