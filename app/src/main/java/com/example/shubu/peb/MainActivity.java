package com.example.shubu.peb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bLogout;
    EditText etname,etAge,etUsername;
    UserLocalStore userLocalStore;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etname = (EditText) findViewById(R.id.etName);
        etAge = (EditText) findViewById(R.id.etAge);
        bLogout = (Button) findViewById(R.id.bLogout);


        bLogout.setOnClickListener(this);

        userLocalStore = new UserLocalStore(this);
    }
    @Override
    protected void onStart(){
        super.onStart();
        if (authenticate() == true){
            displayUserDetails();
        }else{
            startActivity(new Intent(MainActivity.this,Login.class));
        }

    }
    private boolean authenticate(){
        return userLocalStore.getUserLoggedIn();
    }
    private void displayUserDetails(){
        User user = userLocalStore.getLoggedInUser();
        startActivity(new Intent(this,Admin.class));
        etUsername.setText(user.username);
        etname.setText(user.name);
        etAge.setText(user.age + "");

    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bLogout:
                userLocalStore.clearUserData();
                userLocalStore.setUserLoggedIn(false);

                startActivity(new Intent(this, Login.class));
                break;

        }

    }
}
