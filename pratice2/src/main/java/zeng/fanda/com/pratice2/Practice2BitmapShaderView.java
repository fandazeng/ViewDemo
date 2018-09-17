package zeng.fanda.com.pratice2;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Bitmap着色器
 *
 * @author 曾凡达
 * @date 2018/9/6
 */
public class Practice2BitmapShaderView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice2BitmapShaderView(Context context) {
        super(context);
    }

    public Practice2BitmapShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2BitmapShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setShader(new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.batman), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));

        canvas.drawCircle(300, 300, 200, mPaint);

    }
}
