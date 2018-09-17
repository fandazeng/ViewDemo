package zeng.fanda.com.pratice3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 绘制多行文本
 *
 * @author 曾凡达
 * @date 2018/9/10
 */
public class Practice3StaticLayoutView extends View {

    private TextPaint mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);

    public Practice3StaticLayoutView(Context context) {
        super(context);
    }

    public Practice3StaticLayoutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice3StaticLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mTextPaint.setTextSize(100);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //align 是文字的对齐方向，默认左对齐，还有居中和右对齐
        StaticLayout staticLayout = new StaticLayout("hello\nfanda", mTextPaint, 1100,
                Layout.Alignment.ALIGN_CENTER, 1, 0, true);

        canvas.save();
        canvas.translate(200, 200);
        staticLayout.draw(canvas);
        canvas.restore();
    }
}
