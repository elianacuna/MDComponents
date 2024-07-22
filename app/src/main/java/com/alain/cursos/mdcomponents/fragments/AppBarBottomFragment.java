package com.alain.cursos.mdcomponents.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.BottomAppBarCutCornersTopEdge;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.snackbar.Snackbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppBarBottomFragment extends DialogFragment {
    public static final String TAG = "AppBarBottomFragment";

    Unbinder mUnbinder;
    private boolean isCentered;

    @BindView(R.id.bottom_app_bar)
    BottomAppBar bottomAppBar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.containerMain)
    CoordinatorLayout containerMain;

    public AppBarBottomFragment() {
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
        View view = inflater.inflate(R.layout.fragment_app_bar_bottom, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        bottomAppBar.setOnMenuItemClickListener(item -> {
            int resMessage;
            switch (item.getItemId()){
                case R.id.action_favorites:
                    resMessage = R.string.menu_favorites;
                    break;
                case R.id.action_profile:
                    resMessage = R.string.menu_profile;
                    break;
                default:
                    resMessage = R.string.menu_start;
                    break;
            }
            Snackbar.make(containerMain, resMessage, Snackbar.LENGTH_LONG)
                    .setAnchorView(fab)
                    .show();

            return true;
        });

        bottomAppBar.setNavigationOnClickListener(view1 -> {
            Snackbar.make(containerMain, R.string.message_action_success, Snackbar.LENGTH_LONG)
                    .setAnchorView(fab)
                    .show();
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
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @OnClick(R.id.fab)
    public void onViewClicked() {
        if (isCentered){
            bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
        }else{
            bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
        }
        isCentered = !isCentered;
    }
}
