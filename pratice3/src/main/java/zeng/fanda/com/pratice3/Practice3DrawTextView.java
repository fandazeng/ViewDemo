package zeng.fanda.com.pratice3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Locale;

/**
 * 绘制文本
 *
 * @author 曾凡达
 * @date 2018/9/10
 */
public class Practice3DrawTextView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice3DrawTextView(Context context) {
        super(context);
    }

    public Practice3DrawTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice3DrawTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setTextSize(100);

        //y是基线，文本的左下角，x值没有贴着文本，有一点空隙，往左边一点
        canvas.drawText("fanda", 200, 200, mPaint);
        //超过屏幕的文本不会绘制，也不会换行
//        canvas.drawText("Lorem Ipsum is simply dummy text of the printing and typesetting industry.",200,200,mPaint);
        //加了\n换行符也不会换行，而是用了空格来替代
//        canvas.drawText("a\nbc\ndefghi\njklm\nnopqrst\nuvwx\nyz",200,200,mPaint);

//        canvas.drawLine(0,200,200,200,mPaint);

    }
}
