package com.alain.cursos.mdcomponents.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.DialogFragment;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.BottomAppBarCutCornersTopEdge;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.shape.MaterialShapeDrawable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BottomNavigationDrawerFragment extends DialogFragment {

    public static final String TAG = "Bottom Navigation Drawer";

    Unbinder mUnbinder;
    @BindView(R.id.bottom_app_bar)
    BottomAppBar bottomAppBar;

    public BottomNavigationDrawerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialog);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom_navigation_drawer, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        bottomAppBar.setNavigationOnClickListener(v -> {
            ModalBottomSheetFragment fragment = new ModalBottomSheetFragment();
            fragment.show(getFragmentManager().beginTransaction(), ModalBottomSheetFragment.TAG);
        });
        
        BottomAppBarCutCornersTopEdge topEdge = new BottomAppBarCutCornersTopEdge(
                bottomAppBar.getFabCradleMargin(),
                bottomAppBar.getFabCradleRoundedCornerRadius(),
                bottomAppBar.getCradleVerticalOffset()
        );

        MaterialShapeDrawable shapeDrawable = (MaterialShapeDrawable)bottomAppBar.getBackground();
        shapeDrawable.setShapeAppearanceModel(
                shapeDrawable.getShapeAppearanceModel()
                        .toBuilder()
                        .setTopEdge(topEdge)
                        .build());
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}