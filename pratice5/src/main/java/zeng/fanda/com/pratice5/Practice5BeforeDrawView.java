package zeng.fanda.com.pratice5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * 在 draw 前面插入代码
 *
 * @author 曾凡达
 * @date 2018/9/10
 */
public class Practice5BeforeDrawView extends AppCompatEditText {

    public Practice5BeforeDrawView(Context context) {
        super(context);
    }

    public Practice5BeforeDrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice5BeforeDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void draw(Canvas canvas) {      //总调度方法

        //代码写在前面
        canvas.drawColor(Color.parseColor("#66BB6A"));

        super.draw(canvas);



    }

}
