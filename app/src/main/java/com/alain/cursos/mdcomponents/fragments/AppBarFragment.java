package com.alain.cursos.mdcomponents.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppBarFragment extends Fragment {

    public static final String TAG = "App Bar";

    private static Component mInstance;

    Unbinder mUnbinder;

    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_topappbar);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public AppBarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_app_bar, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @OnClick({R.id.btnTop, R.id.btnBottom})
    public void onViewClicked(View view) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        switch (view.getId()) {
            case R.id.btnTop:
                AppBarTopFragment topFragment = new AppBarTopFragment();
                topFragment.show(transaction, FullScreenDialogFragment.TAG);
                break;
            case R.id.btnBottom:
                AppBarBottomFragment bottomFragment = new AppBarBottomFragment();
                bottomFragment.show(transaction, FullScreenDialogFragment.TAG);
                break;
        }
    }
}
