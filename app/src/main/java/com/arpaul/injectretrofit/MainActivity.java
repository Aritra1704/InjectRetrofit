package com.arpaul.injectretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.arpaul.networkmodule.dummyui.NetworkDummyActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void goToLib(View view) {
        startActivity(new Intent(MainActivity.this, NetworkDummyActivity.class));
    }
}
