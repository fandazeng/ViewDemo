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
 * Camera旋转变换
 *
 * @author 曾凡达
 * @date 2018/9/10
 */
public class Practice4CameraRotateView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Camera mCamera;
    private Bitmap mBitmap;

    public Practice4CameraRotateView(Context context) {
        super(context);
    }

    public Practice4CameraRotateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice4CameraRotateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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

        mCamera.save();
        mCamera.rotate(30,0,0);
        mCamera.applyToCanvas(canvas);
        mCamera.restore();

        canvas.drawBitmap(mBitmap,300,100,mPaint);
        //恢复绘制范围
        canvas.restore();

    }
}
