package com.example.locationclient.RESTfulAPI;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class UserBasicAuth implements Interceptor {
    private String credentials;

    public UserBasicAuth(String email,String password){
        this.credentials= Credentials.basic(email,password);
    }
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request authenticatedRequest = request.newBuilder()
                .header("Authorization",credentials)
                .build();
        return chain.proceed(authenticatedRequest);
    }
}
