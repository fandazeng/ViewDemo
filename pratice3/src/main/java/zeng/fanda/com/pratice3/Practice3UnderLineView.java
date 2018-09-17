package zeng.fanda.com.pratice3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 下滑线
 *
 * @author 曾凡达
 * @date 2018/9/10
 */
public class Practice3UnderLineView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice3UnderLineView(Context context) {
        super(context);
    }

    public Practice3UnderLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice3UnderLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setTextSize(100);
        mPaint.setUnderlineText(true);
        canvas.drawText("fanda", 200, 300, mPaint);

    }
}
