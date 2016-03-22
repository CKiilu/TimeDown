package com.scurrae.chris.timedown;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mTextField;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.ed);
        CharSequence ch = "Enter time in seconds.";
        editText.setHint(ch);
        mTextField = (TextView)findViewById(R.id.tx);
        mTextField.setText(R.string.app_name);
        button = (Button)findViewById(R.id.but);
        if(editText.getText().toString() != null ) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int x = Integer.parseInt(editText.getText().toString());
                    new CountDownTimer(x, 1000) {

                        public void onTick(long millisUntilFinished) {
                            mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
                        }

                        public void onFinish() {
                            mTextField.setText("done!");
                        }
                    }.start();
                }
            });
        }
    }
}
