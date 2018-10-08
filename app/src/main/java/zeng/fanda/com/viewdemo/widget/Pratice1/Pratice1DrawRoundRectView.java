package zeng.fanda.com.viewdemo.widget.Pratice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 自定义画圆角矩形
 *
 * @author 曾凡达
 * @date 2018/9/4
 */
public class Pratice1DrawRoundRectView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private RectF mRectF = new RectF();

    public Pratice1DrawRoundRectView(Context context) {
        super(context);
    }

    public Pratice1DrawRoundRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Pratice1DrawRoundRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mRectF.set(400, 200, 1000, 600);
        canvas.drawRoundRect(mRectF, 50, 50, mPaint);

        //这个方法需要API21
//        canvas.drawRoundRect(400, 200, 1000, 600, 50, 50, mPaint);
    }
}
