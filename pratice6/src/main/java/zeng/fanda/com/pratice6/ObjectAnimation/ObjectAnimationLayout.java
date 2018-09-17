package zeng.fanda.com.pratice6.ObjectAnimation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.logging.Logger;

import zeng.fanda.com.pratice6.R;

/**
 * @author 曾凡达
 * @date 2018/9/17
 */
public class ObjectAnimationLayout extends RelativeLayout {

    private ObjectAnimationView mAnimationView;

    private Button mStartAnimation;

    private ObjectAnimator mObjectAnimator;

    public ObjectAnimationLayout(Context context) {
        super(context);
    }

    public ObjectAnimationLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ObjectAnimationLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        mAnimationView = findViewById(R.id.animation_view);
        mStartAnimation = findViewById(R.id.btn_start_animation);

        mObjectAnimator = ObjectAnimator.ofFloat(mAnimationView, "progress", 70);
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
