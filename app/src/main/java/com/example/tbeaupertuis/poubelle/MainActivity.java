package com.example.tbeaupertuis.poubelle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View image = findViewById(R.id.imageView3);
        // On cache l'image avant le clic
        image.setVisibility(View.GONE);

        final View button_3x3 = findViewById(R.id.button_3x3);
        final View button_4x4 = findViewById(R.id.button_4x4);
        final View button_5x5 = findViewById(R.id.button_5x5);
        int model_grid;
        // Au clic bouton 3x3
        button_3x3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int model_grid = 3;
                // On affiche l'image cachée
                //image.setVisibility(View.VISIBLE);
                button_4x4.setLeft(15);

            }
        });
        // Au clic bouton 4x4
        button_4x4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int model_grid = 4;
                // On affiche l'image cachée
                //image.setVisibility(View.VISIBLE);
                button_4x4.setLeft(15);

            }
        });
        // Au clic bouton 5x5
        button_3x3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int model_grid = 5;
                // On affiche l'image cachée
                //image.setVisibility(View.VISIBLE);
                button_4x4.setLeft(15);

            }
        });

    }
}
