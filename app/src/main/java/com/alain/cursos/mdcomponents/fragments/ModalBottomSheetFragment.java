package com.alain.cursos.mdcomponents.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.alain.cursos.mdcomponents.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ModalBottomSheetFragment extends BottomSheetDialogFragment implements
        NavigationView.OnNavigationItemSelectedListener {

    public static final String TAG = "Modal Bottom Sheet";
    Unbinder mUnbinder;
    @BindView(R.id.nmdBottom)
    NavigationView nmdBottom;

    public ModalBottomSheetFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_modal_bottom_sheet, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        nmdBottom.setNavigationItemSelectedListener(this);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_cancel:

                break;
            case R.id.action_full_screen_dialog:
                FullScreenDialogFragment fragment = new FullScreenDialogFragment();
                fragment.show(getFragmentManager().beginTransaction(), FullScreenDialogFragment.TAG);
                break;
            default:
                String msg = item.getTitle().toString();
                Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
                break;
        }

        dismiss();

        return true;
    }
}