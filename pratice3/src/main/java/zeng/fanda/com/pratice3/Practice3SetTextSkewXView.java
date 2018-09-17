package zeng.fanda.com.pratice3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 文字倾斜度
 *
 * @author 曾凡达
 * @date 2018/9/10
 */
public class Practice3SetTextSkewXView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice3SetTextSkewXView(Context context) {
        super(context);
    }

    public Practice3SetTextSkewXView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice3SetTextSkewXView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setTextSize(100);
        mPaint.setTextSkewX(-0.3f);
        canvas.drawText("fanda", 200, 300, mPaint);

    }
}
