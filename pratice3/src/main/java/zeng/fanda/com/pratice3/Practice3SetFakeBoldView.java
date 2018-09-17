package zeng.fanda.com.pratice3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 加粗文本
 *
 * @author 曾凡达
 * @date 2018/9/10
 */
public class Practice3SetFakeBoldView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice3SetFakeBoldView(Context context) {
        super(context);
    }

    public Practice3SetFakeBoldView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice3SetFakeBoldView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setTextSize(100);
        mPaint.setFakeBoldText(false);
        canvas.drawText("fanda", 200, 200, mPaint);
        mPaint.setFakeBoldText(true);
        canvas.drawText("fanda", 200, 300, mPaint);

    }
}
