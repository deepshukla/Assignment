package com.lex.assinment.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.lex.assinment.Adapter.CardDataAdapter;
import com.lex.assinment.Core.GetDataContract;
import com.lex.assinment.Core.Presenter;
import com.lex.assinment.Model.CardDataRes;
import com.lex.assinment.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements GetDataContract.View {
    private Presenter mPresenter;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    CardDataAdapter countryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new Presenter(this);
        mPresenter.getDataFromURL(getApplicationContext(), "");
        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onGetDataSuccess(String message, List<CardDataRes> allCountriesData) {
        countryAdapter = new CardDataAdapter(getApplicationContext(), allCountriesData);
        recyclerView.setAdapter(countryAdapter);

    }

    @Override
    public void onGetDataFailure(String message) {
        Log.d("Status",message);
    }
}
