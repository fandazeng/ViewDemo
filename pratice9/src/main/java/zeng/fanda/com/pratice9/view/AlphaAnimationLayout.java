package zeng.fanda.com.pratice9.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import zeng.fanda.com.pratice9.R;

/**
 * 位移动画
 *
 * @author 曾凡达
 * @date 2018/10/11
 */
public class AlphaAnimationLayout extends RelativeLayout implements View.OnClickListener {

    private Button mLoadFrameAnimaion;
    private ImageView mFragmeAnimationIcon;

    private Animation mAnimation;

    public AlphaAnimationLayout(Context context) {
        super(context);
    }

    public AlphaAnimationLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AlphaAnimationLayout(Context context, AttributeSet attrs, int defStyleAttr) {
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
//            mAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.alpha_anim);
            initAlphaAnimationByCode();
            mFragmeAnimationIcon.startAnimation(mAnimation);
        } else {
            Toast.makeText(getContext(), "I am a lion", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     *  代码方式实现
     */
    public void  initAlphaAnimationByCode() {
        mAnimation = new AlphaAnimation(1, 0);
        mAnimation.setRepeatCount(Animation.INFINITE);
        mAnimation.setDuration(2000);
        mAnimation.setRepeatMode(Animation.REVERSE);
        mAnimation.setInterpolator(new LinearInterpolator());

    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mAnimation != null) {
            mAnimation.cancel();
        }
    }

}
