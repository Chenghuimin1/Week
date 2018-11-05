package chenghuimin.bwie.com.week01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

public class Cricle extends View implements View.OnClickListener {

    private DisplayMetrics displayMetrics;
    private int scrrenwidth;
    private int screenheight;
    private int centerX;
    private int centerY;
    private int[] colors = new int[]{Color.RED, Color.BLUE, Color.CYAN, Color.WHITE, Color.YELLOW, Color.GREEN};
    private Paint paint;
    private String[] desc = new String[]{"苹果", "香蕉", "橙子", "葡萄", "栗子", "火龙果"};
    private boolean isRote;


    public Cricle(Context context) {
        this(context, null);
    }

    public Cricle(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public Cricle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        //测量屏幕的宽高信息
        displayMetrics = context.getResources().getDisplayMetrics();
        scrrenwidth = displayMetrics.widthPixels;
        screenheight = displayMetrics.heightPixels;

        //获取屏幕中心坐标
        centerX = scrrenwidth / 2;
        centerY = screenheight / 2;

        //初始化画笔
        initPaint();

        this.setOnClickListener(this);


    }


    //测量的方法 测量大小


    private void initPaint() {
        //初始化画笔对象
        paint = new Paint();
        //初始化画笔的颜色
        paint.setColor(Color.RED);
        //宽度
        paint.setStrokeWidth(20);
        //样式
        paint.setStyle(Paint.Style.FILL);
        //抗锯齿
        paint.setAntiAlias(true);
    }


    //绘画
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //移动画布的中心位置
        canvas.translate(centerX, centerY);

        //绘制6个圆弧
        RectF rectF = new RectF(-300, -300, 300, 300);

        float start = 60;
        for (int i = 0; i < 6; i++) {
            //设置颜色
            paint.setColor(colors[i]);
            canvas.drawArc(rectF, start * i, 60, true, paint);
        }

        //绘制圆的中心
        paint.setColor(Color.RED);
        canvas.drawCircle(0, 0, 100, paint);

        //设置中心圆的文字颜色及大小
        paint.setColor(Color.YELLOW);
        paint.setTextSize(40);

        //获取文字的宽度和高度
        Rect rectText = new Rect();
        paint.getTextBounds("start", 0, 5, rectText);
        int width = rectText.width();
        int height = rectText.height();
        canvas.drawText("start", -width / 2, height / 2, paint);


        //绘制描述信息
        RectF rectF1 = new RectF(-200, -200, 200, 200);
        for (int i = 0; i < 6; i++) {
            paint.setColor(Color.BLACK);
            Path path = new Path();
            path.addArc(rectF1, start * i+15, 60);
            canvas.drawTextOnPath(desc[i], path, 0, 0, paint);
        }
    }

    //开始动画
    private void startAnimal() {
        isRote = true;
        double random = Math.random();
        RotateAnimation rotateAnimation = new RotateAnimation(0, (float) (720 * random),centerX,centerY);
        rotateAnimation.setDuration(800);
        rotateAnimation.setFillAfter(true);

        //设置重复次数
        rotateAnimation.setInterpolator(new LinearInterpolator());
        //设置重复模式
        rotateAnimation.setRepeatMode(Animation.RESTART);

        //给动画添加监听
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                isRote = false;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        startAnimation(rotateAnimation);

    }

    @Override
    public void onClick(View v) {
        if (!isRote) {
            startAnimal();
        }
    }


    //给一个随机的抽奖结果
    private void setRoundDom() {
        double random = Math.random();
        RotateAnimation rotateAnimation2 = new RotateAnimation(0, (float) (360 * random), centerX, centerY);
        rotateAnimation2.setDuration(100);
        rotateAnimation2.setFillAfter(true);
        startAnimation(rotateAnimation2);
    }


}
