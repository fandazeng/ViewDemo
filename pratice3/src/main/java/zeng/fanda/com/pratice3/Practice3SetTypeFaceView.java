package zeng.fanda.com.pratice3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 设置文本的字体样式
 *
 * @author 曾凡达
 * @date 2018/9/10
 */
public class Practice3SetTypeFaceView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice3SetTypeFaceView(Context context) {
        super(context);
    }

    public Practice3SetTypeFaceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice3SetTypeFaceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mPaint.setTextSize(100);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //加粗
        mPaint.setTypeface(Typeface.DEFAULT_BOLD);
        canvas.drawText("zeng fanda", 200, 200 , mPaint);
        //等宽字体
        mPaint.setTypeface(Typeface.MONOSPACE);
        canvas.drawText("zeng fanda", 200, 300, mPaint);

        mPaint.setTypeface(Typeface.SANS_SERIF);
        canvas.drawText("zeng fanda", 200, 400, mPaint);

        mPaint.setTypeface(Typeface.SERIF);
        canvas.drawText("zeng fanda", 200, 500, mPaint);

    }
}
