package net.learn2develop.calculator;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;

//import android.net.ParseException;

public class First extends Activity {

    String PREFS = "MyPrefs";
    SharedPreferences mPrefs;
    private EditText aEdit;
    private EditText bEdit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Parse.initialize(this, "3Cv42hAPqCrXkh6IkeN3S4WYp15cGfDWlofSJxrs", "KngCrNQYqFSMO2Mpaj9FqHZLfl8rzSiPAqKmF82P");
        ParseAnalytics.trackAppOpened(getIntent());

        setContentView(R.layout.first);
        mPrefs = getSharedPreferences(PREFS, 0);

        //check if the remember option has been check before
        final boolean rememberMe = mPrefs.getBoolean("remember", false);

        if (rememberMe == true) {
            //get previously stored login details
            String login = mPrefs.getString("username", null);
            String upass = mPrefs.getString("password", null);

            if (login != null && upass != null) {
                //fill input boxes with stored login and pass
                EditText loginEbx = (EditText) findViewById(R.id.signup_username_value);
                EditText passEbx = (EditText) findViewById(R.id.signup_password_value);
                loginEbx.setText(login);
                passEbx.setText(upass);

                //set the check box to 'checked'
                CheckBox rememberMeCbx = (CheckBox) findViewById(R.id.chkRememberPassword);
                rememberMeCbx.setChecked(true);
            }

        }


    }


    public void onClick13(View v) {
        aEdit = (EditText) findViewById(R.id.signup_username_value);
        final String a = aEdit.getText().toString();
        bEdit = (EditText) findViewById(R.id.signup_password_value);
        final String b = bEdit.getText().toString();

        CheckBox rememberMeCbx = (CheckBox) findViewById(R.id.chkRememberPassword);
        boolean isChecked = rememberMeCbx.isChecked();
        if (isChecked) {
            saveLoginDetails();
        } else {
            removeLoginDetails();
        }


        //check if the remember option has been check before
        //   final boolean rememberMe = mPrefs.getBoolean("chkRememberPassword", false);

        ParseObject testObj1 = new ParseObject("TesOb1");
        testObj1.put("Username", a);
        testObj1.put("Password", b);
        testObj1.put("remember", isChecked);

        //final ParseUser user=new ParseUser();
        //if(emailVerifie){
        ParseUser.logInInBackground(a, b, new LogInCallback() {
            public void done(ParseUser use, ParseException e) {
                if (use != null) {
                    //final ParseUser user=new ParseUser();
                    //boolean emailVerified=true;

                    // If user exist and authenticated, send user to Welcome.class
                    //emailVerified = user.getBoolean("emailVerified");
                    //if(emailVerified)
                    //{


                    Intent i = new Intent(First.this, MainActivity.class);
                    startActivity(i);

                    Toast.makeText(getApplicationContext(),
                            "Successfully Logged in. Welcome Back!",
                            Toast.LENGTH_LONG).show();
                    finish();

                }
            /*		else{
                        Toast.makeText(getApplicationContext(),
								"Please verify your email id",                         
								Toast.LENGTH_LONG).show();                         
						finish();                               
							
						
					}}*/
                else {
                    Toast.makeText(
                            getApplicationContext(),
                            "No such user exist, please signup" + "\n" + "Or username-password combination does not match",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    public void onClick14(View v) {

        Intent i = new Intent(First.this, Login.class);
        startActivity(i);
        //finish();
    }


    private void saveLoginDetails() {
        //fill input boxes with stored login and pass
        EditText loginEbx = (EditText) findViewById(R.id.signup_username_value);
        EditText passEbx = (EditText) findViewById(R.id.signup_password_value);
        String login = loginEbx.getText().toString();
        String upass = passEbx.getText().toString();

        Editor e = mPrefs.edit();
        e.putBoolean("remember", true);
        e.putString("username", login);
        e.putString("password", upass);
        e.commit();
    }

    private void removeLoginDetails() {
        Editor e = mPrefs.edit();
        e.putBoolean("remember", false);
        e.remove("username");
        e.remove("password");
        e.commit();
    }

}
