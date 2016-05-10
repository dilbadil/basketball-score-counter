package com.example.android.countcounter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ReportActivity extends AppCompatActivity {

    String teamALabel;

    String teamBLabel;

    String threePointsA;

    String threePointsB;

    String twoPointsA;

    String twoPointsB;

    String freeThrowA;

    String freeThrowB;

    String scoreTeamA;

    String scoreTeamB;

    String winner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        Intent intent = getIntent();
        scoreTeamA = intent.getStringExtra("scoreTeamA");
        TextView textScoreTeamA = (TextView) findViewById(R.id.team_1_score);
        textScoreTeamA.setText(scoreTeamA);

        scoreTeamB= intent.getStringExtra("scoreTeamB");
        TextView textScoreTeamB = (TextView) findViewById(R.id.team_2_score);
        textScoreTeamB.setText(scoreTeamB);

        String threePointA = intent.getStringExtra("threePointA");
        TextView threePointAText = (TextView) findViewById(R.id.team1_threepoints);
        threePointAText.setText(threePointA);

        String threePointB = intent.getStringExtra("threePointB");
        TextView threePointBText = (TextView) findViewById(R.id.team2_threepoints);
        threePointBText.setText(threePointB);

        String twoPointA = intent.getStringExtra("twoPointA");
        TextView twoPointAText = (TextView) findViewById(R.id.team1_twopoints);
        twoPointAText.setText(twoPointA);

        String twoPointB = intent.getStringExtra("twoPointB");
        TextView twoPointBText = (TextView) findViewById(R.id.team2_twopoints);
        twoPointBText.setText(twoPointB);

        String freePointA = intent.getStringExtra("freePointA");
        TextView freePointAText = (TextView) findViewById(R.id.team1_freepoints);
        freePointAText.setText(freePointA);

        String freePointB = intent.getStringExtra("freePointB");
        TextView freePointBText = (TextView) findViewById(R.id.team2_freepoints);
        freePointBText.setText(freePointB);

        teamALabel = intent.getStringExtra("teamALabel");
        teamBLabel = intent.getStringExtra("teamBLabel");

        TextView teamALabelTextView = (TextView) findViewById(R.id.team1_label);
        TextView teamBLabelTextView = (TextView) findViewById(R.id.team2_label);
        teamALabelTextView.setText(teamALabel);
        teamBLabelTextView.setText(teamBLabel);

        threePointsA = threePointA;
        threePointsB = threePointB;
        twoPointsA = twoPointA;
        twoPointsB = twoPointB;
        freeThrowA = freePointA;
        freeThrowB = freePointB;

        TextView winnerTextView = (TextView) findViewById(R.id.winner_textView);

        if (Integer.parseInt(scoreTeamA) > Integer.parseInt(scoreTeamB)) {
            winner = teamALabel;
        } else if (Integer.parseInt(scoreTeamB) > Integer.parseInt(scoreTeamA)) {
            winner = teamBLabel;
        } else if (Integer.parseInt(scoreTeamA) == Integer.parseInt(scoreTeamB)) {
            winner = "Draw";
        }

        winnerTextView.setText(winner);
    }

    /**
     * When user click back button.
     */
    public void playAgain(View view) {
        Intent intent = new Intent(getApplicationContext(), TeamFormActivity.class);
        startActivity(intent);
    }

    /**
     * When user click send.
     */
    public void send(View view) {
        String body = "";

        body += "Summary \n\n";
        body += teamALabel + ":\n";
        body += "Three Points: " + threePointsA + "\n";
        body += "Two Points: " + twoPointsA + "\n";
        body += "Free Points: " + freeThrowA + "\n";
        body += "Score: " + scoreTeamA + "\n";
        body += "\n\n";

        body += teamBLabel + ":\n";
        body += "Three Points: " + threePointsB + "\n";
        body += "Two Points: " + twoPointsB + "\n";
        body += "Free Points: " + freeThrowB + "\n";
        body += "Score: " + scoreTeamB + "\n";
        body += "\n\n";
        body += "Winner: " + winner;

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Report basketball match " + teamALabel + " vs " + teamBLabel);
        intent.putExtra(Intent.EXTRA_TEXT, body);

        startActivity(intent);
    }
}
