package com.alain.cursos.mdcomponents.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.PopupMenu;

import androidx.fragment.app.Fragment;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;
import com.google.android.material.button.MaterialButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    public static final String TAG = "Menu";

    private static Component mInstance;

    Unbinder mUnbinder;
    @BindView(R.id.btnMenuPopup)
    MaterialButton btnMenuPopup;
    @BindView(R.id.actvCourses)
    AutoCompleteTextView actvCourses;

    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_menu_width_min);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        btnMenuPopup.setOnClickListener(view1 -> {
            PopupMenu popupMenu = new PopupMenu(getActivity(), view1);
            popupMenu.getMenuInflater().inflate(R.menu.menu_bottom_nav, popupMenu.getMenu());
            popupMenu.show();
        });

        String[] courses = new String[]{"Experto en Firebase para Android +MVP Curso completo +30Hrs",
                "Material Design/theming Profesional para Android",
                "Android: Fundamentos apps de calidad",
                "Kotlin 2020"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.item_menu_dropdown,
                courses);
        actvCourses.setAdapter(adapter);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
