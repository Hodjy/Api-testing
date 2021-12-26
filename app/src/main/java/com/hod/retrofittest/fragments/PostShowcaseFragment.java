package com.hod.retrofittest.fragments;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.hod.retrofittest.R;

public class PostShowcaseFragment extends Fragment {

    private PostShowcaseViewModel mViewModel;
    private TextView mNameET;
    private TextView mJobET;
    private TextView mIdET;
    private TextView mCreatedET;

    public static PostShowcaseFragment newInstance() {
        return new PostShowcaseFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.post_showcase_fragment, container, false);
        mViewModel = new ViewModelProvider(this).get(PostShowcaseViewModel.class);

        initUI(rootView);
        initObservers();
        Bundle bundle = getArguments();

        mViewModel.postDataToSite(bundle.getString("name"), bundle.getString("job"));

        return rootView;
    }

    private void initUI(View iRootView)
    {
        mNameET = iRootView.findViewById(R.id.fragment_post_showcase_name_tv);
        mJobET = iRootView.findViewById(R.id.fragment_post_showcase_job_tv);
        mIdET = iRootView.findViewById(R.id.fragment_post_showcase_id_tv);
        mCreatedET = iRootView.findViewById(R.id.fragment_post_showcase_createdAt_tv);
    }

    private void initObservers()
    {
        mViewModel.getmName().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mNameET.setText(s);
            }
        });

        mViewModel.getmJob().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mJobET.setText(s);
            }
        });

        mViewModel.getmId().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mIdET.setText(s);
            }
        });

        mViewModel.getmCreated().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mCreatedET.setText(s);
            }
        });

        mViewModel.getmError().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Snackbar.make(getView(), s, Snackbar.LENGTH_LONG).show();
            }
        });
    }


}