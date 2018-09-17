package zeng.fanda.com.pratice2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 设置MaskFilter
 *
 * @author 曾凡达
 * @date 2018/9/6
 */
public class Practice2MaskFilterView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    Bitmap bitmap;
    MaskFilter maskFilter1 = new BlurMaskFilter(50, BlurMaskFilter.Blur.NORMAL);
    MaskFilter maskFilter2 = new BlurMaskFilter(50, BlurMaskFilter.Blur.INNER);
    MaskFilter maskFilter3 = new BlurMaskFilter(50, BlurMaskFilter.Blur.OUTER);
    MaskFilter maskFilter4 = new BlurMaskFilter(50, BlurMaskFilter.Blur.SOLID);

    public Practice2MaskFilterView(Context context) {
        super(context);
    }

    public Practice2MaskFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2MaskFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        //需要开启软件加速
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.what_the_fuck);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setMaskFilter(maskFilter1);
        canvas.drawBitmap(bitmap, 100, 50, mPaint);

        mPaint.setMaskFilter(maskFilter2);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 200, 50, mPaint);

        mPaint.setMaskFilter(maskFilter3);
        canvas.drawBitmap(bitmap, 100, bitmap.getHeight() + 100, mPaint);

        mPaint.setMaskFilter(maskFilter4);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 200, bitmap.getHeight() + 100, mPaint);
        
    }
}
