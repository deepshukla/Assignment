package com.lex.assinment.Core;

import android.content.Context;

import com.lex.assinment.Model.CardDataRes;

import java.util.List;

public class Presenter implements GetDataContract.Presenter, GetDataContract.onGetDataListener {
    private GetDataContract.View mGetDataView;
    private Intractor mIntractor;
    public Presenter(GetDataContract.View mGetDataView){
        this.mGetDataView = mGetDataView;
        mIntractor = new Intractor(this);
    }
    @Override
    public void getDataFromURL(Context context, String url) {
        mIntractor.initRetrofitCall(context,url);
    }

    @Override
    public void onSuccess(String message, List<CardDataRes> allCountriesData) {
        mGetDataView.onGetDataSuccess(message, allCountriesData);
    }

    @Override
    public void onFailure(String message) {
        mGetDataView.onGetDataFailure(message);
    }
}
