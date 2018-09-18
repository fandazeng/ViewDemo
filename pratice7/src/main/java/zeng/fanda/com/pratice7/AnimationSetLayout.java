package zeng.fanda.com.pratice7;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * @author 曾凡达
 * @date 2018/9/18
 */
public class AnimationSetLayout extends RelativeLayout {

    private ImageView mMusicIcon;

    private Button mStartAnimation;

    private AnimatorSet mAnimatorSet;

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

        mMusicIcon = findViewById(R.id.iv_music);
        mStartAnimation = findViewById(R.id.btn_start_animation);

        ObjectAnimator scaleX = ObjectAnimator.ofFloat(mMusicIcon, "scaleX", 0, 1);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(mMusicIcon, "scaleY", 0, 1);
        ObjectAnimator translation = ObjectAnimator.ofFloat(mMusicIcon, "translationX", -200,500);
        ObjectAnimator rotation = ObjectAnimator.ofFloat(mMusicIcon, "rotation", 1080);
        rotation.setDuration(2000);
        mAnimatorSet = new AnimatorSet();
        mAnimatorSet.playTogether(scaleX,scaleY);
        mAnimatorSet.play(translation).with(rotation);

        mStartAnimation.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mAnimatorSet.start();
            }
        });
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mAnimatorSet.end();
    }
}
