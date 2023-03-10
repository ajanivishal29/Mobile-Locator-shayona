package com.liveearthmap.callerlocation.device_activity;

import android.view.View;

public class BackgroundToForegroundTransformer extends BaseTransformer {
    private static final float min(float f, float f2) {
        return f < f2 ? f2 : f;
    }

    public void onTransform(View view, float f) {
        float height = (float) view.getHeight();
        float width = (float) view.getWidth();
        float f2 = 1.0f;
        if (f >= 0.0f) {
            f2 = Math.abs(1.0f - f);
        }
        float min = min(f2, 0.5f);
        view.setScaleX(min);
        view.setScaleY(min);
        view.setPivotX(width * 0.5f);
        view.setPivotY(height * 0.5f);
        view.setTranslationX(f < 0.0f ? width * f : (-width) * f * 0.25f);
    }
}
