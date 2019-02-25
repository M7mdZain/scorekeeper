package com.example.android.scorekeeperapp;

import java.io.Serializable;

/**
 * Model class that represents a sporting team playing a football match
 */
class Team implements Serializable {

    private int mScore;
    private int mFouls;
    private int mCorners;
    private int mPenalties;

    int getFlagColor() {
        return mFlagColor;
    }

    void setFlagColor(int flagColor) {
        mFlagColor = flagColor;
    }

    private int mFlagColor;

    int getScore() {
        return mScore;
    }

    void incrementScore() {
        this.mScore += 1;
    }

    int getFouls() {
        return mFouls;
    }

    void incrementFouls() {
        this.mFouls += 1;
    }

    int getCorners() {
        return mCorners;
    }

    void incrementCorners() {
        this.mCorners += 1;
    }

    int getPenalties() {
        return mPenalties;
    }

    void incrementPenalties() {
        this.mPenalties += 1;
    }

}
