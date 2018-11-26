package com.huhai.banner.banner;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/*
 *  @项目名：  BannerMaster
 *  @包名：    com.huhai.banner.bannermaster
 *  @文件名:   Banner
 *  @创建者:   huhai
 *  @创建时间:  2018/11/23 16:01
 *  @描述：
 */
public class Banner extends FrameLayout implements ViewPager.OnPageChangeListener {


    private static final String TAG = "Banner";
    private Context context;
    private BannerAdapter adapter;
    private int selectIndex = 0;
    private Handler handler;
    private ViewPager viewpager;
    private boolean isTouch = false;
    private Timer timer;

    private LinearLayout lvPoint;

    public Banner(@NonNull Context context) {
        super(context);

    }

    public Banner(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.banner, this, true);
        viewpager = view.findViewById(R.id.viewpager);
        lvPoint = view.findViewById(R.id.lv_point);
        adapter = new BannerAdapter(Banner.Builder.builder.url, getContext());
        viewpager.setAdapter(adapter);
        viewpager.addOnPageChangeListener(this);

        for (int i = 0; i < Banner.Builder.builder.url.size(); i++) {
            View dot = View.inflate(getContext(), R.layout.image, lvPoint);
        }
        for (int i = 0; i < Banner.Builder.builder.url.size(); i++) {
            PointView pointView = (PointView) lvPoint.getChildAt(i);
            if (i == 0) {
                pointView.setColor(Builder.builder.selectColor, context);
            } else {
                pointView.setColor(Builder.builder.normalColor, context);

            }

        }

    }

    public Builder builder(Context context) {
        this.context = context;
        return new Builder();
    }

    public void start() {
        init();
        //开启定时器

        initTimerTask();
    }

    private void initTimerTask() {
        if (Builder.builder.isAutoPlay){
            handler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    viewpager.setCurrentItem(selectIndex++);
                }
            };

            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    // (1) 使用handler发送消息
                    // Log.d(TAG, "是否按下" + isTouch);
                    if (!isTouch) {
                        handler.sendEmptyMessage(0);
                    }
                }
            }, 0, Builder.builder.time * 1000);
        }

    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        selectIndex = i;
        for (int k = 0; k < Banner.Builder.builder.url.size(); k++) {
            Log.d(TAG, "当前选中" + k + "计算选中" + (i % 5));
            PointView point = (PointView) lvPoint.getChildAt(k);
            if (k == i % 5) {
                point.setColor(Builder.builder.selectColor, context);
            } else {
                point.setColor(Builder.builder.normalColor, context);

            }

        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {
        switch (i) {
            //用户正在滑动，暂停轮播
            case ViewPager.SCROLL_STATE_DRAGGING:
                isTouch = true;
                break;
            //滑动结束，继续轮播
            case ViewPager.SCROLL_STATE_IDLE:
                isTouch = false;
                break;

        }

    }

    public static class Builder {
        public static Builder builder = new Builder();
        private List<String> url = new ArrayList<>();
        private boolean isAutoPlay;
        private int time;
        private int selectColor;
        private int normalColor;

        /**
         * 地址使用是list集合
         *
         * @param url
         * @return
         */
        public Builder setUrl(List<String> url) {
            builder.url = url;
            return builder;
        }

        /**
         * 是否自动轮播
         *
         * @param isautoPlay
         * @return
         */
        public Builder isAutoPlay(boolean isautoPlay) {
            builder.isAutoPlay = isautoPlay;
            return builder;
        }

        /**
         * 时间单位是s
         *
         * @param time
         * @return
         */
        public Builder setTime(int time) {
            builder.time = time;
            return builder;
        }

        public int getSelectColor() {
            return selectColor;
        }

        public Builder setSelectColor(int selectColor) {
            builder.selectColor = selectColor;
            return builder;
        }

        public int getNormalColor() {
            return normalColor;
        }

        public Builder setNormalColor(int normalColor) {
            builder.normalColor = normalColor;
            return builder;
        }
    }


}
