package com.m.sofiane.moodtracker2.Adapter;

import android.content.Context;
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

    public Mood[] lst_smileys;


    public SlideAdapter(Context context, Mood[] moodlst) {
        this.mContext = context;
        this.lst_smileys = moodlst;

    }

    @Override
    public int getCount() {
        return lst_smileys.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);

    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = mInflater.inflate(R.layout.slide, container, false);
        LinearLayout layoutside = view.findViewById(R.id.slidelinearlayout);
        ImageView imgslide = view.findViewById(R.id.slideimg);


        layoutside.setBackgroundColor(lst_smileys[position].getColors());
        imgslide.setImageResource(lst_smileys[position].getImages());

        container.addView(view);
        return view;


    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);


    }


}
