package com.alain.cursos.mdcomponents.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.chip.Chip;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/* *
 * Project: MD Components from com.alain.cursos.mdcomponents.fragments
 * Created by Alain Nicolás Tello on 26/09/2019 at 05:13 PM
 * All rights reserved 2019.
 * Course Material Design and Theming for Android
 * More info: https://www.udemy.com/course/material-design-theming-diseno-profesional-para-android/
 */

public class CardFragment extends Fragment {

    public static final String TAG = "Card";

    private static Component mInstance;

    Unbinder mUnbinder;

    @BindView(R.id.imgCardLarge)
    AppCompatImageView imgCardLarge;
    @BindView(R.id.chpSecond)
    Chip chpSecond;
    @BindView(R.id.chpThird)
    Chip chpThird;

    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_cards_template);
        mInstance.setType(Constants.SCROLL);
        return mInstance;
    }

    public CardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_card, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop();

        Glide.with(this)
                .load("https://upload.wikimedia.org/wikipedia/commons/thumb/6/6d/Good_Food_Display_" +
                        "-_NCI_Visuals_Online.jpg/1920px-Good_Food_Display_-_NCI_Visuals_Online.jpg")
                .apply(options)
                .into(imgCardLarge);

        chpSecond.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked){
                Toast.makeText(getActivity(), "Checked", Toast.LENGTH_SHORT).show();
            }
        });

        chpThird.setOnCloseIconClickListener(view1 -> chpThird.setVisibility(View.GONE));

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @OnClick(R.id.chpFirst)
    public void onViewClicked() {
        Toast.makeText(getActivity(), "First Chip", Toast.LENGTH_SHORT).show();
    }
}
