package com.armandocl.dev.sisinfov2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.armandocl.dev.sisinfov2.FragmentsViews.AboutFragment;
import com.armandocl.dev.sisinfov2.FragmentsViews.BuscarFragment;
import com.armandocl.dev.sisinfov2.FragmentsViews.ContactoFragment;
import com.armandocl.dev.sisinfov2.FragmentsViews.InicioFragment;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        actionBar.setDisplayHomeAsUpEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.navigation_drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        if (navigationView != null) {
            setupNavigationDrawerContent(navigationView);
        }

        setupNavigationDrawerContent(navigationView);
        //Al iniciar la app mostrar el fragmento de inicio cargado
        setFragment(0);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupNavigationDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.item_navigation_drawer_find:
                                menuItem.setChecked(true);
                                setFragment(1);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_navigation_drawer_contact:
                                menuItem.setChecked(true);
                                setFragment(2);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_navigation_drawer_help_and_feedback:
                                menuItem.setChecked(true);
                                setFragment(3);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_navigation_drawer_about:
                                menuItem.setChecked(true);
                                setFragment(4);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                        }
                        return true;
                    }
                });
    }

    public void setFragment(int position) {
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        switch (position) {
            case 0:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                InicioFragment inicioFragment = new InicioFragment();
                fragmentTransaction.replace(R.id.fragment, inicioFragment);
                fragmentTransaction.commit();
                break;
            case 1:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                BuscarFragment buscarFragment = new BuscarFragment();
                fragmentTransaction.replace(R.id.fragment, buscarFragment);
                fragmentTransaction.commit();
                break;
            case 2:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                ContactoFragment contactoFragment = new ContactoFragment();
                fragmentTransaction.replace(R.id.fragment, contactoFragment);
                fragmentTransaction.commit();
                break;
            case 3:
                /*
                fb://root
                fb://feed
                fb://feed/{userID}
                fb://profile
                fb://profile/{userID}
                fb://page/{id}
                fb://group/{id}
                fb://place/fw?pid={id}
                fb://profile/{#user_id}/wall
                fb://profile/{#user_id}/info
                fb://profile/{#user_id}/photos
                fb://profile/{#user_id}/mutualfriends
                fb://profile/{#user_id}/friends
                fb://profile/{#user_id}/fans
                fb://search
                fb://friends
                fb://pages
                fb://messaging
                fb://messaging/{#user_id}
                fb://online
                fb://requests
                fb://events
                fb://places
                fb://birthdays
                fb://notes
                fb://places
                fb://groups
                fb://notifications
                fb://albums
                fb://album/{%s}?owner={#%s}
                fb://video/?href={href}
                fb://post/{postid}?owner={uid}¹
                */
                String uri = "fb://group/249202925152358";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
                break;
            case 4:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                AboutFragment aboutFragment = new AboutFragment();
                fragmentTransaction.replace(R.id.fragment, aboutFragment);
                fragmentTransaction.commit();
                break;
        }
    }
}