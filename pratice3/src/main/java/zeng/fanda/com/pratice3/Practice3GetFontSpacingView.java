package zeng.fanda.com.pratice3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 获取推荐的行距
 *
 * @author 曾凡达
 * @date 2018/9/10
 */
public class Practice3GetFontSpacingView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice3GetFontSpacingView(Context context) {
        super(context);
    }

    public Practice3GetFontSpacingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice3GetFontSpacingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mPaint.setTextSize(100);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawText("hello fanda", 500, 200, mPaint);

        canvas.drawText("hello fanda", 500, 200 + mPaint.getFontSpacing(), mPaint);

        canvas.drawText("hello fanda", 500, 200 + mPaint.getFontSpacing() * 2, mPaint);

    }
}
