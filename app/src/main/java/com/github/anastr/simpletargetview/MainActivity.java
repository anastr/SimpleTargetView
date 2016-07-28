package com.github.anastr.simpletargetview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.github.anastr.targetviewlib.TargetView;

public class MainActivity extends AppCompatActivity {

    TargetView mTargetView, mTargetView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTargetView = (TargetView) findViewById(R.id.mTargetView);
        Button startButton = (Button) findViewById(R.id.start_button);
        assert startButton != null;
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTargetView.startAnimation();
            }
        });
        Button stopButton = (Button) findViewById(R.id.stop_button);
        assert stopButton != null;
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTargetView.stopAnimation();
            }
        });

        mTargetView3 = (TargetView) findViewById(R.id.mTargetView3);
        Button onOffButton = (Button) findViewById(R.id.on_off_button);
        assert onOffButton != null;
        onOffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mTargetView3.isAnimationRunning())
                    mTargetView3.stopAnimation();
                else
                    mTargetView3.startAnimation();
            }
        });
    }
}
