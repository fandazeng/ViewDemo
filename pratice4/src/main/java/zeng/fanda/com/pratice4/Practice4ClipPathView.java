package zeng.fanda.com.pratice4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 裁剪路径
 *
 * @author 曾凡达
 * @date 2018/9/10
 */
public class Practice4ClipPathView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath1 = new Path();
    private Path mPath2 = new Path();
    private Bitmap mBitmap;

    public Practice4ClipPathView(Context context) {
        super(context);
    }

    public Practice4ClipPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice4ClipPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        mPath1.addCircle(500, 500, 200, Path.Direction.CW);
        //设置填充的类型
        mPath2.setFillType(Path.FillType.INVERSE_WINDING);
        mPath2.addCircle(800, 500, 200, Path.Direction.CW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //保存状态
        canvas.save();
        canvas.clipPath(mPath1);
        canvas.drawBitmap(mBitmap, 200, 200, mPaint);

        //恢复绘制范围
        canvas.restore();

        //保存状态
        canvas.save();
        canvas.clipPath(mPath2);
        canvas.drawBitmap(mBitmap, 800, 200, mPaint);

        //恢复绘制范围
        canvas.restore();

    }
}
