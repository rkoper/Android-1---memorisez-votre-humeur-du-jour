package com.m.sofiane.moodtracker2.Controller;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
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




    private ImageButton mButtonComment1;
    private ImageButton mButtonComment2;
    private ImageButton mButtonComment3;
    private ImageButton mButtonComment4;
    private ImageButton mButtonComment5;
    private ImageButton mButtonComment6;
    private ImageButton mButtonComment7;

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


        FrameLayout mRl11 = this.findViewById(R.id.activiy_history_mood1_right);
        FrameLayout mRl12 = this.findViewById(R.id.activityhistory_mood1_left);
        FrameLayout mRl21 = this.findViewById(R.id.activiy_history_mood2_right);
        FrameLayout mRl22 = this.findViewById(R.id.activity_history_mood2_left);
        FrameLayout mRl31 = this.findViewById(R.id.activiy_history_mood3_right);
        FrameLayout mRl32 = this.findViewById(R.id.activity_history_mood3_left);
        FrameLayout mRl41 = this.findViewById(R.id.activiy_history_mood4_right);
        FrameLayout mRl42 = this.findViewById(R.id.activity_history_mood4_left);
        FrameLayout mRl51 = this.findViewById(R.id.activiy_history_mood5_right);
        FrameLayout mRl52 = this.findViewById(R.id.activity_history_mood5_left);
        FrameLayout mRl61 = this.findViewById(R.id.activiy_history_mood6_right);
        FrameLayout mRl62 = this.findViewById(R.id.activity_history_mood6_left);
        FrameLayout mRl71 = this.findViewById(R.id.activiy_history_mood7_right);
        FrameLayout mRl72 = this.findViewById(R.id.activity_history_mood7_left);

        mPrefs = getSharedPreferences("Mypreferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = mPrefs.getString("" + (mCal.get(Calendar.DAY_OF_YEAR)) + 10, "");
        mMood = gson.fromJson(json, Mood.class);
        if (mMood == null) {
            mRl11.setVisibility(INVISIBLE);
            mRl12.setVisibility(INVISIBLE);
        }

        json = mPrefs.getString("" + mCal.get(Calendar.DAY_OF_YEAR) + 9, "");
        mMood1 = gson.fromJson(json, Mood.class);
        if (mMood1 == null) {
            mRl21.setVisibility(INVISIBLE);
            mRl22.setVisibility(INVISIBLE);
        }

        json = mPrefs.getString("" + mCal.get(Calendar.DAY_OF_YEAR) + 8, "");
        mMood2 = gson.fromJson(json, Mood.class);
        if (mMood2 == null) {
            mRl31.setVisibility(INVISIBLE);
            mRl32.setVisibility(INVISIBLE);
        }

        json = mPrefs.getString("" + mCal.get(Calendar.DAY_OF_YEAR) + 7, "");
        mMood3 = gson.fromJson(json, Mood.class);
        if (mMood3 == null) {
            mRl41.setVisibility(INVISIBLE);
            mRl42.setVisibility(INVISIBLE);
        }

        json = mPrefs.getString("" + mCal.get(Calendar.DAY_OF_YEAR) + 6, "");
        mMood4 = gson.fromJson(json, Mood.class);
        if (mMood4 == null) {
            mRl51.setVisibility(INVISIBLE);
            mRl52.setVisibility(INVISIBLE);
        }

        json = mPrefs.getString("" + mCal.get(Calendar.DAY_OF_YEAR) + 5, "");
        mMood5 = gson.fromJson(json, Mood.class);
        if (mMood5 == null) {
            mRl61.setVisibility(INVISIBLE);
            mRl62.setVisibility(INVISIBLE);
         }

        json = mPrefs.getString("" + mCal.get(Calendar.DAY_OF_YEAR) + 4, "");
        mMood6 = gson.fromJson(json, Mood.class);
        if (mMood6 == null) {
            mRl71.setVisibility(INVISIBLE);
            mRl72.setVisibility(INVISIBLE);
        }

        ChangeOfLayout(mRl11,mRl12,mMood);
        ChangeOfLayout(mRl21,mRl22,mMood1);
        ChangeOfLayout(mRl31,mRl32,mMood2);
        ChangeOfLayout(mRl41,mRl42,mMood3);
        ChangeOfLayout(mRl51,mRl52,mMood4);
        ChangeOfLayout(mRl61,mRl62,mMood5);
        ChangeOfLayout(mRl71,mRl72,mMood6);
    }

    public void ChangeOfLayout(FrameLayout mRight, FrameLayout mLeft, Mood mood)  {

        LinearLayout.LayoutParams mLayoutParamsRight = (LinearLayout.LayoutParams) mRight.getLayoutParams();
        LinearLayout.LayoutParams mLayoutParamsLeft = (LinearLayout.LayoutParams) mLeft.getLayoutParams();

        if (mood==null) {
            mLeft.setVisibility(INVISIBLE);
            mRight.setVisibility(INVISIBLE);
        }
        // Size of Layout
        else {
        switch (mMood.getPositionOfMood()) {

            case 0:
                mLeft.setBackgroundColor(Color.rgb(188, 233, 134));
                mLayoutParamsLeft.width = 0;
                mLayoutParamsLeft.weight = 80;
                mLeft.setLayoutParams(mLayoutParamsLeft);
                mRight.setBackgroundColor(Color.rgb(230, 230, 230));
                mLayoutParamsRight.width = 0;
                mLayoutParamsRight.weight = 20;
                mRight.setLayoutParams(mLayoutParamsRight);
                break;


            case 1:
                mLeft.setBackgroundColor(Color.rgb(70, 138, 217));
                mLayoutParamsLeft.width = 0;
                mLayoutParamsLeft.weight = 60;
                mLeft.setLayoutParams(mLayoutParamsLeft);
                mRight.setBackgroundColor(Color.rgb(230, 230, 230));
                mLayoutParamsRight.width = 0;
                mLayoutParamsRight.weight = 40;
                mRight.setLayoutParams(mLayoutParamsRight);
                break;

            case 2:
                mLeft.setBackgroundColor(Color.rgb(155, 155, 155));
                mLayoutParamsLeft.width = 0;
                mLayoutParamsLeft.weight = 40;
                mLeft.setLayoutParams(mLayoutParamsLeft);
                mRight.setBackgroundColor(Color.rgb(230, 230, 230));
                mLayoutParamsRight.width = 0;
                mLayoutParamsRight.weight = 60;
                mRight.setLayoutParams(mLayoutParamsRight);
                break;

            case 3:
                mLeft.setBackgroundColor(Color.rgb(222, 60, 80));
                mLayoutParamsLeft.width = 0;
                mLayoutParamsLeft.weight = 20;
                mLeft.setLayoutParams(mLayoutParamsLeft);
                mRight.setBackgroundColor(Color.rgb(230, 230, 230));
                mLayoutParamsRight.width = 0;
                mLayoutParamsRight.weight = 80;
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
        } }

        if (   mMood.mComment==null) {
            mButtonComment1.setVisibility(INVISIBLE);
        } else {
            mButtonComment1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(History.this, (CharSequence)    mMood.mComment, Toast.LENGTH_SHORT).show();
                }
            });
        }
        
        if (mMood.mComment==null) {
            mButtonComment2.setVisibility(INVISIBLE);
        } else {
            mButtonComment2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(History.this, (CharSequence) mMood.mComment, Toast.LENGTH_SHORT).show();
                }
            });
        }
        

        if (mMood.mComment==null) {
            mButtonComment3.setVisibility(INVISIBLE);
        } else {
            mButtonComment3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(History.this, (CharSequence) mMood.mComment, Toast.LENGTH_SHORT).show();
                }
            });
        }
        if (mMood.mComment==null) {
            mButtonComment4.setVisibility(INVISIBLE);
        } else {
            mButtonComment4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(History.this, (CharSequence) mMood.mComment, Toast.LENGTH_SHORT).show();
                }
            });
        }
        if (mMood.mComment==null) {
            mButtonComment5.setVisibility(INVISIBLE);
        } else {
            mButtonComment5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(History.this, (CharSequence) mMood.mComment, Toast.LENGTH_SHORT).show();
                }
            });
        }
        if (mMood.mComment==null) {
            mButtonComment6.setVisibility(INVISIBLE);
        } else {
            mButtonComment6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(History.this, (CharSequence) mMood.mComment, Toast.LENGTH_SHORT).show();
                }
            });
        }
        if (mMood.mComment==null) {
            mButtonComment7.setVisibility(INVISIBLE);
        } else {
            mButtonComment7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(History.this, (CharSequence) mMood.mComment, Toast.LENGTH_SHORT).show();
                }
            });
        }

    } }









