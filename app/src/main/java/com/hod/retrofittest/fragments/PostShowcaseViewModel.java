package com.hod.retrofittest.fragments;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.material.snackbar.Snackbar;
import com.hod.retrofittest.retrofitApi.JsonPostResponse;
import com.hod.retrofittest.retrofitApi.SiteConnector;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostShowcaseViewModel extends ViewModel
{
    MutableLiveData<String> mName;
    MutableLiveData<String> mJob;
    MutableLiveData<String> mId;
    MutableLiveData<String> mCreated;
    MutableLiveData<String> mError;

    public PostShowcaseViewModel() {
        mName = new MutableLiveData<>();
        mJob = new MutableLiveData<>();
        mId = new MutableLiveData<>();
        mCreated = new MutableLiveData<>();
        mError = new MutableLiveData<>();
    }

    public void postDataToSite(String iName, String iJob)
    {
        SiteConnector.getInstance().postData(iName, iJob, new Callback<JsonPostResponse>() {
            @Override
            public void onResponse(Call<JsonPostResponse> call, Response<JsonPostResponse> response) {
                if(response.code() == 201)
                {
                    updateLiveData(response.body());
                }
                else
                {
                    postError("Bad Connection.");
                }
            }

            @Override
            public void onFailure(Call<JsonPostResponse> call, Throwable t) {
                postError(t.getMessage());
            }
        });
    }

    private void updateLiveData(JsonPostResponse iResponse)
    {
        mName.postValue(iResponse.getmName());
        mJob.postValue(iResponse.getmJob());
        mId.postValue(iResponse.getmId());
        mCreated.postValue(iResponse.getmCreatedDate());
    }

    public MutableLiveData<String> getmName() {
        return mName;
    }

    public MutableLiveData<String> getmJob() {
        return mJob;
    }

    public MutableLiveData<String> getmId() {
        return mId;
    }

    public MutableLiveData<String> getmCreated() {
        return mCreated;
    }

    public MutableLiveData<String> getmError() {
        return mError;
    }

    public void postError(String iError)
    {
        mError.postValue(iError);
    }
}