package com.example.tbeaupertuis.poubelle;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Chronometer;

/**
 * Created by tbeaupertuis on 18/01/18.
 */

public class GameActivity extends AppCompatActivity {

    Chronometer time;
    TextView nb_mouv;
    long timeWhenStopped = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    //Lancement du chronomètre lors de la création de l'activity
        time = (Chronometer) findViewById(R.id.time);
        time.start();

    //Action du bouton Pause
        Button Pause = (Button)findViewById(R.id.buttonPause);
        Pause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                timeWhenStopped = time.getBase() - SystemClock.elapsedRealtime();
                time.stop();
            }
        });

    //Action du bouton Resume
        Button Resume = (Button)findViewById(R.id.buttonResume);
        Resume.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                time.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                time.start();
            }
        });

    //Action du bouton Rejouer
        Button Rejouer = (Button)findViewById(R.id.buttonRejouer);
        Rejouer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                time.setBase(SystemClock.elapsedRealtime());
                time.start();
                nb_mouv = (TextView) findViewById(R.id.nb_mouv);
                nb_mouv.setText("0");
            }
        });
    }
}