package com.alain.cursos.mdcomponents.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.transition.TransitionManager;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.transition.MaterialArcMotion;
import com.google.android.material.transition.MaterialContainerTransform;
import com.google.android.material.transition.MaterialSharedAxis;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MotionFragment extends Fragment {

    public static final String TAG = "Motion";

    private static Component mInstance;

    Unbinder mUnbinder;
    @BindView(R.id.viewEnd)
    ConstraintLayout viewEnd;
    @BindView(R.id.viewStart)
    FloatingActionButton viewStart;
    @BindView(R.id.containerMain)
    CoordinatorLayout containerMain;
    @BindView(R.id.btnCustom)
    MaterialButton btnCustom;
    @BindView(R.id.viewOut)
    FrameLayout viewOut;
    @BindView(R.id.viewIn)
    LinearLayout viewIn;

    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_motion);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public MotionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_motion, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        btnCustom.setText(R.string.motion_button_next);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }

    @OnClick({R.id.btnCancel, R.id.viewStart})
    public void onMotionClicked(View view) {
        MaterialContainerTransform transform = new MaterialContainerTransform();
        transform.setScrimColor(Color.TRANSPARENT);
        transform.setDuration(500L);

        switch (view.getId()) {
            case R.id.btnCancel:
                transform.setStartView(viewEnd);
                transform.setEndView(viewStart);
                transform.addTarget(viewStart);

                TransitionManager.beginDelayedTransition(containerMain, transform);
                viewEnd.setVisibility(View.GONE);
                viewStart.setVisibility(View.VISIBLE);
                break;
            case R.id.viewStart:
                transform.setPathMotion(new MaterialArcMotion());
                transform.setStartView(viewStart);
                transform.setEndView(viewEnd);
                transform.addTarget(viewEnd);

                TransitionManager.beginDelayedTransition(containerMain, transform);
                viewStart.setVisibility(View.GONE);
                viewEnd.setVisibility(View.VISIBLE);
                break;
        }
    }

    @OnClick(R.id.btnCustom)
    public void onNextClicked() {
        MaterialSharedAxis sharedAxis = new MaterialSharedAxis(MaterialSharedAxis.X, true);
        sharedAxis.setDuration(1500L);

        TransitionManager.beginDelayedTransition(viewEnd, sharedAxis);

        viewOut.setVisibility(View.GONE);
        viewIn.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.btnBack)
    public void onBackClicked() {
        MaterialSharedAxis sharedAxis = new MaterialSharedAxis(MaterialSharedAxis.X, false);
        sharedAxis.setDuration(1500L);

        TransitionManager.beginDelayedTransition(viewEnd, sharedAxis);

        viewIn.setVisibility(View.GONE);
        viewOut.setVisibility(View.VISIBLE);
    }
}