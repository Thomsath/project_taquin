package com.example.tbeaupertuis.poubelle;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Chronometer;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static android.R.id.list;

/**
 * Created by tbeaupertuis on 18/01/18.
 */


public class GameActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static final String TIME_EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE_TIME";
    Chronometer time;
    TextView nb_mouv;
    long timeWhenStopped = 0;
    int test = 2;
    private ImageAdapter image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //Lancement du chronomètre lors de la création de l'activity
        time = (Chronometer) findViewById(R.id.time);
        time.start();



        // --------------------------------------- ENVOIE DES DATA (A METTRE LORSQUE
        //                                         UTILISATEUR A GAGNE LA PARTIE)
        //                                                                      -------------------------------------//
        Integer nb_mouv_test = 5;
        Date timeToScore = Calendar.getInstance().getTime();

        String timeToScoreString = String.valueOf(timeToScore);
        String nb_mouvString = String.valueOf(nb_mouv_test);

        // 2 ELTS

        Intent intent= new Intent(this, ScoreActivity.class);
        intent.putExtra("key1", nb_mouvString);
        intent.putExtra("key2", timeToScoreString);
        startActivity(intent);


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

        GridView gridview = (GridView) findViewById(R.id.GridView);
        image=new ImageAdapter(this, 3,3);
        gridview.setAdapter(image);
        gridview.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}