package com.hod.retrofittest.retrofitApi;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class JsonGetResponse {
    public ArrayList<User> getmData() {
        return mData;
    }

    public void setmData(ArrayList<User> mData) {
        this.mData = mData;
    }

    @SerializedName("data")
    private ArrayList<User> mData;
}
