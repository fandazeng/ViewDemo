package zeng.fanda.com.pratice6;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * 渐变动画
 */
public class Practice6Alpha extends LinearLayout {

    private Button mStartAnimation;
    private ImageView mMusicIcon;

    private int translationStateCount = 2;

    private int mCurState = 0;

    public Practice6Alpha(Context context) {
        super(context);
    }

    public Practice6Alpha(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice6Alpha(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        mStartAnimation = findViewById(R.id.btn_start_animation);
        mMusicIcon = findViewById(R.id.iv_music);

        mStartAnimation.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击播放动画事件
                switch (mCurState) {
                    case 0:
                        //参数是倍数
                        mMusicIcon.animate().alpha(0f);
                        break;
                    case 1:
                        mMusicIcon.animate().alpha(1f);
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