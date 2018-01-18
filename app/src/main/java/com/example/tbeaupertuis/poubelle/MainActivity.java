package com.example.tbeaupertuis.poubelle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View button_start = findViewById(R.id.button_start);
        final View img_squirrel = findViewById(R.id.img_squirrel);
        final View img_planet = findViewById(R.id.img_planet);

        // On cache l'image avant le clic
        img_squirrel.setVisibility(View.GONE);
        img_planet.setVisibility(View.GONE);
        // On cache le buton start avant le clic
        button_start.setVisibility(View.GONE);
        final View button_3x3 = findViewById(R.id.button_3x3);
        final View button_4x4 = findViewById(R.id.button_4x4);
        final View button_5x5 = findViewById(R.id.button_5x5);
        int model_grid;

        // ! ------------------------------------ // 3 X 3 //  ------------------------------------ !

        button_3x3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int model_grid = 3;

                // On affiche l'image cachée
                button_start.setVisibility(View.GONE);
                img_squirrel.setVisibility(View.VISIBLE);
                img_planet.setVisibility(View.GONE);
                button_4x4.setY(300);
            }
        });

        img_squirrel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                button_4x4.setY(270);
                img_squirrel.setVisibility(View.GONE);

                button_start.setY(570);
                button_start.setVisibility(View.VISIBLE);
            }
        });

        // ! ------------------------------------ // 4 X 4 //  ------------------------------------ !

        button_4x4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int model_grid = 4;
                button_4x4.setY(268);
                button_start.setVisibility(View.GONE);
                img_planet.setVisibility(View.VISIBLE);
                img_squirrel.setVisibility(View.GONE);
                button_5x5.setY(380);
            }
        });
        // Au clic de l'image 3x3
        img_squirrel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                //button_5x5.setY(270);
                img_planet.setVisibility(View.GONE);

                button_start.setY(570);
                button_start.setVisibility(View.VISIBLE);
            }
        });
        // ! ------------------------------------ // START //  ------------------------------------ !
        button_start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // On redirige vers l'activité de jeu
                finish();
                //Intent gameActivity=new Intent(this,GameActivity.class);
                startActivity(new Intent(MainActivity.this, GameActivity.class));
                Intent gameActivity = new Intent(MainActivity.this, GameActivity.class);
                startActivity(gameActivity);
            }
        });
    }
}
