package zeng.fanda.com.pratice9.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
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
public class RotateAnimationLayout extends RelativeLayout implements View.OnClickListener {

    private Button mLoadFrameAnimaion;
    private ImageView mFragmeAnimationIcon;

    private Animation mAnimation;

    public RotateAnimationLayout(Context context) {
        super(context);
    }

    public RotateAnimationLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RotateAnimationLayout(Context context, AttributeSet attrs, int defStyleAttr) {
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
//            mAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.rotate_anim);
            initRotateAnimationByCode();
            mFragmeAnimationIcon.startAnimation(mAnimation);
        } else {
            Toast.makeText(getContext(), "I am a lion", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     *  代码方式实现
     */
    public void  initRotateAnimationByCode() {
        mAnimation = new RotateAnimation(90f, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mAnimation.setRepeatCount(Animation.INFINITE);
        mAnimation.setDuration(2000);
        mAnimation.setRepeatMode(Animation.REVERSE);
        mAnimation.setInterpolator(new LinearInterpolator());

        mAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Toast.makeText(getContext(),"onAnimationStart",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(getContext(),"onAnimationEnd",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Toast.makeText(getContext(),"onAnimationRepeat",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mAnimation != null) {
            mAnimation.cancel();
        }
    }

}
