package com.example.httppost;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.httppost.model.Post;
import com.example.httppost.retroAPI.ApiUtils;
import com.example.httppost.retroAPI.RetrofitAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView tvResponse;
    RetrofitAPI APIService;
    private final Object Tag;

    public MainActivity(){
        Tag = "TAG";
    }
    public MainActivity(Object tag) {
        Tag = tag;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etUsername = findViewById(R.id.et_username);
        final EditText etPass = findViewById(R.id.et_pass);
        Button bthPost = findViewById(R.id.btn_Post);
        tvResponse = findViewById(R.id.tv_response);
        APIService = ApiUtils.getRetrofitAPI();

        bthPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString().trim();
                String pass = etPass.getText().toString().trim();
                if (!TextUtils.isEmpty(username) && (!TextUtils.isEmpty(pass))) {
                    sendPost(username,pass);
                }
            }
        });
    }

    public void sendPost(String username, String pass){

        APIService.savePost(username,pass,1).enqueue(new Callback<Post>() {

            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()){
                    showResponse("Post Successfull!" + '\n' + response.body().toString());
                    Log.i((String) Tag, "Post data to API. " + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                showResponse("Post Failure!");
                Log.e((String) Tag, "Unable to post data!");
            }
        });
    }

    public void showResponse (String response){
        if (tvResponse.getVisibility() == View.GONE) {
            tvResponse.setVisibility(View.VISIBLE);
        }
        tvResponse.setText(response);
    }
}