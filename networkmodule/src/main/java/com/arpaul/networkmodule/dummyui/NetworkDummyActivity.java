package com.arpaul.networkmodule.dummyui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.arpaul.networkmodule.R;
import com.arpaul.networkmodule.di.component.DaggerLibComponent;
import com.arpaul.networkmodule.di.component.LibComponent;
import com.arpaul.networkmodule.network.APICall;
import com.arpaul.networkmodule.network.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NetworkDummyActivity extends AppCompatActivity {

    private final String TAG = NetworkDummyActivity.class.getSimpleName();
    private RetrofitService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_dummy);

        LibComponent component = DaggerLibComponent.builder().build();
        service = component.getRetrofit();

    }

    public void buttonClicked(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
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
                } else
                    Log.e(TAG, "service null");
            }
        }).start();
    }
}
