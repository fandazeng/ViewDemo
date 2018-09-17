package zeng.fanda.com.pratice4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 错切变换
 *
 * @author 曾凡达
 * @date 2018/9/10
 */
public class Practice4SkewView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap mBitmap;

    public Practice4SkewView(Context context) {
        super(context);
    }

    public Practice4SkewView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice4SkewView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //保存状态
        canvas.save();
        canvas.skew(0.5f,0f);
        canvas.drawBitmap(mBitmap, 100, 300, mPaint);

        //恢复绘制范围
        canvas.restore();

        //保存状态
        canvas.save();
        canvas.translate(500, -200);
        canvas.skew(0f,0.5f);
        canvas.drawBitmap(mBitmap, 400, 300, mPaint);

        //恢复绘制范围
        canvas.restore();

    }
}
