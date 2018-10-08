package zeng.fanda.com.viewdemo.widget.Pratice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 自定义画自定义View
 *
 * @author 曾凡达
 * @date 2018/9/4
 */
public class Pratice1DrawPathView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();

    public Pratice1DrawPathView(Context context) {
        super(context);
    }

    public Pratice1DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Pratice1DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStyle(Paint.Style.FILL);
        mPath.addArc(500, 200, 700, 400, -225, 225);
//        //这里不能是true，如果是true，起点会变成第二个圆弧的起点，false才保持第一个圆弧的起点，注意这个参数
        mPath.arcTo(700, 200, 900, 400, -180, 225, false);
        mPath.lineTo(700, 542);

        canvas.drawPath(mPath, mPaint);
    }
}
