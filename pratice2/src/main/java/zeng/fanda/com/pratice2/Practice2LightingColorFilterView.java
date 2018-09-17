package zeng.fanda.com.pratice2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 模拟简单的光照效果
 *
 * @author 曾凡达
 * @date 2018/9/6
 */
public class Practice2LightingColorFilterView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    ColorFilter colorFilter1 = new LightingColorFilter(0x00ffff, 0x000000);
    ColorFilter colorFilter2 = new LightingColorFilter(0xffffff, 0x003000);

    public Practice2LightingColorFilterView(Context context) {
        super(context);
    }

    public Practice2LightingColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2LightingColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap batman = BitmapFactory.decodeResource(getResources(), R.drawable.batman);

        mPaint.setColorFilter(colorFilter1);
        canvas.drawBitmap(batman, 0, 0, mPaint);

        mPaint.setColorFilter(colorFilter2);
        canvas.drawBitmap(batman, batman.getWidth()+100, 0, mPaint);



    }
}
