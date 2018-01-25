package com.example.tbeaupertuis.poubelle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        final View button_restart = findViewById(R.id.btn_replay);
        final View button_changeGrid = findViewById(R.id.btn_changeGrid);

        button_restart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // On redirige vers l'activité de jeu
                finish();
                Intent gameActivity = new Intent(ScoreActivity.this, GameActivity.class);
                startActivity(gameActivity);
            }
        });

        button_changeGrid.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                Intent mainActivity = new Intent(ScoreActivity.this, MainActivity.class);
                startActivity(mainActivity);
            }
        });

           // Récupération des variables envoyées (temps et mouvement)

            // Mouvements
            Intent intent = getIntent();
            String message = intent.getStringExtra(GameActivity.EXTRA_MESSAGE) + " mouvements";

            // Variables à changer par la var de mvt
            TextView textView_score = (TextView) findViewById(R.id.textView_score);
            textView_score.setText(message);

            // Temps
            intent = getIntent();
            message = intent.getStringExtra(GameActivity.EXTRA_MESSAGE) + " mouvements";

            // Variables à changer par la var de temps
            textView_score = (TextView) findViewById(R.id.textView_score);
            textView_score.setText(message);
    }
}