package com.example.android.scorekeeperapp;

import android.arch.lifecycle.ViewModel;
import android.graphics.Color;

/**
 * ViewModel for surviving values of UI views in fragment for configuration changes
 */
class ScoreKeeperViewModel extends ViewModel {

    private Team mTeamA, mTeamB;

    /**
     * Constructor
     */
    ScoreKeeperViewModel() {
        if (mTeamA == null) {
            mTeamA = new Team();
            mTeamA.setFlagColor(Color.RED);
        }
        if (mTeamB == null) {
            mTeamB = new Team();
            mTeamB.setFlagColor(Color.WHITE);
        }
    }

    /**
     * return team A
     */
    Team getTeamA() {
        return mTeamA;
    }

    /**
     * return team B
     */
    Team getTeamB() {
        return mTeamB;
    }

    /**
     * reset teams for new match
     */
    void resetTeams() {
        int teamAFlagColor = mTeamA.getFlagColor();
        int teamBFlagColor = mTeamB.getFlagColor();
        mTeamA = new Team();
        mTeamA.setFlagColor(teamAFlagColor);
        mTeamB = new Team();
        mTeamB.setFlagColor(teamBFlagColor);
    }
}
