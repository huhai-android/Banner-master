package com.huhai.banner.banner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

/*
 *  @项目名：  BannerMaster
 *  @包名：    com.huhai.banner.bannermaster
 *  @文件名:   PointView
 *  @创建者:   huhai
 *  @创建时间:  2018/11/26 15:18
 *  @描述：
 */
public class PointView extends View {
    private Paint paintSelect;
    private Paint paintNoSelect;
    private int mViewWidth;
    private int mViewHeight;
    private List<String> data;
    private Context context;
    private int margin = 20;//指示器间距
    private int radius = 5;//指示器半径
    private int color=R.color.white;

    public PointView(Context context) {
        super(context);
        initPaint();

    }


    public PointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();

    }


    private void initPaint() {
        paintSelect = new Paint();
        paintSelect.setAntiAlias(true);//去锯齿
        paintSelect.setColor(getResources().getColor(color));
        paintSelect.setTextSize(20);
        //  消除字体锯齿
        paintSelect.setFlags(Paint.ANTI_ALIAS_FLAG);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        getViewXY();
    }


    /*获取自定义view的宽度*/
    private void getViewXY() {
        mViewWidth = getMeasuredWidth();
        mViewHeight = getMeasuredHeight();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (context!=null){
            canvas.drawCircle(mViewWidth / 2, mViewHeight / 2, DisplayUtils.dp2px(context,radius), paintSelect);

        }


    }


    public void setColor(int color, Context context) {
        this.color = color;
        this.context = context;
        initPaint();
        invalidate();
    }
}
