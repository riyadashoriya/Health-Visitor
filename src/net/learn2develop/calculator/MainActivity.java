package net.learn2develop.calculator;

//import net.example.pro.Item;
//import net.example.pro.Signup;
//import net.example.pro.Login;
//import net.example.pro.User;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.parse.ParseUser;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void onClick1(View v) {
        Intent i = new Intent(MainActivity.this, Bmi.class);
        startActivity(i);
    }

    public void onClick5(View v) {
        Intent i = new Intent(MainActivity.this, Aboutme.class);
        startActivity(i);
        //finish();
    }

    public void onClick2(View v) {
        Intent i = new Intent(MainActivity.this, Baldiet.class);
        startActivity(i);
    }

    public void onClick4(View v) {
        Intent i = new Intent(MainActivity.this, Exsugg.class);
        startActivity(i);
    }

    public void onClick3(View v) {
        Intent i = new Intent(MainActivity.this, Nut.class);
        startActivity(i);
    }

    public void onClick11(View v) {
        Intent i = new Intent(MainActivity.this, First.class);

        ParseUser.logOut();

        finish();
        startActivity(i);
        Toast.makeText(getApplicationContext(),
                "You are now logged out!",
                Toast.LENGTH_LONG).show();
        finish();

    }

}
