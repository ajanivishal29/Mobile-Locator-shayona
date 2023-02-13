package com.liveearthmap.callerlocation;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;

import com.facebook.ads.NativeAdLayout;
import com.liveearthmap.callerlocation.Main_Ads.RetrofitResponce.DataItem;
import com.liveearthmap.callerlocation.Main_Ads.admob_ads.Adintermethod;
import com.liveearthmap.callerlocation.Main_Ads.admob_ads.TemplateView;
import com.liveearthmap.callerlocation.Main_Ads.admob_ads.Utils;
import com.liveearthmap.callerlocation.activity.realocation_GPSCheck_Activity;
import com.liveearthmap.callerlocation.activity.realocation_LocationInfoAct;
import com.liveearthmap.callerlocation.activity.realocation_NumberLocatorAct;
import com.liveearthmap.callerlocation.activity.realocation_Tools_Activity;
import com.liveearthmap.callerlocation.bank_activity.realocation_Banklist_Activity;
import com.liveearthmap.callerlocation.nearby_activity.realocation_PlaceNotFound_Activity;
import com.liveearthmap.callerlocation.recharge_activity.realocation_Rechargee_Activity;
import com.liveearthmap.callerlocation.sim_information_activity.realocation_SimInfo_Activity;
import com.liveearthmap.callerlocation.traffic_activity.realocation_Traffic_Finder;
import com.liveearthmap.callerlocation.ussd_activity.realocation_USSD_Activity;

import java.util.ArrayList;
import java.util.List;

public class realocation_HomePage_Activity extends AppCompatActivity {
    ImageView Btn_Bankinfo;
    ImageView Btn_Locationinfo;
    ImageView Btn_Mobiletools;
    ImageView Btn_Nearbyplace;
    ImageView Btn_NumberSearch;
    ImageView Btn_RechargePlan;
    ImageView Btn_SimInfo;
    ImageView Btn_Trafficarea;
    ImageView Btn_Ussdcode;

    private String[] PERMISSIONS = {"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.INTERNET", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_NETWORK_STATE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.READ_PHONE_STATE", "android.permission.WRITE_SETTINGS", "android.permission.CALL_PHONE", "android.permission.FOREGROUND_SERVICE", "android.permission.CAMERA"};
    String feature;

    public DataItem convertedObject;
    public Activity context;

    TemplateView admobmediumnative;
    NativeAdLayout native_ad_container;
    CardView q_native;

    TemplateView admobsmallnative;
    NativeAdLayout native_banner_ad_container;
    CardView q_native_banner;

    TemplateView admobmediumnative1;
    NativeAdLayout native_ad_container1;
    CardView q_native1;

    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.realocation_homepage_layout);

        context = realocation_HomePage_Activity.this;

        admobsmallnative = findViewById(R.id.admobsmallnative);
        native_banner_ad_container = findViewById(R.id.native_banner_ad_container);
        q_native_banner = findViewById(R.id.q_native_banner);

        admobmediumnative = findViewById(R.id.admobmediumnative);
        native_ad_container = findViewById(R.id.native_ad_container);
        q_native = findViewById(R.id.q_native);

        admobmediumnative1 = findViewById(R.id.admobmediumnative1);
        native_ad_container1 = findViewById(R.id.native_ad_container1);
        q_native1 = findViewById(R.id.q_native1);

        convertedObject = Utils.getResponse(this);

        if (convertedObject != null) {
            Adintermethod.getInstance(this).ShowInter(this);
            Adintermethod.getInstance(this).checkNativeBannerAdsMode(this, admobsmallnative, native_banner_ad_container, q_native_banner);
            Adintermethod.getInstance(this).checkNativeAdsMode(this, admobmediumnative, native_ad_container, q_native);
            Adintermethod.getInstance(this).checkNativeAdsMode(this, admobmediumnative1, native_ad_container1, q_native1);
        }

