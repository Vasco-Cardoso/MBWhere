package com.example.mbwherelimpo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    public String numero = "000000000";

    public TextView usr_username;
    public TextView usr_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainMenu();
            }
        });

        usr_username = (TextView) findViewById(R.id.user_number);
        usr_password = (TextView) findViewById(R.id.user_passw);
    }

    public void openMainMenu(){
        if(usr_username.getText().toString().equals("1") && usr_password.getText().toString().equals("1")) {
            Intent intent = new Intent(this, MainMenu.class);
            startActivity(intent);
        }
        else
        {
            Context context = getApplicationContext();
            CharSequence text = "User or password wrong!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

    }
}
