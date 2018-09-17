package zeng.fanda.com.pratice2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 获取文本的路径
 *
 * @author 曾凡达
 * @date 2018/9/6
 */
public class Practice2TextPathView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mTextPath = new Path();
    private String text = "Hello Fanda!";

    public Practice2TextPathView(Context context) {
        super(context);
    }

    public Practice2TextPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2TextPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mPaint.setTextSize(120);
        mPaint.getTextPath(text,0,text.length(),50,400,mTextPath);

        mTextPaint.setStyle(Paint.Style.STROKE);
        mTextPaint.setTextSize(100);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawText(text,50,200,mPaint);

        canvas.drawPath(mTextPath,mTextPaint);
    }
}
