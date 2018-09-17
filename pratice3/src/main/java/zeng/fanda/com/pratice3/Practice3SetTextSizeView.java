package zeng.fanda.com.pratice3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 设置文本的字体大小
 *
 * @author 曾凡达
 * @date 2018/9/10
 */
public class Practice3SetTextSizeView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice3SetTextSizeView(Context context) {
        super(context);
    }

    public Practice3SetTextSizeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice3SetTextSizeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setTextSize(50);
        canvas.drawText("fanda", 200, 200, mPaint);
        mPaint.setTextSize(60);
        canvas.drawText("fanda", 200, 300, mPaint);
        mPaint.setTextSize(70);
        canvas.drawText("fanda", 200, 400, mPaint);
        mPaint.setTextSize(80);
        canvas.drawText("fanda", 200, 500, mPaint);
        mPaint.setTextSize(90);
        canvas.drawText("fanda", 200, 600, mPaint);

    }
}
