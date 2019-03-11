package com.m.sofiane.moodtracker2.Controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.m.sofiane.moodtracker2.Adapter.SlideAdapter;
import com.m.sofiane.moodtracker2.Model.Mood;
import com.m.sofiane.moodtracker2.R;

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

    final Mood[] lst_smileys = {
            new Mood(R.drawable.smiley_sad, Color.rgb(222, 60, 80), "", 0),
            new Mood(R.drawable.smiley_disappointed, Color.rgb(155, 155, 155), "", 1),
            new Mood(R.drawable.smiley_normal, Color.rgb(70, 138, 217), "", 2),
            new Mood(R.drawable.smiley_happy, Color.rgb(188, 233, 134), "", 3),
            new Mood(R.drawable.smiley_super_happy, Color.rgb(249, 236, 79), "", 4)
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPrefs = getSharedPreferences("Mypreferences", MODE_PRIVATE);
        mViewPager = findViewById(R.id.viewpager);
        myadapter = new SlideAdapter(this, lst_smileys);
        mViewPager.setAdapter(myadapter);
        mViewPager.setCurrentItem(3);
        Gson gson = new Gson();
        String json = mPrefs.getString("" + (mCal.get(Calendar.DAY_OF_YEAR)), "");
        mMood = gson.fromJson(json, Mood.class);
        if (mMood == null) {
            mMood = new Mood(R.drawable.smiley_happy, R.color.light_sage, "", 0);
        }

        // initialized Mood + Color + Comment + Position


        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int positionFixe, float v, int i1) {
            }

            // Recover Position of Smiley
            @Override
            public void onPageSelected(int positionOfMood) {

                Calendar mCal = Calendar.getInstance();

                mMood.mPositionOfMood = lst_smileys[positionOfMood].getPositionOfMood();
                mMood.mColors = lst_smileys[positionOfMood].getColors();
                mMood.mImages = lst_smileys[positionOfMood].getImages();

                SharedPreferences.Editor prefsEditor = mPrefs.edit();
                Gson gson = new Gson();
                String json = gson.toJson(mMood);
                prefsEditor.putString(("" + (mCal.get(Calendar.DAY_OF_YEAR)-6)), json);
                prefsEditor.apply();

                MediaPlayer mediaPlayer;

                switch (mMood.getPositionOfMood()) {
                    case 0:
                        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.sound1);
                        mediaPlayer.start();
                        break;

                    case 1:
                        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.sound2);
                        mediaPlayer.start();
                        break;

                    case 2:
                        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.sound3);
                        mediaPlayer.start();
                        break;

                    case 3:
                        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.sound4);
                        mediaPlayer.start();
                        break;

                    case 4:
                        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.sound5);
                        mediaPlayer.start();
                        break;
                    default:
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });

        mButton1 = findViewById(R.id.Button1);

// Call PopUP

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.your_mood);
        builder.setMessage(R.string.you_mood_today);

        mComment = new EditText(this);
        builder.setView(mComment);

        // Recover Comment

        builder.setPositiveButton(R.string.send, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String mTxt = mComment.getText().toString();
                if (!mTxt.isEmpty())
                    Toast.makeText(getApplicationContext(), mTxt, Toast.LENGTH_LONG).show();
                mMood.mComment = mTxt;
                SharedPreferences.Editor prefsEditor = mPrefs.edit();
                Gson gson = new Gson();
                String json = gson.toJson(mMood);
                prefsEditor.putString("" + (mCal.get(Calendar.DAY_OF_YEAR)-6), json);
                prefsEditor.apply();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        final AlertDialog ad = builder.create();
        // initalized Two button

        mButton1 = findViewById(R.id.Button1);
        mButton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ad.show();
            }
        });

        mButton2 = findViewById(R.id.Button2);

        // Lauch history

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent historyActivityIntent = new Intent(MainActivity.this, History.class);
                startActivity(historyActivityIntent);
            }
        });
    }
}



