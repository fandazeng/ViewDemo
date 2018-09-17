package zeng.fanda.com.pratice6;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import static zeng.fanda.com.pratice6.utils.Utils.dpToPixel;

/**
 * 缩放动画
 */
public class Practice6Scale extends LinearLayout {

    private Button mStartAnimation;
    private ImageView mMusicIcon;

    private int translationStateCount = 4;

    private int mCurState = 0;

    public Practice6Scale(Context context) {
        super(context);
    }

    public Practice6Scale(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice6Scale(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
                        mMusicIcon.animate().scaleX(1.5f);
                        break;
                    case 1:
                        mMusicIcon.animate().scaleX(1);
                        break;
                    case 2:
                        mMusicIcon.animate().scaleY(1.5f);
                        break;
                    case 3:
                        mMusicIcon.animate().scaleY(1);
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