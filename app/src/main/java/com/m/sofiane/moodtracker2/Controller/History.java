package com.m.sofiane.moodtracker2.Controller;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.m.sofiane.moodtracker2.Model.Mood;
import com.m.sofiane.moodtracker2.R;

import java.util.Calendar;

import static android.view.View.INVISIBLE;
import static java.util.Calendar.getInstance;

/**
 * created by Sofiane M. 13/02/2019
 */
public class History extends MainActivity {

    private Mood mMood;
    private Mood mMood1;
    private Mood mMood2;
    private Mood mMood3;
    private Mood mMood4;
    private Mood mMood5;
    private Mood mMood6;


    private ImageView mButtonComment1;
    private ImageView mButtonComment2;
    private ImageView mButtonComment3;
    private ImageView mButtonComment4;
    private ImageView mButtonComment5;
    private ImageView mButtonComment6;
    private ImageView mButtonComment7;

    protected SharedPreferences mPrefs;
    private Calendar mCal = getInstance();
    private EditText mComment;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        // Initialized Layout of mood

        mButtonComment1 = findViewById(R.id.buttonComment1);
        mButtonComment2 = findViewById(R.id.buttonComment2);
        mButtonComment3 = findViewById(R.id.buttonComment3);
        mButtonComment4 = findViewById(R.id.buttonComment4);
        mButtonComment5 = findViewById(R.id.buttonComment5);
        mButtonComment6 = findViewById(R.id.buttonComment6);
        mButtonComment7 = findViewById(R.id.buttonComment7);


        FrameLayout mRl11 = this.findViewById(R.id.activiy_history_mood7_right);
        FrameLayout mRl12 = this.findViewById(R.id.activity_history_mood7_left);
        FrameLayout mRl21 = this.findViewById(R.id.activiy_history_mood6_right);
        FrameLayout mRl22 = this.findViewById(R.id.activity_history_mood6_left);
        FrameLayout mRl31 = this.findViewById(R.id.activiy_history_mood5_right);
        FrameLayout mRl32 = this.findViewById(R.id.activity_history_mood5_left);
        FrameLayout mRl41 = this.findViewById(R.id.activiy_history_mood4_right);
        FrameLayout mRl42 = this.findViewById(R.id.activity_history_mood4_left);
        FrameLayout mRl51 = this.findViewById(R.id.activiy_history_mood3_right);
        FrameLayout mRl52 = this.findViewById(R.id.activity_history_mood3_left);
        FrameLayout mRl61 = this.findViewById(R.id.activiy_history_mood2_right);
        FrameLayout mRl62 = this.findViewById(R.id.activity_history_mood2_left);
        FrameLayout mRl71 = this.findViewById(R.id.activity_history_mood1_right);
        FrameLayout mRl72 = this.findViewById(R.id.activity_history_mood1_left);

        mPrefs = getSharedPreferences("Mypreferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = mPrefs.getString("" + (mCal.get(Calendar.DAY_OF_YEAR) - 1), "");
        mMood = gson.fromJson(json, Mood.class);
        if (mMood == null) {
            mRl11.setVisibility(INVISIBLE);
            mRl12.setVisibility(INVISIBLE);
        }

        json = mPrefs.getString("" + (mCal.get(Calendar.DAY_OF_YEAR) - 2), "");
        mMood1 = gson.fromJson(json, Mood.class);
        if (mMood1 == null) {
            mRl21.setVisibility(INVISIBLE);
            mRl22.setVisibility(INVISIBLE);
        }

        json = mPrefs.getString("" + (mCal.get(Calendar.DAY_OF_YEAR) - 3), "");
        mMood2 = gson.fromJson(json, Mood.class);
        if (mMood2 == null) {
            mRl31.setVisibility(INVISIBLE);
            mRl32.setVisibility(INVISIBLE);
        }

        json = mPrefs.getString("" + (mCal.get(Calendar.DAY_OF_YEAR) - 4), "");
        mMood3 = gson.fromJson(json, Mood.class);
        if (mMood3 == null) {
            mRl41.setVisibility(INVISIBLE);
            mRl42.setVisibility(INVISIBLE);
        }

        json = mPrefs.getString("" + (mCal.get(Calendar.DAY_OF_YEAR) - 5), "");
        mMood4 = gson.fromJson(json, Mood.class);
        if (mMood4 == null) {
            mRl51.setVisibility(INVISIBLE);
            mRl52.setVisibility(INVISIBLE);
        }

        json = mPrefs.getString("" + (mCal.get(Calendar.DAY_OF_YEAR) - 6), "");
        mMood5 = gson.fromJson(json, Mood.class);
        if (mMood5 == null) {
            mRl61.setVisibility(INVISIBLE);
            mRl62.setVisibility(INVISIBLE);
        }

        json = mPrefs.getString("" + (mCal.get(Calendar.DAY_OF_YEAR) - 7), "");
        mMood6 = gson.fromJson(json, Mood.class);
        if (mMood6 == null) {
            mRl71.setVisibility(INVISIBLE);
            mRl72.setVisibility(INVISIBLE);
        }

        ChangeOfLayout(mRl11, mRl12, mButtonComment1, mMood);
        ChangeOfLayout(mRl21, mRl22, mButtonComment2, mMood1);
        ChangeOfLayout(mRl31, mRl32, mButtonComment3, mMood2);
        ChangeOfLayout(mRl41, mRl42, mButtonComment4, mMood3);
        ChangeOfLayout(mRl51, mRl52, mButtonComment5, mMood4);
        ChangeOfLayout(mRl61, mRl62, mButtonComment6, mMood5);
        ChangeOfLayout(mRl71, mRl72, mButtonComment7, mMood6);
    }

