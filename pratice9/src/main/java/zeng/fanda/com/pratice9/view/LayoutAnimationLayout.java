package zeng.fanda.com.pratice9.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import zeng.fanda.com.pratice9.R;

/**
 * 布局动画
 *
 * @author 曾凡达
 * @date 2018/10/11
 */
public class LayoutAnimationLayout extends RelativeLayout implements View.OnClickListener {

    private Button mLoadFrameAnimaion;

    private Animation mAnimation;

    public LayoutAnimationLayout(Context context) {
        super(context);
    }

    public LayoutAnimationLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LayoutAnimationLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mLoadFrameAnimaion = findViewById(R.id.btn_load_frame_animation);

        mLoadFrameAnimaion.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        mAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.layout_anim);
//
//        LayoutAnimationController controller = new LayoutAnimationController(mAnimation);
//
//        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
//        controller.setDelay(0.5f);
//
//        setLayoutAnimation(controller);
//        startLayoutAnimation();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mAnimation != null) {
            mAnimation.cancel();
        }
    }

}
