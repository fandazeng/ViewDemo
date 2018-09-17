package zeng.fanda.com.pratice6;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import static zeng.fanda.com.pratice6.utils.Utils.dpToPixel;

/**
 * 混合多属性动画
 */
public class Practice6Multi extends RelativeLayout {

    private Button mStartAnimation;
    private ImageView mMusicIcon;

    private int translationStateCount = 2;

    private int mCurState = 0;

    public Practice6Multi(Context context) {
        super(context);
    }

    public Practice6Multi(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice6Multi(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        mStartAnimation = findViewById(R.id.btn_start_animation);
        mMusicIcon = findViewById(R.id.iv_music);
        mMusicIcon.setAlpha(0f);
        mMusicIcon.setScaleX(0f);
        mMusicIcon.setScaleY(0f);

        mStartAnimation.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击播放动画事件
                switch (mCurState) {
                    case 0:
                        //参数是倍数
                        mMusicIcon.animate().translationX(dpToPixel(200)).rotation(360).scaleX(1).scaleY(1).alpha(1f).setDuration(700);
                        break;
                    case 1:
                        mMusicIcon.animate().translationX(0).rotation(0).scaleX(0).scaleY(0).alpha(0f).setDuration(700);
                        break;
                }
                mCurState++;
                if (mCurState == translationStateCount) {
                    mCurState = 0;
                }
            }
        });
    }

}