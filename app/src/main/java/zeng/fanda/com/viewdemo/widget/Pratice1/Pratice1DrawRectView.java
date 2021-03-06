package zeng.fanda.com.viewdemo.widget.Pratice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 自定义画矩形
 *
 * @author 曾凡达
 * @date 2018/9/4
 */
public class Pratice1DrawRectView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private RectF mRectF = new RectF();
    private Rect mRect = new Rect();

    public Pratice1DrawRectView(Context context) {
        super(context);
    }

    public Pratice1DrawRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Pratice1DrawRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mRectF.set(400, 200, 1000, 800);
        mRect.set(400, 200, 1000, 800);
        canvas.drawRect(400, 200, 1000, 800, mPaint);
        canvas.drawRect(mRectF, mPaint);
        canvas.drawRect(mRect, mPaint);
    }
}
