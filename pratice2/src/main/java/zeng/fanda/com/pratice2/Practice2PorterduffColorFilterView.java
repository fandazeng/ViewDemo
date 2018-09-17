package zeng.fanda.com.pratice2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 使用一个指定的颜色和一种指定的 PorterDuff.Mode来与绘制对象进行合成
 *
 * @author 曾凡达
 * @date 2018/9/6
 */
public class Practice2PorterduffColorFilterView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice2PorterduffColorFilterView(Context context) {
        super(context);
    }

    public Practice2PorterduffColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2PorterduffColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap batman = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        ColorFilter porterFilter = new PorterDuffColorFilter(Color.parseColor("#80000000"), PorterDuff.Mode.SRC_OVER);
        mPaint.setColorFilter(porterFilter);
        canvas.drawBitmap(batman, 0, 0, mPaint);

    }
}
