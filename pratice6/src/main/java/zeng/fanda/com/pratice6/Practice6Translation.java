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
 * 位移动画
 */
public class Practice6Translation extends LinearLayout {

    private Button mStartAnimation;
    private ImageView mMusicIcon;

    private int translationStateCount = Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP ? 6 : 4;

    private int mCurState = 0;

    public Practice6Translation(Context context) {
        super(context);
    }

    public Practice6Translation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice6Translation(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        mStartAnimation = findViewById(R.id.btn_start_animation);
        mMusicIcon = findViewById(R.id.iv_music);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            // 给音乐图标加上合适的阴影
            mMusicIcon.setOutlineProvider(new MusicOutlineProvider());
        }
        mStartAnimation.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击播放动画事件
                switch (mCurState) {
                    case 0:
                        mMusicIcon.animate().translationX(dpToPixel(100));
                        break;
                    case 1:
                        mMusicIcon.animate().translationX(0);
                        break;
                    case 2:
                        mMusicIcon.animate().translationYBy(dpToPixel(50));
                        break;
                    case 3:
                        mMusicIcon.animate().translationY(0);
                        break;
                    case 4:
                        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
                            mMusicIcon.animate().translationZ(dpToPixel(10));
                        }
                        break;
                    case 5:
                        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
                            mMusicIcon.animate().translationZ(0);
                        }
                        break;
                }
                mCurState++;
                if (mCurState == translationStateCount) {
                    mCurState = 0;
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    class MusicOutlineProvider extends ViewOutlineProvider {
        Path mPath = new Path();

        {
            mPath.moveTo(0, dpToPixel(10));
            mPath.lineTo(dpToPixel(7), dpToPixel(2));
            mPath.lineTo(dpToPixel(116), dpToPixel(58));
            mPath.lineTo(dpToPixel(116), dpToPixel(70));
            mPath.lineTo(dpToPixel(7), dpToPixel(128));
            mPath.lineTo(0, dpToPixel(120));
            mPath.close();
        }

        @Override
        public void getOutline(View view, Outline outline) {
            outline.setConvexPath(mPath);
        }
    }

}