    public void ChangeOfLayout(FrameLayout mRight, FrameLayout mLeft, ImageView comment, final Mood mood) {

        LinearLayout.LayoutParams mLayoutParamsRight = (LinearLayout.LayoutParams) mRight.getLayoutParams();
        LinearLayout.LayoutParams mLayoutParamsLeft = (LinearLayout.LayoutParams) mLeft.getLayoutParams();

        if (mood == null) {
            mLeft.setVisibility(INVISIBLE);
            mRight.setVisibility(INVISIBLE);
        }
        // Size of Layout
        else {
            switch (mood.getPositionOfMood()) {

                case 0:
                    mLeft.setBackgroundColor(Color.rgb(222, 60, 80));
                    mLayoutParamsLeft.width = 0;
                    mLayoutParamsLeft.weight = 20;
                    mLeft.setLayoutParams(mLayoutParamsLeft);
                    mRight.setBackgroundColor(Color.rgb(230, 230, 230));
                    mLayoutParamsRight.width = 0;
                    mLayoutParamsRight.weight = 80;
                    mRight.setLayoutParams(mLayoutParamsRight);
                    break;


                case 1:
                    mLeft.setBackgroundColor(Color.rgb(155, 155, 155));
                    mLayoutParamsLeft.width = 0;
                    mLayoutParamsLeft.weight = 40;
                    mLeft.setLayoutParams(mLayoutParamsLeft);
                    mRight.setBackgroundColor(Color.rgb(230, 230, 230));
                    mLayoutParamsRight.width = 0;
                    mLayoutParamsRight.weight = 60;
                    mRight.setLayoutParams(mLayoutParamsRight);
                    break;

                case 2:
                    mLeft.setBackgroundColor(Color.rgb(70, 138, 217));
                    mLayoutParamsLeft.width = 0;
                    mLayoutParamsLeft.weight = 60;
                    mLeft.setLayoutParams(mLayoutParamsLeft);
                    mRight.setBackgroundColor(Color.rgb(230, 230, 230));
                    mLayoutParamsRight.width = 0;
                    mLayoutParamsRight.weight = 40;
                    mRight.setLayoutParams(mLayoutParamsRight);

                    break;

                case 3:
                    mLeft.setBackgroundColor(Color.rgb(188, 233, 134));
                    mLayoutParamsLeft.width = 0;
                    mLayoutParamsLeft.weight = 80;
                    mLeft.setLayoutParams(mLayoutParamsLeft);
                    mRight.setBackgroundColor(Color.rgb(230, 230, 230));
                    mLayoutParamsRight.width = 0;
                    mLayoutParamsRight.weight = 20;
                    mRight.setLayoutParams(mLayoutParamsRight);

                    break;

                case 4:
                    mLeft.setBackgroundColor(Color.rgb(249, 236, 79));
                    mLayoutParamsLeft.width = 0;
                    mLayoutParamsLeft.weight = 100;
                    mLeft.setLayoutParams(mLayoutParamsLeft);
                    mRight.setBackgroundColor(Color.rgb(230, 230, 230));
                    mLayoutParamsRight.width = 0;
                    mLayoutParamsRight.weight = 0;
                    mRight.setLayoutParams(mLayoutParamsRight);
                    break;
                default:
            }
        }

        if (mood == null || mood.mComment.isEmpty()) {
            comment.setVisibility(View.INVISIBLE);
        } else {
            comment.setVisibility(View.VISIBLE);
            comment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(History.this, (CharSequence) mood.mComment, Toast.LENGTH_SHORT).show();
                }
            });
        }

    }


}









