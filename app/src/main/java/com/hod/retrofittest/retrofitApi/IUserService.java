package com.hod.retrofittest.retrofitApi;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IUserService {
    //https://reqres.in/
    @GET("api/users?page=2")
    Call<JsonGetResponse> getData();

    @FormUrlEncoded
    @POST("api/users")
    Call<JsonPostResponse> postNewUser(@Field("name") String iName, @Field("job") String iJob);
}
