package com.lex.assinment.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface AllCardDataResponse {
    @GET("/cardData")
    Call<List<CardDataRes>> getCardData();
}
