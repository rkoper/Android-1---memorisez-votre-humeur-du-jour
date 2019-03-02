package com.m.sofiane.moodtracker2.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.m.sofiane.moodtracker2.Model.Mood;
import com.m.sofiane.moodtracker2.R;


/**
 * created by Sofiane M. 09/01/2019
 */
public class SlideAdapter extends PagerAdapter {
    private Context mContext;
    private LayoutInflater mInflater;

    public Mood[] getMood() {
        return lst_smileys;
    }

    public Mood[] lst_smileys = {
            new Mood(R.drawable.smiley_happy, Color.rgb(188,233,134), "", 0),
            new Mood(R.drawable.smiley_normal, Color.rgb(70,138 , 217), "", 1),
            new Mood(R.drawable.smiley_disappointed, Color.rgb(155, 155, 155), "", 2),
            new Mood(R.drawable.smiley_sad, Color.rgb(222 , 60, 80), "", 3),
            new Mood(R.drawable.smiley_super_happy, Color.rgb(249, 236, 79), "", 4)
};


    public SlideAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return lst_smileys.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view== object);

    }
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        mInflater =(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = mInflater.inflate(R.layout.slide,container,false);
        LinearLayout layoutside = view.findViewById(R.id.slidelinearlayout);
        ImageView imgslide  = view.findViewById(R.id.slideimg);


        layoutside.setBackgroundColor(lst_smileys[position].getColors());
        imgslide.setImageResource(lst_smileys[position].getImages());

        container.addView(view);
        return view;


    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);


    }


}
