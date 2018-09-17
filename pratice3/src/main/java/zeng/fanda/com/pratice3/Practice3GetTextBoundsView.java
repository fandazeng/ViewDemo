package zeng.fanda.com.pratice3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 获取文字的显示范围
 *
 * @author 曾凡达
 * @date 2018/9/10
 */
public class Practice3GetTextBoundsView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private String content = "hello fanda!";

    private Rect mRect = new Rect();

    public Practice3GetTextBoundsView(Context context) {
        super(context);
    }

    public Practice3GetTextBoundsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice3GetTextBoundsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setTextSize(100);
        mPaint.getTextBounds(content,0,content.length(),mRect);
        canvas.drawText(content, 200, 200, mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(3);

        mRect.left += 200;
        mRect.right += 200;
        mRect.top += 200;
        mRect.bottom += 200;
        canvas.drawRect(mRect,mPaint);

    }
}
