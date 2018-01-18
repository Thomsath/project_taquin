package com.example.tbeaupertuis.poubelle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.GridView;
import android.widget.Toast;

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

        GridView gridview = (GridView) findViewById(R.id.GridView);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                //Toast.makeText(HelloGridView.this, "" + position,
                        //Toast.LENGTH_SHORT).show();
            }
        });
    }
}