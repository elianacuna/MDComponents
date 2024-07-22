package com.alain.cursos.mdcomponents.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.alain.cursos.mdcomponents.R;
import com.google.android.material.appbar.MaterialToolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppBarTopFragment extends DialogFragment {
    public static final String TAG = "AppBarTopFragment";

    Unbinder mUnbinder;
    @BindView(R.id.toolbar)
    MaterialToolbar toolbar;

    public AppBarTopFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialog);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_app_bar_top, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        toolbar.setNavigationOnClickListener(view1 -> dismiss());

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
