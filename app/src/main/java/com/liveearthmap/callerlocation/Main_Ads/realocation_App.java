package com.liveearthmap.callerlocation.Main_Ads;


import static com.liveearthmap.callerlocation.Main_Ads.realocation_Splace_Activity.apiInterface;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import androidx.multidex.MultiDex;

import com.anchorfree.sdk.UnifiedSDK;
import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;
import com.liveearthmap.callerlocation.Main_Ads.RetrofitResponce.DataItem;
import com.liveearthmap.callerlocation.Main_Ads.RetrofitResponce.LocaladsResponce;
import com.liveearthmap.callerlocation.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class realocation_App extends Application {
    private int success;
    public static ArrayList<DataItem> arrAdDataStart = new ArrayList<>();
    private StartAdListener startAdListener;
    public static realocation_Touch_AppOpenManager valeAppOpenManager;

    public static Context context;
    public static SharedPreferences.Editor editor;
    public static SharedPreferences preferences;

    private static realocation_App instance;

    UnifiedSDK unifiedSDK;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        initApplication();
        SharedPreferences sharedPreferences = getSharedPreferences("LiveCricScoreData", 0);
        preferences = sharedPreferences;
        editor = sharedPreferences.edit();
        context = getApplicationContext();

        MobileAds.initialize((Context) this, (OnInitializationCompleteListener) new OnInitializationCompleteListener() {
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        valeAppOpenManager = new realocation_Touch_AppOpenManager(this);

        if (AudienceNetworkAds.isInitialized(this)) {
            return;
        }
        AudienceNetworkAds.initialize(this);
    }

    private void initApplication() {
        instance = this;
    }

    public static realocation_App getInstance() {
        return instance;
    }

   @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    public void FatchStartApps() {
        arrAdDataStart.clear();
        Call<LocaladsResponce> call1 = apiInterface.localads("com.findlocation.callerlocation");

        call1.enqueue(new Callback<LocaladsResponce>() {
            @Override
            public void onResponse(Call<LocaladsResponce> call, Response<LocaladsResponce> response) {
                if (response.isSuccessful() && response.body() != null) {

                    if (response.body().getData() != null && response.body().getData().size() > 0) {
                        arrAdDataStart.addAll(response.body().getData());
                        if (startAdListener != null)
                            startAdListener.onStartAdLoaded();
                    }
                }

            }

            @Override
            public void onFailure(Call<LocaladsResponce> call, Throwable t) {
                call.cancel();
                if (startAdListener != null)
                    startAdListener.onStartAdError();
            }
        });
    }

    // Listener defined earlier
    public interface StartAdListener {

        public void onStartAdError();

        public void onStartAdLoaded();
    }

    public void setStartAdListener(StartAdListener listener) {
        this.startAdListener = listener;
        FatchStartApps();

    }


}
