package zeng.fanda.com.pratice5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.widget.ImageViewCompat;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**
 * 在OnDraw后面插入代码
 *
 * @author 曾凡达
 * @date 2018/9/10
 */
public class Practice5AfterOnDrawView extends AppCompatImageView {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice5AfterOnDrawView(Context context) {
        super(context);
    }

    public Practice5AfterOnDrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice5AfterOnDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mPaint.setTextSize(28);
        mPaint.setColor(Color.YELLOW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //代码写在后面
        if (BuildConfig.DEBUG) {
            // 在DEBUG模式下绘制出 drawable 的尺寸信息
            Drawable drawable = getDrawable();
            if (drawable != null) {
                canvas.save();
                canvas.concat(getImageMatrix());
                Rect bounds = drawable.getBounds();
                canvas.drawText(getResources().getString(R.string.image_size, bounds.width(), bounds.height()), 20, 40, mPaint);
                canvas.restore();
            }
        }
    }
}
