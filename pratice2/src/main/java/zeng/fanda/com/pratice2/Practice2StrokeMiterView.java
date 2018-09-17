package zeng.fanda.com.pratice2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 设置 MITER 型拐角的延长线的最大值
 *
 * @author 曾凡达
 * @date 2018/9/6
 */
public class Practice2StrokeMiterView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();

    public Practice2StrokeMiterView(Context context) {
        super(context);
    }

    public Practice2StrokeMiterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2StrokeMiterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(50);

        mPath.rLineTo(200, 0);
        mPath.rLineTo(-160, 120);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();

//        拐角角度小于29度时，会变成BEVEL模式，防止尖角过长

        canvas.translate(100, 100);
        mPaint.setStrokeMiter(1);
        canvas.drawPath(mPath, mPaint);

        canvas.translate(300, 0);
        mPaint.setStrokeMiter(3);
        canvas.drawPath(mPath, mPaint);

        canvas.translate(300, 0);
        mPaint.setStrokeMiter(5);
        canvas.drawPath(mPath, mPaint);

        canvas.restore();
    }
}
