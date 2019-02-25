package com.example.android.scorekeeperapp;

import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import yuku.ambilwarna.AmbilWarnaDialog;

/**
 * Fragment that occupies the entire screen of the MainActivity
 */
public class MainFragment extends Fragment {

    // Fragment View returned by onCreateView()
    View view;

    // UI Views
    TextView tvTeamAScore;
    TextView tvTeamBScore;
    Button btnRematch;
    Button btnTeamAScore;
    Button btnTeamBScore;
    Button btnTeamAFouls;
    Button btnTeamBFouls;
    Button btnTeamACorners;
    Button btnTeamBCorners;
    Button btnTeamAPenalties;
    Button btnTeamBPenalties;
    ImageView ivTeamAFlag;
    ImageView ivTeamBFlag;

    // ViewModel for surviving values of UI views in fragment for configuration changes
    ScoreKeeperViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_main, container, false);

        // Inflating Views **********************************************
        inflateViews();

        // initialize ViewModel **********************************************
        viewModel = ViewModelProviders.of((getActivity())).get(ScoreKeeperViewModel.class);

        // update UI views for score (important for configuration changes)
        updateTeamAScore();
        updateTeamBScore();

        // listeners for buttons & images OnClick
        addListeners();

        return view;
    }

    /**
     * Updating values of UI views for Team A
     */
    private void updateTeamAScore() {
        tvTeamAScore.setText(String.valueOf(viewModel.getTeamA().getScore()));
        btnTeamAScore.setText(String.valueOf(viewModel.getTeamA().getScore()));
        btnTeamAFouls.setText(String.valueOf(viewModel.getTeamA().getFouls()));
        btnTeamACorners.setText(String.valueOf(viewModel.getTeamA().getCorners()));
        btnTeamAPenalties.setText(String.valueOf(viewModel.getTeamA().getPenalties()));
        ivTeamAFlag.setColorFilter(viewModel.getTeamA().getFlagColor());
    }

    /**
     * Updating values of UI views for Team B
     */
    private void updateTeamBScore() {
        tvTeamBScore.setText(String.valueOf(viewModel.getTeamB().getScore()));
        btnTeamBScore.setText(String.valueOf(viewModel.getTeamB().getScore()));
        btnTeamBFouls.setText(String.valueOf(viewModel.getTeamB().getFouls()));
        btnTeamBCorners.setText(String.valueOf(viewModel.getTeamB().getCorners()));
        btnTeamBPenalties.setText(String.valueOf(viewModel.getTeamB().getPenalties()));
        ivTeamBFlag.setColorFilter(viewModel.getTeamB().getFlagColor());
    }

    /**
     * Adding Button listeners for team A, B, and Rematch
     */
    private void addListeners() {
        btnRematch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newMatch();
            }
        });

        btnTeamAScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getTeamA().incrementScore();
                tvTeamAScore.setText(String.valueOf(viewModel.getTeamA().getScore()));
                btnTeamAScore.setText(String.valueOf(viewModel.getTeamA().getScore()));
            }
        });

        btnTeamBScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getTeamB().incrementScore();
                tvTeamBScore.setText(String.valueOf(viewModel.getTeamB().getScore()));
                btnTeamBScore.setText(String.valueOf(viewModel.getTeamB().getScore()));
            }
        });

        btnTeamAFouls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getTeamA().incrementFouls();
                btnTeamAFouls.setText(String.valueOf(viewModel.getTeamA().getFouls()));
            }
        });

        btnTeamBFouls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getTeamB().incrementFouls();
                btnTeamBFouls.setText(String.valueOf(viewModel.getTeamB().getFouls()));
            }
        });

        btnTeamACorners.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getTeamA().incrementCorners();
                btnTeamACorners.setText(String.valueOf(viewModel.getTeamA().getCorners()));
            }
        });

        btnTeamBCorners.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getTeamB().incrementCorners();
                btnTeamBCorners.setText(String.valueOf(viewModel.getTeamB().getCorners()));
            }
        });

        btnTeamAPenalties.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getTeamA().incrementPenalties();
                btnTeamAPenalties.setText(String.valueOf(viewModel.getTeamA().getPenalties()));
            }
        });

        btnTeamBPenalties.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getTeamB().incrementPenalties();
                btnTeamBPenalties.setText(String.valueOf(viewModel.getTeamB().getPenalties()));
            }
        });

        // Changing the color of team A flag
        ivTeamAFlag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // show color picker
                // initialColor is the initially-selected color to be shown in the rectangle on the left of the arrow.
                // for example, 0xff000000 is black, 0xff0000ff is blue. Please be aware of the initial 0xff which is the alpha.

                AmbilWarnaDialog dialog = new AmbilWarnaDialog(getActivity(), viewModel.getTeamA().getFlagColor(), new AmbilWarnaDialog.OnAmbilWarnaListener() {
                    @Override
                    public void onCancel(AmbilWarnaDialog dialog) {
                        // cancel was selected by the user
                    }

                    @Override
                    public void onOk(AmbilWarnaDialog dialog, int color) {
                        // color is the color selected by the user.
                        ivTeamAFlag.setColorFilter(color);
                        viewModel.getTeamA().setFlagColor(color);
                    }
                });
                dialog.show();
            }
        });

        // Changing the color of team B flag
        ivTeamBFlag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // show color picker
                // initialColor is the initially-selected color to be shown in the rectangle on the left of the arrow.
                // for example, 0xff000000 is black, 0xff0000ff is blue. Please be aware of the initial 0xff which is the alpha.

                AmbilWarnaDialog dialog = new AmbilWarnaDialog(getActivity(), viewModel.getTeamB().getFlagColor(), new AmbilWarnaDialog.OnAmbilWarnaListener() {
                    @Override
                    public void onCancel(AmbilWarnaDialog dialog) {
                        // cancel was selected by the user
                    }

                    @Override
                    public void onOk(AmbilWarnaDialog dialog, int color) {
                        // color is the color selected by the user.
                        ivTeamBFlag.setColorFilter(color);
                        viewModel.getTeamB().setFlagColor(color);
                    }
                });
                dialog.show();
            }
        });

    }

    /**
     * Inflating views from XML
     */
    private void inflateViews() {
        tvTeamAScore = view.findViewById(R.id.tvTeamAScore);
        tvTeamBScore = view.findViewById(R.id.tvTeamBScore);
        btnRematch = view.findViewById(R.id.btnRematch);
        btnTeamAScore = view.findViewById(R.id.btnTeamAScore);
        btnTeamBScore = view.findViewById(R.id.btnTeamBScore);
        btnTeamAFouls = view.findViewById(R.id.btnTeamAFouls);
        btnTeamBFouls = view.findViewById(R.id.btnTeamBFouls);
        btnTeamACorners = view.findViewById(R.id.btnTeamACorners);
        btnTeamBCorners = view.findViewById(R.id.btnTeamBCorners);
        btnTeamAPenalties = view.findViewById(R.id.btnTeamAPenalties);
        btnTeamBPenalties = view.findViewById(R.id.btnTeamBPenalties);
        ivTeamAFlag = view.findViewById(R.id.ivTeamAFlag);
        ivTeamBFlag = view.findViewById(R.id.ivTeamBFlag);
    }

    /**
     * Resetting UI Views for a new match
     */
    private void newMatch() {
        viewModel.resetTeams();
        updateTeamAScore();
        updateTeamBScore();
    }
}
