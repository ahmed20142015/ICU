package com.marvelwall.ahmedpc.icu.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.marvelwall.ahmedpc.icu.R;
import com.marvelwall.ahmedpc.icu.fragments.Identify;
import com.marvelwall.ahmedpc.icu.fragments.MangmentWizard;
import com.marvelwall.ahmedpc.icu.fragments.Map;
import com.marvelwall.ahmedpc.icu.fragments.NewsAndIntroduction;
import com.marvelwall.ahmedpc.icu.fragments.Report;
import com.marvelwall.ahmedpc.icu.fragments.Scan;

public class DoctorHome extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        Map.OnFragmentInteractionListener,
        Scan.OnFragmentInteractionListener,
        Identify.OnFragmentInteractionListener,
        MangmentWizard.OnFragmentInteractionListener,
        Report.OnFragmentInteractionListener {

    private FragmentManager manager;
    private FragmentTransaction transaction;
    public static LinearLayout alarm,samaa;
    ImageView openDrawer,ivSamaa;
    DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_home);
        alarm=findViewById(R.id.alarm);
        samaa = findViewById(R.id.samaaa);
        ivSamaa = findViewById(R.id.iv_samaaa);
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        openDrawer = findViewById(R.id.open_drawer);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);


        openDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.END);
            }
        });

        //lood frament
        Fragment fragment = new Map();
        manager = getSupportFragmentManager();
        if (manager == null)
            manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

        transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
        // transaction.replace(R.id.mainContent, fragment, "login").commit();
        transaction.replace(R.id.mainContenttwo, fragment, "Map").commit();

        ivSamaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //lood frament
                Fragment fragment = new Scan();
                manager = getSupportFragmentManager();
                if (manager == null)
                    manager = getSupportFragmentManager();
                transaction = manager.beginTransaction();

                transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
                // transaction.replace(R.id.mainContent, fragment, "login").commit();
                transaction.replace(R.id.mainContenttwo, fragment, "Scan").addToBackStack("Scan").commit();
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        //else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
