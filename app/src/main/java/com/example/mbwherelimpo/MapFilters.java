package com.example.mbwherelimpo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.util.Log;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

public class MapFilters extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_filters);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ImageButton Money = (ImageButton) findViewById(R.id.dinheiro);
        ImageButton Paper = (ImageButton) findViewById(R.id.paper);
        ImageButton People = (ImageButton) findViewById(R.id.fila);
        ImageButton Wheelchair = (ImageButton) findViewById(R.id.wheelchair);
        ImageButton Deposit = (ImageButton) findViewById(R.id.deposit);

        final Switch sw_money = findViewById(R.id.switch_money);
        final Switch sw_paper = findViewById(R.id.switch_paper);
        final Switch sw_deposit = findViewById(R.id.switch_deposit);
        final Switch sw_line = findViewById(R.id.switch_line);
        final Switch sw_wheelchair = findViewById(R.id.switch_wheelchair);

        Bundle extras = getIntent().getExtras();
        final ImageView img = (ImageView) findViewById(R.id.Map);

        if(extras == null)
        {

        }
        else
        {
            String value = null;
            value = (String)extras.getString("value");
            if(value.equalsIgnoreCase("a"))
            {
                img.setImageResource(R.drawable.dinheiro_proximo);
                sw_money.setChecked(true);
            }
            else if (value.equalsIgnoreCase("b"))
            {
                img.setImageResource(R.drawable.papel_proximo);
                sw_paper.setChecked(true);
            }
            else if (value.equalsIgnoreCase("c"))
            {
                img.setImageResource(R.drawable.deposito_proximo);
                sw_deposit.setChecked(true);
            }
            else
            {
                img.setImageResource(R.drawable.todos);
                sw_money.setChecked(true);
                sw_paper.setChecked(true);
                sw_deposit.setChecked(true);
                sw_wheelchair.setChecked(true);
                sw_line.setChecked(true);
            }

        }

        Money.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                img.setImageResource(R.drawable.dinheiro_proximo);
                if (sw_money.isChecked())
                {
                    sw_money.setChecked(false);
                }
                else
                    sw_money.setChecked(true);
            }
        });


        Paper.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                img.setImageResource(R.drawable.papel_proximo);
                if (sw_paper.isChecked())
                {
                    sw_paper.setChecked(false);
                }
                else
                sw_paper.setChecked(true);
            }
        });


        People.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                img.setImageResource(R.drawable.fila_proximo);
                if (sw_line.isChecked())
                {
                    sw_line.setChecked(false);
                }
                else
                sw_line.setChecked(true);
            }
        });


        Wheelchair.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                img.setImageResource(R.drawable.dinheiro_proximo);
                if (sw_wheelchair.isChecked())
                {
                    sw_wheelchair.setChecked(false);
                }
                else
                sw_wheelchair.setChecked(true);
            }
        });


        Deposit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                img.setImageResource(R.drawable.deposito_proximo);
                if (sw_deposit.isChecked())
                {
                    sw_deposit.setChecked(false);
                }
                else
                sw_deposit.setChecked(true);
            }
        });
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
        getMenuInflater().inflate(R.menu.map_filters, menu);
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
