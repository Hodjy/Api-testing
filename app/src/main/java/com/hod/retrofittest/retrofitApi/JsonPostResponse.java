package com.hod.retrofittest.retrofitApi;

import com.google.gson.annotations.SerializedName;

public class JsonPostResponse {
    @SerializedName("name")
    private String mName;
    @SerializedName("job")
    private String mJob;
    @SerializedName("id")
    private String mId;
    @SerializedName("createdAt")
    private String mCreatedDate;

    public String getmName() {
        return mName;
    }

    public String getmJob() {
        return mJob;
    }

    public String getmId() {
        return mId;
    }

    public String getmCreatedDate() {
        return mCreatedDate;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmJob(String mJob) {
        this.mJob = mJob;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public void setmCreatedDate(String mCreatedDate) {
        this.mCreatedDate = mCreatedDate;
    }
}
