package zeng.fanda.com.pratice2;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 设置端点的样式
 *
 * @author 曾凡达
 * @date 2018/9/6
 */
public class Practice2StrokeCapView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice2StrokeCapView(Context context) {
        super(context);
    }

    public Practice2StrokeCapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2StrokeCapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(50);
        mPaint.setStrokeCap(Paint.Cap.BUTT);//默认
        canvas.drawLine(100,100,600,100,mPaint);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(100,300,600,300,mPaint);
        mPaint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawLine(100,500,600,500,mPaint);
    }
}
