package com.example.translatepocc.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by fatihkocak on 20.09.2018.
 */

public interface ApiInterface {

    @GET("single")
    Call<String> translate(@Query("client") String client,
                           @Query("sl") String sl,
                           @Query("tl") String tl,
                           @Query("hl") String hl,
                           @Query("dt") List<String> dt,
                           @Query("ie") String ie,
                           @Query("oe") String oe,
                           @Query("otf") int otf,
                           @Query("ssel") int ssel,
                           @Query("tsel") int tsel,
                           @Query("kc") int kc,
                           @Query("q") String text,
                           @Query("tk") String token);



}
