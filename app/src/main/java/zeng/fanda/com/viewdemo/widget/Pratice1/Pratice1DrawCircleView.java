package zeng.fanda.com.viewdemo.widget.Pratice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 自定义画圆
 *
 * @author 曾凡达
 * @date 2018/9/4
 */
public class Pratice1DrawCircleView extends View {

    private Paint mPaint = new Paint();

    public Pratice1DrawCircleView(Context context) {
        super(context);
    }

    public Pratice1DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Pratice1DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setAntiAlias(true);
        //注意这行代码，如果不加，fragment切换的时候，绘画会混乱
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(450, 250, 230, mPaint);
        mPaint.setColor(Color.BLUE);
        canvas.drawCircle(450, 790, 230, mPaint);

        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        canvas.drawCircle(1050, 250, 230, mPaint);

        mPaint.setStrokeWidth(100);
        canvas.drawCircle(1050, 790, 220, mPaint);
    }

}
