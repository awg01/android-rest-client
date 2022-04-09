package com.example.myapplication;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button sendPostRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendPostRequest = (Button) findViewById(R.id.btnPost);
        sendPostRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnPostClicked();
            }
        });

    }

    private void btnPostClicked() {
        ApiInterface apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        Call<User> call = apiInterface.getUserInfo("akash", "android developer");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.e(TAG, "onResponse: "+response.code());
                Log.e(TAG, "onResponse: name "+response.body().getName());
                Log.e(TAG, "onResponse: id "+response.body().getId());
                Log.e(TAG, "onResponse: job "+response.body().getJob());
                Log.e(TAG, "onResponse: createdAt "+response.body().getCreatedAt());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());
            }
        });
    }
}