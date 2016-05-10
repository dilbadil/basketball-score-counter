package com.example.android.countcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int threePointA = 0;
    int threePointB = 0;
    int twoPointA = 0;
    int twoPointB = 0;
    int freePointA = 0;
    int freePointB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        String teamNameA = intent.getStringExtra("teamNameA");
        String teamNameB = intent.getStringExtra("teamNameB");

        TextView team1Label = (TextView) findViewById(R.id.team1_label);
        TextView team2Label = (TextView) findViewById(R.id.team2_label);

        team1Label.setText(teamNameA);
        team2Label.setText(teamNameB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * When user click on three points button.
     */
    public void clickThreePointsA(View view) {
        scoreTeamA += 3;
        threePointA += 1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * When user click on three points button.
     */
    public void clickTwoPointsA(View view) {
        scoreTeamA += 2;
        twoPointA += 1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * When user click on three points button.
     */
    public void clickFreeePointsA(View view) {
        scoreTeamA += 1;
        freePointA += 1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * When user click on three points button.
     */
    public void clickThreePointsB(View view) {
        scoreTeamB += 3;
        threePointB += 1;
        displayForTeamB(scoreTeamB);
    }

    /**
     * When user click on three points button.
     */
    public void clickTwoPointsB(View view) {
        scoreTeamB += 2;
        twoPointB += 1;
        displayForTeamB(scoreTeamB);
    }

    /**
     * When user click on three points button.
     */
    public void clickFreeePointsB(View view) {
        scoreTeamB += 1;
        freePointB += 1;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Reset score for team a and team  b.
     */
    public void reset(View view) {
        scoreTeamA = scoreTeamB = threePointA = threePointB = twoPointA = twoPointB = freePointA = freePointB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    /**
     * Go to report page.
     */
    public void report(View view) {
        TextView team1Label = (TextView) findViewById(R.id.team1_label);
        TextView team2Label = (TextView) findViewById(R.id.team2_label);

        Intent intent = new Intent(getApplicationContext(), ReportActivity.class);
        intent.putExtra("scoreTeamA", String.valueOf(scoreTeamA));
        intent.putExtra("scoreTeamB", String.valueOf(scoreTeamB));
        intent.putExtra("threePointA", String.valueOf(threePointA));
        intent.putExtra("threePointB", String.valueOf(threePointB));
        intent.putExtra("twoPointA", String.valueOf(twoPointA));
        intent.putExtra("twoPointB", String.valueOf(twoPointB));
        intent.putExtra("freePointA", String.valueOf(freePointA));
        intent.putExtra("freePointB", String.valueOf(freePointB));
        intent.putExtra("teamALabel", team1Label.getText().toString());
        intent.putExtra("teamBLabel", team2Label.getText().toString());

        startActivity(intent);
    }
}
