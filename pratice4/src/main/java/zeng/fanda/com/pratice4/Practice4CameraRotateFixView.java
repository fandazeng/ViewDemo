package zeng.fanda.com.pratice4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Camera修正版旋转变换
 *
 * @author 曾凡达
 * @date 2018/9/10
 */
public class Practice4CameraRotateFixView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Camera mCamera;
    private Bitmap mBitmap;

    public Practice4CameraRotateFixView(Context context) {
        super(context);
    }

    public Practice4CameraRotateFixView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice4CameraRotateFixView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        mCamera = new Camera();
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
        mCamera.rotateX(20);    //沿X轴旋转 Camera的三维空间
        canvas.translate(300 + mBitmap.getWidth() / 2, 100 + mBitmap.getHeight()/2);  //旋转之后把投影移动回来
        mCamera.applyToCanvas(canvas);  //把旋转投影投影到Canvas
        canvas.translate(-300 - mBitmap.getWidth() / 2, -100 - mBitmap.getHeight()/2); //旋转之前把绘制内容移动到轴心（原点）
        mCamera.restore(); //恢复 Camera 状态

        canvas.drawBitmap(mBitmap, 300, 100, mPaint);
        //恢复绘制范围
        canvas.restore();

    }
}
