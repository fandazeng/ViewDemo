package zeng.fanda.com.viewdemo.widget.Pratice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * 自定义画椭圆
 *
 * @author 曾凡达
 * @date 2018/9/4
 */
public class Pratice1DrawOvalView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private RectF mRectF = new RectF();

    public Pratice1DrawOvalView(Context context) {
        super(context);
    }

    public Pratice1DrawOvalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Pratice1DrawOvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mRectF.set(500, 400, 1000, 700);
//        canvas.drawOval(500, 400, 1000, 700, mPaint);
        canvas.drawOval(mRectF, mPaint);
    }
}
