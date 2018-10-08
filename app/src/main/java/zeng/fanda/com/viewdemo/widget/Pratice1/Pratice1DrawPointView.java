package zeng.fanda.com.viewdemo.widget.Pratice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 自定义画点
 *
 * @author 曾凡达
 * @date 2018/9/4
 */
public class Pratice1DrawPointView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Pratice1DrawPointView(Context context) {
        super(context);
    }

    public Pratice1DrawPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Pratice1DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //设置点的大小
        mPaint.setStrokeWidth(150);

        //设置点的形状
        mPaint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(1000, 400, mPaint);

        //设置端点的形状
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(500, 400, mPaint);

//        float[] points = {0, 0, 50, 50, 50, 100, 100, 50, 100, 100, 150, 50, 150, 100};
//        canvas.drawPoints(points,mPaint);
        //offset ，跳过点的数量，下述是跳过0,0两个点
//         count是要绘制的点的数量（50, 50, 50, 100, 100, 50, 100, 100）
//        canvas.drawPoints(points, 2, 8, mPaint);

    }
}
