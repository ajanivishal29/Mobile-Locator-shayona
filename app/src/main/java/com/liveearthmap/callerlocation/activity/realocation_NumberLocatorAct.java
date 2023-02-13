package com.liveearthmap.callerlocation.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.liveearthmap.callerlocation.Main_Ads.admob_ads.Adintermethod;
import com.facebook.ads.NativeAdLayout;
import com.liveearthmap.callerlocation.Main_Ads.RetrofitResponce.DataItem;
import com.liveearthmap.callerlocation.Main_Ads.admob_ads.TemplateView;
import com.liveearthmap.callerlocation.Main_Ads.admob_ads.Utils;
import com.liveearthmap.callerlocation.R;

public class realocation_NumberLocatorAct extends AppCompatActivity {

    /* renamed from: p */

    public DataItem convertedObject;
    public Activity context;

    TemplateView admobmediumnative;
    NativeAdLayout native_ad_container;
    CardView q_native;

    TemplateView admobsmallnative;
    NativeAdLayout native_banner_ad_container;
    CardView q_native_banner;

    public C6221m f6394p;

    /* renamed from: com.loctracker.findlocation.callerlocation.NumberLocatorAct$a */
    public class C1677a implements View.OnClickListener {
        public C1677a() {
        }

        public void onClick(View view) {
            realocation_NumberLocatorAct.this.f6394p.f27810e.setEnabled(false);
            realocation_NumberLocatorAct.this.startActivity(new Intent(realocation_NumberLocatorAct.this, realocation_NumberLocatorOpenAct.class));
        }
    }

    /* renamed from: com.loctracker.findlocation.callerlocation.NumberLocatorAct$b */
    public class C1678b implements View.OnClickListener {
        public C1678b() {
        }

        public void onClick(View view) {
            realocation_NumberLocatorAct.this.startActivity(new Intent(realocation_NumberLocatorAct.this, realocation_LocationAct.class));
        }
    }

    /* renamed from: com.loctracker.findlocation.callerlocation.NumberLocatorAct$c */
    public class C1679c implements View.OnClickListener {
        public C1679c() {
        }

        public void onClick(View view) {
            realocation_NumberLocatorAct.this.f6394p.f27811f.setEnabled(false);
            realocation_NumberLocatorAct.this.startActivity(new Intent(realocation_NumberLocatorAct.this, realocation_StdCodesAct.class));
        }
    }

    /* renamed from: com.loctracker.findlocation.callerlocation.NumberLocatorAct$d */
    public class C1680d implements View.OnClickListener {
        public C1680d() {
        }

        public void onClick(View view) {
            realocation_NumberLocatorAct.this.f6394p.f27809d.setEnabled(false);
            realocation_NumberLocatorAct.this.startActivity(new Intent(realocation_NumberLocatorAct.this, realocation_IsdCodesAct.class));
        }
    }

    /* renamed from: com.loctracker.findlocation.callerlocation.NumberLocatorAct$e */
    public class C1681e implements View.OnClickListener {
        public C1681e() {
        }

        public void onClick(View view) {
            realocation_NumberLocatorAct.this.onBackPressed();
        }
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
        View inflate = getLayoutInflater().inflate(R.layout.realocation_activity_number_locator, (ViewGroup) null, false);

        admobsmallnative = inflate.findViewById(R.id.admobsmallnative);
        native_banner_ad_container = inflate.findViewById(R.id.native_banner_ad_container);
        q_native_banner = inflate.findViewById(R.id.q_native_banner);

        admobmediumnative = inflate.findViewById(R.id.admobmediumnative);
        native_ad_container = inflate.findViewById(R.id.native_ad_container);
        q_native = inflate.findViewById(R.id.q_native);

        context = realocation_NumberLocatorAct.this;

        convertedObject = Utils.getResponse(this);

        if (convertedObject != null) {
            Adintermethod.getInstance(this).ShowInter(this);
            Adintermethod.getInstance(this).checkNativeBannerAdsMode(this, admobsmallnative, native_banner_ad_container, q_native_banner);
            Adintermethod.getInstance(this).checkNativeAdsMode(this, admobmediumnative, native_ad_container, q_native);
        }

        int i = R.id.back;
        ImageView imageView = (ImageView) inflate.findViewById(R.id.back);
        if (imageView != null) {
            i = R.id.constraintLayout;
            RelativeLayout linearLayout = (RelativeLayout) inflate.findViewById(R.id.constraintLayout);
            if (linearLayout != null) {
                i = R.id.iv_isdCodes;
                ImageView imageView2 = (ImageView) inflate.findViewById(R.id.iv_isdCodes);
                if (imageView2 != null) {
                    i = R.id.iv_numberLocator;
                    ImageView imageView3 = (ImageView) inflate.findViewById(R.id.iv_numberLocator);
                    if (imageView3 != null) {
                        i = R.id.iv_Stdcodes;
                        ImageView imageView4 = (ImageView) inflate.findViewById(R.id.iv_Stdcodes);
                        if (imageView4 != null) {
                            i = R.id.lv_locationBtn;
                            ImageView imageView5 = (ImageView) inflate.findViewById(R.id.lv_locationBtn);
                            if (imageView5 != null) {
                                LinearLayout linearLayout3 = (LinearLayout) inflate;
                                this.f6394p = new C6221m(linearLayout3, imageView, linearLayout, imageView2, imageView3, imageView4, imageView5);
                                setContentView((View) linearLayout3);
                                this.f6394p.f27810e.setOnClickListener(new C1677a());
                                this.f6394p.f27812g.setOnClickListener(new C1678b());
                                this.f6394p.f27811f.setOnClickListener(new C1679c());
                                this.f6394p.f27809d.setOnClickListener(new C1680d());
                                this.f6394p.f27807b.setOnClickListener(new C1681e());
                                return;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    public final class C6221m {

        /* renamed from: a */
        public final RelativeLayout f27806a;

        /* renamed from: b */
        public final ImageView f27807b;

        /* renamed from: d */
        public final ImageView f27809d;

        /* renamed from: e */
        public final ImageView f27810e;

        /* renamed from: f */
        public final ImageView f27811f;

        /* renamed from: g */
        public final ImageView f27812g;

        public C6221m(LinearLayout linearLayout3, ImageView imageView, RelativeLayout linearLayout, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5) {
            this.f27806a = linearLayout;
            this.f27807b = imageView;
            this.f27809d = imageView2;
            this.f27810e = imageView3;
            this.f27811f = imageView4;
            this.f27812g = imageView5;
        }
    }

    public void onRestart() {
        super.onRestart();
        this.f6394p.f27810e.setEnabled(true);
        this.f6394p.f27812g.setEnabled(true);
        this.f6394p.f27809d.setEnabled(true);
        this.f6394p.f27811f.setEnabled(true);
    }

    public void onResume() {
        super.onResume();
        this.f6394p.f27810e.setEnabled(true);
        this.f6394p.f27812g.setEnabled(true);
        this.f6394p.f27809d.setEnabled(true);
        this.f6394p.f27811f.setEnabled(true);
    }
}
