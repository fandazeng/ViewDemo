package zeng.fanda.com.pratice2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Xfermode
 *
 * @author 曾凡达
 * @date 2018/9/6
 */
public class Practice2XfermodeView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice2XfermodeView(Context context) {
        super(context);
    }

    public Practice2XfermodeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2XfermodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        setLayerType(LAYER_TYPE_SOFTWARE,mPaint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //开启软件加速,离屏缓冲，用这个方法也能实现
//        setLayerType(LAYER_TYPE_SOFTWARE,mPaint);
        //这种方法性能更高
        int saved = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG);

        Bitmap batman = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        Bitmap logo = BitmapFactory.decodeResource(getResources(), R.drawable.batman_logo);


        canvas.drawBitmap(batman, 0, 0, mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
//        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(logo, 0, 0, mPaint);
        mPaint.setXfermode(null);

//        canvas.restoreToCount(saved);

    }
}
