package com.example.mbwherelimpo;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import com.google.android.material.navigation.NavigationView;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class list_atms extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_atms);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Button button1 = findViewById(R.id.rua1);
        Button button2 = findViewById(R.id.rua2);
        Button button3 = findViewById(R.id.rua3);
        Button button4 = findViewById(R.id.rua4);
        Button button5 = findViewById(R.id.rua5);
        Button button6 = findViewById(R.id.rua6);
        Button button7 = findViewById(R.id.rua7);

        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openActivity1();
            }
        });

        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openActivity1();
            }
        });

        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openActivity1();
            }
        });

        button4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openActivity1();
            }
        });

        button5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openActivity1();
            }
        });

        button6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openActivity1();
            }
        });

        button7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openActivity1();
            }
        });

    }

    public void openActivity1(){

        Intent intent = new Intent(this, MapFilters.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list_atms, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.ATMsMoney) {
            Intent intent = new Intent(this, MapFilters.class);
            intent.putExtra("value","a");
            startActivity(intent);
        } else if(id == R.id.Home) {
            Intent intent = new Intent(this, MainMenu.class);
            startActivity(intent);
        } else if (id == R.id.ATMsPaper) {
            Intent intent = new Intent(this, MapFilters.class);
            intent.putExtra("value","b");
            startActivity(intent);
        } else if (id == R.id.ATMsDeposit) {
            Intent intent = new Intent(this, MapFilters.class);
            intent.putExtra("value","c");
            startActivity(intent);
        } else if (id == R.id.RouteATM) {
            Intent intent = new Intent(this, Route.class);
            startActivity(intent);
        } else if (id == R.id.ListATM) {
            Intent intent = new Intent(this, list_atms.class);
            startActivity(intent);
        } else if (id == R.id.Logout) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
