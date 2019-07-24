package com.lex.assinment.Core;


import android.content.Context;
import android.util.Log;

import com.lex.assinment.Model.AllCardDataResponse;
import com.lex.assinment.Model.CardDataRes;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class Intractor implements GetDataContract.Interactor{
    private static final String TAG = "Intractor";
    private GetDataContract.onGetDataListener mOnGetDatalistener;
    List<  CardDataRes> allcountry = new ArrayList<>();
    List<String> allCountriesData = new ArrayList<>();
    private Call<List<CardDataRes>> call;


    public Intractor(GetDataContract.onGetDataListener mOnGetDatalistener){
        this.mOnGetDatalistener = mOnGetDatalistener;
    }
    @Override
    public void initRetrofitCall(Context context, String url) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://demo8716682.mockable.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AllCardDataResponse request = retrofit.create(AllCardDataResponse.class);
        call = request.getCardData();

        call.enqueue(new Callback<List<CardDataRes>>() {
            @Override
            public void onResponse(Call<List<CardDataRes>> call, Response<List<CardDataRes>> response) {
                Log.d(TAG, "onResponse: ");
                allcountry=response.body();
                mOnGetDatalistener.onSuccess("List Size: " + allCountriesData.size(), allcountry);

            }

            @Override
            public void onFailure(Call<List<CardDataRes>> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
                mOnGetDatalistener.onFailure(t.getMessage());
            }
        });

       /* call.enqueue(new Callback<CardDataRes>() {
            @Override
            public void onResponse(Call<CardDataRes> call, retrofit2.Response<CardDataRes> response) {
                CardDataRes jsonResponse = response.body();
              *//*  allcountry = jsonResponse.getUserDesire();
                for(int i=0;i<allcountry.size();i++){
                    allCountriesData.add(allcountry.get(i).getName());
                }
              *//*
              Log.d("Data", "Refreshed");
                mOnGetDatalistener.onSuccess("List Size: " + allCountriesData.size(), allcountry);



            }
            @Override
            public void onFailure(Call<CardDataRes> call, Throwable t) {
                Log.v("Error",t.getMessage());
                mOnGetDatalistener.onFailure(t.getMessage());
            }
        });*/
    }
}
