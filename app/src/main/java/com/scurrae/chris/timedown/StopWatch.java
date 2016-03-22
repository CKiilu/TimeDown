package com.scurrae.chris.timedown;

/**
 * Created by chris on 3/22/16.
 */

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class StopWatch extends AppCompatActivity {
    TextView mTextField;
    Chronometer chronometer;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stop);
        chronometer = (Chronometer)findViewById(R.id.ed2);

        mTextField = (TextView)findViewById(R.id.tx2);
        mTextField.setText(R.string.app_name);
        button = (Button)findViewById(R.id.but2);
        button.setText("Start timer");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
            }
        });
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                chronometer.stop();
                return true;
            }
        });
    }
}
