package com.github.anastr.simpletargetview;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.anastr.targetviewlib.TargetView;

public class MainActivity extends AppCompatActivity {

    TargetView mTargetView;

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

        Button button_targetColor = (Button) findViewById(R.id.button_targetColor);
        Button button_targetWidth = (Button) findViewById(R.id.button_targetWidth);
        Button button_backgroundEffectColor = (Button) findViewById(R.id.button_backgroundEffectColor);
        Button button_allTargets = (Button) findViewById(R.id.button_allTargets);

        assert button_targetColor != null;
        assert button_targetWidth != null;
        assert button_backgroundEffectColor != null;
        assert button_allTargets != null;

        button_targetColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.editText_targetColor);
                String text = editText.getText().toString();
                try {
                    mTargetView.setTargetColor(Color.parseColor(text));
                }
                catch (Exception e) {
                    editText.setError("input error, color input EX:(#aa00ffdd)or (red)...");
                }
                editText.setText("");
            }
        });
        button_targetWidth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.editText_targetWidth);
                String text = editText.getText().toString();
                try {
                    mTargetView.setTargetWidth(Integer.parseInt(text));
                }
                catch (Exception e) {
                    editText.setError("input error");
                }
                editText.setText("");
            }
        });
        button_backgroundEffectColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.editText_backgroundEffectColor);
                String text = editText.getText().toString();
                try {
                    mTargetView.setBackgroundEffectColor(Color.parseColor(text));
                }
                catch (Exception e) {
                    editText.setError("input error, color input EX:(#aa00ffdd)or (red)...");
                }
                editText.setText("");
            }
        });

        button_allTargets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AllTargetsActivity.class));
            }
        });
    }
}
