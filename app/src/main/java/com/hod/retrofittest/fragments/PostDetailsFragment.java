package com.hod.retrofittest.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.hod.retrofittest.R;

import org.jetbrains.annotations.NotNull;

public class PostDetailsFragment extends Fragment {
    private EditText mNameET;
    private EditText mJobET;
    private Button mPostBtn;
    private String mName = "";
    private String mJob = "";


    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater,
                             @Nullable @org.jetbrains.annotations.Nullable ViewGroup container,
                             @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_post_details, container, false);

        mNameET = rootView.findViewById(R.id.fragment_post_details_name_et);
        mJobET  = rootView.findViewById(R.id.fragment_post_details_job_et);
        mPostBtn = rootView.findViewById(R.id.fragment_post_details_post_btn);

        setListeners();

        return rootView;
    }

    private void setListeners()
    {
        mNameET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mName = s.toString();
            }
        });

        mJobET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mJob = s.toString();
            }
        });

        mPostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("name", mName);
                bundle.putSerializable("job", mJob);

                assert getParentFragment() != null;
                NavHostFragment.findNavController(getParentFragment()).navigate(R.id.action_to_postShowcaseFragment, bundle);
            }
        });
    }
}
