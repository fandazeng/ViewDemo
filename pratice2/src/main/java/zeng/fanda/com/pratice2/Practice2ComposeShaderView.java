package zeng.fanda.com.pratice2;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 混合着色器
 *
 * @author 曾凡达
 * @date 2018/9/6
 */
public class Practice2ComposeShaderView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice2ComposeShaderView(Context context) {
        super(context);
    }

    public Practice2ComposeShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2ComposeShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        //开启软件加速
        setLayerType(LAYER_TYPE_SOFTWARE,mPaint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Shader batman = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.batman), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Shader logo = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.batman_logo), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        mPaint.setShader(new ComposeShader(batman,logo, PorterDuff.Mode.DST_IN));

        canvas.drawCircle(300, 300, 300, mPaint);


    }
}
