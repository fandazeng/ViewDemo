package zeng.fanda.com.pratice3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 设置文字对齐方式
 *
 * @author 曾凡达
 * @date 2018/9/10
 */
public class Practice3SetTextAlignView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice3SetTextAlignView(Context context) {
        super(context);
    }

    public Practice3SetTextAlignView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice3SetTextAlignView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mPaint.setTextSize(100);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText("hello fanda", 700, 200, mPaint);

        mPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("hello fanda", 700, 300, mPaint);

        mPaint.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText("hello fanda", 700, 400, mPaint);

    }
}
