package com.example.aniruddh.randomuser.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.aniruddh.randomuser.Model.User;
import com.example.aniruddh.randomuser.R;
import com.example.aniruddh.randomuser.View.Adapters.UserAdapter;
import com.example.aniruddh.randomuser.api.APIservice;
import com.example.aniruddh.randomuser.api.ApiModel.RandomUserResponse;
import com.example.aniruddh.randomuser.api.RetrofitBuilder;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_people_list) RecyclerView mRecyclerView;

    private UserAdapter mAdapter;
    private APIservice mService;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mService = RetrofitBuilder.getAPIervice();
        mAdapter = new UserAdapter(new ArrayList<User>());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

        loadUsers();




    }

    public void loadUsers() {
        mService.getRandomUsers(1).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RandomUserResponse>() {


                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RandomUserResponse response) {
                        mAdapter.add(response.getResults());
                    }
                });
    }

}
