package com.primedsoft.primedpoll.api;

import com.primedsoft.primedpoll.Models.CompleteRegistration;
import com.primedsoft.primedpoll.Models.Data;
import com.primedsoft.primedpoll.Models.Interest;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
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



    @PUT("api/complete/registration")
    @Headers("Content-Type: application/json")
    Call<CompleteRegistration.CompleteRegisterationResponseBody> completeReg(@Header("Authorization") String s, @Body CompleteRegistration.CompleteRegistrationData body);

    @FormUrlEncoded
    @PUT("api/complete/registration")
    Call<CompleteRegistration.CompleteRegisterationResponseBody> completeReg(@Header("Authorization") String s, @Field("data") CompleteRegistration body);

    @FormUrlEncoded
    @PUT("api/complete/registration")
    Call<CompleteRegistration.CompleteRegisterationResponseBody> completeRegF(@Header("Authorization") String s,
                                                                              @Field("first_name") String firstName, @Field("last_name") String lastName,
                                                                              @Field("phone") String phone, @Field("dob") String dob,
                                                                              @Field("interest_ids") int[] interestIds);

    @GET("api/interest")
    Call<ArrayList<Interest>> allInterest();

}
