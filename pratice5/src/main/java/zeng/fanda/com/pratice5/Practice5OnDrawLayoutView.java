package zeng.fanda.com.pratice5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * 在 ViewGroup 的 OnDraw 中插入代码
 *
 * @author 曾凡达
 * @date 2018/9/10
 */
public class Practice5OnDrawLayoutView extends LinearLayout {

    private Pattern mPattern = new Pattern();

    public Practice5OnDrawLayoutView(Context context) {
        super(context);
    }

    public Practice5OnDrawLayoutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice5OnDrawLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        //注意这句代码，默认ViewGroup是不走onDraw的
        // ViewGroup 需要主动开启 dispatchDraw() 以外的绘制
        setWillNotDraw(false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 绘制斑点
        mPattern.draw(canvas);

    }

    private class Pattern {
        private static final float PATTERN_RATIO = 5f / 6;

        Paint patternPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Practice5OnDrawLayoutView.Pattern.Spot[] spots;

        private Pattern() {
            spots = new Practice5OnDrawLayoutView.Pattern.Spot[4];
            spots[0] = new Practice5OnDrawLayoutView.Pattern.Spot(0.24f, 0.3f, 0.026f);
            spots[1] = new Practice5OnDrawLayoutView.Pattern.Spot(0.69f, 0.25f, 0.067f);
            spots[2] = new Practice5OnDrawLayoutView.Pattern.Spot(0.32f, 0.6f, 0.067f);
            spots[3] = new Practice5OnDrawLayoutView.Pattern.Spot(0.62f, 0.78f, 0.083f);
        }

        private Pattern(Practice5OnDrawLayoutView.Pattern.Spot[] spots) {
            this.spots = spots;
        }

        {
            patternPaint.setColor(Color.parseColor("#A0E91E63"));
        }

        private void draw(Canvas canvas) {
            int repitition = (int) Math.ceil((float) getWidth() / getHeight());
            for (int i = 0; i < spots.length * repitition; i++) {
                Practice5OnDrawLayoutView.Pattern.Spot spot = spots[i % spots.length];
                canvas.drawCircle(i / spots.length * getHeight() * PATTERN_RATIO + spot.relativeX * getHeight(), spot.relativeY * getHeight(), spot.relativeSize * getHeight(), patternPaint);
            }
        }

        private class Spot {
            private float relativeX;
            private float relativeY;
            private float relativeSize;

            private Spot(float relativeX, float relativeY, float relativeSize) {
                this.relativeX = relativeX;
                this.relativeY = relativeY;
                this.relativeSize = relativeSize;
            }
        }
    }
}