        if (!hasPermissions(this, this.PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, this.PERMISSIONS, 1);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            PermissionCheck();
        }
        bindview();
    }

    public boolean hasPermissions(Context context2, String... strArr) {
        if (!(Build.VERSION.SDK_INT < 23 || context2 == null || strArr == null)) {
            for (String checkSelfPermission : strArr) {
                if (ActivityCompat.checkSelfPermission(context2, checkSelfPermission) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    @SuppressLint("ResourceAsColor")
    private void bindview() {
        ImageView imageView = (ImageView) findViewById(R.id.btn_numberlocation);

        this.Btn_NumberSearch = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                realocation_HomePage_Activity homePage_Activity = realocation_HomePage_Activity.this;
                homePage_Activity.startActivity(new Intent(homePage_Activity, realocation_NumberLocatorAct.class));
            }
        });
        ImageView imageView2 = (ImageView) findViewById(R.id.btn_nearbyplace);
        this.Btn_Nearbyplace = imageView2;
        imageView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                if (realocation_GPSCheck_Activity.isLocationEnabled(realocation_HomePage_Activity.this.context)) {
                    realocation_HomePage_Activity homePage_Activity = realocation_HomePage_Activity.this;
                    homePage_Activity.startActivity(new Intent(homePage_Activity.context, realocation_PlaceNotFound_Activity.class));
                } else if (!((Activity) realocation_HomePage_Activity.this.context).isFinishing()) {
                    realocation_HomePage_Activity.this.showGPSDisabledAlertToUser();
                }
            }
        });
        ImageView imageView3 = (ImageView) findViewById(R.id.btn_trafficarea);
        this.Btn_Trafficarea = imageView3;
        imageView3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                if (realocation_GPSCheck_Activity.isLocationEnabled(realocation_HomePage_Activity.this.context)) {
                    realocation_HomePage_Activity homePage_Activity = realocation_HomePage_Activity.this;
                    homePage_Activity.startActivity(new Intent(homePage_Activity.context, realocation_Traffic_Finder.class));
                } else if (!((Activity) realocation_HomePage_Activity.this.context).isFinishing()) {
                    realocation_HomePage_Activity.this.showGPSDisabledAlertToUser();
                }

            }
        });
        ImageView imageView4 = (ImageView) findViewById(R.id.btn_simcardinfo);
        this.Btn_SimInfo = imageView4;
        imageView4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                realocation_HomePage_Activity homePage_Activity = realocation_HomePage_Activity.this;
                homePage_Activity.startActivity(new Intent(homePage_Activity, realocation_SimInfo_Activity.class));
            }
        });
        ImageView imageView5 = (ImageView) findViewById(R.id.btn_bankinfo);
        this.Btn_Bankinfo = imageView5;
        imageView5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                realocation_HomePage_Activity homePage_Activity = realocation_HomePage_Activity.this;
                homePage_Activity.startActivity(new Intent(homePage_Activity, realocation_Banklist_Activity.class));
            }
        });
        ImageView imageView6 = (ImageView) findViewById(R.id.btn_mobiletools);
        this.Btn_Mobiletools = imageView6;
        imageView6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                realocation_HomePage_Activity homePage_Activity = realocation_HomePage_Activity.this;
                homePage_Activity.startActivity(new Intent(homePage_Activity, realocation_Tools_Activity.class));
            }
        });

        ImageView imageView8 = (ImageView) findViewById(R.id.btn_locationinfo);
        this.Btn_Locationinfo = imageView8;
        imageView8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                realocation_HomePage_Activity homePage_Activity = realocation_HomePage_Activity.this;
                homePage_Activity.startActivity(new Intent(homePage_Activity.context, realocation_LocationInfoAct.class));
            }
        });
        ImageView imageView9 = (ImageView) findViewById(R.id.btn_rechargeplan);
        this.Btn_RechargePlan = imageView9;
        imageView9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                realocation_HomePage_Activity homePage_Activity = realocation_HomePage_Activity.this;
                homePage_Activity.startActivity(new Intent(homePage_Activity, realocation_Rechargee_Activity.class));
            }
        });
        ImageView imageView10 = (ImageView) findViewById(R.id.btn_ussdcode);
        this.Btn_Ussdcode = imageView10;
        imageView10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                realocation_HomePage_Activity homePage_Activity = realocation_HomePage_Activity.this;
                homePage_Activity.startActivity(new Intent(homePage_Activity, realocation_USSD_Activity.class));
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void PermissionCheck() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (!addPermission(arrayList2, "android.permission.ACCESS_FINE_LOCATION")) {
            arrayList.add("Content-Location");
        }
        if (!addPermission(arrayList2, "android.permission.ACCESS_COARSE_LOCATION")) {
            arrayList.add("Location Coarse");
        }
        if (!addPermission(arrayList2, "android.permission.READ_EXTERNAL_STORAGE")) {
            arrayList.add("READ_EXTERNAL_STORAGE");
        }
        if (!addPermission(arrayList2, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            arrayList.add("Write Exteranal");
        }
        if (!addPermission(arrayList2, "android.permission.CAMERA")) {
            arrayList.add("CAMERA");
        }
        if (!addPermission(arrayList2, "android.permission.WRITE_CONTACTS")) {
            arrayList.add("WContacts");
        }
        if (arrayList2.size() > 0) {
            requestPermissions((String[]) arrayList2.toArray(new String[arrayList2.size()]), 124);
        }
    }

    private boolean addPermission(List<String> list, String str) {
        if (Build.VERSION.SDK_INT < 23 || checkSelfPermission(str) == 0) {
            return true;
        }
        list.add(str);
        return shouldShowRequestPermissionRationale(str);
    }

    public void onBackPressed() {
        if (convertedObject != null) {
            Adintermethod.getInstance(this).ShowInterBack(this);
            finish();
        } else {
            finish();
        }
    }

    public void showGPSDisabledAlertToUser() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setMessage(getResources().getString(R.string.no_gps)).setCancelable(false).setPositiveButton(getResources().getString(R.string.enable_gps), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                realocation_HomePage_Activity.this.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.compass_cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog create = builder.create();
        builder.setCancelable(false);
        create.show();
    }
}
