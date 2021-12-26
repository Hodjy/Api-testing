package com.hod.retrofittest.retrofitApi;

import com.google.gson.annotations.SerializedName;

public class NewUser {
    @SerializedName("name")
    private String mName;
    @SerializedName("job")
    private String mJob;

    public NewUser(String mName, String mJob) {
        this.mName = mName;
        this.mJob = mJob;
    }

    public String getmName() {
        return mName;
    }

    public String getmJob() {
        return mJob;
    }
}
