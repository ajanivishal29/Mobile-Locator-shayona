package com.liveearthmap.callerlocation.nearby_activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.liveearthmap.callerlocation.Main_Ads.RetrofitResponce.DataItem;
import com.liveearthmap.callerlocation.Main_Ads.admob_ads.Adintermethod;
import com.liveearthmap.callerlocation.Main_Ads.admob_ads.TemplateView;
import com.liveearthmap.callerlocation.Main_Ads.admob_ads.Utils;
import com.liveearthmap.callerlocation.R;
import com.liveearthmap.callerlocation.service.GPS_Tracker;
import com.facebook.ads.NativeAdLayout;

import java.util.ArrayList;

public class realocation_PlaceNotFound_Activity extends AppCompatActivity implements PlaceNumberList_Adapter.ClickItem {
    public Activity activity = null;
    private ArrayList<Places> callLocatorPlacesListDataModelArrayList;
    private EditText editSearches;
    public ImageView imgeGifts;
    public Double latitude;
    public Double longitude;
    public PlaceNumberList_Adapter placesNumbersListAdapter;
    public RelativeLayout relAdview;
    private RecyclerView revPlacesList;
    private TextView txtNoPlacesAvailable;

    public DataItem convertedObject;
    public Activity context;

    TemplateView admobmediumnative;
    NativeAdLayout native_ad_container;
    CardView q_native;

    TemplateView admobsmallnative;
    NativeAdLayout native_banner_ad_container;
    CardView q_native_banner;

    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    public realocation_PlaceNotFound_Activity() {
        Double valueOf = Double.valueOf(0.0d);
        this.latitude = valueOf;
        this.longitude = valueOf;
        this.callLocatorPlacesListDataModelArrayList = new ArrayList<>();
        this.placesNumbersListAdapter = null;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.realocation_place_no_list_fou_layout);
        this.activity = this;

        context = realocation_PlaceNotFound_Activity.this;

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

        GPS_Tracker gPS_Tracker = new GPS_Tracker(this.activity);
        if (gPS_Tracker.isgpsenabled() && gPS_Tracker.canGetLocation()) {
            this.latitude = Double.valueOf(gPS_Tracker.getLatitude());
            this.longitude = Double.valueOf(gPS_Tracker.getLongitude());
        }
        AddPlacesDataListType();
        initComponentsData();
    }

    private void AddPlacesDataListType() {
        this.callLocatorPlacesListDataModelArrayList.clear();
        this.callLocatorPlacesListDataModelArrayList.add(new Places("jewellery_store", "Jewelry store", "jewelry_store"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("airport", "Airport", "airport"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("amusement_park", "Amusement park", "amusement_park"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("aquarium", "Aquarium", "aquarium"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("library", "Library", "library"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("art_gallery", "Art gallery", "art_gallery"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("atm", "Atm", "atm"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("local_government_office", "Local government office", "local_government_office"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("bakery", "Bakery", "bakery"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("locksmith", "Locksmith", "locksmith"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("bank", "Bank", "Bank"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("meal_delivery", "Meal delivery", "meal_delivery"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("beauty_salon", "Beauty salon", "beauty_salon"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("bicycle_store", "Bicycle store", "bicycle_store"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("mosque", "Mosque", "mosque"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("book_store", "Book store", "book_store"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("movie_rental", "Movie rental", "movie_rental"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("bowling_alley", "Bowling alley", "bowling_alley"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("movie_theater", "Movie theater", "movie_theater"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("bus_station", "Bus station", "bus_station"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("cafe", "Cafe", "cafe"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("museum", "Museum", "museum"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("night_club", "Night club", "night_club"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("car_dealer", "Car dealer", "car_dealer"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("painter", "Painter", "painter"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("car_rental", "Car rental", "car_rental"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("park", "Park", "park"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("car_repair", "Car repair", "car_repair"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("parking", "Parking", "parking"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("car_wash", "Car wash", "car_wash"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("pet_store", "Pet store", "pet_store"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("casino", "Casino", "casino"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("pharmacy", "Pharmacy", "pharmacy"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("cemetery", "Cemetery", "cemetery"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("physiotherapist", "Physiotherapist", "physiotherapist"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("church", "Church", "church"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("plumber", "Plumber", "plumber"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("city_hall", "City hall", "city_hall"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("police", "Police", "police"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("clothing_store", "Clothing store", "clothing_store"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("post_office", "Post office", "post_office"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("convenience_store", "Convenience store", "convenience_store"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("real_estate_agency", "Real estate agency", "real_estate_agency"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("courthouse", "Courthouse", "courthouse"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("restaurant", "Restaurant", "restaurant"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("dentist", "Dentist", "dentist"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("roofing_contractor", "Roofing contractor", "roofing_contractor"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("department_store", "Department store", "department_store"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("rv_park", "Rv park", "rv_park"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("doctor", "Doctor", "doctor"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("school", "School", "school"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("electrician", "Electrician", "electrician"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("shoe_store", "Shoe store", "shoe_store"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("electronics_store", "Electronics store", "electronics_store"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("shopping_mall", "Shopping mall", "shopping_mall"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("embassy", "Embassy", "embassy"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("spa", "Spa", "spa"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("fire_station", "Fire station", "fire_station"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("stadium", "Stadium", "stadium"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("furniture_store", "Furniture store", "furniture_store"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("subway_station", "Subway station", "subway_station"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("gas_station", "Gas station", "gas_station"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("supermarket", "Supermarket", "supermarket"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("gym", "Gym", "gym"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("gas_station", "Gas station", "gas_station"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("hair_care", "Hair care", "hair_care"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("taxi_stand", "Taxi stand", "taxi_stand"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("hardware_store", "Hardware store", "hardware_store"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("train_station", "Train station", "train_station"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("hindu_temple", "Hindu temple", "hindu_temple"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("home_goods_store", "Home goods store", "home_goods_store"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("travel_agency", "Travel agency", "travel_agency"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("hospital", "Hospital", "hospital"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("veterinary_care", "Veterinary care", "veterinary_care"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("insurance_agency", "Insurance agency", "insurance_agency"));
        this.callLocatorPlacesListDataModelArrayList.add(new Places("zoo", "Zoo", "zoo"));
    }

    private void initComponentsData() {
        this.revPlacesList = (RecyclerView) findViewById(R.id.revPlacesList);
        this.editSearches = (EditText) findViewById(R.id.editSearches);
        this.revPlacesList.setLayoutManager(new LinearLayoutManager(this.activity, 1, false));
        PlaceNumberList_Adapter placeNumberList_Adapter = new PlaceNumberList_Adapter(this.activity, this.callLocatorPlacesListDataModelArrayList);
        this.placesNumbersListAdapter = placeNumberList_Adapter;
        placeNumberList_Adapter.PlacesInterface(this);
        this.revPlacesList.setAdapter(this.placesNumbersListAdapter);
        this.editSearches.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                realocation_PlaceNotFound_Activity.this.placesNumbersListAdapter.getFilter().filter(charSequence.toString());
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

    public void click(int i, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:%f,%f" + this.latitude + "," + this.longitude + "?q=" + str));
            intent.setPackage("com.google.android.apps.maps");
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            try {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
                Toast.makeText(this.activity, R.string.please_install_google_map, 0).show();
            }
        }
    }
}
