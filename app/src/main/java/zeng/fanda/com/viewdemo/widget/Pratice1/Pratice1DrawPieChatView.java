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
 * 自定义画直饼图
 *
 * @author 曾凡达
 * @date 2018/9/4
 */
public class Pratice1DrawPieChatView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();

    public Pratice1DrawPieChatView(Context context) {
        super(context);
    }

    public Pratice1DrawPieChatView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Pratice1DrawPieChatView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawColor(Color.parseColor("#546e7a"));

        mPaint.setColor(Color.parseColor("#e84e40"));
        canvas.drawArc(200, 50, 900, 750, -180, 125, true, mPaint);

        mPaint.setColor(Color.parseColor("#ffc107"));
        canvas.drawArc(230, 80, 930, 780, -55, 52, true, mPaint);

        mPaint.setColor(Color.parseColor("#7b1fa2"));
        canvas.drawArc(230, 80, 930, 780, 0, 7, true, mPaint);

        mPaint.setColor(Color.parseColor("#9e9e9e"));
        canvas.drawArc(230, 80, 930, 780, 10, 6, true, mPaint);

        mPaint.setColor(Color.parseColor("#00796b"));
        canvas.drawArc(230, 80, 930, 780, 19, 52, true, mPaint);

        mPaint.setColor(Color.parseColor("#3f51b5"));
        canvas.drawArc(230, 80, 930, 780, 73, 105, true, mPaint);

        mTextPaint.setTextSize(38);
        mTextPaint.setColor(Color.WHITE);
        canvas.drawText("Lollipop", 5, 80, mTextPaint);
        canvas.drawText("KitKat", 100, 800, mTextPaint);
        canvas.drawText("Marshmallow", 1050, 250, mTextPaint);
        canvas.drawText("Froyo", 1050, 435, mTextPaint);
        canvas.drawText("Gingerbread", 1050, 490, mTextPaint);
        canvas.drawText("Ice Cream Sandwich", 1050, 550, mTextPaint);
        canvas.drawText("Jelly Bean", 1050, 700, mTextPaint);


        //不加这行代码，显示不出来
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(5);

        //第一条线 Lollipop
        mPath.moveTo(170, 80);
        mPath.rLineTo(160, 0);
        mPath.rLineTo(28, 28);

        //第二条线 KitKat
        mPath.moveTo(220, 800);
        mPath.rLineTo(160, 0);
        mPath.rLineTo(50, -50);

        //第三条线 Marshmallow
        mPath.moveTo(1040, 250);
        mPath.rLineTo(-100, 0);
        mPath.rLineTo(-43, 43);

        //第四条线 Froyo
        mPath.moveTo(1040, 420);
        mPath.rLineTo(-110, 0);

        //第五条线 Gingerbread
        mPath.moveTo(1040, 490);
        mPath.rLineTo(-40, 0);
        mPath.rLineTo(-30, -30);
        mPath.rLineTo(-37, 0);

        //第六条线 Ice Cream Sandwich
        mPath.moveTo(1040, 550);
        mPath.rLineTo(-40, 0);
        mPath.rLineTo(-35, -35);
        mPath.rLineTo(-40, 0);

        //第七条线 Jelly Bean
        mPath.moveTo(1040, 700);
        mPath.rLineTo(-140, 0);
        mPath.rLineTo(-50, -50);

        canvas.drawPath(mPath, mPaint);


    }
}
