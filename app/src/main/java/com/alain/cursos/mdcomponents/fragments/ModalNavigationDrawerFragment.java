package com.alain.cursos.mdcomponents.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;

import com.alain.cursos.mdcomponents.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ModalNavigationDrawerFragment extends DialogFragment implements
        NavigationView.OnNavigationItemSelectedListener {

    public static final String TAG = "Modal Navigation Drawer";
    Unbinder mUnbinder;

    @BindView(R.id.nmd)
    NavigationView nmd;
    @BindView(R.id.toolbar)
    MaterialToolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    public ModalNavigationDrawerFragment() {
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
        View view = inflater.inflate(R.layout.fragment_modal_navigation_drawer, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar,
                R.string.dialog_ok, R.string.dialog_cancel);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        nmd.setNavigationItemSelectedListener(this);
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
                //drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.action_app_bar_bottom:
                AppBarBottomFragment bottomFragment = new AppBarBottomFragment();
                bottomFragment.show(getFragmentManager().beginTransaction(), AppBarBottomFragment.TAG);
                break;

            default:
                String msg = item.getTitle().toString();
                Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}