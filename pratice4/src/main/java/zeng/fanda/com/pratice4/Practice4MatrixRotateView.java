package zeng.fanda.com.pratice4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Matrix旋转变换
 *
 * @author 曾凡达
 * @date 2018/9/10
 */
public class Practice4MatrixRotateView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap mBitmap;

    public Practice4MatrixRotateView(Context context) {
        super(context);
    }

    public Practice4MatrixRotateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice4MatrixRotateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(mBitmap, 400, 300, mPaint);

        Matrix matrix = new Matrix();
        matrix.preTranslate(500, 0);
        matrix.postRotate(45f, 800 + mBitmap.getWidth() / 2, 300 + mBitmap.getHeight() / 2);
        //保存状态
        canvas.save();
        canvas.concat(matrix);
        canvas.drawBitmap(mBitmap, 400, 300, mPaint);

        //恢复绘制范围
        canvas.restore();

    }
}
