package com.hod.retrofittest.retrofitApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SiteConnector {
    private static SiteConnector mSiteConnectorInstance = null;

    private final String BASE_URL = "https://reqres.in/";
    private IUserService mCallService;

    private SiteConnector()
    {
        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mCallService = mRetrofit.create(IUserService.class);
    }

    public static SiteConnector getInstance()
    {
        if(mSiteConnectorInstance == null)
        {
            mSiteConnectorInstance = new SiteConnector();
        }

        return mSiteConnectorInstance;
    }

    public void postData(String iName, String iJob, Callback<JsonPostResponse> iCallback)
    {
        Call<JsonPostResponse> jsonPostResponseCall = mCallService.postNewUser(iName,iJob);
        jsonPostResponseCall.enqueue(iCallback);
    }

    public void getData(Callback<JsonGetResponse> iCallback)
    {
        Call<JsonGetResponse> jsonGetResponseCall = mCallService.getData();
        jsonGetResponseCall.enqueue(iCallback);
    }
}
