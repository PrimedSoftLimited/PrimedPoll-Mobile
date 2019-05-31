package com.primedsoft.primedpoll.api;

import com.primedsoft.primedpoll.Models.Data;
import com.primedsoft.primedpoll.Models.Interest;

import java.util.ArrayList;
import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("api/register")
    Call<Data> register(@Field("email") String email,
                        @Field("password") String password,
                        @Field("password_confirmation") String confirmPassword);

    @GET("register/verify/{verifyToken}")
    Call<Data> verification(@Header("Authorization") String token);

    @FormUrlEncoded
    @POST("api/login")
    Call<Data> login(@Field("email") String email,
                     @Field("password") String password);

    @FormUrlEncoded
    @POST("api/password/reset")
    Call<Data> resetPassword(@Field("email") String email);

    @FormUrlEncoded
    @PUT("api/password/change")
    Call<Data> changePassword(
            @Field("verifycode") String verifyCode,
            @Field("password") String password,
            @Field("password_confirmation") String passwordConfirmation);

    @FormUrlEncoded
    @POST("api/register/verify")
    Call<Data> verify(@Field("verifycode") String verifycode);


    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    @PUT("api/complete/registration")
    Call<ResponseBody> completeReg(@Header("Authorization") String s, @Body RequestBody body);

    @GET("api/interest")
    Call<ArrayList<Interest>> allInterest();

}
