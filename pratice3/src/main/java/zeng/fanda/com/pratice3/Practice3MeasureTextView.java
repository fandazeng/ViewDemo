package zeng.fanda.com.pratice3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 获取测量文字的宽度
 *
 * @author 曾凡达
 * @date 2018/9/10
 */
public class Practice3MeasureTextView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private String text1 = "三个月内你胖了";
    private String text2 = "4.5";
    private String text3 = "公斤";

    private float text1_width;
    private float text2_width;

    public Practice3MeasureTextView(Context context) {
        super(context);
    }

    public Practice3MeasureTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice3MeasureTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setTextSize(100);
        canvas.drawText(text1, 200, 200, mPaint);
        text1_width = mPaint.measureText(text1);

        mPaint.setTextSize(150);
        mPaint.setColor(Color.RED);
        canvas.drawText(text2, 200 + text1_width, 200, mPaint);
        text2_width = mPaint.measureText(text2);

        mPaint.reset();
        mPaint.setTextSize(100);
        canvas.drawText(text3, 200 + text1_width + text2_width, 200, mPaint);

    }
}
