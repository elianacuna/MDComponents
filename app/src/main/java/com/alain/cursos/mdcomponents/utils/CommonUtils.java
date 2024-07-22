package com.alain.cursos.mdcomponents.utils;

/* *
 * Project: MD Components from com.alain.cursos.mdcomponents.utils
 * Created by Alain Nicolás Tello on 13/09/2019 at 06:03 PM
 * All rights reserved 2019.
 * Course Material Design and Theming for Android
 * More info: https://www.udemy.com/especialidad-en-firebase-para-android-con-mvp-profesional/
 */

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.alain.cursos.mdcomponents.fragments.AlertDialogFragment;
import com.alain.cursos.mdcomponents.fragments.AppBarFragment;
import com.alain.cursos.mdcomponents.fragments.BottomNavigationBarFragment;
import com.alain.cursos.mdcomponents.fragments.ButtonFragment;
import com.alain.cursos.mdcomponents.fragments.CardFragment;
import com.alain.cursos.mdcomponents.fragments.CheckboxFragment;
import com.alain.cursos.mdcomponents.fragments.FloatingActionButtonFragment;
import com.alain.cursos.mdcomponents.fragments.MenuFragment;
import com.alain.cursos.mdcomponents.fragments.MotionFragment;
import com.alain.cursos.mdcomponents.fragments.NavigationDrawerFragment;
import com.alain.cursos.mdcomponents.fragments.PickerFragment;
import com.alain.cursos.mdcomponents.fragments.SheetsBottomFragment;
import com.alain.cursos.mdcomponents.fragments.SnackBarFragment;
import com.alain.cursos.mdcomponents.fragments.TextFieldFragment;

public class CommonUtils {

    public static void setFragment(AppCompatActivity activity, String nameFragment, int contentRes){
        Fragment fragment = getFragmentById(nameFragment);
        activity.getSupportFragmentManager().beginTransaction()
                .add(contentRes, fragment)
                .commit();
    }

    private static Fragment getFragmentById(String nameFragment) {
        Fragment fragment = null;

        switch (nameFragment){
            //SCROLL
            case ButtonFragment.TAG:
                fragment = new ButtonFragment();
                break;
            case TextFieldFragment.TAG:
                fragment = new TextFieldFragment();
                break;
            case CheckboxFragment.TAG:
                fragment = new CheckboxFragment();
                break;
            case CardFragment.TAG:
                fragment = new CardFragment();
                break;

            //STATIC
            case BottomNavigationBarFragment.TAG:
                fragment = new BottomNavigationBarFragment();
                break;
            case SnackBarFragment.TAG:
                fragment = new SnackBarFragment();
                break;
            case FloatingActionButtonFragment.TAG:
                fragment = new FloatingActionButtonFragment();
                break;
            case MenuFragment.TAG:
                fragment = new MenuFragment();
                break;
            case AlertDialogFragment.TAG:
                fragment = new AlertDialogFragment();
                break;
            case AppBarFragment.TAG:
                fragment = new AppBarFragment();
                break;
            case PickerFragment.TAG:
                fragment = new PickerFragment();
                break;
            case NavigationDrawerFragment.TAG:
                fragment = new NavigationDrawerFragment();
                break;
            case SheetsBottomFragment.TAG:
                fragment = new SheetsBottomFragment();
                break;
            case MotionFragment.TAG:
                fragment = new MotionFragment();
                break;
        }

        return fragment;
    }
}
