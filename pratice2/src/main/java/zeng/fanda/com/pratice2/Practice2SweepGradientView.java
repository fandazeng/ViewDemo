package zeng.fanda.com.pratice2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 扫描着色器
 *
 * @author 曾凡达
 * @date 2018/9/6
 */
public class Practice2SweepGradientView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice2SweepGradientView(Context context) {
        super(context);
    }

    public Practice2SweepGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2SweepGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setShader(new SweepGradient(300, 300,
                Color.parseColor("#E91E63"), Color.parseColor("#2196F3")));

        canvas.drawCircle(300, 300, 200, mPaint);

    }
}
