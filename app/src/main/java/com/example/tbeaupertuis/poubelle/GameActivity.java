package com.example.tbeaupertuis.poubelle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

/**
 * Created by tbeaupertuis on 18/01/18.
 */

public class GameActivity extends AppCompatActivity {

    Chronometer time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Pause = (Button)findViewById(R.id.buttonPause);
        Pause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                time.stop();
            }
        });
    }
}