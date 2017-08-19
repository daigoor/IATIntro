package com.ibda.droid.training.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ibda.droid.training.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText username;

//    private View.OnClickListener clickEvent = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            displayToast("nested");
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button greeting = (Button) findViewById(R.id.btn_greeting);
        Button die = (Button) findViewById(R.id.btn_die);

        this.username = (EditText) findViewById(R.id.etxt_username);

        greeting.setText(getString(R.string.btn_greeting));

//        //Set click #1
//        greeting.setOnClickListener(clickEvent);
//
//        //Set click #2
//        greeting.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                displayToast("anon");
//            }
//        });

        //Set click #3
        greeting.setOnClickListener(this);
        die.setOnClickListener(this);

        displayToast("created");


    }

    @Override
    protected void onResume() {
        super.onResume();
        displayToast("resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        displayToast("pused");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_greeting:
                displayToast(this.username.getText().toString());
                break;
            case R.id.btn_die:
                this.finish();
                break;
        }

    }

    private void displayToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
