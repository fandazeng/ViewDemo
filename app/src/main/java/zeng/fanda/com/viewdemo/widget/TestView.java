package zeng.fanda.com.viewdemo.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ComposePathEffect;
import android.graphics.ComposeShader;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.EmbossMaskFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import zeng.fanda.com.viewdemo.R;

/**
 * 自定义练习的View
 *
 * @author 曾凡达
 * @date 2018/9/3
 */
public class TestView extends View {

    private Paint mPaint = new Paint();
    private TextPaint mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();

    private Bitmap dstBmp;
    private Bitmap srcBmp;
    private int width = 400;
    private int height = 400;

    public TestView(Context context) {
        super(context);
    }

    public TestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//      这类颜色填充方法一般用于在绘制之前设置底色，或者在绘制之后为界面设置半透明蒙版。
        canvas.drawColor(Color.BLACK);
        canvas.drawColor(Color.parseColor("#88880000"));
        canvas.drawRGB(100, 200, 100);
        canvas.drawARGB(255, 200, 200, 100);

        // Paint
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(20);
        mPaint.setAntiAlias(true);


//        ================================================================画圆

//        canvas.drawCircle(150, 150, 100, mPaint);

//        ================================================================ 画矩形

//        canvas.drawRect(400,100,600,300,mPaint);

//        ================================================================ 画点

//        mPaint.setStrokeWidth(50);  //设置点的大小
//        mPaint.setStrokeCap(Paint.Cap.ROUND);   //设置点的形状
//        canvas.drawPoint(700,200,mPaint);

//        float[] points = {0, 0, 50, 50, 50, 100, 100, 50, 100, 100, 150, 50, 150, 100};
//        canvas.drawPoints(points,mPaint);
        //offset ，跳过点的数量，下述是跳过0,0两个点
        // count是要绘制的点的数量（50, 50, 50, 100, 100, 50, 100, 100）
//        canvas.drawPoints(points, 2, 8, mPaint);

//        ================================================================ 画椭圆

//        canvas.drawOval(100,100,200,100,mPaint);

//        ================================================================ 画线

//        canvas.drawLine(100,100,200,50,mPaint);

//        float[] points = {20, 20, 120, 20, 70, 20, 70, 120, 20, 120, 120, 120, 150, 20, 250, 20, 150, 20, 150, 120, 250, 20, 250, 120, 150, 120, 250, 120};
//        canvas.drawLines(points, mPaint);
//        跟画多点类似
//        canvas.drawLines(points,2,8,mPaint);

//        ================================================================ 画圆角矩形

//        left, top, right, bottom 是四条边的坐标，rx 和 ry 是圆角的横向半径和纵向半径
//        canvas.drawRoundRect(100, 100, 300, 300, 50, 150, mPaint);

//        ================================================================ 绘制弧形或扇形

//        水平向右方向为0度，顺时针为正，逆时针为负
//        mPaint.setStyle(Paint.Style.FILL);  //实心时会封口，空心时是圆弧，如果userCenter是true，为扇形
//        canvas.drawArc(200,100,800,500,0,90,true,mPaint);

//        ================================================================ 画自定义图形

        // 使用 path 对图形进行描述
//        mPaint.setStyle(Paint.Style.FILL);
//        mPath.addArc(200, 200, 400, 400, -225, 225);
        //这里不能是true，如果是true，起点会变成第二个圆弧的起点，false才保持第一个圆弧的起点，注意这个参数
//        mPath.arcTo(400, 200, 600, 400, -180, 225, false);
//        mPath.lineTo(400, 542);

        //================================================================ 添加子图形

//        mPath.addCircle(300,300,200,Path.Direction.CW);
//        mPath.addRect(400,100,600,300,Path.Direction.CW);
//        mPath.addOval(100,100,200,100,Path.Direction.CW);

        //================================================================ 画直线或曲线

//        mPath.lineTo(100, 100);
//        mPath.rLineTo(100,0);

