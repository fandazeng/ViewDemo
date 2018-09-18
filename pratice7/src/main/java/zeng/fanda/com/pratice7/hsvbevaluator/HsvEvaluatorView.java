package zeng.fanda.com.pratice7.hsvbevaluator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import zeng.fanda.com.pratice7.utils.Utils;

/**
 * @author 曾凡达
 * @date 2018/9/18
 */
public class HsvEvaluatorView extends View{

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private int color = 0xffff0000;

    public HsvEvaluatorView(Context context) {
        super(context);
    }

    public HsvEvaluatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HsvEvaluatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(color);

        canvas.drawCircle(getWidth()/2,getHeight()/2, Utils.dpToPixel(70),mPaint);
    }


    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
        invalidate();
    }
}
