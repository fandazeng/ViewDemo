package zeng.fanda.com.pratice2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 辐射着色器
 *
 * @author 曾凡达
 * @date 2018/9/6
 */
public class Practice2RadialGradientView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice2RadialGradientView(Context context) {
        super(context);
    }

    public Practice2RadialGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2RadialGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setShader(new RadialGradient(300, 300, 200,
                Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), Shader.TileMode.CLAMP));

        canvas.drawCircle(300, 300, 200, mPaint);

    }
}
