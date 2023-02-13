package com.liveearthmap.callerlocation.Main_Ads.admob_ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.facebook.ads.NativeAdLayout;
import com.liveearthmap.callerlocation.Main_Ads.RetrofitResponce.DataItem;
import com.liveearthmap.callerlocation.Main_Ads.realocation_thankyou;
import com.liveearthmap.callerlocation.R;
import com.liveearthmap.callerlocation.activity.realocation_StartApplictaion;
import com.liveearthmap.callerlocation.activity.realocation_Web_pp;

public class realocation_Privacy_PolicyActivity extends AppCompatActivity {
    ImageView Continue;

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

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.realocation_activity_privacypolicy);
        Continue = findViewById(R.id.continue_btn);

        context = realocation_Privacy_PolicyActivity.this;
        admobsmallnative = findViewById(R.id.admobsmallnative);
        native_banner_ad_container = findViewById(R.id.native_banner_ad_container);
        q_native_banner = findViewById(R.id.q_native_banner);

        admobmediumnative = findViewById(R.id.admobmediumnative);
        native_ad_container = findViewById(R.id.native_ad_container);
        q_native = findViewById(R.id.q_native);

        convertedObject = Utils.getResponse(this);

        if (convertedObject != null) {
            Adintermethod.getInstance(this).checkstaticNativeAdsMode(this, admobmediumnative, native_ad_container, q_native);
            Adintermethod.getInstance(this).checkstaticNativeBannerAdsMode(this, admobsmallnative, native_banner_ad_container, q_native_banner);
            Adintermethod.getInstance(this).admob_nativebanner_load(this, convertedObject.getAdmobNativeid());
            Adintermethod.getInstance(this).admob_native_load(this, convertedObject.getAdmobNativeid());

        }

        findViewById(R.id.ppp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(realocation_Privacy_PolicyActivity.this, realocation_Web_pp.class));
            }
        });
        this.Continue.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (convertedObject != null) {
                    Adintermethod.getInstance(realocation_Privacy_PolicyActivity.this).adintercheck(convertedObject, context, convertedObject.getFbinter2(), new Adintermethod.onAdIntent() {
                        @Override
                        public void onintentscreen() {
                            startActivity(new Intent(realocation_Privacy_PolicyActivity.this, realocation_StartApplictaion.class));
                        }
                    });
                } else {
                    startActivity(new Intent(realocation_Privacy_PolicyActivity.this, realocation_StartApplictaion.class));
                }
            }
        });

        findViewById(R.id.iv_rate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (convertedObject != null) {
                    Adintermethod.getInstance(realocation_Privacy_PolicyActivity.this).ShowInter(realocation_Privacy_PolicyActivity.this);
                    Uri uri = Uri.parse("market://details?id=" + getPackageName());
                    Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                    goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                            Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                            Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                    try {
                        startActivity(goToMarket);
                    } catch (ActivityNotFoundException e) {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
                    }

                } else {
                    Uri uri = Uri.parse("market://details?id=" + getPackageName());
                    Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                    goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                            Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                            Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                    try {
                        startActivity(goToMarket);
                    } catch (ActivityNotFoundException e) {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
                    }
                }
            }
        });

        findViewById(R.id.iv_shareBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (convertedObject != null) {
                    Adintermethod.getInstance(realocation_Privacy_PolicyActivity.this).ShowInter(realocation_Privacy_PolicyActivity.this);
                    try {
                        int applicationNameId = realocation_Privacy_PolicyActivity.this.getApplicationInfo().labelRes;
                        Intent i = new Intent(Intent.ACTION_SEND);
                        i.setType("text/plain");
                        i.putExtra(Intent.EXTRA_SUBJECT, getApplicationContext().getString(applicationNameId));
                        String text = "Install this cool application: ";
                        String link = "https://play.google.com/store/apps/details?id=" + getPackageName();
                        i.putExtra(Intent.EXTRA_TEXT, text + " " + link);
                        startActivity(Intent.createChooser(i, "Share link:"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {
                    try {
                        int applicationNameId = realocation_Privacy_PolicyActivity.this.getApplicationInfo().labelRes;
                        Intent i = new Intent(Intent.ACTION_SEND);
                        i.setType("text/plain");
                        i.putExtra(Intent.EXTRA_SUBJECT, getApplicationContext().getString(applicationNameId));
                        String text = "Install this cool application: ";
                        String link = "https://play.google.com/store/apps/details?id=" + getPackageName();
                        i.putExtra(Intent.EXTRA_TEXT, text + " " + link);
                        startActivity(Intent.createChooser(i, "Share link:"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    public void onBackPressed() {
        startActivity(new Intent(realocation_Privacy_PolicyActivity.this, realocation_thankyou.class));
    }
}
