package com.example.translatepocc.api;

public class ApiUtils {
    private ApiUtils(){}

    public static final String baseURL = "https://translate.google.com/translate_a/";

    public static ApiInterface getApiInterface(){
        return RetrofitClient.getClient(baseURL).create(ApiInterface.class);
    }
}