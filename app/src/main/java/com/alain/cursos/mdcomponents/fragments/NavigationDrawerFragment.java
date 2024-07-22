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
import com.google.android.material.button.MaterialButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class NavigationDrawerFragment extends Fragment {

    public static final String TAG = "Navigation Drawer";

    private static Component mInstance;

    Unbinder mUnbinder;
    @BindView(R.id.btnModal)
    MaterialButton btnModal;
    @BindView(R.id.btnBottom)
    MaterialButton btnBottom;

    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_navigation_drawer);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }

    @OnClick({R.id.btnModal, R.id.btnBottom})
    public void onViewClicked(View view) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        switch (view.getId()) {
            case R.id.btnModal:
                ModalNavigationDrawerFragment modalFragment = new ModalNavigationDrawerFragment();
                modalFragment.show(transaction, ModalNavigationDrawerFragment.TAG);
                break;
            case R.id.btnBottom:
                BottomNavigationDrawerFragment bottomFragment = new BottomNavigationDrawerFragment();
                bottomFragment.show(transaction, BottomNavigationDrawerFragment.TAG);
                break;
        }
    }
}