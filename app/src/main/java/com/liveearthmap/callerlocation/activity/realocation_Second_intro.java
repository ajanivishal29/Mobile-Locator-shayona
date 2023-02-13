package com.liveearthmap.callerlocation.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.liveearthmap.callerlocation.Main_Ads.RetrofitResponce.DataItem;
import com.liveearthmap.callerlocation.Main_Ads.admob_ads.Adintermethod;
import com.liveearthmap.callerlocation.Main_Ads.admob_ads.TemplateView;
import com.liveearthmap.callerlocation.Main_Ads.admob_ads.Utils;
import com.liveearthmap.callerlocation.R;
import com.facebook.ads.NativeAdLayout;

public class realocation_Second_intro extends AppCompatActivity {

    public DataItem convertedObject;
    public Activity context;

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
        setContentView((int) R.layout.realocation_call_second_intro);

        context = realocation_Second_intro.this;

        admobmediumnative = findViewById(R.id.admobmediumnative);
        native_ad_container = findViewById(R.id.native_ad_container);
        q_native = findViewById(R.id.q_native);


        convertedObject = Utils.getResponse(this);


        if (convertedObject != null) {
                Adintermethod.getInstance(this).ShowInter(this);
                Adintermethod.getInstance(this).checkNativeAdsMode(this, admobmediumnative, native_ad_container, q_native);
        }

        findViewById(R.id.continue_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realocation_Second_intro.this.startActivity(new Intent(realocation_Second_intro.this, realocation_Call_Third_intro.class));
            }
        });
    }
}
