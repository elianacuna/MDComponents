package com.alain.cursos.mdcomponents.fragments;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.transition.TransitionManager;

import com.alain.cursos.mdcomponents.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.transition.MaterialFadeThrough;
import com.google.android.material.transition.SlideDistanceProvider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ModalBottomSheetFullScreenFragment extends BottomSheetDialogFragment {

    public static final String TAG = "Modal BottomSheet FullScreen";
    @BindView(R.id.btnCancel)
    ImageButton btnCancel;
    @BindView(R.id.appBar)
    AppBarLayout appBar;
    @BindView(R.id.tvBar)
    TextView tvBar;
    /*@BindView(R.id.llBar)
    LinearLayout llBar;*/
    @BindView(R.id.containerBar)
    FrameLayout containerBar;
    @BindView(R.id.vExtraSpace)
    View vExtraSpace;

    private BottomSheetBehavior mBottomSheetBehavior;
    Unbinder mUnbinder;

    public ModalBottomSheetFullScreenFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);

        View view = View.inflate(getContext(), R.layout.fragment_modal_bottom_sheet_full_screen, null);
        mUnbinder = ButterKnife.bind(this, view);

        bottomSheetDialog.setContentView(view);

        vExtraSpace.setMinimumHeight((Resources.getSystem().getDisplayMetrics().heightPixels) / 4);

        mBottomSheetBehavior = BottomSheetBehavior.from((View) view.getParent());
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);
        mBottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

                MaterialFadeThrough fadeThrough = new MaterialFadeThrough();
                fadeThrough.setSecondaryAnimatorProvider(new SlideDistanceProvider(Gravity.TOP));
                fadeThrough.setDuration(250L);

                TransitionManager.beginDelayedTransition(containerBar, fadeThrough);

                int statusBarColor = ContextCompat.getColor(getActivity(), R.color.colorPrimaryDark);

                if (BottomSheetBehavior.STATE_EXPANDED == newState){
                    tvBar.setVisibility(View.GONE);
                    appBar.setVisibility(View.VISIBLE);
                    //llBar.setVisibility(View.GONE);
                    statusBarColor = ContextCompat.getColor(getActivity(), R.color.colorAccent);
                } else if (BottomSheetBehavior.STATE_COLLAPSED == newState){
                    appBar.setVisibility(View.GONE);
                    //llBar.setVisibility(View.VISIBLE);
                    tvBar.setVisibility(View.VISIBLE);
                }

                getActivity().getWindow().setStatusBarColor(statusBarColor);
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

        btnCancel.setOnClickListener(v -> mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN));

        return bottomSheetDialog;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}