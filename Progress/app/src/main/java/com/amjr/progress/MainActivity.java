package com.amjr.progress;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Show the progressView
                ProgressView.getInstance().Show(MainActivity.this, new ProgressView.ICallback() {
                    @Override
                    public void run() {

                        // *** Place your code here ***

                        //Dismiss the progressView
                        ProgressView.getInstance().Dismiss();
                    }
                });
            }
        });
    }
}
