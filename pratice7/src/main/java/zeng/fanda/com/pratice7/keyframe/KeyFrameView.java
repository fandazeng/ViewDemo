package zeng.fanda.com.pratice7.keyframe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import zeng.fanda.com.pratice7.utils.Utils;


/**
 * @author 曾凡达
 * @date 2018/9/17
 */
public class KeyFrameView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private RectF mRectF = new RectF();

    private final float mRadius = Utils.dpToPixel(80);

    private float mProgress = 0;

    public KeyFrameView(Context context) {
        super(context);
    }

    public KeyFrameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public KeyFrameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float mCenterX = getWidth() / 2;
        float mCenterY = getHeight() / 2;

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(Utils.dpToPixel(40));
//        //居中对齐
        mPaint.setTextAlign(Paint.Align.CENTER);
        //这个点才是文本在布局的中心点,ascent值为负，整体中心点会往下移动
        canvas.drawText((int) mProgress + "%", mCenterX, mCenterY - (mPaint.ascent() + mPaint.descent()) / 2, mPaint);

        mPaint.reset();
        mPaint.setColor(Color.parseColor("#E91E63"));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(Utils.dpToPixel(15));
        mPaint.setStrokeCap(Paint.Cap.ROUND);

        mRectF.set(mCenterX - mRadius, mCenterY - mRadius, mCenterX + mRadius, mCenterY + mRadius);
        canvas.drawArc(mRectF, 90, 3.6f * mProgress, false, mPaint);
    }

    public float getProgress() {
        return mProgress;
    }

    public void setProgress(float progress) {
        mProgress = progress;
        invalidate();
    }
}
