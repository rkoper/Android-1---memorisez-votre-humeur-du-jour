package com.m.sofiane.moodtracker2.Controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.m.sofiane.moodtracker2.Model.Mood;
import com.m.sofiane.moodtracker2.R;
import com.m.sofiane.moodtracker2.View.SlideAdapter;

import java.util.Calendar;



public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private SlideAdapter myadapter;
    private Calendar mCal = Calendar.getInstance();
    private ImageView mButton1;
    private ImageView mButton2;
    private EditText mComment;
    private Mood mMood;
    public SharedPreferences mPrefs;
    private Mood mPositionOfMood;
    private Mood mColors;
    private Mood mImages;




    @Override
 public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPrefs = getPreferences(MODE_PRIVATE);
        mViewPager = findViewById(R.id.viewpager);
        myadapter = new SlideAdapter(this);
        mViewPager.setAdapter(myadapter);
        final Gson gson = new Gson();
        final String json = mPrefs.getString("" + mCal.get(Calendar.DAY_OF_YEAR),"");
        mMood = gson.fromJson(json, Mood.class);



        final Mood[] lst_smileys = {
                new Mood(R.drawable.smiley_happy,Color.rgb(255, 255, 255),"",0),
                new Mood(R.drawable.smiley_normal,Color.rgb(255, 255, 5),"",1),
                new Mood(R.drawable.smiley_disappointed,Color.rgb(237, 127, 16),"",2),
                new Mood(R.drawable.smiley_sad,Color.rgb(255, 0, 0),"",3),
                new Mood(R.drawable.smiley_super_happy,Color.rgb(255, 0, 127),"",4),
        };


        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int positionOfMood) {


                Calendar mCal = Calendar.getInstance();
                if (mMood == null) {
                    gson.fromJson(json, Mood.class);
                }

                else {
                mMood.mPositionOfMood=lst_smileys[positionOfMood].getPositionOfMood();
                mMood.mColors= lst_smileys[positionOfMood].getColors();
                mMood.mImages = lst_smileys[positionOfMood].getImages();

                SharedPreferences.Editor prefsEditor = mPrefs.edit();
                Gson gson = new Gson();
                String json = gson.toJson(mMood);
                prefsEditor.putString("" + mCal.get(Calendar.DAY_OF_YEAR),json);
                prefsEditor.commit();

            } }

            @Override
            public void onPageScrollStateChanged(int i) {
            }


        });

        mButton1 =  findViewById(R.id.Button1);

// Call PopUP


        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle(R.string.your_mood);
        builder.setMessage(R.string.you_mood_today);

        mComment = new EditText(this);
        builder.setView(mComment);

        builder.setPositiveButton(R.string.send, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                String mTxt = mComment.getText().toString();
                Toast.makeText(getApplicationContext(),mTxt, Toast.LENGTH_LONG).show();
                mMood.mComment = mTxt;
                SharedPreferences.Editor prefsEditor = mPrefs.edit();
                Gson gson = new Gson();
                String json = gson.toJson(mMood);
                prefsEditor.putString("" + mCal.get(Calendar.DAY_OF_YEAR),json);
                prefsEditor.commit();
            }



        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();


            }
        });

        final AlertDialog ad= builder.create();

        mButton1 = findViewById(R.id.Button1);
        mButton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ad.show();
            }
        });

        mButton2 =  findViewById(R.id.Button2);

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent historyActivityIntent = new Intent(MainActivity.this, History.class);
                startActivity(historyActivityIntent);

            }

        });

    }

}


