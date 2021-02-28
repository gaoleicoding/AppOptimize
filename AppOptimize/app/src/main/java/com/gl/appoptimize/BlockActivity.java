package com.gl.appoptimize;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BlockActivity extends AppCompatActivity {

    private final String TAG = "LeakActivity";

    private TextView tvBlock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block);
        tvBlock = findViewById(R.id.tv_block);
        tvBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cpuCalculate();
            }
        });

    }

    private void cpuCalculate() {
        int count = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 100; j++) {
                count += i + j;
                Log.d(TAG, "count=" + count);
            }
        }
        tvBlock.setText(count + "");
    }
}
