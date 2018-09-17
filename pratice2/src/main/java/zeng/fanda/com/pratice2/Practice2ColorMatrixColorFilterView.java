package zeng.fanda.com.pratice2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 使用一个 ColorMatrix 来对颜色进行处理
 *
 * @author 曾凡达
 * @date 2018/9/6
 */
public class Practice2ColorMatrixColorFilterView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice2ColorMatrixColorFilterView(Context context) {
        super(context);
    }

    public Practice2ColorMatrixColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2ColorMatrixColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap batman = BitmapFactory.decodeResource(getResources(), R.drawable.batman);

        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(10);
        ColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);
        mPaint.setColorFilter(colorFilter);
        canvas.drawBitmap(batman, 0, 0, mPaint);




    }
}
