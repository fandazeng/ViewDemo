package zeng.fanda.com.pratice7.hsvbevaluator;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
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
public class HsvEvalulatorLayout extends RelativeLayout {

    private HsvEvaluatorView mAnimationView;

    private Button mStartAnimation;

    private ObjectAnimator mObjectAnimator;

    public HsvEvalulatorLayout(Context context) {
        super(context);
    }

    public HsvEvalulatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HsvEvalulatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        mAnimationView = findViewById(R.id.animation_view);
        mStartAnimation = findViewById(R.id.btn_start_animation);

        mObjectAnimator = ObjectAnimator.ofInt(mAnimationView, "color", 0xffff0000,0xff00ff00);
        mObjectAnimator.setInterpolator(new LinearInterpolator());
        mObjectAnimator.setEvaluator(new HsvEvaluator());
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

    private class HsvEvaluator implements TypeEvaluator<Integer> {

        float[] startHsv = new float[3];

        float[] endHsv = new float[3];

        float[] outHsv = new float[3];

        @Override
        public Integer evaluate(float fraction, Integer startValue, Integer endValue) {

            // 把 ARGB 转换成 HSV
            Color.colorToHSV(startValue, startHsv);
            Color.colorToHSV(endValue, endHsv);

            // 计算当前动画完成度（fraction）所对应的颜色值
            if (endHsv[0] - startHsv[0] > 180) {
                endHsv[0] -= 360;
            } else if (endHsv[0] - startHsv[0] < -180) {
                endHsv[0] += 360;
            }

            outHsv[0] = startHsv[0] + (endHsv[0] - startHsv[0]) * fraction;
            if (outHsv[0] > 360) {
                outHsv[0] -= 360;
            } else if (outHsv[0] < 0) {
                outHsv[0] += 360;
            }

            outHsv[1] = startHsv[1] + (endHsv[1] - startHsv[1]) * fraction;
            outHsv[2] = startHsv[2] + (endHsv[2] - startHsv[2]) * fraction;

            // 计算当前动画完成度（fraction）所对应的透明度
            int alpha = startValue >> 24 + (int) ((endValue >> 24 - startValue >> 24) * fraction);

            // 把 HSV 转换回 ARGB 返回
            return Color.HSVToColor(alpha,outHsv);
        }
    }
}
