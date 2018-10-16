package zeng.fanda.com.pratice9.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
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
public class TranslateAnimationLayout extends RelativeLayout implements View.OnClickListener {

    private Button mLoadFrameAnimaion;
    private ImageView mFragmeAnimationIcon;

    private Animation mAnimation;

    public TranslateAnimationLayout(Context context) {
        super(context);
    }

    public TranslateAnimationLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TranslateAnimationLayout(Context context, AttributeSet attrs, int defStyleAttr) {
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
//            mAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.translate_anim);
            initTranslateAnimationByCode();
            mFragmeAnimationIcon.startAnimation(mAnimation);
        } else {
            Toast.makeText(getContext(), "I am a lion", Toast.LENGTH_SHORT).show();
        }
    }

    public void  initTranslateAnimationByCode() {
        // 如果是Animation.RELATIVE_TO_PARENT 或 Animation.RELATIVE_TO_SELF ，则值要用百分比 0% -100%
        mAnimation = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,0.5f,Animation.RELATIVE_TO_PARENT,
                0.2f,Animation.RELATIVE_TO_PARENT, 0.5f,Animation.RELATIVE_TO_PARENT, 0.2f);


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
