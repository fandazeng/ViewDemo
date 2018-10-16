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
 * Camera修正版旋转变换
 *
 * @author 曾凡达
 * @date 2018/9/10
 */
public class Practice4CameraHitingFaceFixView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Camera mCamera;
    private Bitmap mBitmap;

    private Matrix mMatrix = new Matrix();
    private Point mPoint = new Point(150, 50);
    private int degree;
    private ObjectAnimator mObjectAnimator;

    public Practice4CameraHitingFaceFixView(Context context) {
        super(context);
    }

    public Practice4CameraHitingFaceFixView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice4CameraHitingFaceFixView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(mBitmap, mBitmap.getWidth() * 2, mBitmap.getHeight() * 2, true);
        mBitmap.recycle();
        mBitmap = scaledBitmap;
        mCamera = new Camera();

        mObjectAnimator = ObjectAnimator.ofInt(Practice4CameraHitingFaceFixView.this, "degree", 0, 360);
        mObjectAnimator.setDuration(5000);
        mObjectAnimator.setInterpolator(new LinearInterpolator());
        mObjectAnimator.setRepeatCount(ValueAnimator.INFINITE);

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        //往外为负
        float newZ = - displayMetrics.density * 6;
        mCamera.setLocation(0, 0, newZ);
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

        //保存状态
        canvas.save();

        /*
         * canvas的变换操作要反着写，理解的时候反序理解就行了
         * */
        mCamera.save(); //保存 Camera 的状态
        mCamera.rotateX(degree);    //沿X轴旋转 Camera的三维空间
        canvas.translate(mPoint.x + mBitmap.getWidth() / 2,  mPoint.y + mBitmap.getHeight()/2);  //旋转之后把投影移动回来
        mCamera.applyToCanvas(canvas);  //把旋转投影投影到Canvas
        canvas.translate(-mPoint.x - mBitmap.getWidth() / 2, - mPoint.y - mBitmap.getHeight()/2); //旋转之前把绘制内容移动到轴心（原点）
        mCamera.restore(); //恢复 Camera 状态

        canvas.drawBitmap(mBitmap, mPoint.x, mPoint.y, mPaint);
        //恢复绘制范围
        canvas.restore();

        //Matrix 实现方式============================

        /*
        mCamera.save(); //保存 Camera 的状态
        mMatrix.reset();
        mCamera.rotateX(degree);    //沿X轴旋转 Camera的三维空间
        mCamera.getMatrix(mMatrix);
        mCamera.restore(); //恢复 Camera 状态

        mMatrix.preTranslate(-mPoint.x - mBitmap.getWidth() / 2, - mPoint.y - mBitmap.getHeight() / 2);
        mMatrix.postTranslate(mPoint.x + mBitmap.getWidth() / 2,  mPoint.y + mBitmap.getHeight() / 2);

        //保存状态
        canvas.save();
        canvas.concat(mMatrix);
        canvas.drawBitmap(mBitmap, mPoint.x, mPoint.y, mPaint);
        //恢复绘制范围
        canvas.restore();
        */

    }

    public void setDegree(int degree) {
        this.degree = degree;
        invalidate();
    }
}
