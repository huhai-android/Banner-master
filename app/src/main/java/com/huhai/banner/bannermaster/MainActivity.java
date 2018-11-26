package com.huhai.banner.bannermaster;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.huhai.banner.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.banner)
    Banner banner;
    private List<String> url = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        url.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3093755834,2286212200&fm=26&gp=0.jpg");
        url.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1192400329,3991339099&fm=26&gp=0.jpg");
        url.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=488151815,2133376803&fm=26&gp=0.jpg");
        url.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2820444047,3234320340&fm=26&gp=0.jpg");
        url.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3416614824,961552606&fm=26&gp=0.jpg");
        banner.builder(this)
                .setUrl(url)
                .isAutoPlay(false)
                .setTime(2)
                .setSelectColor(R.color.red)
                .setNormalColor(R.color.white);


        banner.start();

    }
}
