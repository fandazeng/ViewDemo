package zeng.fanda.com.pratice6;

import android.content.Context;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import zeng.fanda.com.pratice6.utils.Utils;

/**
 * 速度设置器
 */
public class Practice6Interpolator extends LinearLayout {

    private Button mStartAnimation;
    private ImageView mMusicIcon;
    private Spinner mSpinner;

    private Interpolator[] mInterpolators = new Interpolator[13];
    private Path mInterpolatorPath;

    public Practice6Interpolator(Context context) {
        super(context);
    }

    public Practice6Interpolator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice6Interpolator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mInterpolatorPath = new Path();
        // 先以「时间完成度 : 动画完成度 = 1 : 1」的速度匀速运行 50%
        mInterpolatorPath.lineTo(0.5f, 0.5f);
        // 然后瞬间跳跃到 0% 的动画完成度
        mInterpolatorPath.moveTo(0.5f, 0f);
        // 然后「时间完成度 : 动画完成度 = 1 : 1」的速度匀速运行 50%
        mInterpolatorPath.lineTo(1, 1);
        mInterpolators[0] = new AccelerateDecelerateInterpolator();
        mInterpolators[1] = new LinearInterpolator();
        mInterpolators[2] = new AccelerateInterpolator();
        mInterpolators[3] = new DecelerateInterpolator();
        mInterpolators[4] = new AnticipateInterpolator();
        mInterpolators[5] = new OvershootInterpolator();
        mInterpolators[6] = new AnticipateOvershootInterpolator();
        mInterpolators[7] = new BounceInterpolator();
        mInterpolators[8] = new CycleInterpolator(0.5f);
        mInterpolators[9] = PathInterpolatorCompat.create(mInterpolatorPath);
        //AccelerateInterpolator，初始阶段加速度比 AccelerateInterpolator 要快一些
        mInterpolators[10] = new FastOutLinearInInterpolator();
        //AccelerateDecelerateInterpolator，初始阶段加速度比 AccelerateInterpolator 要快得多
        mInterpolators[11] = new FastOutSlowInInterpolator();
        //DecelerateInterpolator，，初始速度更高
        mInterpolators[12] = new LinearOutSlowInInterpolator();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        mSpinner =  findViewById(R.id.interpolatorSpinner);
        mStartAnimation = findViewById(R.id.btn_start_animation);
        mMusicIcon = findViewById(R.id.iv_music);

        mStartAnimation.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击播放动画事件
                mMusicIcon.animate()
                        .translationX(Utils.dpToPixel(150))
                        .setDuration(600)
                        .setInterpolator(mInterpolators[mSpinner.getSelectedItemPosition()])
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                mMusicIcon.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        mMusicIcon.setTranslationX(0);
                                    }
                                }, 500);
                            }
                        });
            }
        });
    }

}