package zeng.fanda.com.viewdemo.widget.Pratice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 自定义画圆弧
 *
 * @author 曾凡达
 * @date 2018/9/4
 */
public class Pratice1DrawArcView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Pratice1DrawArcView(Context context) {
        super(context);
    }

    public Pratice1DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Pratice1DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(500, 550, 800, 750, -180, 90, false, mPaint);

        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawArc(500, 600, 1000, 800, 0, 180, false, mPaint);

        canvas.drawArc(700, 550, 1000, 750, -125, 100, true, mPaint);


    }
}
