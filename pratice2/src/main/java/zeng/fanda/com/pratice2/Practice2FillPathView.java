package zeng.fanda.com.pratice2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.SumPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 获取实际绘制的 Path
 *
 * @author 曾凡达
 * @date 2018/9/6
 */
public class Practice2FillPathView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mPathPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();
    private Path mPath1 = new Path();
    private Path mPath2 = new Path();
    private Path mPath3 = new Path();

    public Practice2FillPathView(Context context) {
        super(context);
    }

    public Practice2FillPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2FillPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    {
        mPath.moveTo(50, 100);
        mPath.rLineTo(50, 100);
        mPath.rLineTo(80, -150);
        mPath.rLineTo(100, 100);
        mPath.rLineTo(70, -120);
        mPath.rLineTo(150, 80);

        mPathPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 第一处：获取 Path
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeWidth(0);
        mPaint.getFillPath(mPath, mPath1);
        canvas.drawPath(mPath, mPaint);

        canvas.save();
        canvas.translate(500, 0);
        canvas.drawPath(mPath1, mPathPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 200);
        mPaint.setStyle(Paint.Style.STROKE);
        // 第二处：设置 Style 为 STROKE 后再获取 Path
        mPaint.getFillPath(mPath, mPath2);
        canvas.drawPath(mPath, mPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 200);
        canvas.drawPath(mPath2, mPathPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 400);
        mPaint.setStrokeWidth(40);
        // 第三处：Style 为 STROKE 并且线条宽度为 40 时的 Path
        mPaint.getFillPath(mPath, mPath3);
        canvas.drawPath(mPath, mPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 400);
        canvas.drawPath(mPath3, mPathPaint);
        canvas.restore();
    }
}