        //移动，辅助来改变起点位置
//        mPath.moveTo(200,0);
        //================================================================画二次贝塞尔曲线

//        mPath.rQuadTo(100,100,200,100);
        //================================================================画三次贝塞尔曲线

//        mPath.rCubicTo(100,100,200,100,200,300);
//        canvas.drawPath(mPath,mPaint);

//        mPath.lineTo(100, 100);
        //================================================================ 画圆弧,不使用当前位置作为弧线的起点

        // 直接连线连到弧形起点（有痕迹）,forceMoveTo = false
//        mPath.arcTo(100,100,300,300,-90,90,false);
//        forceMoveTo = true 的简化版 arcTo()
//        mPath.addArc(100,100,300,300,-90,90);
//        canvas.drawPath(mPath,mPaint);

//        close() 封闭当前子图形
//        mPaint.setStyle(Paint.Style.FILL); //这个样式会自动封闭子图形
//        mPath.moveTo(100, 100);
//        mPath.lineTo(200, 100);
//        mPath.lineTo(150, 150);
//        mPath.close();

//        mPath.setFillType(Path.FillType.WINDING);
//        mPaint.setStyle(Paint.Style.FILL);
//        mPath.addCircle(100,100,100, Path.Direction.CW);
//        mPath.addCircle(200,200,150, Path.Direction.CCW);
//        canvas.drawPath(mPath, mPaint);

        // ================================================================ 画Bitmap

//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
//        canvas.drawBitmap(bitmap, 200, 100, mPaint);

        // ================================================================画文本

//        mPaint.setStyle(Paint.Style.FILL);
//        mPaint.setStrokeWidth(2);
//        mPaint.setTextSize(84);
//        canvas.drawText("海兰小天使",200,200,mPaint);


        //shader ================================================================着色器

        //线性着色器
//        Shader shader = new LinearGradient(100, 100, 500, 500, Color.parseColor("#ffffff"), Color.parseColor("#000000"), Shader.TileMode.CLAMP);
//        mPaint.setShader(shader);
//        canvas.drawCircle(300,200,200,mPaint);

//        Shader shaderMirror = new LinearGradient(100, 100, 500, 500, Color.parseColor("#ffffff"), Color.parseColor("#000000"), Shader.TileMode.MIRROR);
//        mPaint.setShader(shaderMirror);
//        canvas.drawCircle(700,200,200,mPaint);

//        Shader shaderRepeat = new LinearGradient(100, 100, 500, 500, Color.parseColor("#ffffff"), Color.parseColor("#000000"), Shader.TileMode.REPEAT);
//        mPaint.setShader(shaderRepeat);
//        canvas.drawCircle(700,700,200,mPaint);

        //辐射着色器
//        Shader shader = new RadialGradient(300, 300, 200, Color.WHITE, Color.BLACK, Shader.TileMode.CLAMP);
//        mPaint.setShader(shader);
//        canvas.drawCircle(300,300,200,mPaint);

//        Shader shaderMirror = new RadialGradient(800, 300, 200, Color.WHITE, Color.BLACK, Shader.TileMode.MIRROR);
//        mPaint.setShader(shaderMirror);
//        canvas.drawCircle(800,300,200,mPaint);

//        Shader shaderRepeat = new RadialGradient(300, 800, 200, Color.WHITE, Color.BLACK, Shader.TileMode.REPEAT);
//        mPaint.setShader(shaderRepeat);
//        canvas.drawCircle(300,800,200,mPaint);

        //扫描着色器
//        Shader shader = new SweepGradient(300, 300, Color.WHITE, Color.BLACK);
//        mPaint.setShader(shader);
//        canvas.drawCircle(300,300,200,mPaint);

        //混合着色器
//        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.mipmap.test);
//        Shader shader1 = new BitmapShader(bitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);


//        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.mipmap.bg);
//        Shader shader2 = new BitmapShader(bitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        //第3个参数是结合策略，即shader2用什么策略与shader1结合
//        Shader shader = new ComposeShader(shader1, shader2, PorterDuff.Mode.OVERLAY);

//        mPaint.setShader(shader);
        //这里需要用软件加速，不能用硬件加速，不然显示出不来
//        setLayerType(View.LAYER_TYPE_SOFTWARE, mPaint);
//        canvas.drawRect(100, 100, 1000, 800, mPaint);


