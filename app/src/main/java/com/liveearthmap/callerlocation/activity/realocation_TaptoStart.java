package com.liveearthmap.callerlocation.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.facebook.ads.NativeAdLayout;
import com.liveearthmap.callerlocation.Main_Ads.RetrofitResponce.DataItem;
import com.liveearthmap.callerlocation.Main_Ads.admob_ads.Adintermethod;
import com.liveearthmap.callerlocation.Main_Ads.admob_ads.TemplateView;
import com.liveearthmap.callerlocation.Main_Ads.admob_ads.Utils;
import com.liveearthmap.callerlocation.R;

public class realocation_TaptoStart extends AppCompatActivity {

    public DataItem convertedObject;
    public Activity context;

    TemplateView admobsmallnative;
    NativeAdLayout native_banner_ad_container;
    CardView q_native_banner;

    TemplateView admobmediumnative;
    NativeAdLayout native_ad_container;
    CardView q_native;

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
        setContentView((int) R.layout.realocation_activity_taptostart);


        context = realocation_TaptoStart.this;
        admobsmallnative = findViewById(R.id.admobsmallnative);
        native_banner_ad_container = findViewById(R.id.native_banner_ad_container);
        q_native_banner = findViewById(R.id.q_native_banner);

        admobmediumnative = findViewById(R.id.admobmediumnative);
        native_ad_container = findViewById(R.id.native_ad_container);
        q_native = findViewById(R.id.q_native);

        convertedObject = Utils.getResponse(this);

        if (convertedObject != null) {
            Adintermethod.getInstance(this).ShowInter(this);
            Adintermethod.getInstance(this).checkNativeBannerAdsMode(this, admobsmallnative, native_banner_ad_container, q_native_banner);
            Adintermethod.getInstance(this).checkNativeAdsMode(this, admobmediumnative, native_ad_container, q_native);
        }

        findViewById(R.id.hybridbtn).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(realocation_TaptoStart.this, GenderActivity.class));
            }
        });

        findViewById(R.id.terrainbtn).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(realocation_TaptoStart.this, GenderActivity.class));
            }
        });

        findViewById(R.id.roadbtn).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(realocation_TaptoStart.this, GenderActivity.class));
            }
        });

        findViewById(R.id.satellitebtn).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(realocation_TaptoStart.this, GenderActivity.class));
            }
        });
    }
}
