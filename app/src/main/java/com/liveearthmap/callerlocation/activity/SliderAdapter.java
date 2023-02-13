package com.liveearthmap.callerlocation.activity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.liveearthmap.callerlocation.R;
import com.tiagosantos.enchantedviewpager.EnchantedViewPager;
import com.tiagosantos.enchantedviewpager.EnchantedViewPagerAdapter;

import java.util.ArrayList;

public class SliderAdapter extends EnchantedViewPagerAdapter {

    public ArrayList<Slider_Data> marrayList;
    Context mcontext;
    LayoutInflater inflater;

    public SliderAdapter(Context context, ArrayList<Slider_Data> arrayList) {
        super(arrayList);
        mcontext = context;
        inflater = (LayoutInflater) context.getSystemService("layout_inflater");
        marrayList = arrayList;
    }

    @Override
    public Object instantiateItem(ViewGroup viewGroup, int i) {

        if (marrayList.size() == 0) {
            Toast.makeText(mcontext, "ArrayList null", Toast.LENGTH_SHORT).show();
            return null;

        }
        View inflate = inflater.inflate(R.layout.slider_layout, viewGroup, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.image);
        imageView.setImageResource(marrayList.get(i).getImageResource());
        inflate.setTag(EnchantedViewPager.ENCHANTED_VIEWPAGER_POSITION + i);
        viewGroup.addView(inflate);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mcontext.startActivity(new Intent(mcontext, realocation_Second_intro.class));
            }
        });
        return inflate;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    /* renamed from: c */
    public int getCount() {
        return marrayList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }


}
