package com.example.locationclient.RESTfulAPI;

import com.example.locationclient.ViewModels.UserLocationViewModel;
import com.example.locationclient.ViewModels.UserLoginViewModel;
import com.example.locationclient.ViewModels.UserRegisterViewModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface API {

    @POST("locations/createLocation")
    Call<UserLocationViewModel> CreateLocation(@Body UserLocationViewModel userLocationViewModel);

    @POST("users/login")
    Call<UserLoginViewModel> Login(@Body UserLoginViewModel userLoginViewModel);

    @POST("users/register")
    Call<UserRegisterViewModel> Register(@Body UserRegisterViewModel userRegisterViewModel);
}
