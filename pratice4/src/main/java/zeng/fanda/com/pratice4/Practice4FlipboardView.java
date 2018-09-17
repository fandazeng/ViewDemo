package zeng.fanda.com.pratice4;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * 翻页
 *
 * @author 曾凡达
 * @date 2018/9/10
 */
public class Practice4FlipboardView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Camera mCamera;
    private Bitmap mBitmap;

    private int degree;
    private ObjectAnimator mObjectAnimator;

    public Practice4FlipboardView(Context context) {
        super(context);
    }

    public Practice4FlipboardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice4FlipboardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        mCamera = new Camera();

        mObjectAnimator = ObjectAnimator.ofInt(Practice4FlipboardView.this, "degree", 0, 180);
        mObjectAnimator.setDuration(2500);
        mObjectAnimator.setInterpolator(new LinearInterpolator());
        mObjectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        mObjectAnimator.setRepeatMode(ValueAnimator.REVERSE);

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mObjectAnimator.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mObjectAnimator.end();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        int bitmapWidth = mBitmap.getWidth();
        int bitmapHeight = mBitmap.getHeight();
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int x = centerX - bitmapWidth / 2;
        int y = centerY - bitmapHeight / 2;

        // 第一遍绘制：上半部分
        canvas.save();
        canvas.clipRect(0, 0, getWidth(), centerY);
        canvas.drawBitmap(mBitmap, x, y, mPaint);
        canvas.restore();

        // 第二遍绘制：下半部分
        canvas.save();

        if (degree < 90) {
            canvas.clipRect(0, centerY, getWidth(), getHeight());
        } else {
            canvas.clipRect(0, 0, getWidth(), centerY);
        }

        mCamera.save();
        mCamera.rotateX(degree);
        canvas.translate(centerX, centerY);
        mCamera.applyToCanvas(canvas);
        canvas.translate(-centerX, -centerY);
        mCamera.restore();

        canvas.drawBitmap(mBitmap, x, y, mPaint);
        canvas.restore();

    }

    public void setDegree(int degree) {
        this.degree = degree;
        invalidate();
    }
}
