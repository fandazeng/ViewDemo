package zeng.fanda.com.pratice5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * 在 OnDrawForegroun 后面插入代码
 *
 * @author 曾凡达
 * @date 2018/9/10
 */
public class Practice5AfterOnDrawForegroundView extends AppCompatImageView {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice5AfterOnDrawForegroundView(Context context) {
        super(context);
    }

    public Practice5AfterOnDrawForegroundView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice5AfterOnDrawForegroundView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mPaint.setTextSize(28);
        mPaint.setColor(Color.RED);
    }

    @Override
    public void onDrawForeground(Canvas canvas) {
        super.onDrawForeground(canvas);

        //这个方法在api23以上才有效

        //代码写在后面
        if (BuildConfig.DEBUG) {
            // 在DEBUG模式下绘制出 drawable 的尺寸信息
            Drawable drawable = getDrawable();
            if (drawable != null) {
                canvas.save();
                canvas.concat(getImageMatrix());
                canvas.drawRect(0,10,100,50,mPaint);
                mPaint.setColor(Color.WHITE);
                canvas.drawText("NEW", 20, 40, mPaint);
                canvas.restore();
            }
        }
    }

}
