package com.example.mbwherelimpo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.mbwherelimpo.R.array.List;

public class MainMenu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    ImageButton ButtonMoney;
    ImageButton ButtonPaper;
    ImageButton ButtonDeposit;
    ImageButton ButtonList;
    ImageButton ButtonRoute;
    ImageButton ButtonReportError;
    ImageButton ButtonBlockCard;
    ImageButton ButtonMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ButtonMoney = (ImageButton)findViewById(R.id.ButtonMoney);
        ButtonPaper = (ImageButton)findViewById(R.id.ButtonPaper);
        ButtonDeposit = (ImageButton)findViewById(R.id.ButtonDeposit);
        ButtonList = (ImageButton)findViewById(R.id.ButtonList);
        ButtonRoute = (ImageButton)findViewById(R.id.ButtonRoute);
        ButtonReportError = (ImageButton)findViewById(R.id.ButtonReportError);
        ButtonBlockCard = (ImageButton)findViewById(R.id.ButtonBlockCard);
        ButtonMap = (ImageButton)findViewById(R.id.Map);

        ButtonMoney.setOnClickListener(this);
        ButtonPaper.setOnClickListener(this);
        ButtonDeposit.setOnClickListener(this);
        ButtonList.setOnClickListener(this);
        ButtonRoute.setOnClickListener(this);
        ButtonReportError.setOnClickListener(this);
        ButtonBlockCard.setOnClickListener(this);
        ButtonMap.setOnClickListener(this);
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
        getMenuInflater().inflate(R.menu.main_menu, menu);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ButtonMoney:
                Intent intent = new Intent(this, MapFilters.class);
                intent.putExtra("value","a");
                startActivity(intent);
                break;
            case R.id.ButtonPaper:
                Intent intent2 = new Intent(this, MapFilters.class);
                intent2.putExtra("value","b");
                startActivity(intent2);
                break;
            case R.id.ButtonDeposit:
                Intent intent3 = new Intent(this, MapFilters.class);
                intent3.putExtra("value","c");
                startActivity(intent3);
                break;
            case R.id.ButtonList:
                Intent intent4 = new Intent(this, list_atms.class);
                startActivity(intent4);
                break;
            case R.id.ButtonRoute:
                Intent intent5 = new Intent(this, Route.class);
                startActivity(intent5);
                break;
            case R.id.ButtonReportError:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainMenu.this);

                LayoutInflater inflater = this.getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_report_error, null);

                Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(List));
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);

                builder.setView(view).setTitle("").setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Context context = getApplicationContext();
                        CharSequence text = "Error reported, thank you!";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                });

                builder.setView(view);
                AlertDialog dialog2 =  builder.create();
                dialog2.show();

                break;
            case R.id.ButtonBlockCard:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(MainMenu.this);

                LayoutInflater inflater2 = this.getLayoutInflater();
                View view2 = inflater2.inflate(R.layout.dialog_block_card, null);

                builder2.setView(view2).setTitle("").setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Context context = getApplicationContext();
                        CharSequence text = "Confirmed, you'll receive a contact soon!";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                });

                builder2.setView(view2);
                AlertDialog dialog3 =  builder2.create();
                dialog3.show();

                break;
            case R.id.Map:
                Intent intent8 = new Intent(this, MainMenu.class);
                startActivity(intent8);
                break;
        }
    }

    public void openDialog()
    {
        Dialog_BlockCard dialog = new Dialog_BlockCard();
        dialog.show(getSupportFragmentManager(), "Dialog");
    }
}
