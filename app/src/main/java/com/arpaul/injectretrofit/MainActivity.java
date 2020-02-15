package com.arpaul.injectretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.arpaul.injectretrofit.common.AppInstance;
import com.arpaul.injectretrofit.common.AppPref;
import com.arpaul.injectretrofit.network.APICall;
import com.arpaul.networkmodule.network.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();
    private RetrofitService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppPref pref = ((AppInstance)getApplication()).getAppComponent().getAppPref();
        if(pref != null) {
            Log.e(TAG, "pref not null");
        } else
            Log.e(TAG, "pref null");
        service = ((AppInstance)getApplication()).getLibComponent().getRetrofit();
    }

    public void callNetwork(View view) {
        if(service != null) {
            Log.e(TAG, "service not null");
            APICall apiCall = service.createService(APICall.class);
            apiCall.getData().enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if(response != null) {
                        Log.e(TAG, "response not null");
                    } else
                        Log.e(TAG, "response null");
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    if(t != null) {
                        Log.e(TAG, "t not null "+t.getMessage());
                    } else
                        Log.e(TAG, "response null");
                }
            });
        }
    }
}
