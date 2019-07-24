package com.lex.assinment.Core;

import android.content.Context;

import com.lex.assinment.Model.CardDataRes;

import java.util.List;


public interface GetDataContract {
    interface View{
        void onGetDataSuccess(String message, List<CardDataRes> list);
        void onGetDataFailure(String message);
    }
    interface Presenter{
        void getDataFromURL(Context context, String url);
    }
    interface Interactor{
        void initRetrofitCall(Context context, String url);

    }
    interface onGetDataListener{
        void onSuccess(String message, List<CardDataRes> list);
        void onFailure(String message);
    }
}
