package zeng.fanda.com.pratice7.ofobject;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PointFEvaluator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.lang.reflect.Type;

import zeng.fanda.com.pratice7.R;
import zeng.fanda.com.pratice7.argbevaluator.ArgbEvaluatorView;

/**
 * @author 曾凡达
 * @date 2018/9/18
 */
public class PointEvalulatorLayout extends RelativeLayout {

    private PointView mAnimationView;

    private Button mStartAnimation;

    private ObjectAnimator mObjectAnimator;

    public PointEvalulatorLayout(Context context) {
        super(context);
    }

    public PointEvalulatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PointEvalulatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        mAnimationView = findViewById(R.id.animation_view);
        mStartAnimation = findViewById(R.id.btn_start_animation);

        mObjectAnimator = ObjectAnimator.ofObject(mAnimationView, "position", new PointEvaluator(),new PointF(0,0),new PointF(1,1));
        mObjectAnimator.setInterpolator(new FastOutSlowInInterpolator());
        mObjectAnimator.setEvaluator(new PointEvaluator());
        mObjectAnimator.setDuration(1000);

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

    private class PointEvaluator implements TypeEvaluator<PointF> {

        PointF mPointF = new PointF();

        @Override
        public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
            float x = startValue.x + (endValue.x - startValue.x) * fraction;
            float y = startValue.y + (endValue.y - startValue.y) * fraction;
            mPointF.set(x,y);
            return mPointF;
        }
    }

}
