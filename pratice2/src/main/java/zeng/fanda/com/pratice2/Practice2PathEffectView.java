package zeng.fanda.com.pratice2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.SumPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 设置路径效果
 *
 * @author 曾凡达
 * @date 2018/9/6
 */
public class Practice2PathEffectView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();
    private PathEffect cornerPathEffect = new CornerPathEffect(20);
    private PathEffect discretePathEffect = new DiscretePathEffect(20, 5);
    private PathEffect dashPathEffect = new DashPathEffect(new float[]{20, 10, 5, 10}, 0);
    private PathEffect mPathDashPathEffect;
    private PathEffect sumPathEffect = new SumPathEffect(dashPathEffect, discretePathEffect);
    private PathEffect composePathEffect = new ComposePathEffect(dashPathEffect, discretePathEffect);

    public Practice2PathEffectView(Context context) {
        super(context);
    }

    public Practice2PathEffectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2PathEffectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    {
        mPaint.setStyle(Paint.Style.STROKE);

        mPath.moveTo(50, 100);
        mPath.rLineTo(50, 100);
        mPath.rLineTo(80, -150);
        mPath.rLineTo(100, 100);
        mPath.rLineTo(70, -120);
        mPath.rLineTo(150, 80);

        Path dashPath = new Path();
        dashPath.lineTo(20, -30);
        dashPath.lineTo(40, 0);
        dashPath.close();
        mPathDashPathEffect = new PathDashPathEffect(dashPath, 50, 0, PathDashPathEffect.Style.MORPH);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // CornerPathEffect
        mPaint.setPathEffect(cornerPathEffect);
        canvas.drawPath(mPath, mPaint);

        canvas.save();
        canvas.translate(500, 0);
        // DiscretePathEffect
        mPaint.setPathEffect(discretePathEffect);
        canvas.drawPath(mPath, mPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 200);
        // DashPathEffect
        mPaint.setPathEffect(dashPathEffect);
        canvas.drawPath(mPath, mPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 200);
        // PathDashPathEffect
        mPaint.setPathEffect(mPathDashPathEffect);
        canvas.drawPath(mPath, mPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 400);
        // SumPathEffect
        mPaint.setPathEffect(sumPathEffect);
        canvas.drawPath(mPath, mPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 400);
        // ComposePathEffect
        mPaint.setPathEffect(composePathEffect);
        canvas.drawPath(mPath, mPaint);
        canvas.restore();

        mPaint.setPathEffect(null);
    }
}
