package zeng.fanda.com.pratice2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 在之后的绘制内容下面加一层阴影
 *
 * @author 曾凡达
 * @date 2018/9/6
 */
public class Practice2ShadowLayerView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice2ShadowLayerView(Context context) {
        super(context);
    }

    public Practice2ShadowLayerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2ShadowLayerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setTextSize(140);
        mPaint.setShadowLayer(4, 10, 10, Color.BLUE);
        //清除阴影层
//        mPaint.clearShadowLayer();
        canvas.drawText("Hello Fanda!", 200, 200, mPaint);
    }
}
