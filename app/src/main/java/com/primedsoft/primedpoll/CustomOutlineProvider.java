package com.primedsoft.primedpoll;

import android.graphics.Outline;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewOutlineProvider;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class CustomOutlineProvider extends ViewOutlineProvider {

    int roundCorner;

    public CustomOutlineProvider(int round) {
        roundCorner = round;
    }

    @Override
    public void getOutline(View view, Outline outline) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), roundCorner);
        }

    }
}
