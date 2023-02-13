package com.liveearthmap.callerlocation.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.liveearthmap.callerlocation.Main_Ads.RetrofitResponce.DataItem;
import com.liveearthmap.callerlocation.Main_Ads.admob_ads.Adintermethod;
import com.liveearthmap.callerlocation.Main_Ads.admob_ads.TemplateView;
import com.liveearthmap.callerlocation.Main_Ads.admob_ads.Utils;
import com.liveearthmap.callerlocation.R;
import com.liveearthmap.callerlocation.device_activity.realocation_DeviceInfo_Activity;
import com.liveearthmap.callerlocation.system_activity.realocation_SystemUsage_Activity;
import com.facebook.ads.NativeAdLayout;

public class realocation_Tools_Activity extends AppCompatActivity {
    ImageView audio;
    ImageView device_info;
    ImageView system;

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

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.realocation_mobile_tools_layout);

        this.device_info = (ImageView) findViewById(R.id.device_info);
        this.system = (ImageView) findViewById(R.id.system);
        this.audio = (ImageView) findViewById(R.id.audio);

        context = realocation_Tools_Activity.this;

        admobmediumnative = findViewById(R.id.admobmediumnative);
        native_ad_container = findViewById(R.id.native_ad_container);
        q_native = findViewById(R.id.q_native);

        convertedObject = Utils.getResponse(this);

        if (convertedObject != null) {
            Adintermethod.getInstance(this).ShowInter(this);
            Adintermethod.getInstance(this).checkNativeAdsMode(this, admobmediumnative, native_ad_container, q_native);
        }

        this.device_info.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                realocation_Tools_Activity mobile_Tools_Activity = realocation_Tools_Activity.this;
                mobile_Tools_Activity.startActivity(new Intent(mobile_Tools_Activity.getApplicationContext(), realocation_DeviceInfo_Activity.class));

            }
        });
        this.system.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                realocation_Tools_Activity mobile_Tools_Activity = realocation_Tools_Activity.this;
                mobile_Tools_Activity.startActivity(new Intent(mobile_Tools_Activity.getApplicationContext(), realocation_SystemUsage_Activity.class));
            }
        });
        this.audio.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT < 23) {
                    return;
                }
                if (!Settings.System.canWrite(realocation_Tools_Activity.this.getApplicationContext())) {
                    realocation_Tools_Activity mobile_Tools_Activity = realocation_Tools_Activity.this;
                    mobile_Tools_Activity.startActivityForResult(new Intent("android.settings.action.MANAGE_WRITE_SETTINGS", Uri.parse("package:" + realocation_Tools_Activity.this.getPackageName())), 200);
                    return;
                }
                realocation_Tools_Activity mobile_Tools_Activity2 = realocation_Tools_Activity.this;
                mobile_Tools_Activity2.startActivity(new Intent(mobile_Tools_Activity2, realocation_ManageAudio_Activity.class));
            }
        });
    }

    public void onBackPressed() {
        if (convertedObject != null) {
            Adintermethod.getInstance(this).ShowInterBack(this);
            finish();
        } else {
            finish();
        }
    }
}
