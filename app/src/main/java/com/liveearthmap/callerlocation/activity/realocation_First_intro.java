package com.liveearthmap.callerlocation.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.ads.NativeAdLayout;
import com.liveearthmap.callerlocation.Main_Ads.RetrofitResponce.DataItem;
import com.liveearthmap.callerlocation.Main_Ads.admob_ads.Adintermethod;
import com.liveearthmap.callerlocation.Main_Ads.admob_ads.TemplateView;
import com.liveearthmap.callerlocation.Main_Ads.admob_ads.Utils;
import com.liveearthmap.callerlocation.R;
import com.tiagosantos.enchantedviewpager.EnchantedViewPager;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class realocation_First_intro extends AppCompatActivity {

    public DataItem convertedObject;
    public Activity context;

    TemplateView admobmediumnative;
    NativeAdLayout native_ad_container;
    CardView q_native;

    RecyclerView iteamscroll;
    public ArrayList<iteamData> f1219q = new ArrayList<>();

    public EnchantedViewPager enchantedViewPager;
    public ArrayList<Slider_Data> sliderDataArrayList = new ArrayList<>();
    public static int f1217u;
    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 4500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 4500; // tim

    ArrayList<Slider_Data> albumList = new ArrayList<>();


    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    public void onBackPressed() {
        if (convertedObject != null) {
            Adintermethod.getInstance(this).ShowInterBack(this);
            finish();
        } else {
            finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.realocation_mirror_first_intro);

        context = realocation_First_intro.this;

        admobmediumnative = findViewById(R.id.admobmediumnative);
        native_ad_container = findViewById(R.id.native_ad_container);
        q_native = findViewById(R.id.q_native);

        convertedObject = Utils.getResponse(this);

        if (convertedObject != null) {
            Adintermethod.getInstance(this).ShowInter(this);
            Adintermethod.getInstance(this).checkNativeAdsMode(this, admobmediumnative, native_ad_container, q_native);
        }

        enchantedViewPager = findViewById(R.id.slider);

        SliderAdapter adapter = new SliderAdapter(this, createAlbumList());
        enchantedViewPager.setAdapter(adapter);
        enchantedViewPager.setCurrentItem(1);
        enchantedViewPager.useAlpha();
        enchantedViewPager.useScale();
        adapter.enableCarrousel();
        pagerautoscroll();

        findViewById(R.id.callnumberbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realocation_First_intro.this.startActivity(new Intent(realocation_First_intro.this, realocation_Second_intro.class));
            }
        });

        findViewById(R.id.callhistrybtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realocation_First_intro.this.startActivity(new Intent(realocation_First_intro.this, realocation_Second_intro.class));
            }
        });

        iteamscroll = findViewById(R.id.iteamscroll);

        iteamscroll.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        this.f1219q.add(new iteamData(R.drawable.d1, "prodress"));
        this.f1219q.add(new iteamData(R.drawable.d2, "prodress"));
        this.f1219q.add(new iteamData(R.drawable.d3, "prodress"));
        this.f1219q.add(new iteamData(R.drawable.d4, "prodress"));
        this.f1219q.add(new iteamData(R.drawable.d5, "prodress"));
        this.f1219q.add(new iteamData(R.drawable.d6, "prodress"));
        this.f1219q.add(new iteamData(R.drawable.d7, "prodress"));
        this.f1219q.add(new iteamData(R.drawable.d8, "prodress"));
        this.f1219q.add(new iteamData(R.drawable.d9, "prodress"));
        this.f1219q.add(new iteamData(R.drawable.d10, "prodress"));
        iteamscroll.setAdapter(new IteamAdapter(this.f1219q, this));
    }


    public void pagerautoscroll() {
        /*After setting the adapter use the timer */
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == albumList.size()) {
                    currentPage = 0;
                }
                enchantedViewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);
    }

    private ArrayList<Slider_Data> createAlbumList() {

        for (int i = 0; i < 3; i++) {
            albumList.add(new Slider_Data(getAlbumArtReference(i)));
        }
        return albumList;
    }

    private int getAlbumArtReference(int position) {
        if (position == 0) {
            return R.drawable.slider1;
        } else if (position == 1) {
            return R.drawable.slider2;
        } else if (position == 2) {
            return R.drawable.slider3;
        }

        return R.drawable.slider1;
    }
}
