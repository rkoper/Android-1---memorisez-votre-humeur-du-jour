package com.m.sofiane.moodtracker2.Model;

import com.m.sofiane.moodtracker2.Controller.MainActivity;


/**
 * created by Sofiane M. 07/02/2019
 */
public class Mood extends MainActivity {
    public int mImages;
    public int mColors;
    public String mComment;
    public int mPositionOfMood;



  public Mood (int images, int colors, String comment, int positionOfMood) {
        mImages = images;
        mColors = colors;
        mComment = comment;
        mPositionOfMood = positionOfMood;


  }



    public int getImages() {
        return mImages;
    }

    public int getColors() {
        return mColors;
    }

    private String getComment() {
        return mComment;
    }

    public int getPositionOfMood() { return mPositionOfMood;}






}
