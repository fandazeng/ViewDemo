package zeng.fanda.com.pratice7;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * @author 曾凡达
 * @date 2018/9/18
 */
public class PropertyValuesHolderLayout extends RelativeLayout {

    private ImageView mMusicIcon;

    private Button mStartAnimation;

    private ObjectAnimator mObjectAnimator;

    public PropertyValuesHolderLayout(Context context) {
        super(context);
    }

    public PropertyValuesHolderLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PropertyValuesHolderLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        mMusicIcon = findViewById(R.id.iv_music);
        mStartAnimation = findViewById(R.id.btn_start_animation);

        PropertyValuesHolder holder1 = PropertyValuesHolder.ofFloat("scaleY", 0,1);
        PropertyValuesHolder holder2 = PropertyValuesHolder.ofFloat("scaleX", 0,1);
        PropertyValuesHolder holder3 = PropertyValuesHolder.ofFloat("alpha", 0,1);
        mObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(mMusicIcon, holder1,holder2,holder3);
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