        //ColorFilter ================================================================过滤器

        //参数里的 mul 和 add 都是和颜色值格式相同的 int 值，其中 mul 用来和目标像素相乘，add 用来和目标像素相加
//        ColorFilter colorFilter = new LightingColorFilter(0x00ffff, 0x003000);

//        使用一个指定的颜色和一种指定的 PorterDuff.Mode来与绘制对象进行合成
//        ColorFilter porterFilter = new PorterDuffColorFilter(Color.parseColor("#80000000"), PorterDuff.Mode.SRC_OVER);

//        ColorMatrix colorMatrix = new ColorMatrix();
//        colorMatrix.setSaturation(10f);
//        ColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test);
//        Shader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
//        mPaint.setShader(shader);
//        mPaint.setColorFilter(colorFilter);

        //setXfermode ================================================================Transfer mode

        //离屏缓冲
        int layerID = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG);

        dstBmp = makeDst(width, height);
        srcBmp = makeSrc(width, height);

        canvas.drawBitmap(dstBmp, 0, 0, mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        canvas.drawBitmap(srcBmp, width / 2, height / 2, mPaint);
        mPaint.setXfermode(null);

        canvas.restoreToCount(layerID);

        mPaint.setStrokeWidth(30);

        //设置端点的样式
//        mPaint.setStrokeCap(Paint.Cap.BUTT);
//        canvas.drawLine(100,100,300,100,mPaint);
//        mPaint.setStrokeCap(Paint.Cap.SQUARE);
//        canvas.drawLine(100,200,300,200,mPaint);
//        mPaint.setStrokeCap(Paint.Cap.ROUND);
//        canvas.drawLine(100,300,300,300,mPaint);

        //线条形状 ================================================================线条形状

        //设置拐角的样式，拐角角度小于29度时，会变成BEVEL模式，防止尖角过长
//        mPaint.setStyle(Paint.Style.STROKE);
//        mPaint.setStrokeJoin(Paint.Join.MITER);
//        mPath.moveTo(100, 100);
//        mPath.rLineTo(200,0);
//        mPath.rLineTo(-200,120);
//        canvas.drawPath(mPath,mPaint);

//        mPaint.setStrokeJoin(Paint.Join.ROUND);
//        mPath.moveTo(700, 100);
//        mPath.rLineTo(200,0);
//        mPath.rLineTo(-200,200);
//        canvas.drawPath(mPath,mPaint);
//
//        mPaint.setStrokeJoin(Paint.Join.BEVEL);
//        mPath.moveTo(400, 100);
//        mPath.rLineTo(200,0);
//        mPath.rLineTo(-200,200);
//        canvas.drawPath(mPath,mPaint);

        //色彩优化 ================================================================色彩优化

//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test);

        //设置抖动来优化色彩深度降低时的绘制效果，现在不太实用
//        mPaint.setDither(true);
        //设置双线性过滤来优化 Bitmap 放大绘制的效果
//        mPaint.setFilterBitmap(true);
//        canvas.drawBitmap(bitmap, 200, 100, mPaint);

        //setPathEffect设置路径效果，共有6种效果类 ================================================================

        // 把所有拐角变成圆角
//        PathEffect pathEffect = new CornerPathEffect(50);
        //把线条进行随机的偏离，让轮廓变得乱七八糟
//        PathEffect pathEffect2 = new DiscretePathEffect(20, 35);
        //使用虚线来绘制线条
//        PathEffect pathEffect = new DashPathEffect(new float[]{30,20,15,20},0);

        //使用一个 Path 来绘制「虚线」
//        Path dashPath = new Path();
//        dashPath.rLineTo(40,0);
//        dashPath.rLineTo(-20,20);
//        dashPath.close();
//        PathEffect pathEffect = new PathDashPathEffect(dashPath,50,0, PathDashPathEffect.Style.TRANSLATE);

        //混合效果类，分别按照两种 PathEffect 分别对目标进行绘制,会有两条效果线
//        PathEffect sumEffect = new SumPathEffect(pathEffect, pathEffect2);

        //混合效果类，只有1条效果线，是混合处理的
//        PathEffect composeEffect = new ComposePathEffect(pathEffect, pathEffect2);

//        mPaint.setStrokeWidth(20);
//        mPaint.setStyle(Paint.Style.STROKE);
//        mPaint.setPathEffect(composeEffect);
//        mPath.moveTo(100, 100);
//        mPath.rLineTo(200, 0);
//        mPath.rLineTo(300, 300);
//        mPath.rLineTo(300, -200);
//        mPath.rLineTo(300, 300);
//
//        canvas.drawPath(mPath, mPaint);

        //附加效果类 ================================================================

        //在之后的绘制内容下面加一层阴影
//        mPaint.setShadowLayer(10,5,-5,Color.RED);
//        mPaint.setTextSize(100);
        //清除阴影层
//        mPaint.clearShadowLayer();
//        canvas.drawText("Hello World!",200,200,mPaint);

        //MaskFilter

//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test);
        //关闭硬件加速才有效
//        setLayerType(View.LAYER_TYPE_SOFTWARE, mPaint);
        //模糊效果
//        mPaint.setMaskFilter(new BlurMaskFilter(150, BlurMaskFilter.Blur.NORMAL));

        //浮雕效果
//        mPaint.setMaskFilter(new EmbossMaskFilter(new float[]{0, 1, 1}, 0.2f, 8, 10));

//        canvas.drawBitmap(bitmap, 200, 100, mPaint);

        //获取绘制的Path ================================================================


//        PathEffect pathEffect = new DashPathEffect(new float[]{30, 20, 15, 20}, 0);
//
//        mPaint.setStrokeWidth(20);
//        mPaint.setStyle(Paint.Style.STROKE);
//        mPaint.setPathEffect(pathEffect);
//        mPath.moveTo(100, 100);
//        mPath.rLineTo(200, 0);
//        mPath.rLineTo(300, 300);
//        mPath.rLineTo(300, -200);
//        mPath.rLineTo(300, 300);
//
////        canvas.drawPath(mPath, mPaint);
//
//        Path mRealtPath = new Path();
//        mPaint.getFillPath(mPath, mRealtPath);
//        //重置 Paint 的所有属性为默认值，相当于重新 new 一个，不过性能当然高一些啦
//        mPaint.reset();
//        mPaint.setFlags(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
//        //等价于
//        mPaint.setAntiAlias(true);
//        mPaint.setDither(true);
//
//        canvas.drawPath(mRealtPath, mPaint);


        //文本绘制相关========================================================

        //绘制多行文本============================================

        String text1 = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
        //width 是文字区域的宽度，文字到达这个宽度后就会自动换行
        //align 是文字的对齐方向；
        //spacingmult 是行间距的倍数，通常情况下填 1 就好；
        //spacingadd 是行间距的额外增加值，通常情况下填 0 就好；
        //includeadd 是指是否在文字上下添加额外的空间，来避免某些过高的字符的绘制出现越界。
//        StaticLayout staticLayout1 = new StaticLayout(text1, mTextPaint, 1100,
//                Layout.Alignment.ALIGN_NORMAL, 1, 0, true);

//        String text2 = "a\nbc\ndefghi\njklm\nnopqrst\nuvwx\nyz";
//        StaticLayout staticLayout2 = new StaticLayout(text2, mTextPaint, 1100,
//                Layout.Alignment.ALIGN_NORMAL, 1, 0, true);

//        canvas.save();
//        canvas.translate(50, 100);
//        staticLayout1.draw(canvas);
//        canvas.translate(0, 300);
//        staticLayout2.draw(canvas);
//        canvas.restore();

//        mPaint.setTextSize(100);

        //y是基线，文本的左下角，x值没有贴着文本，有一点空隙，往左边一点
//        canvas.drawText("landa",200,200,mPaint);
        //超过屏幕的文本不会绘制，也不会换行
//        canvas.drawText("Lorem Ipsum is simply dummy text of the printing and typesetting industry.",200,200,mPaint);
        //加了\n换行符也不会换行，而是用了空格来替代
//        canvas.drawText("a\nbc\ndefghi\njklm\nnopqrst\nuvwx\nyz",200,200,mPaint);

//        canvas.drawLine(0,200,200,200,mPaint);

        //沿着路径绘制文本
//        mPaint.setStyle(Paint.Style.STROKE);
//        mPaint.setPathEffect(new CornerPathEffect(50));
//        mPaint.setStrokeWidth(5);
//        mPath.moveTo(100, 100);
//        mPath.rLineTo(200, 200);
//        mPath.rLineTo(250, -250);
//        mPath.rLineTo(200, 200);
//
//        canvas.drawPath(mPath, mPaint);
//        canvas.drawTextOnPath("zengfanda",mPath,0,-20,mPaint);

        //是否使用伪粗体
//        mPaint.setFakeBoldText(true);
        //是否加删除线
//        mPaint.setStrikeThruText(true);
        //是否加下划线
//        mPaint.setUnderlineText(true);
        //设置文字倾斜度
//        mPaint.setTextSkewX(0.5f);
        //设置文字变胖变瘦
//        mPaint.setTextScaleX(1.5f);
        //设置字符间距
//        mPaint.setLetterSpacing(0.3f);
        //用 CSS 的 font-feature-settings 的方式来设置文字
//        mPaint.setFontFeatureSettings("smcp");
        //设置文字的对齐方式
        // mPaint.setTextAlign(Paint.Align.CENTER);
        //设置绘制所使用的 地域
//        mPaint.setTextLocale(Locale.TAIWAN);
        //设置是否启用字体的 hinting （字体微调)，现在没用
//        mPaint.setHinting();
        //对中国人没用，不需要了解
//        mPaint.setElegantTextHeight(true);
        //是否开启次像素级的抗锯齿，现在没必要用
//        mPaint.setSubpixelText(true);

        //文本工具类
        /*
        Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();
        String content =fontMetrics.top + "=" + fontMetrics.ascent + "=" + fontMetrics.descent + "=" + fontMetrics.bottom;
        mPaint.setTypeface(Typeface.DEFAULT);
        canvas.drawText("zeng fanda", 200, 200, mPaint);
        //加粗
        mPaint.setTypeface(Typeface.DEFAULT_BOLD);
        //获取推荐的行距 getFontSpacing
        canvas.drawText("zeng fanda", 200, 200 + mPaint.getFontSpacing(), mPaint);
        //等宽字体
        mPaint.setTypeface(Typeface.MONOSPACE);
        canvas.drawText("zeng fanda", 200, 200 + mPaint.getFontSpacing() * 2, mPaint);

        mPaint.setTypeface(Typeface.SANS_SERIF);
        canvas.drawText("zeng fanda", 200, 200 + mPaint.getFontSpacing() * 3, mPaint);

        mPaint.setTypeface(Typeface.SERIF);
        canvas.drawText("zeng fanda", 200, 200 + mPaint.getFontSpacing() * 4, mPaint);

        mPaint.setTextSize(50);
        canvas.drawText(content, 200, 200 + mPaint.getFontSpacing() * 7, mPaint);
        */

//        测量文字尺寸类
        /*
        Rect bounds = new Rect();
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawText("zeng fanda", 200, 200, mPaint);

        //获取文字的显示范围
        mPaint.getTextBounds("zeng fanda", 0, "zeng fanda".length(), bounds);
        bounds.left += 200;
        bounds.top += 200;
        bounds.right += 200;
        bounds.bottom += 200;
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(bounds, mPaint);

        //测量文字的宽度并返回
        //measureText() 测出来的宽度总是比 getTextBounds() 大一点点
//        canvas.drawText("zeng fanda", 200, 200, mPaint);
//        float width = mPaint.measureText("zeng fanda");
        canvas.drawLine(200, 200, bounds.right, 200, mPaint);
        */


    }

    static Bitmap makeDst(int w, int h) {
        Bitmap bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bm);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);

        p.setColor(0xFFFFCC44);
        c.drawOval(new RectF(0, 0, w, h), p);
        return bm;
    }

    static Bitmap makeSrc(int w, int h) {
        Bitmap bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bm);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);

        p.setColor(0xFF66AAFF);
        c.drawRect(0, 0, w, h, p);
        return bm;
    }

}
