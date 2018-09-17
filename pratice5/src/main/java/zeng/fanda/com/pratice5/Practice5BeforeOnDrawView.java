package zeng.fanda.com.pratice5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 在OnDraw前面插入代码
 *
 * @author 曾凡达
 * @date 2018/9/10
 */
public class Practice5BeforeOnDrawView extends AppCompatTextView {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private RectF mRectF = new RectF();

    public Practice5BeforeOnDrawView(Context context) {
        super(context);
    }

    public Practice5BeforeOnDrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice5BeforeOnDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mPaint.setColor(Color.YELLOW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //代码写在前面

        //行数索引从0开始
        Layout layout = getLayout();
        mRectF.left = layout.getLineLeft(1) + getPaddingLeft();
        mRectF.top = layout.getLineTop(1);
        mRectF.right = layout.getLineRight(1) + getPaddingLeft();
        mRectF.bottom = layout.getLineBottom(1);

        canvas.drawRect(mRectF, mPaint);

        mRectF.left = layout.getLineLeft(layout.getLineCount() - 4) + getPaddingLeft();
        mRectF.top = layout.getLineTop(layout.getLineCount() - 4);
        mRectF.right = layout.getLineRight(layout.getLineCount() - 4) + getPaddingLeft();
        mRectF.bottom = layout.getLineBottom(layout.getLineCount() - 4);

        canvas.drawRect(mRectF, mPaint);

        super.onDraw(canvas);
    }
}
