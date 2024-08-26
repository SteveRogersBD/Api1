package com.example.apicall;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    TextView tv;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=findViewById(R.id.random_text);
        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        apiInterface.getElement().enqueue(new Callback<PostPojo>() {
            @Override
            public void onResponse(Call<PostPojo> call, Response<PostPojo> response) {
                if(response.isSuccessful() && response.body()!=null)
                {
                    Toast.makeText(MainActivity.this, "Gotcha", Toast.LENGTH_SHORT).show();
                    PostPojo a = response.body();
                    tv.setText(a.toString());
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Nothing", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PostPojo> call, Throwable throwable) {
                Toast.makeText(MainActivity.this, "error 404", Toast.LENGTH_SHORT).show();
            }
        });
    }
}