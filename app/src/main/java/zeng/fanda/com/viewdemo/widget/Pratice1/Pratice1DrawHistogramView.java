package zeng.fanda.com.viewdemo.widget.Pratice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 自定义画直方图
 *
 * @author 曾凡达
 * @date 2018/9/4
 */
public class Pratice1DrawHistogramView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();

    public Pratice1DrawHistogramView(Context context) {
        super(context);
    }

    public Pratice1DrawHistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Pratice1DrawHistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.parseColor("#546e7a"));
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(4);
        mPath.moveTo(100, 50);
        mPath.rLineTo(0, 800);
        mPath.rLineTo(1200, 0);

        canvas.drawPath(mPath, mPaint);

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSize(40);
        canvas.drawText("Froyo", 150, 900, mPaint);
        canvas.drawText("GB", 330, 900, mPaint);
        canvas.drawText("ICS", 485, 900, mPaint);
        canvas.drawText("JB", 630, 900, mPaint);
        canvas.drawText("KitKat", 760, 900, mPaint);
        canvas.drawText("L", 950, 900, mPaint);
        canvas.drawText("M", 1090, 900, mPaint);

        mPaint.setColor(Color.parseColor("#2baf2b"));
        canvas.drawRect(150, 850, 270, 850, mPaint);
        canvas.drawRect(300, 820, 420, 850, mPaint);
        canvas.drawRect(450, 820, 570, 850, mPaint);
        canvas.drawRect(600, 630, 720, 850, mPaint);
        canvas.drawRect(750, 430, 870, 850, mPaint);
        canvas.drawRect(900, 330, 1020, 850, mPaint);
        canvas.drawRect(1050, 650, 1170, 850, mPaint);

    }
}
