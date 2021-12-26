package com.hod.retrofittest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;
import com.hod.retrofittest.retrofitApi.IUserService;
import com.hod.retrofittest.retrofitApi.JsonGetResponse;
import com.hod.retrofittest.retrofitApi.SiteConnector;
import com.hod.retrofittest.retrofitApi.User;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private final String BASE_URL = "https://reqres.in/";
    private RecyclerView mRecycleView;
    private UserAdapter mUserAdapter;
    private Button mGoToPostBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUi();
        getUsers();
    }

    private void initUi() {
        mRecycleView = findViewById(R.id.main_activity_rv);
        mGoToPostBtn = findViewById(R.id.main_activity_go_to_post_btn);

        mUserAdapter = new UserAdapter(new ArrayList<User>());
        mRecycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecycleView.setHasFixedSize(true);
        mRecycleView.setAdapter(mUserAdapter);

        mGoToPostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPostActivity();
            }
        });
    }

    private void getUsers() {
        SiteConnector.getInstance().getData(new Callback<JsonGetResponse>() {
            @Override
            public void onResponse(Call<JsonGetResponse> call, Response<JsonGetResponse> response) {
                if (response.code() == 200)
                {
                    JsonGetResponse data = response.body();
                    updateRecyclerView(data.getmData());
                    Snackbar.make(mRecycleView,"Success!!",Snackbar.LENGTH_LONG).show();
                }
                else
                {
                    Snackbar.make(mRecycleView,"check the connection.",Snackbar.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JsonGetResponse> call, Throwable t) {
                Snackbar.make(mRecycleView, Objects.requireNonNull(t.getMessage()),Snackbar.LENGTH_LONG).show();
            }
        });
    }

    private void updateRecyclerView(ArrayList<User> iUsers)
    {
        mUserAdapter.setUsers(iUsers);
        mUserAdapter.notifyDataSetChanged();
    }

    private void goToPostActivity()
    {
        Intent intent = new Intent(this, PostActivity.class);
        startActivity(intent);
    }
    /**

     Retrofit retrofit = new Retrofit.Builder()
     .baseUrl(BASE_URL)
     .addConverterFactory(GsonConverterFactory.create())
     .build();

     IUserService service = retrofit.create(IUserService.class);
     Call<JsonGetResponse> call = service.getData();
     call.enqueue(
     */

}