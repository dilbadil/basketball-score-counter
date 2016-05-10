package com.example.android.countcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TeamFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_form);
    }

    public void showMain(View view) {
        EditText teamNameA = (EditText) findViewById(R.id.team1_edittext);
        EditText teamNameB = (EditText) findViewById(R.id.team2_edittext);
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("teamNameA", teamNameA.getText().toString().trim());
        intent.putExtra("teamNameB", teamNameB.getText().toString().trim());

        startActivity(intent);
    }
}
