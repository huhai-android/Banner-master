package com.huhai.banner.banner;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/*
 *  @项目名：  BannerMaster
 *  @包名：    com.huhai.banner.bannermaster
 *  @文件名:   BannerAdapter
 *  @创建者:   huhai
 *  @创建时间:  2018/11/23 15:26
 *  @描述：
 */
public class BannerAdapter extends PagerAdapter {
    private static final String TAG = "BannerAdapter";
    private final List<String> urllist = new ArrayList<>();
    private final WeakReference<Context> context;

    public BannerAdapter(List<String> url, Context context) {
        urllist.clear();
        urllist.addAll(url);
        this.context =new WeakReference<>(context);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Log.d(TAG, position + "");
        View view = View.inflate(context.get(), R.layout.item_view, null);
        ImageView imageView = view.findViewById(R.id.image);
        if (urllist.size()>0){
            Glide.with(context.get()).load(urllist.get(position %5)).into(imageView);
            container.addView(view);
        }
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }


}
