package com.example.tbeaupertuis.poubelle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

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


            // VALEURS A REMPLCER DANS LE GAMEACTIVITY
            Intent in = getIntent();
            String value_mouv = in.getStringExtra("key1");
            String value_time = in.getStringExtra("key2");
            TextView textView_time = (TextView) findViewById(R.id.textView_time);
            textView_time.setText("Votre temps : " + value_time);

            TextView textView_score = (TextView) findViewById(R.id.textView_score);
            textView_score.setText(value_mouv + " mouvements");

    }
}